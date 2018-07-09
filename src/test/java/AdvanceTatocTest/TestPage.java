package AdvanceTatocTest;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class TestPage {
	WebDriver driver;
	ValidateImage vi;
	//TestTable tt;
	@BeforeClass
	void connectionWithChromeAndOpenLink() {
		driver = new ChromeDriver();
		driver.get("http://10.0.31.161:9292/");
		vi=new ValidateImage(driver);
	}
	public void verifyDataTablePresent() {
		driver.findElement(By.linkText("Sortable Data Tables")).click();
		String s=driver.findElement(By.xpath("//*[@id=\"content\"]/div/h3")).getText();
		System.out.println(s);
		Assert.assertEquals(s,"Data Tables");
	}
	public void verifyDataTableSorted() {
		//driver.findElement(By.cssSelector(".header.headerSortDown"));
		double max=0;boolean c=false;
		for(int i=0;i<4;i++) {
		String x1=driver.findElement(By.xpath("//*[@id=\"table1\"]/tbody/tr["+(i+1)+"]/td[4]")).getText();
		String x2=x1.substring(1);
		double x=Double.parseDouble(x2);
		if(x>max) {
			max=x;
			System.out.println(x);c=true;
		}//else c=false;
		}	
		Assert.assertTrue(c);
	}
	@Test
	void runFirstPage() {
		verifyDataTablePresent();
		verifyDataTableSorted();
	}
	@Test
	public void validateImage() throws InterruptedException {
		vi.validateInvalidImages();

	}

}
