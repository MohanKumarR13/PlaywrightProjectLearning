package com.playwright;

import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.options.FilePayload;

public class FileUpload {
	static Page page;

	public static void main(String[] args) throws InterruptedException {
		Playwright playwright = Playwright.create();
		Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
		page = browser.newPage();
		page.navigate("https://davidwalsh.name/demo/multiple-file-upload.php");
		// Single File Upload
		page.setInputFiles("input#filesToUpload", Paths.get("C:\\MyFolder\\s.txt"));
		Thread.sleep(4000);
		page.setInputFiles("input#filesToUpload", new Path[0]);
		// Multiple File Upload
		page.setInputFiles("input#filesToUpload", new Path[] { Paths.get("C:\\MyFolder\\s.txt"),
				Paths.get("C:\\MyFolder\\t.txt"), Paths.get("C:\\MyFolder\\u.txt") });
		Thread.sleep(4000);
		page.setInputFiles("input#filesToUpload", new Path[0]);
		// Run time File Upload
		page.setInputFiles("input#filesToUpload",
				new FilePayload("mohan.txt", "text-plain", "this is mohan".getBytes(StandardCharsets.UTF_8)));

	}
}