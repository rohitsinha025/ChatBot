package com.hybridFramework.IRALaunchPage;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.IRAHomePage;
import com.hybridFramework.browser.SeleniumUtils;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class IRALaunchPageWithErrorCapture extends TestBase{

	private final Logger log = LoggerHelper.getLogger(IRAlaunchpage.class);
	public IRAHomePage iraHomePage;
	String currentWindowHandle = null;
	
	@BeforeTest
	public void instantiateValues() {
		iraHomePage = new IRAHomePage(driver);
	}

	@Test
	public void startWithIRA() throws Exception {
		log.info(IRAlaunchpage.class.getName() + " started");
		Config config = new Config(properties);
		driver.get(config.getWebsite());
		
		iraHomePage.getFalseWelcomeMessage();
		iraHomePage.closeWelcomePopUpMsg();
	}
}
