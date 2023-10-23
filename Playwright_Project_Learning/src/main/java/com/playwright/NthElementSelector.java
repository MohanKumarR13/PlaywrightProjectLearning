package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class NthElementSelector {
	static Page page;

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		page = browser.newPage();
		page.navigate("https://www.bigbasket.com/");
		Locator locator = page.locator("div.footer-links li a >> nth=0");
		String ele = locator.textContent();
		System.out.println(ele);
		locator.click();
		
		Locator locator1 = page.locator("div.footer-links li a >> nth=1");
		String ele1 = locator1.textContent();
		System.out.println(ele1);
	}
}