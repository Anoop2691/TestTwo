package TestVariousTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class LoginPageValidation {
	WebDriver driver;
	public LoginPageValidation(WebDriver driver) {
		this.driver=driver;
	}
	public void PageIsDisplayed() {
		driver.findElement(By.linkText("Form Authentication")).click();
		Assert.assertEquals("Login Page",driver.findElement(By.xpath("//*[@id=\"content\"]/div/h2")).getText());
	}
	public void validateWithInvalidCredentials() {
		driver.findElement(By.cssSelector("#username")).sendKeys("Anoop");
		driver.findElement(By.cssSelector("#password")).sendKeys("Anoop");
		driver.findElement(By.className("radius")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("#flash")).getText().contains("Your username is invalid!"));
	}
	public void validateWithValidCredentials() {
		driver.findElement(By.cssSelector("#username")).sendKeys("tomsmith");
		driver.findElement(By.cssSelector("#password")).sendKeys("SuperSecretPassword!");
		driver.findElement(By.className("radius")).click();
		Assert.assertTrue(driver.findElement(By.cssSelector("#flash")).getText().contains("You logged into a secure area!"));
		driver.findElement(By.cssSelector("#content > div > a > i")).click();
		System.out.println(driver.findElement(By.cssSelector("#flash")).getText());
		Assert.assertTrue(driver.findElement(By.cssSelector("#flash")).getText().contains("You logged out of the secure area!"));
		
	}
}
