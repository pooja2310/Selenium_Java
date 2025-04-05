package org.example.login;

import org.example.base.TestBase;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class WebTableHandlingElements extends TestBase {
	
	String beforeXpath = "//table[@class='table table-striped mt-3']/tbody/tr[";
	String afterXpath = "]/td[1]";
	
	String beforeXpathCol = "//table[@class='table table-striped mt-3']/tbody/tr[";
	String middleXpathCol= "]/td[";
	String afterXpathCol = "]";
	
	String beforeXpathColHdr = "//table[@class='table table-striped mt-3']/thead/tr[1]/th[";
	
	String afterXpathColHdr = "]";
	
	public void webTableHandle() {
		List<WebElement> rows = driver.findElements(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr"));
		int rowCount = rows.size();
		System.out.println("Row count is :" + rowCount);
		List<WebElement> col = driver.findElements(By.xpath("//table[@class='table table-striped mt-3']/tbody/tr[1]/td"));
		int colCount = col.size();
		System.out.println("column count is :" + colCount);
		System.out.println("-------------------------");
		
		// This is to display column header.
		for (int i = 1; i <= colCount; i++) {
			String colHdrXpath = beforeXpathColHdr + i + afterXpathColHdr;
			WebElement colHdr = driver.findElement(By.xpath(colHdrXpath));
			System.out.println("Column Header : " + colHdr.getText());
		}
		System.out.println("-------------------------");

		/* This is to display first column data.
		for (int i = 1; i <= rowCount; i++) {
			String firstnameXpath = beforeXpath + i + afterXpath;
			WebElement firstColData = driver.findElement(By.xpath(firstnameXpath));
			System.out.println("First Column Data : " +firstColData.getText());
		}
		System.out.println("-------------------------");*/
		
		/* This is to display first row data.
		for (int i = 1; i <= colCount; i++) {
			String actualXpath = beforeXpathCol + i + afterXpathCol;
			WebElement firstRowData = driver.findElement(By.xpath(actualXpath));
			System.out.println("First Row Data : " +firstRowData.getText());
		}*/
		
		// This is to display row and column data.
		for (int i = 1; i <= rowCount; i++) {
			for (int j = 1; j < colCount; j++) {
				
				String actualXpath = beforeXpathCol + i + middleXpathCol + j + afterXpathCol;
				WebElement rowColData = driver.findElement(By.xpath(actualXpath));
				System.out.println(rowColData.getText());
			}
		}
	}
}
