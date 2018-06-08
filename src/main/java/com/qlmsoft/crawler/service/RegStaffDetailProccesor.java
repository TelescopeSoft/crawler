package com.qlmsoft.crawler.service;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.time.DateUtils;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.qlmsoft.crawler.mohurd.bean.RegStaffVO;

@Service
public class RegStaffDetailProccesor {

	private static final String SPAN = "span>";

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	public static final String JZSC_URL = "http://jzsc.mohurd.gov.cn";

	public CloseableHttpClient closeHttpClient = HttpClients.createDefault();

	public void regStaffDetailReq(String staffDetailUrl, RegStaffVO staff) {

		CloseableHttpResponse httpResponse = null;
		HttpGet httpget = new HttpGet(JZSC_URL + staffDetailUrl);

		try {
			httpResponse = closeHttpClient.execute(httpget);
			String html = EntityUtils.toString(httpResponse.getEntity(),
					"UTF-8");

			if (html != null) {
				regStaffDetailResult(staff, html);
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

	}

	private void regStaffDetailResult(RegStaffVO staff, String html) {

		Document doc = Jsoup.parse(html);

		try {
			Element genderEl = doc.select(
					"div.query_info_box  div.activeTinyTabContent dl dd")
					.get(0);
			String genderStr = genderEl.html();
			staff.setGender(genderStr.substring(genderStr.lastIndexOf(SPAN)
					+ SPAN.length()));

			Element idTypeEl = doc.select(
					"div.query_info_box  div.activeTinyTabContent dl dd")
					.get(1);
			String idTypeStr = idTypeEl.html();
			staff.setIdType(idTypeStr.substring(idTypeStr.lastIndexOf(SPAN)
					+ SPAN.length()));

			Element idNoEl = doc.select(
					"div.query_info_box  div.activeTinyTabContent dl dd")
					.get(2);
			String idCardStr = idNoEl.html();
			staff.setIdCard2(idCardStr.substring(idCardStr.lastIndexOf(SPAN)
					+ SPAN.length()));

			Elements certEls = doc.select("div#regcert_tab  dl");
			if (certEls != null) {
				for (Element el : certEls) {
					Elements ddEl = el.getElementsByTag("dd");
					// logger.error("dd size :" + ddEl.size());

					Element regTypeEl = ddEl.get(0);
					String regTypeStr = regTypeEl.getElementsByTag("b").get(0)
							.html();

					if (!StringUtils.isBlank(staff.getRegMajor())) {
						// 有注册专业
						Element regMajorEl = ddEl.get(1);
						String regMajorStr = regMajorEl.html().substring(
								regMajorEl.html().lastIndexOf(SPAN)
										+ SPAN.length());
						if (regTypeStr.equals(staff.getRegType())
								&& regMajorStr.equals(staff.getRegMajor())) {

							Element regCertNoEl = ddEl.get(2);
							String regCertNo = regCertNoEl.html().substring(
									regCertNoEl.html().lastIndexOf(SPAN)
											+ SPAN.length());
							staff.setCertNo(regCertNo);

							Element regNoEl = ddEl.get(3);
							String regNoStr = regNoEl.html().substring(
									regNoEl.html().lastIndexOf(SPAN)
											+ SPAN.length());
							staff.setRegNo(regNoStr);

							Element regValidDateEl = ddEl.get(4);
							String regValidDateStr = regValidDateEl.html()
									.substring(
											regValidDateEl.html().lastIndexOf(
													SPAN)
													+ SPAN.length());
							staff.setValidDate(regValidDateStr);

							staff.setValid(DateUtils.parseDate(regValidDateStr,
									"yyyy年MM月dd日"));

							// 注册单位
							// Element regCorp =
							// el.getElementsByTag("dt").get(0);
							break;
						}

					} else {
						// 没有注册专业
						if (regTypeStr.equals(staff.getRegType())) {

							Element regCertNoEl = ddEl.get(1);
							String regCertNo = regCertNoEl.html().substring(
									regCertNoEl.html().lastIndexOf(SPAN)
											+ SPAN.length());
							staff.setCertNo(regCertNo);

							Element regNoEl = ddEl.get(2);
							String regNoStr = regNoEl.html().substring(
									regNoEl.html().lastIndexOf(SPAN)
											+ SPAN.length());
							staff.setRegNo(regNoStr);

							Element regValidDateEl = ddEl.get(3);
							String regValidDateStr = regValidDateEl.html()
									.substring(
											regValidDateEl.html().lastIndexOf(
													SPAN)
													+ SPAN.length());
							staff.setValidDate(regValidDateStr);

							staff.setValid(DateUtils.parseDate(regValidDateStr,
									"yyyy年MM月dd日"));

							// 注册单位
							// Element regCorp =
							// el.getElementsByTag("dt").get(0);
							break;
						}
					}

				}
			}

		} catch (Exception e) {
			e.printStackTrace();
			logger.error(e.getMessage());
		}

	}

}
