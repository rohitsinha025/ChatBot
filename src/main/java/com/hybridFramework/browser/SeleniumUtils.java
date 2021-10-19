package com.hybridFramework.browser;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;

public class SeleniumUtils {

	public static final Logger logger = Logger.getLogger(SeleniumUtils.class.getName());
	public WebDriver driver;
	
	public SeleniumUtils(WebDriver driver) {
		this.driver = driver;
	}
	
	public String WindowHandle() {
		String windowHandle = driver.getWindowHandle();
		System.out.println("Current window handle is : "+windowHandle);
		return windowHandle;
	}
	
	public void switchToNewTab(String currentWindowHandle) {
		ArrayList<String> tabs = new ArrayList<String> (driver.getWindowHandles());
		for(int i=0;i<tabs.size();i++) {
			if(!tabs.get(i).equals(currentWindowHandle)) {
				driver.switchTo().window(tabs.get(i));
			}
		}
	}
	
	public void switchBackToPreviousWindow(String windowHandle) {
		driver.switchTo().window(windowHandle);
	}
	
	public void closeCurrentTab(String windowHandle) {
		driver.close();
		driver.switchTo().window(windowHandle);
	}
	
}
