package com.playwright;

import java.awt.Dimension;
import java.awt.Toolkit;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType.LaunchOptions;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightBasics {

	public static void main(String[] args) {
		Dimension toolkit = Toolkit.getDefaultToolkit().getScreenSize();
		int width = (int) toolkit.getWidth();
		int height = (int) toolkit.getWidth();

		Playwright playwright = Playwright.create();
		LaunchOptions launchOptions = new LaunchOptions();
		launchOptions.setChannel("chrome");
		launchOptions.setHeadless(false);
		Browser browser = playwright.chromium().launch(launchOptions);
		// Browser browser = playwright.chromium().launch(new
		// BrowserType.LaunchOptions().setHeadless(false));
		// Browser browser = playwright.webkit().launch(new
		// BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser
				.newContext(new Browser.NewContextOptions().setViewportSize(width, height));
		Page page = browserContext.newPage();

		// Page page = browser.newPage();
		page.pause();
		page.navigate("https://www.amazon.com");
		String title = page.title();
		System.out.println("Page title is : " + title);
		String url = page.url();
		System.out.println("URL is : " + url);
		browser.close();
		playwright.close();

	}

}
