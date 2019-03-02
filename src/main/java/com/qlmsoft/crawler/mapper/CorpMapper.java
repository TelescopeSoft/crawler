package com.qlmsoft.crawler.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.qlmsoft.crawler.entity.CorpEntity;

public interface CorpMapper {

	List<CorpEntity> getCorpWithoutUnifiedSocialCreditCode();

	void updateUnifiedSocialCreditCode(CorpEntity corp);

	void updateNoCredCode(CorpEntity corp);

	// CorpEntity findCorpByUnifiedSocialCreditCode(String code);

	// 勘察设计企业
	List<CorpEntity> getSurveyAndDesign();

	// 勘察企业
	List<CorpEntity> getSurveyAndDesignStaff();

	// 新增企业部分
	List<CorpEntity> getSurveyAndDesignAdd();

	// 过期资质的企业
	List<CorpEntity> getCorpWithExpiredCert();

	// 培训企业名单
	List<String> getPeixun();

	CorpEntity getCorpByZzjgdm(@Param(value = "qyID") String qyID);

}