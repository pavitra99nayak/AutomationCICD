package LambdaTest.LambdaTestPlaygroud;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import LambdaTest.BaseMethods.BaseTest;
import LambdaTest.PageObjects.DashboardPage;
import LambdaTest.PageObjects.LoginPage;

public class DashboardScenarios extends BaseTest{
	
	@Test
	public void Login()
	{
		LoginPage loginP = new LoginPage(driver);
		loginP.LoginWithValidcreds();
	}
	
	@Test(dependsOnMethods="Login")
	public void EditUserInfo()
	{
		DashboardPage DashB = new DashboardPage(driver);
		DashB.EditInfo();
		String Actual = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		Assert.assertEquals(Actual, "Success: Your account has been successfully updated.");
	}
	
	@Test(dependsOnMethods="Login")
	public void ChangePassword()
	{
		DashboardPage DashB = new DashboardPage(driver);
		DashB.ChangePass();
		String Actual = driver.findElement(By.xpath("//div[@class='alert alert-success alert-dismissible']")).getText();
		Assert.assertEquals(Actual, "Success: Your password has been successfully updated.");
	}
}
