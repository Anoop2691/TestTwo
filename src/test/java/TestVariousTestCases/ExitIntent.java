package TestVariousTestCases;

import java.awt.AWTException;
import java.awt.Robot;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import junit.framework.Assert;

public class ExitIntent {
	WebDriver driver;
	String s;
	public ExitIntent(WebDriver driver) {
		this.driver=driver;
	}
	public void exitIntentClick() {
		driver.findElement(By.linkText("Exit Intent")).click();
	}
	public void exitIntentPageAssert() {
		exitIntentClick();
		Assert.assertEquals("Exit Intent",driver.findElement(By.xpath("//*[@id=\"content\"]/div[1]/h3")).getText());
	}
	public void checkForModalBox() throws AWTException, InterruptedException {
		 Robot robot = new Robot();
		 Thread.sleep(3000);
		 for(int i=150;i>=100;i--)
		    robot.mouseMove(200,i);
		    //robot.mouseMove(0,600);
		    Thread.sleep(3000);
		s=driver.findElement(By.className("modal-title")).getText().toUpperCase();
		Assert.assertEquals("THIS IS A MODAL WINDOW", s);
	}
	public void checkClosingOfModalWindow() {
		driver.findElement(By.className("modal-footer")).click();
		try {
			Assert.assertFalse(driver.findElement(By.id("modal-title")).isDisplayed());
		}catch(Exception e) {
			
		}
	}
}
