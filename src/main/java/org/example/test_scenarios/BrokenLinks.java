package org.example.test_scenarios;

import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

public class BrokenLinks extends TestBase {
	public void countOfLinks() {
		List<WebElement> listOfLinks = driver.findElements(By.tagName("a"));
		System.out.println(listOfLinks.size());
		List<String> urlList= new ArrayList<>();
		for(WebElement e: listOfLinks){
			String url=e.getDomAttribute("href");
		  // urlList.add(url);
		   checkBrokenLinks(url);
			//urlList.parallelStream().forEach(e->checkBrokenLinks(e));  -----This is for performance improvement.
		 
		}
	}
	
	public void checkBrokenLinks(String urlLink){
		try{
		URL url =new URL(urlLink);
		HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
		httpURLConnection.setConnectTimeout(5000);
		httpURLConnection.connect();
		if(httpURLConnection.getResponseCode()>=400){
			System.out.println(urlLink + "----" + httpURLConnection.getResponseMessage() + " is a Broken link");}
			else
			{
			  System.out.println(urlLink + "----" + httpURLConnection.getResponseMessage());
			}
		} catch (Exception ex) {
		
		}
	
	}
}
