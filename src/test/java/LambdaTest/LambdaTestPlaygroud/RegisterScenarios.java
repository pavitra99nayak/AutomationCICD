package LambdaTest.LambdaTestPlaygroud;
import java.io.IOException;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

import LambdaTest.BaseMethods.*;
import LambdaTest.PageObjects.SignUpPage;
public class RegisterScenarios extends BaseTest{
	
	@Test(dependsOnMethods="EmailAvaiableTC3", groups="SanityTest")
	public void RegisterTC1() throws IOException
	{
		SignUpPage rg = new SignUpPage(driver);
		rg.Register("testlambda123@gmail.com");
		String Actual = driver.findElement(By.xpath("//h1[@class='page-title my-3']")).getText();
		Assert.assertEquals(Actual, "Your Account Has Been Created!");
		//rg.CntBtn2.click();
	}
	
	@Test(groups="SanityTest")
	public void BlankClickTC2()
	{
		SignUpPage rg = new SignUpPage(driver);
		rg.BlankClick();
	}
	
	@Test(dependsOnMethods="BlankClickTC2", groups="SanityTest")
	public void EmailAvaiableTC3()
	{
		SignUpPage rg = new SignUpPage(driver);
		rg.EmailAlreadyAvailable();
		String Actual = rg.alreadExtEmail.getText();
		Assert.assertEquals(Actual, "Warning: E-Mail Address is already registered!");
	}
}