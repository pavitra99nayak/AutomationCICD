package LambdaTest.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LambdaTest.AbstractMethods.ReusableMethods;

public class CartPage extends ReusableMethods{
	WebDriver driver;
	public CartPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//button[@title='Add to Cart'])[2]")
	WebElement cartBtn;
	@FindBy(xpath="//a[@class='btn btn-primary btn-block']")
	WebElement viewCartBtn;
	@FindBy(xpath="(//table[@class='table table-bordered']//td[@class='text-left'])")
	List<WebElement> tableDetails;
	@FindBy(xpath="//a[text()='Checkout']")
	WebElement checkOut;
	@FindBy(id="input-payment-firstname")
	WebElement Fname;
	@FindBy(id="input-payment-lastname")
	WebElement Lname;
	@FindBy(id="input-payment-address-1")
	WebElement Add1;
	@FindBy(id="input-payment-city")
	WebElement city;
	@FindBy(id="input-payment-postcode")
	WebElement PostCode;
	@FindBy(xpath="//label[@for='input-agree']")
	WebElement condition;
	@FindBy(xpath="//button[@class='btn btn-lg btn-block btn-primary']")
	WebElement contBtn;
	@FindBy(id="button-confirm")
	WebElement contBtn2;
	
	@FindBy(xpath="(//div[@class='icon svg-icon'])[17]")
	WebElement cartIcon;
	@FindBy(xpath="//button[@class='ml-2 mb-1 close']")
	WebElement close;
	@FindBy(xpath="//a[@class='icon-right both btn btn-secondary btn-lg btn-block']")
	WebElement checkOutBtn;
	public void cartItem(String ItemName)
	{
		driver.findElement(By.xpath("(//a[text()='"+ItemName+"'])[2]")).click();
	//	Wait(By.xpath("//button[@title='Add to Cart']"));
		cartBtn.click();
		//Wait(By.xpath("//a[@class='btn btn-primary btn-block']"));
		//viewCartBtn.click();
	}
	public void DisplaycartItemsDetails()
	{
		Wait(By.xpath("//table[@class='table table-bordered']"));
		System.out.println("*** Details ***");
		for(int i=1;i<tableDetails.size();i++)
		{
			System.out.println(tableDetails.get(i).getText());
		}
	}
	
	public void Proceed()
	{
		condition.click();
		contBtn.click();
		Wait(By.id("button-confirm"));
		contBtn2.click();
		Wait(By.xpath("//h1[@class='page-title my-3']"));
	}
	
	public void CheckOutItems()
	{
		Wait(By.xpath("//button[@class='ml-2 mb-1 close']"));
		close.click();
		cartIcon.click();
		Wait(By.xpath("//a[@class='icon-right both btn btn-secondary btn-lg btn-block']"));
		checkOutBtn.click();
	}
}
