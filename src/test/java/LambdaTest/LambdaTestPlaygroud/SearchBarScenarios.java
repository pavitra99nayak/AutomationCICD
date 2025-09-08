package LambdaTest.LambdaTestPlaygroud;

import org.testng.annotations.Test;

import LambdaTest.BaseMethods.BaseTest;
import LambdaTest.PageObjects.LoginPage;
import LambdaTest.PageObjects.SearchBarPage;

public class SearchBarScenarios extends BaseTest{
	
	@Test
	public void Login()
	{
		LoginPage LoginP = new LoginPage(driver);
		LoginP.LoginWithValidcreds();
	}
	
	@Test(dependsOnMethods="Login")
	public void searchItemsTC1()
	{
		SearchBarPage bar = new SearchBarPage(driver);
		bar.SearchItem("sam", "Samsung Galaxy Tab 10.1");
		bar.ItemDetals();
	}
	
	@Test(dependsOnMethods="searchItemsTC1")
	public void SearchUsingFilterTC2()
	{
		SearchBarPage bar = new SearchBarPage(driver);
		bar.SearchUsingFilter("Apple", "MacBook");
	}

	
}
