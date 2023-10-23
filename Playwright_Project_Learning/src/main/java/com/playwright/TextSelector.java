package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class TextSelector {
	public static void main(String[] args) {

		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		// Text Locators
		Page page = browser.newPage();
		// page.navigate("https://www.orangehrm.com/en/30-day-free-trial/");

		page.navigate("https://demo.opencart.com/index.php?route=account/login");
		/*
		 * page.locator("text=Contact Sales").click(); Locator links =
		 * page.locator(("text= Privacy Policy")); for (int i = 0; i < links.count();
		 * i++) { String text = links.nth(i).textContent(); if
		 * (text.contains("Service Privacy Policy")) { links.nth(i).click(); break; } }
		 */

		String header = page.locator("h2:has-text('New Customer')").textContent();
		System.out.println(header);

		String header1 = page.locator("div.well h2:has-text('New Customer')").textContent();
		System.out.println(header1);

		String pageheader = page.locator("text= Your Store").first().textContent();
		System.out.println(pageheader);

		page.locator("form input:has-text('Login')").click();
	}
}