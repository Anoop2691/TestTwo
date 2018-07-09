package AdvanceTatocTest;

import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ValidateImage {
	WebDriver driver;
	int invalidImageCount;
	ArrayList<String> brokenlist; 
	public ValidateImage(WebDriver driver) {
		this.driver = driver;
		brokenlist = new ArrayList<String>();
	}
public void validateInvalidImages() {
	driver.get("http://10.0.31.161:9292/");
		driver.findElement(By.linkText("Broken Images")).click();
		
		try {
			 invalidImageCount = 0;
			List<WebElement> imagesList = driver.findElements(By.tagName("img"));
			System.out.println("Total no. of images are " + imagesList.size());
			for (WebElement imgElement : imagesList) {
				if (imgElement != null) {
					verifyimageActive(imgElement);
				}
			}
			System.out.println("Total no. of invalid images are " + invalidImageCount);
			System.out.println("Broken images urls are " + brokenlist);

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			
		}
		
	}

	public void verifyimageActive(WebElement imgElement) {
		try {
			HttpClient client = HttpClientBuilder.create().build();
			HttpGet request = new HttpGet(imgElement.getAttribute("src"));
			HttpResponse response = client.execute(request);
			// verifying response code he HttpStatus should be 200 if not,
			// increment as invalid images count
			if (response.getStatusLine().getStatusCode() != 200){
				invalidImageCount++;
				brokenlist.add(imgElement.getAttribute("src").toString());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
