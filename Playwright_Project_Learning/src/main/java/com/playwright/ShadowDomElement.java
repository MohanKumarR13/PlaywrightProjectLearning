package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class ShadowDomElement {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		// Page--DOM-->Shadow DOM-->Elements
		// Page--DOM-->I Frame-->Shadow DOM-->Elements
		
		//page.navigate("https://selectorshub.com/xpath-practice-page/");
		//page.locator("#pact").locator("div#snacktimr #tea").fill("Ginger Masala Tea");

		
		page.navigate("https://books-pwakit.appspot.com/");
		page.locator("book-app[apptitle='BOOKS'] #input").fill("Testing Books");
		String text = page.locator("book-app[apptitle='BOOKS'] .books-desc").textContent();
		System.out.println(text);

	}

}
