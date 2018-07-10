package TestVariousTestCases;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Reporter;

import junit.framework.Assert;

public class HoverPage {
	WebDriver driver;
	public HoverPage(WebDriver driver) {
		this.driver=driver;
	}
	public void checkWhetherPageDisplayed() {
		driver.findElement(By.linkText("Hovers")).click();
		Assert.assertEquals("Hovers",driver.findElement(By.xpath("//div[@id=\"content\"]/div/h3")).getText(),"Assertion failed: Clicked on 'Hovers' and verified that page is not displayed");
		Reporter.log("Assertion passed: Clicked on 'Hovers' and verified that page is displayed",true);
	}
	public void checkBeforeHoveringAndAfterHovering() throws AWTException, InterruptedException {
		Robot robot = new Robot();
	    robot.mouseMove(600,0);
	    Assert.assertFalse("Assertion failed: Verified that user name and ‘view profile’ link doesnot disappears below the image",driver.findElement(By.cssSelector("#content > div > div:nth-child(3) > div > h5")).isDisplayed());
	    Reporter.log("Assertion passed: Verified that user name and ‘view profile’ link disappear from below the image",true);
	    robot.mouseMove(200,250);
	    Thread.sleep(3000);
	    Assert.assertTrue("Assertion failed: Verified that user name and ‘view profile’ link doesnot appears below the image",driver.findElement(By.cssSelector("#content > div > div:nth-child(3) > div > h5")).isDisplayed());
	    Reporter.log("Assertion passed: Verified that user name and ‘view profile’ link appears below the image",true);
	}
}
