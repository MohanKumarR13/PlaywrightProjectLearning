package com.playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Download;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class DownloadFile {
	static Page page;

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = browser.newPage();
		page.navigate("https://chromedriver.storage.googleapis.com/index.html?path=102.0.5005.27/");

		Download download = page.waitForDownload(() -> {
			page.click("a:text('chromedriver_mac64.zip')");
		});
		// download.cancel();
		System.out.println(download.failure());

		System.out.println(download.url());
		System.out.println(download.page().title());

		String path = download.path().toString();
		System.out.println(path);

		download.saveAs(Paths.get("Mohan.zip"));
		System.out.println(download.suggestedFilename());
	}
}