package TestVariousTestCases;

import java.awt.AWTException;
import java.io.IOException;


import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class PageTest {
  AccessPageObjects test;
  @BeforeMethod
  public void openLink() {
	  test=new AccessPageObjects();
	  test.openLinkAndCreateObjects();
  }
  

  @Test
  void checkPresenceOfPromptWindow() {
	  test.ba.clickOnBasicAuth();
  }
  @Test
  void checkExitContent() throws AWTException, InterruptedException {
	  test.ei.exitIntentPageAssert();
	  test.ei.checkForModalBox();
	  test.ei.checkClosingOfModalWindow();
  }
  @Test
  void checkTable() {
	  test.t.verifyDataTablePresent();
	  test.t.verifyDataTableSorted();
  }
  @Test
  public void validateImage() throws InterruptedException {
	  test.vi.validateInvalidImages();

	}
  @Test
  public void loginPageInvalidCredentials() {
	  test.lpv.PageIsDisplayed();
	  test.lpv.validateWithInvalidCredentials();
	  test.lpv.validateWithValidCredentials();
  }
  @Test
  public void checkForHoverPage() throws AWTException, InterruptedException {
	  test. hp.checkWhetherPageDisplayed();
	  test. hp.checkBeforeHoveringAndAfterHovering();
  }
  @Test
  public void checkForStatusCodes() throws IOException {
	  test.sc.verifyPageIsDisplayed();
	  test.sc.clickOnLink404();
	  test. sc.check404StatusCode();
  }
  @Test
  public void checkWYSIWYGEditor() {
	  test.ed.checkPageIsDisplayed();
	  test.ed.editEditor();
  }
  
  @AfterMethod
  void closeBrowser() {
	  test.driver.close();
  }
}
