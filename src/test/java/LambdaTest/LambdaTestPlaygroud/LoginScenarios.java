package LambdaTest.LambdaTestPlaygroud;

import org.testng.annotations.Test;

import LambdaTest.BaseMethods.BaseTest;
import LambdaTest.PageObjects.LoginPage;

public class LoginScenarios extends BaseTest{
	
	@Test(groups="SanityTest")
	public void LoginWithValidCredsTC1()
	{
		LoginPage loginP= new LoginPage(driver);
		loginP.LoginWithValidcreds();
	}
	
	@Test
	public void LoginWithInvalidCredsTC2()
	{
		LoginPage loginP= new LoginPage(driver);
		loginP.InvalidCreds();
	}
}
