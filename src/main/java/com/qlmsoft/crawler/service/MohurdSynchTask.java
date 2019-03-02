package com.qlmsoft.crawler.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by aaronhuang on 2019/1/8.
 */
@Component
public class MohurdSynchTask {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    MohurdCorpCrawler crawler;

    @Scheduled(cron="0 0 17 ? * TUE")
    private void process(){
        logger.info("begin to crawler corps with expired certs.");
        crawler.crawlerCorpWithExpiredCert(false);
    }
}
