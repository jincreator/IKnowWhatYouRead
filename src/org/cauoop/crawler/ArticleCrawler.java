package org.cauoop.crawler;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class ArticleCrawler {
	public String getHtml(String str) {
		Document doc;
		try {
			doc = Jsoup.connect(str).get();
			return doc.body().text();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
}
