package com.playwright;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class XpathLocator {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		page.navigate("https://www.amazon.com/");
		page.locator("//input[@id='twotabsearchtextbox']").fill("Mac Book Pro");
		Locator totalAmazonLinks = page.locator("//a[contains(text(),'Amazon')]");
		System.out.println(totalAmazonLinks.count());
		List<String> textList = totalAmazonLinks.allInnerTexts();
		for (String e : textList) {
			System.out.println(e);
		}
	}

}
