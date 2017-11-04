package com.selenium.test;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Application implements ElementByXPathIdInf {

	static WebDriver driver = null;
	static WebDriverWait wait = null;
	static List<ArrayList<String>> excelData = null;
	static final String SITEURL = "https://sit2.ispectrum.com/buyflow/buyflow-localization?v=ORG";
	
	/**
	 * @param args
	 * 
	 */
	public static void main(String[] args) {

		System.setProperty("webdriver.gecko.driver", "E:\\projects\\java8\\seleniumtest\\geckodriver.exe");
		try {
			ApplicationInf application = new ApplicationImpl();
			excelData = new ReadExcelsheet().getExcelData();
			driver = (WebDriver) Class.forName(application.getDriverFullPath(excelData.get(1).get(0))).newInstance();
			driver.get(SITEURL);
//			driver.get("https://www.google.com");
			driver.manage().window().maximize();
			excelData.stream().forEach(cellValue -> application.process(cellValue));

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
