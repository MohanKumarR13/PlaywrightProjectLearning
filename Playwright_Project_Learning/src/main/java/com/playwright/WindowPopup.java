package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class WindowPopup {
	static Page page1;
	static Page page2;

	public static void main(String[] args) throws InterruptedException {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("https://opensource-demo.orangehrmlive.com/");
		// Open new tab/window afterclick on link on the parent page
		Page popup = page.waitForPopup(() -> {
			page.click("img[alt='OrangeHRM on twitter']");
		});
		System.out.println("Popup Window title : " + popup.title());
		popup.close();
		System.out.println("Parent Window title : " + page.title());
		page.close();
//Open new tab/window pop up and enter the url
		Page popup1 = page.waitForPopup(() -> {
			page.click("img[target='_blank']");
		});
		popup1.waitForLoadState();
		popup1.navigate("https://www.amazon.com/");

		System.out.println("Popup Window title : " + popup1.title());
		popup.close();
		System.out.println("Parent Window title : " + page.title());
		page.close();
		/*
		 * BrowserContext browserContext1 = browser.newContext(); BrowserContext
		 * browserContext2 = browser.newContext();
		 * 
		 * page1 = browserContext1.newPage(); page2 = browserContext2.newPage();
		 * 
		 * page1.navigate("https://www.google.com/");
		 * page2.navigate("https://www.amazon.com/");
		 */

	}
}