package LambdaTest.BaseMethods;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import LambdaTest.PageObjects.LaunchApplication;
public class BaseTest {
	public WebDriver driver;
	public WebDriver intialization() throws IOException
	{
		Properties prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\LambdaTest\\AbstractMethods\\GlobalParam.properties");
		prop.load(fis);
		String BrowserName = prop.getProperty("browser");
		
		if(BrowserName.equalsIgnoreCase("chrome"))
		{
			System.setProperty("webdriver.chrome.driver", "C:\\chromedriver.exe");
			driver = new ChromeDriver();
		}
		else if(BrowserName.equalsIgnoreCase("edge"))
		{
			System.setProperty("webdriver.edge.driver", "C:\\msedgedriver.exe");
			driver =new EdgeDriver();
		}
		driver.manage().window().maximize();
		return driver;
		
	}
	
	public List<HashMap<String, String>> DataReader(String filePath) throws IOException
	{
		//json to string
		String JsontoString = FileUtils.readFileToString(new File(filePath), StandardCharsets.UTF_8);
		
		ObjectMapper mapper = new ObjectMapper();
		List<HashMap<String,String>> input =mapper.readValue(JsontoString, new TypeReference<List<HashMap<String,String>>>() {});
		return input;
	}
	
	public String TakeScreenShot(String MethodName, WebDriver driver) throws IOException
	{
		TakesScreenshot tc = (TakesScreenshot)driver;
		File scr = tc.getScreenshotAs(OutputType.FILE);
		String dest = System.getProperty("user.dir")+"\\Screenshots\\"+MethodName+".png";
		FileUtils.copyFile(scr, new File(dest));
		return dest;
	}
	
	@BeforeMethod(alwaysRun=true)
	public void LaunchLambdaApplication() throws IOException
	{
		driver = intialization();
		LaunchApplication launchApp = new LaunchApplication(driver);
		launchApp.goTo();
	}
	
	
	  @AfterMethod(alwaysRun=true)
	  public void TearDown() 
	  { 
		  driver.close(); 
	  }
	 
}
