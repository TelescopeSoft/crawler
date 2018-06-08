package com.qlmsoft.crawler.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.http.Consts;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.qlmsoft.crawler.entity.CorpRegStaff;
import com.qlmsoft.crawler.entity.CorpRegStaffCert;
import com.qlmsoft.crawler.entity.CorpRegStaffCertExample;
import com.qlmsoft.crawler.entity.CorpRegStaffExample;
import com.qlmsoft.crawler.mapper.CorpRegStaffCertMapper;
import com.qlmsoft.crawler.mapper.CorpRegStaffMapper;
import com.qlmsoft.crawler.mohurd.bean.BaseCorpVO;
import com.qlmsoft.crawler.mohurd.bean.RegStaffVO;
import com.qlmsoft.crawler.mohurd.bean.RegStaffs;

@Service
public class RegStaffProccesor {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static final String CORP_REG_STAFF_LIST_URL = "http://jzsc.mohurd.gov.cn/dataservice/query/comp/regStaffList/";

	public CloseableHttpClient closeHttpClient = HttpClients.createDefault();

	@Autowired
	RegStaffDetailProccesor detailProc;

	@Autowired
	CorpRegStaffMapper regStaffMapper;

	@Autowired
	CorpRegStaffCertMapper regStaffCertMapper;

	public RegStaffs regStaffListReq(BaseCorpVO corpVO) {
		RegStaffs result = null;

		CloseableHttpResponse httpResponse = null;
		HttpGet httpget = new HttpGet(CORP_REG_STAFF_LIST_URL
				+ corpVO.getCorpPageID());

		try {
			httpResponse = closeHttpClient.execute(httpget);
			String html = EntityUtils.toString(httpResponse.getEntity(),
					"UTF-8");

			if (html != null) {
				result = regStaffListResult(corpVO, html);

				if (result.getStaffs() != null && !result.getStaffs().isEmpty()) {

					// 保存人员以及人员证书信息

					CorpRegStaffExample staffEx = new CorpRegStaffExample();
					CorpRegStaffCertExample staffCertEx = new CorpRegStaffCertExample();

					List<CorpRegStaff> existRegStaff = null;
					List<CorpRegStaffCert> existCert = null;

					for (RegStaffVO sta : result.getStaffs()) {

						staffEx.clear();
						staffEx.createCriteria().andNameEqualTo(sta.getName())
								.andIdCard2EqualTo(sta.getIdCard());

						existRegStaff = regStaffMapper.selectByExample(staffEx);

						Integer staffId = null;
						if (existRegStaff == null || existRegStaff.isEmpty()) {
							CorpRegStaff record = new CorpRegStaff();
							record.setCorpId(sta.getCorpID());
							record.setCreateTime(new Date());
							record.setGender("男".equals(sta.getGender()) ? 0
									: 1);
							record.setIdCard2(sta.getIdCard2());
							record.setIdType(sta.getIdType());
							record.setName(sta.getName());
							record.setStatus(0);
							record.setUpdateTime(record.getUpdateTime());

							regStaffMapper.insert(record);
							//logger.info("id : " + record.getId());
							staffId = record.getId();

						} else {
							staffId = existRegStaff.get(0).getId();
						}

						staffCertEx.clear();
						staffCertEx.createCriteria()
								.andRegTypeEqualTo(sta.getRegType())
								.andRegMajorEqualTo(sta.getRegMajor())
								.andCertNoEqualTo(sta.getCertNo())
								.andValidDateEqualTo(sta.getValid());

						existCert = regStaffCertMapper
								.selectByExample(staffCertEx);
						if (existCert == null || existCert.isEmpty()) {
							CorpRegStaffCert cert = new CorpRegStaffCert();
							cert.setCertNo(sta.getCertNo());
							cert.setCreateTime(new Date());
							cert.setUpdateTime(cert.getCreateTime());
							cert.setRegMajor(sta.getRegMajor());
							cert.setRegNo(sta.getRegNo());
							cert.setRegType(sta.getRegType());
							cert.setStaffId(staffId);
							cert.setStatus(0);
							cert.setValidDate(sta.getValid());
							cert.setStaffIdCard2(sta.getIdCard2());

							regStaffCertMapper.insert(cert);
						}

					}

				}

			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (httpResponse != null) {
				try {
					httpResponse.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		return result;

	}

	public List<RegStaffVO> regStaffListReqByPage(String corpId, String corpPageID, int page,
			int total, int pageSize) {

		List<RegStaffVO> staffList = null;

		CloseableHttpResponse httpResponse = null;
		HttpPost httpPost = new HttpPost(CORP_REG_STAFF_LIST_URL + corpPageID);

		// 设置Post参数
		List<NameValuePair> params = new ArrayList<NameValuePair>();
		params.add(new BasicNameValuePair("$total", String.valueOf(total)));
		params.add(new BasicNameValuePair("$reload", "0"));
		params.add(new BasicNameValuePair("$pg", String.valueOf(page)));
		params.add(new BasicNameValuePair("$pgsz", String.valueOf(pageSize)));
		httpPost.setEntity(new UrlEncodedFormEntity(params, Consts.UTF_8));

		try {

			httpResponse = closeHttpClient.execute(httpPost);
			String html = EntityUtils.toString(httpResponse.getEntity(),
					"UTF-8");

			if (html != null) {
				staffList = regStaffListResultForSinglePage(corpId, html);
			}

		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (httpResponse != null) {
				try {
					httpResponse.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}

		}

		return staffList;
	}

	private RegStaffs regStaffListResult(BaseCorpVO corp, String html) {
		logger.info("===========corpid : " + corp.getZzjgdm());

		RegStaffs result = null;
		List<RegStaffVO> staffs = null;
		Document doc = Jsoup.parse(html);

		try {
			Element totalSpan = doc.select(
					"div.comp_regstaff_links a.selected span").first();

			String regEx = "[^0-9]";
			Pattern p = Pattern.compile(regEx);

			Matcher totalStr = p.matcher(totalSpan.html());

			result = new RegStaffs();
			result.setTotal(Integer.parseInt(totalStr.replaceAll("").trim()));

			Elements trs = doc.select("table.pro_table_box tbody tr");

			// 多出一个tr元素不并包含数据
			int pageSize = trs.size() > 1 ? (trs.size() - 1) : trs.size();

			// 处理第一页数据
			staffs = resolveRegStaff(corp.getZzjgdm(), trs);

			if (result.getTotal() > pageSize) {
				// 有分页，计算分页
				result.setPageSize(pageSize);
				result.setTotalPage((result.getTotal() / pageSize) + 1);

				logger.info("total : " + result.getTotal() + " - pagesize:"
						+ result.getPageSize() + " -totalpage:"
						+ result.getTotalPage());

				// 抓取分页数据
				for (int i = 2; i <= result.getTotalPage(); i++) {

					List<RegStaffVO> staffInPage = regStaffListReqByPage(corp.getZzjgdm(), 
							corp.getCorpPageID(), i, result.getTotal(),
							result.getPageSize());
					if (staffInPage != null && !staffInPage.isEmpty()) {
						staffs.addAll(staffInPage);
					}

				}

			}

			result.setStaffs(staffs);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

		if (result.getStaffs().isEmpty()) {
			logger.info(corp.getCorpID() + " has no reg staff");
		} else {
			logger.info(corp.getCorpID() + " staffs:");
			for (RegStaffVO vo : result.getStaffs()) {
				logger.info(vo.toString());
			}
		}

		return result;

	}

	private List<RegStaffVO> regStaffListResultForSinglePage(String corpId, String html) {

		List<RegStaffVO> staffs = null;
		Document doc = Jsoup.parse(html);
		try {
			Elements trs = doc.select("table.pro_table_box tbody tr");
			staffs = resolveRegStaff(corpId, trs);

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}
		return staffs;

	}

	private List<RegStaffVO> resolveRegStaff(String corpId, Elements trs) {
		List<RegStaffVO> staffs = new ArrayList<RegStaffVO>();
		for (Element tr : trs) {
			RegStaffVO staff = new RegStaffVO();
			staff.setCorpID(corpId);

			Elements tds = tr.getElementsByTag("td");
			String staffDetailUrlStr = null;
			String staffDetailUrl = null;
			if (tds.size() == 6) {
				staff.setName(tds.get(1).getElementsByTag("a").first().html());

				// 获取人员详细信息
				staffDetailUrlStr = tds.get(1).getElementsByTag("a")
						.attr("onclick");
				staffDetailUrl = staffDetailUrlStr.substring(
						staffDetailUrlStr.indexOf('/'),
						staffDetailUrlStr.lastIndexOf("'"));

				staff.setIdCard(tds.get(2).html());
				staff.setRegType(tds.get(3).html());
				staff.setRegNo(tds.get(4).html());
				staff.setRegMajor(tds.get(5).html());

				detailProc.regStaffDetailReq(staffDetailUrl, staff);

				staffs.add(staff);

			}

		}
		return staffs;
	}

}
