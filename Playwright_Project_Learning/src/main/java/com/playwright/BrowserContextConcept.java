package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class BrowserContextConcept {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext1 = browser.newContext();
		Page page1 = browserContext1.newPage();
		page1.navigate("https://www.orangehrm.com/orangehrm-30-day-trial");
		page1.fill("#Form_getForm_Name", "Mohan");
		System.out.println("Title is " + page1.title());

		BrowserContext browserContext2 = browser.newContext();
		Page page2 = browserContext2.newPage();
		page2.navigate("http://www.automationpractice.pl/index.php");
		page2.fill("#search_query_top", "Dress");
		System.out.println("Title is " + page2.title());

		BrowserContext browserContext3 = browser.newContext();
		Page page3 = browserContext3.newPage();
		page3.navigate("http://google.com/");
		System.out.println("Title is " + page3.title());

		page1.close();
		browserContext1.close();
		page2.close();
		browserContext2.close();
		page3.close();
		browserContext3.close();
	}

}
