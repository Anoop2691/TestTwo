package AdvanceTatocTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPage {
	WebDriver driver;
	//TestTable tt;
	@BeforeClass
	void connectionWithChromeAndOpenLink() {
		driver = new ChromeDriver();
		driver.get("http://10.0.31.161:9292/");
	}
	public void verifyDataTablePresent() {
		driver.findElement(By.linkText("Sortable Data Tables")).click();
		String s=driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
		System.out.println(s);
		Assert.assertEquals(s,"Data Tables");
	}
	public void verifyDataTableSorted() {
		
	}
	@Test
	void runFirstPage() {
		verifyDataTablePresent();
	}
}
