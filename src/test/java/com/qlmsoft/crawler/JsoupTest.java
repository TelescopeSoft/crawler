package com.qlmsoft.crawler;

import java.io.File;
import java.io.IOException;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class JsoupTest {

	private final static Logger logger = LoggerFactory.getLogger(JsoupTest.class);

	public static void main(String[] args) throws IOException {
		logger.info("start");
		File input = new File("jsoup.html");
		Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
		Elements els = doc.select("div.search_name a");

		String qymc = "海门市青龙船务工程有限公司";
		String innerUrl = null;
		String corpName = null;

		for (Element el : els) {
			logger.info("html:" + el.html());
			corpName = el.getElementsByTag("span").get(0).html();
			if (("<em>" + qymc + "</em>").equals(corpName)) {
				innerUrl = el.attr("href");
				break;
			}
		}
		
		logger.info("innerUrl:" + innerUrl);

	}

}
