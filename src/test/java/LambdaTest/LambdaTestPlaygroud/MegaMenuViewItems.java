package LambdaTest.LambdaTestPlaygroud;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import LambdaTest.BaseMethods.BaseTest;
import LambdaTest.PageObjects.LoginPage;
import LambdaTest.PageObjects.MegaMenuPage;

public class MegaMenuViewItems extends BaseTest{
	@Test
	public void Login()
	{
		LoginPage lPage = new LoginPage(driver);
		lPage.LoginWithValidcreds();
	}
	
	@Test(dataProvider="MegaMenuDataSet")
	public void ViewItems(HashMap<String,String> input)
	{
		MegaMenuPage megaPage = new MegaMenuPage(driver);
		megaPage.ViewItemsFromMegaMenu(input.get("Item"));
	}

	@DataProvider
	public Object[][] MegaMenuDataSet() throws IOException
	{
		String filePath = System.getProperty("user.dir")+"\\src\\test\\java\\LambdaTest\\BaseMethods\\MultipleMegaMenuItems.json";
		List<HashMap<String,String>> input = DataReader(filePath);
		return new Object[][] {{input.get(0)},{input.get(1)},{input.get(2)}};
	}
}
