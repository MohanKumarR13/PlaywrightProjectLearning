package com.playwright;

import java.nio.charset.StandardCharsets;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class FileUploadContent {
	static Page page;

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = browser.newPage();
		page.navigate("https://cgi-lib.berkeley.edu/ex/fup.html");

		// Run time File Upload
		page.setInputFiles("input[name='upfile']",
				new FilePayload("mohan.txt", "text-plain", "this is mohan".getBytes(StandardCharsets.UTF_8)));
		page.click("input[value='Press']");
	}
}