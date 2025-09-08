package LambdaTest.PageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LambdaTest.AbstractMethods.ReusableMethods;

public class LoginPage extends ReusableMethods{
	WebDriver driver;
	public LoginPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//a[@role='button']//span[@class='title'][normalize-space()='My account']")
	WebElement myAccBtn;
	@FindBy(xpath="//span[normalize-space()='Login']")
	WebElement loginBtn;
	@FindBy(id="input-email")
	WebElement email;
	@FindBy(id="input-password")
	WebElement password;
	@FindBy(xpath="//input[@value='Login']")
	WebElement loginBtn1;
	@FindBy(xpath="//span[contains(text(),'Logout')]")
	WebElement logout;
	By loc1=By.xpath("//h2[@class='card-header h5']");
	@FindBy(xpath="//div[@class='alert alert-danger alert-dismissible']")
	WebElement error;
	
	public void LoginWithValidcreds()
	{
		Actions a = new Actions(driver);
		a.moveToElement(myAccBtn).pause(300);
		a.moveToElement(loginBtn).click().build().perform();
		email.sendKeys("Lambda1@gmail.com");
		password.sendKeys("Abcd@1234");
		loginBtn1.click();
		//Wait(loc1);
		//a.moveToElement(myAccBtn);
		//a.moveToElement(logout).click().build().perform();;
	}
	
	public void InvalidCreds()
	{
		Actions a = new Actions(driver);
		a.moveToElement(myAccBtn).pause(300);
		a.moveToElement(loginBtn).click().build().perform();
		email.sendKeys("lambda123@gemail.com");
		password.sendKeys("Abcd@1234");
		loginBtn1.click();
	}
}
