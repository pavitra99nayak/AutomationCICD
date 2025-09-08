package LambdaTest.PageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class DashboardPage {
	WebDriver driver;
	public DashboardPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//div[@class='col-6 col-sm-4 col-lg-2_4'])[1]")
	WebElement EditInfo;
	@FindBy(id="input-telephone")
	WebElement oldtelNo;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement cntBtn;
	
	@FindBy(xpath="(//div[@class='col-6 col-sm-4 col-lg-2_4'])[2]")
	WebElement ChangePass;
	@FindBy(id="input-password")
	WebElement password;
	@FindBy(id="input-confirm")
	WebElement confirmPass;
	public void EditInfo()
	{
		EditInfo.click();
		oldtelNo.clear();
		oldtelNo.sendKeys("+91 7022809834");
		cntBtn.click();
	}
	
	public void ChangePass()
	{
		ChangePass.click();
		password.sendKeys("Pavitra@16");
		confirmPass.sendKeys("Pavitra@16");
		cntBtn.click();
	}
	
	

}
