package org.cauoop.crawler;

import java.io.IOException;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

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
	public String selectGet(String address, String hereLink, String hereText, String deny) {
		String data="";
		try {
			Elements newsHeadlines;
			if(hereLink.isEmpty()) {
				newsHeadlines = Jsoup.connect(address).get().select("a[href]");
			} else {
				newsHeadlines = Jsoup.connect(address).get().select(hereLink).select("a[href]");
			}
			for(Element l:newsHeadlines) {
				String link = l.attr("abs:href");
				if(!deny.isEmpty()&&link.contains(deny)) {
					continue;
				}
				data = data + getHtml(link,hereText) + " ";
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(data);
		return data;
	}
	public String selectGet(String address, String hereLink, String hereText) {
		return selectGet(address, hereLink, hereText, "");
	}
	public String selectGet(String address, String hereText) {
		return selectGet(address, "", hereText, "");
	}
}