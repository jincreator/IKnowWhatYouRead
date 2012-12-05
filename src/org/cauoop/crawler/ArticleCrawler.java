package org.cauoop.crawler;

import java.net.*;
import java.io.*;

public class ArticleCrawler {
	public String fetch(String address){
		try {
			URL cwURL = new URL(address);
			URLConnection cwURLConnection = cwURL.openConnection();
			cwURLConnection.connect();
			String encoding = cwURLConnection.getContentEncoding();
			BufferedReader in
				= new BufferedReader(
						new InputStreamReader(
								cwURLConnection.getInputStream(),encoding));
			//FIXME: Not sure InputStreamReader works well when encoding is null.
			StringBuilder builder = new StringBuilder();
			String aux = "";
			while ((aux = in.readLine()) != null) {
			    builder.append(aux);
			}
			in.close();
			String page = builder.toString();
			return page;
		} 
		catch (MalformedURLException e) { 
			// new URL() failed
			// ...
			return null;
		} 
		catch (IOException e) {   
			// openConnection() failed
			// ...
			return null;
		}
	}
}
