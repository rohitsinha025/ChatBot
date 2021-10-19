package com.hybridFramework.PageObject;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

import java.util.List;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.hybridFramework.helper.Javascript.JavaScriptHelper;
import com.hybridFramework.helper.Logger.LoggerHelper;
import com.hybridFramework.helper.Wait.WaitHelper;
import com.hybridFramework.helper.assertionHelper.VerificationHelper;
import com.hybridFramework.testBase.Config;
import com.hybridFramework.testBase.TestBase;

public class IRAHomePage {

	WebDriver driver;
	private final Logger log = LoggerHelper.getLogger(IRAHomePage.class);
	WaitHelper waitHelper;
	TestBase base;
	JavaScriptHelper javaScriptHelper;

	@FindBy(xpath = "//body/div[@id='avm_chat_widget_71bad76f-102c-465d-995a-d8e1f78b477c']/div[5]/h3[1]")
	WebElement testAgentIRAWelcomeMsg;
	
	@FindBy(xpath = "//a[@class='avm-icon-cross']")
	WebElement closeWelcomeMsg;
	
	@FindBy(xpath = "//a[@class='avm-bot-avatar']")
	WebElement iraIcon;
	
	@FindBy(xpath = "//a[contains(text(),'Get Started')]")
	WebElement getStartedLink;
	
	@FindBy(xpath = "//a[contains(text(),'Start Over')]")
	WebElement startOverMenuButtonLink;
	
	@FindBy(xpath = "//a[text()='Download']")
	WebElement downloadLink;
	
	@FindBy(xpath = "//textarea[@id='queryTextbox']")
	WebElement textField;
	
	@FindBy(xpath = "//button[contains(text(),'Send')]")
	WebElement sendButton;
	
	@FindBy(xpath = "//input[contains(@class,'helper')]")
	WebElement fullName;
	
	@FindBy(xpath = "//textarea[contains(@class,'helper')]")
	WebElement addres;
	
	@FindBy(xpath = "//span[contains(@class,'helper') and @aria-label='Male']")
	WebElement maleRadioButton;
	
	@FindBy(xpath = "//input[contains(@aria-label,'selection field')]")
	WebElement howOftenYouSearch;
	
	@FindBy(xpath = "//input[contains(@aria-label,'selection field')]/..//li[1]")
	WebElement selectHowOftenYouWork;
	
	@FindBy(xpath = "//label[contains(@aria-label,'rating 5')]")
	WebElement rating;
	
	@FindBy(xpath = "//button[contains(@class,'card_submit')]")
	WebElement submit;
	
	@FindBy(xpath = "//a[text()='Google']")
	WebElement googleLink;
	
	@FindBy(xpath = "//a[text()='Call']")
	WebElement callLink;
	
	@FindBy(xpath = "//button[contains(@aria-label,'popup')]")
	WebElement closeView;
	
	@FindBy(xpath = "//a[text()='Yes']")
	WebElement yes;
	
	@FindBy(xpath = "//a[text()='Motor']")
	WebElement chooseMotor;
	
	@FindBy(xpath = "//a[text()='Car Insurance']")
	WebElement chooseCarInsurance;
	 

	public IRAHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
		waitHelper = new WaitHelper(driver);
	}

	public void getWelcomeMessage() throws InterruptedException {
		waitHelper.setExplicitWait(2000);
		waitHelper.waitForElement(driver, testAgentIRAWelcomeMsg, new Config(TestBase.properties).getExplicitWait());
		String[] actualWelcomeMsg = { "Test agent - IRA", "Hello and welcome to IRA agent" };
		String[] expectedWelcomeMsg = testAgentIRAWelcomeMsg.getText().trim().split("\\r?\\n");
		Assert.assertEquals(actualWelcomeMsg[0], expectedWelcomeMsg[0]);
	}
	
	public void getFalseWelcomeMessage() throws InterruptedException {
		waitHelper.setExplicitWait(2000);
		waitHelper.waitForElement(driver, testAgentIRAWelcomeMsg, new Config(TestBase.properties).getExplicitWait());
		boolean flag = VerificationHelper.verifyTextEquals(testAgentIRAWelcomeMsg, "This is wrong text1");
		Assert.assertTrue(flag);
	}
	
	public void closeWelcomePopUpMsg() {
		log.info("Closing Welcome message pop-up");
		waitHelper.waitForElement(driver, new Config(TestBase.properties).getExplicitWait(), closeWelcomeMsg);
		closeWelcomeMsg.click();
	}
	
	public void clickOnIraIcon() {
		log.info("Clicking on IRA icon");
		waitHelper.waitForElement(driver, new Config(TestBase.properties).getExplicitWait(), iraIcon);
		iraIcon.click();
	}
	
	public void clickOnGetStartedLink() {
		log.info("Click on Get started link");
		waitHelper.waitForElement(driver, new Config(TestBase.properties).getExplicitWait(), getStartedLink);
		getStartedLink.click();
	}
	
	public void clickOniFrame(String iframeName) {
		driver.switchTo().defaultContent(); 
		driver.switchTo().frame(driver.findElement(By.name(iframeName)));
	}
	
	public void clickOnStartOverMenuButtonLink() {
		log.info("Click on start over menu button");
		waitHelper.waitForElement(driver, new Config(TestBase.properties).getExplicitWait(), startOverMenuButtonLink);
		startOverMenuButtonLink.click();
	}
	
	public void clickOnDownloadMotorPolicy() throws Exception {
		waitHelper.setExplicitWait(2000);
		String locator = "xpath://a[text()='Download Motor Policy']";
		base = new TestBase(driver);
		List<WebElement> listElements = base.getLocators(locator);
		if(listElements.size()>0) {
			log.info("Click on DownloadMotorPolicy");
			assertTrue(true, "Download Motor Policy is coming in the chat");
			listElements.get(0).click();
		}else {
			assertFalse(false, "Download Motor Policy is not coming in the chat");
		}
		
	}
	
	public void clickOnDownload() throws InterruptedException {
		waitHelper.setExplicitWait(2000);
		log.info("Click on Download link");
		waitHelper.waitForElement(driver, new Config(TestBase.properties).getExplicitWait(), downloadLink);
		downloadLink.click();
	}
	
	public void sendValues(String text) throws InterruptedException {
		waitHelper.setExplicitWait(2000);
		log.info("Click on Text field to enter some values");
		driver.switchTo().defaultContent(); 
		driver.switchTo().frame(driver.findElement(By.name("avaamoIframe")));
		textField.sendKeys(text);
	}
	
	public void clickOnSendButton() {
		log.info("Click on send button");
		waitHelper.waitForElement(driver, new Config(TestBase.properties).getExplicitWait(), sendButton);
		sendButton.click();
	}
	
	public void fillForm(String name,String address) throws InterruptedException {
		log.info("Fill the form");
		waitHelper.setExplicitWait(4000);
		log.info("Full name is entered : "+name);
		fullName.sendKeys(name);
		waitHelper.setExplicitWait(2000);
		log.info("Address is entered : "+address);
		addres.sendKeys(address);
		waitHelper.setExplicitWait(2000);
		javaScriptHelper = new JavaScriptHelper(driver);
		javaScriptHelper.scrollToElemetAndClick(maleRadioButton);
		waitHelper.setExplicitWait(2000);
		log.info("Click on drop-down to select how often you search");
		howOftenYouSearch.click();
		waitHelper.setExplicitWait(2000);
		log.info("Select from drop-down");
		selectHowOftenYouWork.click();
		waitHelper.setExplicitWait(2000);
		rating.click();
		waitHelper.setExplicitWait(2000);
		javaScriptHelper.scrollIntoView(submit);
		log.info("Click on submit");
		submit.click();
	}
	
	public void clickOnGoogleLink() throws InterruptedException {
		log.info("Click on Google link");
		waitHelper.waitForElement(driver, new Config(TestBase.properties).getExplicitWait(), googleLink);
		googleLink.click();
	}
	
	public void clickOnCallLink() {
		log.info("Click on Call link");
		waitHelper.waitForElement(driver, new Config(TestBase.properties).getExplicitWait(), callLink);
		callLink.click();
	}
	
	public void clickOnCloseView() {
		log.info("Close webview");
		waitHelper.waitForElement(driver, new Config(TestBase.properties).getExplicitWait(), closeView);
		closeView.click();
	}
	
	public void clickOnYesOption() {
		log.info("click on yes");
		waitHelper.waitForElement(driver, new Config(TestBase.properties).getExplicitWait(), yes);
		yes.click();
	}
	
	public void clickOnMotorOption() {
		log.info("click on Motor");
		waitHelper.waitForElement(driver, new Config(TestBase.properties).getExplicitWait(), chooseMotor);
		chooseMotor.click();
	}
	
	public void clickOnCarInsurance() {
		log.info("click on Car Insurance");
		waitHelper.waitForElement(driver, new Config(TestBase.properties).getExplicitWait(), chooseCarInsurance);
		chooseCarInsurance.click();
	}
}
