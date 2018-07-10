package TestVariousTestCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import junit.framework.Assert;

public class StatusCode {
	WebDriver driver;
	public StatusCode(WebDriver driver) {
		this.driver=driver;
	}
	public void verifyPageIsDisplayed() {
		driver.findElement(By.linkText("Status Codes")).click();
		Assert.assertEquals("Status Codes",driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText(),"Assertion failed:Clicked on 'Status Codes' and verified that page is not displayed");
		Reporter.log("Assertion passed:Clicked on 'Status Codes' and verified that page is displayed",true);
	}
	public void clickOnLink404() {
		driver.findElement(By.linkText("404")).click();
		Assert.assertTrue("Assertion failed:Verified page is not displayed with 404 message",driver.findElement(By.cssSelector("#content > div > p")).getText().contains("This page returned a 404 status code."));
		Reporter.log("Assertion passed:Verified page is displayed with 404 message",true);
	}
	public void check404StatusCode() throws IOException {
		URL url = new URL("http://10.0.31.161:9292/status_codes/404");
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		int code = connection.getResponseCode();
		Assert.assertTrue("Assertion failed:verified the HTTP Status code of the page is not 404",code==404);
		Reporter.log("Assertion passed:verified the HTTP Status code of the page is 404",true);
	}
}
