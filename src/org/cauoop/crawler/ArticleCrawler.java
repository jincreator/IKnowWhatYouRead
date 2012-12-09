package org.cauoop.crawler;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ArticleCrawler {
	public String getHtml(String str, String hereText) {
		try {
			Document doc = Jsoup.connect(str).get();
			String page;
			if(hereText.isEmpty()) {
				page = doc.body().text();
			} else {
				page = doc.select(hereText).text();
			}
			return page.replaceAll("\\p{Punct}","");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	public String getHtml(String str) {
		return getHtml(str, "");
	}
}