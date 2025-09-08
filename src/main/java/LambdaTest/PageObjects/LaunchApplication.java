package LambdaTest.PageObjects;

import org.openqa.selenium.WebDriver;

public class LaunchApplication {
	WebDriver dirver;
	WebDriver driver;
	public LaunchApplication(WebDriver driver)
	{
		this.driver=driver;
	}
	
	public void goTo()
	{
		driver.get("https://ecommerce-playground.lambdatest.io/index.php");
	}
	
}
