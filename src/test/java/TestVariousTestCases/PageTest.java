package TestVariousTestCases;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PageTest {
  WebDriver driver;
  BasicAuthentication ba;
  ExitIntent ei;
  Tables t;
  ValidateImage vi;
  LoginPageValidation lpv;
  HoverPage hp;
  StatusCode sc;
  WYSIWYGEditor ed;
  @BeforeClass
  public void openLink() {
	  driver=new ChromeDriver();
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
  @AfterMethod
  void openLinkEveryTime() {
	  driver.get("http://10.0.31.161:9292/");
  }
 // @Test
  void checkPresenceOfPromptWindow() {
	  ba.clickOnBasicAuth();
  }
  @Test
  void checkExitContent() throws AWTException, InterruptedException {
	  ei.exitIntentPageAssert();
	  ei.checkForModalBox();
	  ei.checkClosingOfModalWindow();
  }
  @Test
  void checkTable() {
	  t.verifyDataTablePresent();
	  t.verifyDataTableSorted();
  }
  @Test
  public void validateImage() throws InterruptedException {
		vi.validateInvalidImages();

	}
  @Test
  public void loginPageInvalidCredentials() {
	  lpv.PageIsDisplayed();
	  lpv.validateWithInvalidCredentials();
	  lpv.validateWithValidCredentials();
  }
  @Test
  public void checkForHoverPage() throws AWTException {
	  hp.checkWhetherPageDisplayed();
	  hp.checkBeforeHoveringAndAfterHovering();
  }
  @Test
  public void checkForStatusCodes() throws IOException {
	  sc.verifyPageIsDisplayed();
	  sc.clickOnLink404();
	  sc.check404StatusCode();
  }
  @Test
  public void checkWYSIWYGEditor() {
	  ed.checkPageIsDisplayed();
	  ed.editEditor();
  }
}
