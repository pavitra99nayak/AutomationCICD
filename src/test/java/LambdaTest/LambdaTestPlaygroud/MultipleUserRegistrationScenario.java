package LambdaTest.LambdaTestPlaygroud;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import LambdaTest.BaseMethods.BaseTest;
import LambdaTest.PageObjects.SignUpPage;

public class MultipleUserRegistrationScenario extends BaseTest {
	@Test(dataProvider="DataInput")
	public void MultipleRegiser(HashMap<String,String> input)
	{
		SignUpPage sUp = new SignUpPage(driver);
		sUp.MultipleRegsiter(input.get("Fname"), input.get("Lname"), input.get("Email"),input.get("TeleNum"), input.get("Password"));	
	}
	
	@DataProvider
	public Object[][] DataInput() throws IOException
	{
		String FilePath=System.getProperty("user.dir")+"\\src\\test\\java\\LambdaTest\\BaseMethods\\MultipleRegData.json";
		List<HashMap<String,String>> input = DataReader(FilePath);
		return new Object[][] {{input.get(0)},{input.get(1)}};
	}
}