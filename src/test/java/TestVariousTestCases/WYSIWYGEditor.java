package TestVariousTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

public class WYSIWYGEditor {

	WebDriver driver;
	public WYSIWYGEditor(WebDriver driver) {
		this.driver=driver;
	}
	public void checkPageIsDisplayed() {
		driver.findElement(By.linkText("WYSIWYG Editor")).click();
		Assert.assertTrue(driver.findElement(By.xpath("//*[@id=\"mceu_13-body\"]")).isDisplayed());
	}
	public void editEditor() {
		driver.switchTo().frame("mce_0_ifr");
		driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p")).clear();
		driver.findElement(By.id("tinymce")).sendKeys("QA Infotech");
		driver.findElement(By.id("tinymce")).sendKeys(Keys.chord(Keys.CONTROL, "a"));
		driver.switchTo().defaultContent();
		driver.findElement(By.xpath("//*[@id=\"mceu_3\"]/button/i")).click();
		driver.switchTo().frame("mce_0_ifr");
		String Expected="QA Infotech";
		String Actual=driver.findElement(By.xpath("//*[@id=\"tinymce\"]/p/strong")).getText();
		System.out.println(Actual);
		Assert.assertEquals(Actual, Expected);
	}
}