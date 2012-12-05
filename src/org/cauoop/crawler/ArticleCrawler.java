package org.cauoop.crawler;

import java.net.*;
import java.io.*;

public class ArticleCrawler {
	public void fetch(String address){
		try {
			URL cwURL = new URL(address);
			URLConnection cwURLConnection = cwURL.openConnection();
			cwURLConnection.connect();
		} 
		catch (MalformedURLException e) { 
			// new URL() failed
			// ...
		} 
		catch (IOException e) {   
			// openConnection() failed
			// ...
		}
	}
}
