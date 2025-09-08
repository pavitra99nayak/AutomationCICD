package LambdaTest.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LambdaTest.AbstractMethods.ReusableMethods;

public class SignUpPage extends ReusableMethods{
	WebDriver driver;
	public SignUpPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="//a[@role='button']//span[@class='title'][normalize-space()='My account']")
	WebElement myAccBtn;
	@FindBy(xpath="//div[@class='info']//span[normalize-space()='Register']")
	WebElement registerBtn;
	@FindBy(id="input-firstname")
	WebElement fName;
	By loc1 = By.id("input-firstname");
	@FindBy(id="input-lastname")
	WebElement lName;
	@FindBy(id="input-email")
	WebElement eMail;
	@FindBy(id="input-telephone")
	WebElement telePhone;
	@FindBy(id="input-password")
	WebElement password;
	@FindBy(id="input-confirm")
	WebElement confirmPass;
	@FindBy(xpath="//div[contains(@class,'custom-checkbox')]//label[@class='custom-control-label']")
	WebElement ConfirmCheckBox;
	@FindBy(xpath="//input[@value='Continue']")
	WebElement CntBtn;
	@FindBy(xpath="//div[@class='buttons mb-4']//a")
	public WebElement CntBtn2;
	By loc = By.xpath("//h1[@class='page-title my-3']");
	@FindBy(xpath="//div[@class='text-danger']")
	public List<WebElement> ErrorMsgs;
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	public WebElement alreadExtEmail;
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	WebElement logout;
	
	public void Register(String Email)
	{
		Actions a = new Actions(driver);
		a.moveToElement(myAccBtn);
		a.moveToElement(registerBtn).click().build().perform();
		fName.sendKeys("Test");
		lName.sendKeys("Tester");
		eMail.sendKeys(Email);
		telePhone.sendKeys("+91 7023443454");
		password.sendKeys("Abcd@1234");
		confirmPass.sendKeys("Abcd@1234");
		ConfirmCheckBox.click();
		CntBtn.click();
		//CntBtn2.click();
	}
	
	public void BlankClick()
	{
		Actions a = new Actions(driver);
		a.moveToElement(myAccBtn);
		a.moveToElement(registerBtn).click().build().perform();
		CntBtn.click();
		for(WebElement item: ErrorMsgs)
		{
			System.out.println(item.getText());
		}
		
	}
	
	public void EmailAlreadyAvailable()
	{
		Wait(loc1);
		fName.sendKeys("Test");
		lName.sendKeys("Tester");
		eMail.sendKeys("ptesti186n@gemail.com");
		telePhone.sendKeys("+91 7023443454");
		password.sendKeys("Abcd@1234");
		confirmPass.sendKeys("Abcd@1234");
		ConfirmCheckBox.click();
		CntBtn.click();
	}
	
	public void MultipleRegsiter(String Fname, String Lname, String Email, String TeleNum, String Password)
	{

			Actions a = new Actions(driver);
			a.moveToElement(myAccBtn);
			a.moveToElement(registerBtn).click().build().perform();
			fName.sendKeys(Fname);
			lName.sendKeys(Lname);
			eMail.sendKeys(Email);
			telePhone.sendKeys(TeleNum);
			password.sendKeys(Password);
			confirmPass.sendKeys(Password);
			ConfirmCheckBox.click();
			CntBtn.click();
			CntBtn2.click();
			a.moveToElement(myAccBtn).pause(300);
			a.moveToElement(logout).click().build().perform();
	}

}
