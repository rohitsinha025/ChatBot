package com.hybridFramework.PageObject;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.helper.Wait.WaitHelper;
import com.hybridFramework.testBase.TestBase;

public class IffcoTockyoHomePage {

	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(IRAHomePage.class);
	WaitHelper waitHelper;
	TestBase base;
	
	public IffcoTockyoHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}

}
