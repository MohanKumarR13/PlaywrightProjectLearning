package com.playwright;

import java.util.List;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VisibleElements {

	public static void main(String[] args) {
		Playwright playwright = Playwright.create();

		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));

		Page page = browser.newPage();
		//button:visible
		//button>>visible=true
		page.navigate("https://www.amazon.com/");
		List<String>linkText=page.locator("a:visible").allInnerTexts();
		for(int i=0;i<linkText.size();i++) {
			System.out.println(linkText.get(i));
		}
		int imagesCount=page.locator("xpath=//img >> visible=true").count();
		System.out.println(imagesCount);
	}

}
