package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class LocatorConcept {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		/*
		 * page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial"); //Single
		 * Element Locator contactSales = page.locator("text= Contact Sales");
		 * contactSales.hover(); contactSales.click();
		 */

		/*
		 * page.navigate("https://academy.naveenautomationlabs.com/");
		 * 
		 * Locator loginBtn = page.locator("text= Login"); int totalLogin =
		 * loginBtn.count(); System.out.println(totalLogin); loginBtn.first();
		 * loginBtn.click();
		 */
		// Multiple Elements
		page.navigate("https://www.orangehrm.com/orangehrm-30-day-trial");

		Locator countryOptions = page.locator("Form_getForm_Country");
		System.out.println(countryOptions.count());
		for (int i = 0; i < countryOptions.count(); i++) {
			String text = countryOptions.nth(i).textContent();
			System.out.println(text);
		}
		/*
		 * List<String> optionTextList = countryOptions.allTextContents(); for (String e
		 * : optionTextList) { System.out.println(e); } optionTextList.forEach(ele ->
		 * System.out.println(ele));
		 */

	}

}
