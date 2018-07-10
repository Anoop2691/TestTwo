package TestVariousTestCases;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Reporter;

public class AccessPageObjects {
	  WebDriver driver;
	  BasicAuthentication ba;
	  ExitIntent ei;
	  Tables t;
	  ValidateImage vi;
	  LoginPageValidation lpv;
	  HoverPage hp;
	  StatusCode sc;
	  WYSIWYGEditor ed;
	  public void openLinkAndCreateObjects() {
		  driver=new ChromeDriver();
		  driver.manage().window().maximize();
		  Reporter.log("Launch application ", true);
		  driver.get("http://10.0.31.161:9292/");
		  ba=new BasicAuthentication(driver);
		  ei=new ExitIntent(driver);
		  t=new Tables(driver);
		  vi=new ValidateImage(driver);
		  lpv=new LoginPageValidation(driver);
		  hp=new HoverPage(driver);
		  sc=new StatusCode(driver);
		  ed=new WYSIWYGEditor(driver);
	  }
}
