package com.qlmsoft.crawler.web;

import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.qlmsoft.crawler.service.CrawlerService;
import com.qlmsoft.crawler.service.MohurdCorpCrawler;

@RestController
public class CrawlerController {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private CrawlerService service;
	
	@Autowired
	private MohurdCorpCrawler mohurdCorpService;

	@RequestMapping("/crawler")
	public String index() {
		return "OK";
	}

	@RequestMapping("/crawler/start")
	public String start(String user, String password, String corpName) {
		if ("huangzhengyu".equals(user) && "GHadmin1234".equals(password)) {
			System.out.println("corpName:" + corpName);
//			service.start(corpName);
			service.beginCrawler(corpName);
			return "OK";
		} else {
			return "Fail";
		}

	}
	
	@RequestMapping("/crawler/qyzs")
	public String qyzs(String user, String password, String corpName) {
		if ("huangzhengyu".equals(user) && "GHadmin1234".equals(password)) {
			logger.info("begin to crawl qyzs for :" + corpName);
//			service.start(corpName);
			mohurdCorpService.start(corpName);;
			return "OK";
		} else {
			return "Fail";
		}

	}
	
	@RequestMapping("/crawler/qyzs/kanchasheji")
	public String qyzsKanchasheji(String user, String password,String corpName) {
//		if ("huangzhengyu".equals(user) && "GHadmin1234".equals(password)) {
			logger.info("begin to crawl");
//			service.start(corpName);
			if(StringUtils.isEmpty(corpName)){
				mohurdCorpService.start();
			}else {
				mohurdCorpService.start(corpName);
			}
			
			return "OK";
//		} else {
//			return "Fail";
//		}

	}
	
}
