package TestVariousTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Tables {
	WebDriver driver;
	public Tables(WebDriver driver) {
		this.driver=driver;
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
			c=true;
		}//else c=false;
		}	
		Assert.assertTrue(c);
	}
}
