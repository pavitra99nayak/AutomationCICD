package LambdaTest.LambdaTestPlaygroud;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import LambdaTest.BaseMethods.BaseTest;
import LambdaTest.PageObjects.CartPage;
import LambdaTest.PageObjects.LoginPage;
import LambdaTest.PageObjects.MegaMenuPage;

public class BuyItemsScenarios extends BaseTest{
	
	@Test
	public void Login()
	{
		LoginPage loginP = new LoginPage(driver);
		loginP.LoginWithValidcreds();
	}
	
	@Test(dependsOnMethods="Login")
	public void ViewItemsTC1()
	{
		MegaMenuPage megaPage = new MegaMenuPage(driver);
		megaPage.ViewItemsFromMegaMenu("Apple");
	}
	
	@Test(dependsOnMethods="ViewItemsTC1")
	public void AddItemstoCartTC2()
	{
		CartPage CartP = new CartPage(driver);
		CartP.cartItem("iPod Nano");
	}
	
	
	  @Test(dependsOnMethods="AddItemstoCartTC2") 
	  public void CheckOutTC3() 
	  {
		  CartPage CartP = new CartPage(driver); 
		  CartP.CheckOutItems();
		  CartP.Proceed();
		  String Actual =driver.findElement(By.xpath("//h1[@class='page-title my-3']")).getText();
		  Assert.assertEquals(Actual, " Your order has been placed!");
	  }
}
