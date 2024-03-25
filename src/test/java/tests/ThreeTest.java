package tests;

import org.testng.annotations.Test;
import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;

import resources.Base;

public class ThreeTest extends Base{

	@Test
	public void testThree() throws IOException, InterruptedException {
		System.out.println("Test Three");
WebDriver driver = initiaizeDriver();
		
		driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
		Thread.sleep(2000);
		driver.quit();
	}
}
