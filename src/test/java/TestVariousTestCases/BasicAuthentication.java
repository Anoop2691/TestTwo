package TestVariousTestCases;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class BasicAuthentication {
	WebDriver driver;
	public BasicAuthentication(WebDriver driver) {
		this.driver=driver;
	}
	void clickOnBasicAuth() {
		driver.findElement(By.linkText("Basic Auth")).click();
		Alert alert=driver.switchTo().alert();
		String s=alert.getText();
		System.out.println(s);
		Assert.assertEquals("Sign In", s);
		alert.sendKeys("admin" + Keys.TAB + "admin");
		//alert.authenticateUsing(new UserAndPassword("admin", "admin"));
		//alert.setAuthenticationCredentials();
		//alert.accept();
	}
}
