package TestVariousTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class LoginPageValidation {
	WebDriver driver;
	public LoginPageValidation(WebDriver driver) {
		this.driver=driver;
	}
	public void PageIsDisplayed() {
		driver.findElement(By.linkText("Form Authentication")).click();
		Assert.assertEquals("Login Page",driver.findElement(By.xpath("//div[@id='content']/div/h2")).getText(),"Assertion failed: Clicked on 'Form Authentication' and verified that page is not displayed");
		Reporter.log("Assertion passed: Clicked on 'Form Authentication' and verified that page is displayed",true);
	}
	public void validateWithInvalidCredentials() {
		driver.findElement(By.cssSelector("#username")).sendKeys("Anoop");
		driver.findElement(By.cssSelector("#password")).sendKeys("Anoop");
		driver.findElement(By.className("radius")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("#flash")).getText().contains("Your username is invalid!"),"Assertion failed:Verified error message is not displayed on Login page");
		Reporter.log("Assertion passed:Verified error message is displayed on Login page",true);

	}
	public void validateWithValidCredentials() {
		driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
		driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.className("radius")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("#flash")).getText().contains("You logged into a secure area!"),"Assertion failed:verified that secure page is not displayed");
		Reporter.log("Assertion passed:verified Secure Area page is displayed",true);
		driver.findElement(By.cssSelector("#content > div > a > i")).click();
		System.out.println(driver.findElement(By.cssSelector("#flash")).getText());
		Assert.assertTrue(driver.findElement(By.cssSelector("#flash")).getText().contains("You logged out of the secure area!"),"Assertion failed:verified that You did not logged out of the secure area");
		Reporter.log("Assertion passed:verified that You logged out of the secure area",true);

	}
}
