package com.hybridFramework.IRALaunchPage;

import org.apache.log4j.Logger;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.hybridFramework.PageObject.IRAHomePage;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.helper.Wait.WaitHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class IRAInsuranceRenew extends TestBase {
	
	private final Logger log = LoggerHelper.getLogger(IRAlaunchpage.class);
	public IRAHomePage iraHomePage;
	public WaitHelper waitHelper;
	
	@BeforeTest
	public void instantiateValues() {
		iraHomePage = new IRAHomePage(driver);
		waitHelper = new WaitHelper(driver);
	}
	
	
	@Test(priority = 1, description = "Welcome Screen - Click on Notification, get that text and get into the bot Type any greetings message and fetch the response message"
			+ "<Menu Options> - click on the <Start Over> button, Click on Download Motor Policy and Click on Download link")
	public void startWithIRA() throws Exception {
		log.info(IRAlaunchpage.class.getName() + " started");
		Config config = new Config(properties);
		driver.get(config.getWebsite());
		
		iraHomePage.getWelcomeMessage();
		iraHomePage.closeWelcomePopUpMsg();
		iraHomePage.clickOnIraIcon();
		iraHomePage.clickOnGetStartedLink();
		iraHomePage.clickOniFrame("avaamoIframe");
		iraHomePage.clickOnStartOverMenuButtonLink();
		waitHelper.setExplicitWait(2000);
		iraHomePage.sendValues("I need to renew my motor policy");
		waitHelper.setExplicitWait(2000);
		iraHomePage.clickOnSendButton();
		waitHelper.setExplicitWait(2000);
		iraHomePage.sendValues("M0012345");
		waitHelper.setExplicitWait(2000);
		iraHomePage.clickOnSendButton();
		waitHelper.setExplicitWait(2000);
		iraHomePage.sendValues("HR21AB1010");
		waitHelper.setExplicitWait(2000);
		iraHomePage.clickOnSendButton();
		waitHelper.setExplicitWait(2000);
		iraHomePage.sendValues("9857689500");
		waitHelper.setExplicitWait(2000);
		iraHomePage.clickOnSendButton();
		waitHelper.setExplicitWait(2000);
		iraHomePage.sendValues("rohitsinha024@gmail.com");
		waitHelper.setExplicitWait(2000);
		iraHomePage.clickOnSendButton();
		waitHelper.setExplicitWait(2000);
		iraHomePage.clickOnYesOption();
		waitHelper.setExplicitWait(2000);
	}
	
	@Test(priority = 2)
	public void buyNewPolicy() throws InterruptedException {
		iraHomePage.sendValues("I want to buy a new policy");
		waitHelper.setExplicitWait(2000);
		iraHomePage.clickOnSendButton();
		waitHelper.setExplicitWait(2000);
		iraHomePage.clickOnMotorOption();
		waitHelper.setExplicitWait(2000);
		iraHomePage.clickOnCarInsurance();
		waitHelper.setExplicitWait(2000);
	}
	
	@Test(priority = 3)
	public void intimateAClaim() throws InterruptedException {
		iraHomePage.sendValues("how to intimate a claim?");
		waitHelper.setExplicitWait(2000);
		iraHomePage.clickOnSendButton();
		waitHelper.setExplicitWait(4000);
	}
	
}
