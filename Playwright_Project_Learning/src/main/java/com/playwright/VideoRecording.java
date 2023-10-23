package com.playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class VideoRecording {
	static Page page;

	public static void main(String[] args) throws InterruptedException {

		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		BrowserContext browserContext = browser
				.newContext(new Browser.NewContextOptions().setRecordVideoDir(Paths.get("myvideos/")).setRecordVideoSize(640,480));
		page = browserContext.newPage();
		page.navigate("https://academy.naveenautomationlabs.com/");
		page.click("text=Login");
		page.click("button:has-text(\"Sign Up\")");
		page.click("[placeholde\"Name\"]");
		page.fill("[placeholde\"Name\"]", "testingautomation");
		page.fill("[placeholde\"Email\"]", "testingautomation@gmail.com");
		page.fill("[placeholde\"Create Password\"]", "test123");
		page.click("text=+91");
		page.click(":nth-match(:text(\"India (भारत\"),2)");

		page.click("[placeholde\"Mobile\"]");
		page.fill("[placeholde\"Name\"]", "9898989898");
		page.click("text=By signing up,I agree to the Terms of Use and Privacy Policy. >> i");
		page.click("#loginFormHtml div [aria-label=\"Close\"]");
		browserContext.close();
		page.close();
		playwright.close();

	}
}