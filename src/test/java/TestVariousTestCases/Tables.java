package TestVariousTestCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.Reporter;

public class Tables {
	WebDriver driver;
	public Tables(WebDriver driver) {
		this.driver=driver;
	}
	public void verifyDataTablePresent() {
		driver.findElement(By.linkText("Sortable Data Tables")).click();
		String getSubTitleOfPage=driver.findElement(By.xpath("//div[@id='content']/div/h3")).getText();
		Assert.assertEquals(getSubTitleOfPage,"Data Tables","Assertion failed:Clicked on 'Sortable Data Tables' and verified that page is not displayed");
		Reporter.log("Assertion Passed:Clicked on 'Sortable Data Tables' and verified that page is displayed",true);
	}
	public void verifyDataTableSorted() {
		//driver.findElement(By.cssSelector(".header.headerSortDown"));
		double max=0;boolean checkCondition=false;
		for(int i=0;i<4;i++) {
		String fetchValueOfDueInTable=driver.findElement(By.xpath("//*[@id='table1']/tbody/tr["+(i+1)+"]/td[4]")).getText();
		String valueOfDue=fetchValueOfDueInTable.substring(1);
		double value=Double.parseDouble(valueOfDue);
		if(value>max) {
			max=value;
			checkCondition=true;
		}//else c=false;
		}	
		Assert.assertTrue(checkCondition,"Assertion failed:Verified that Example 1 Table is not sorted by Due column descending order");
		Reporter.log("Assertion Passed:Verified that Example 1 Table is sorted by Due column descending order",true);
	}
}
