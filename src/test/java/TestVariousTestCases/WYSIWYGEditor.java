package TestVariousTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.Reporter;

public class WYSIWYGEditor {

	WebDriver driver;
	public WYSIWYGEditor(WebDriver driver) {
		this.driver=driver;
	}
	public void checkPageIsDisplayed() {
		driver.findElement(By.linkText("WYSIWYG Editor")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//div[@id='mceu_13-body']")).isDisplayed(),"Assertion failed:Clicked on 'WYSIWYG Editor' and verified that page is not displayed");
		Reporter.log("Assertion passed:Clicked on 'WYSIWYG Editor' and verified that page is displayed",true);
	}
	public void editEditor() {
		driver.switchTo().frame("mce_0_ifr");
		driver.findElement(By.id("tinymce")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("QA Infotech");
		driver.findElement(By.id("tinymce")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//div[@id='mceu_3']/button/i")).click();
		driver.switchTo().frame("mce_0_ifr");
		String Expected="QA Infotech";
		String Actual=driver.findElement(By.cssSelector("#tinymce > p > strong")).getText();
		System.out.println(Actual);
		Assert.assertEquals(Actual, Expected,"Assertion failed: After editing texbox verified that the text entered in text editor doesn't appears in Bold style");
		Reporter.log(" Assertion passed: After editing texbox verified that the text entered in text editor now appears in Bold style",true);
	}
}