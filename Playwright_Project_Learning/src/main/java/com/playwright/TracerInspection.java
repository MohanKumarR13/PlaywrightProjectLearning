package com.playwright;

import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.FrameLocator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Tracing;
import com.microsoft.playwright.options.AriaRole;

public class TracerInspection {

	public static void main(String[] args) {
		try (Playwright playwright = Playwright.create()) {
			Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
			BrowserContext context = browser.newContext();
			context.tracing().start(new Tracing.StartOptions().setScreenshots(true).setScreenshots(true));
			Page page = browser.newPage();
			page.navigate("https://academy.naveenautomationlabs.com/");
			page.getByRole(AriaRole.LINK, new Page.GetByRoleOptions().setName("Login")).click();

			page.frameLocator("#microfe-popup-login").getByText("Sign up").click();
			page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").click();
			page.frameLocator("#microfe-popup-login").getByPlaceholder("Name").fill("Mohan");
			page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").click();
			page.frameLocator("#microfe-popup-login").getByPlaceholder("Email address").fill("123@gmail.com");
			page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").click();
			page.frameLocator("#microfe-popup-login").getByPlaceholder("Password").fill("moh@nR13");
			page.frameLocator("#microfe-popup-login")
					.getByRole(AriaRole.BUTTON, new FrameLocator.GetByRoleOptions().setName("Next")).click();
			page.frameLocator("#microfe-popup-login").getByPlaceholder("Enter your number").click();
			page.frameLocator("#microfe-popup-login").getByPlaceholder("Enter your number").fill("+91 98765-45678");
			page.frameLocator("#microfe-popup-login").locator("#loginPopupCloseBtn svg").click();

			context.tracing().stop(new Tracing.StopOptions()

					.setPath(Paths.get("trace.zip")));
		}
	}

}
