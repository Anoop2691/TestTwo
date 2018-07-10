package TestVariousTestCases;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class StatusCode {
	WebDriver driver;
	public StatusCode(WebDriver driver) {
		this.driver=driver;
	}
	public void verifyPageIsDisplayed() {
		driver.findElement(By.linkText("Status Codes")).click();
		Assert.assertEquals("Status Codes",driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText());
	}
	public void clickOnLink404() {
		driver.findElement(By.linkText("404")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("#content > div > p")).getText().contains("This page returned a 404 status code."));
	}
	public void check404StatusCode() throws IOException {
		URL url = new URL("http://10.0.31.161:9292/status_codes/404");
		HttpURLConnection connection = (HttpURLConnection)url.openConnection();
		connection.setRequestMethod("GET");
		connection.connect();
		int code = connection.getResponseCode();
		Assert.assertTrue(code==404);
	}
}
