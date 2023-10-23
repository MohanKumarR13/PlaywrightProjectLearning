package com.playwright;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class FrameHandle {
	public static void main(String[] args) {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser.newContext();
		Page page = browserContext.newPage();
		page.navigate("http://londonfreelance.org/courses/frames/index.html");
		String header = page.frameLocator("frame[name='main']").locator("h2").textContent();
		System.out.println(header);
		String header2 = page.frame("main").locator("h2").textContent();
		System.out.println(header2);

		BrowserContext browserContext1 = browser.newContext();
		Page page1 = browserContext1.newPage();
		page1.navigate("https://www.formsite.com/templates/registration-form-templates/vehicle-registration-form/");

		page1.locator("img[title=vehicle-registration-forms-and-templates']").click();

		page1.frameLocator("//iframe[contains(@id,'frame-one)]").locator("#RESUET_TEXTField-8").fill("Mohan");
	}
}