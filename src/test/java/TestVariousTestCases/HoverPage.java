package TestVariousTestCases;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import junit.framework.Assert;

public class HoverPage {
	WebDriver driver;
	public HoverPage(WebDriver driver) {
		this.driver=driver;
	}
	public void checkWhetherPageDisplayed() {
		driver.findElement(By.linkText("Hovers")).click();
		Assert.assertEquals("Hovers",driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText());
	}
	public void checkBeforeHoveringAndAfterHovering() throws AWTException {
		Robot robot = new Robot();
	    robot.mouseMove(600,0);
	    Assert.assertFalse(driver.findElement(By.cssSelector("#content > div > div:nth-child(3) > div > h5")).isDisplayed());
	    robot.mouseMove(200,250);
	    Assert.assertFalse(driver.findElement(By.cssSelector("#content > div > div:nth-child(3) > div > h5")).isDisplayed());
	}
}
