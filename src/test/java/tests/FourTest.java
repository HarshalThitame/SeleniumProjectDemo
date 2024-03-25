package tests;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import resources.Base;

public class FourTest extends Base {

	 public WebDriver driver;

	@Test
	public void testFour() throws IOException, InterruptedException {
		System.out.println("Test Four");
		driver = initiaizeDriver();

		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		Thread.sleep(2000);
		AssertJUnit.fail();
	}

	@AfterMethod 
	public void closer() {
		driver.quit();
	}
}
