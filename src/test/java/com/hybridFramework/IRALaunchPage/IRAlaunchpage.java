package com.hybridFramework.IRALaunchPage;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.IRAHomePage;
import com.hybridFramework.browser.SeleniumUtils;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.helper.Wait.WaitHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class IRAlaunchpage extends TestBase {
	private final Logger log = LoggerHelper.getLogger(IRAlaunchpage.class);
	public SeleniumUtils seleniumUtils;
	public IRAHomePage iraHomePage;
	public WaitHelper waitHelper;
	String currentWindowHandle = null;
	
	@BeforeTest
	public void instantiateValues() {
		seleniumUtils = new SeleniumUtils(driver);
		iraHomePage = new IRAHomePage(driver);
		waitHelper = new WaitHelper(driver);
	}

	@Test(description = "Welcome Screen - Click on Notification, get that text and get into the bot Type any greetings message and fetch the response message"
			+ "<Menu Options> - click on the <Start Over> button, Click on Download Motor Policy and Click on Download link")
	public void startWithIRA() throws Exception {
		log.info(IRAlaunchpage.class.getName() + " started");
		Config config = new Config(properties);
		driver.get(config.getWebsite());
		
		currentWindowHandle = seleniumUtils.WindowHandle();

		iraHomePage.getWelcomeMessage();
		iraHomePage.closeWelcomePopUpMsg();
		iraHomePage.clickOnIraIcon();
		iraHomePage.clickOnGetStartedLink();
		iraHomePage.clickOniFrame("avaamoIframe");
		iraHomePage.clickOnStartOverMenuButtonLink();
		waitHelper.setExplicitWait(3000);
		iraHomePage.clickOnDownloadMotorPolicy();
		iraHomePage.clickOnDownload();
	
		seleniumUtils.switchToNewTab(currentWindowHandle);
		
		log.info("URL of new window is : "+driver.getCurrentUrl());
		
		seleniumUtils.switchBackToPreviousWindow(currentWindowHandle);
	}
	
	@Test(dependsOnMethods = { "startWithIRA" }, description = "Type <Test Bot> - Fill the Form and Submit")
	public void fillForm() throws InterruptedException {
		iraHomePage.sendValues("Test Bot");
		waitHelper.setExplicitWait(2000);
		iraHomePage.clickOnSendButton();
		iraHomePage.fillForm("ABC", "Bangalore");
	}
	
	@Test(dependsOnMethods = { "fillForm" }, description = "Type <New Test> - Click on Links Google and close the web view. Click on call and Close the call popup")
	public void tryWithNewKeyWords() throws InterruptedException {
		iraHomePage.sendValues("New Test");
		waitHelper.setExplicitWait(2000);
		iraHomePage.clickOnSendButton();
		iraHomePage.clickOnGoogleLink();
		waitHelper.setExplicitWait(2000);
		iraHomePage.clickOnCloseView();
		waitHelper.setExplicitWait(2000);
		iraHomePage.clickOnCallLink();
		
		seleniumUtils.switchToNewTab(currentWindowHandle);
		waitHelper.setExplicitWait(2000);
		seleniumUtils.closeCurrentTab(currentWindowHandle);
		waitHelper.setExplicitWait(2000);
	}
}
