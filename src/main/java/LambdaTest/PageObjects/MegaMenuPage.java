package LambdaTest.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LambdaTest.AbstractMethods.ReusableMethods;

public class MegaMenuPage extends ReusableMethods{
	WebDriver driver;
	public MegaMenuPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	@FindBy(xpath="//span[normalize-space()='Mega Menu']")
	WebElement megaMenu;
	@FindBy(xpath="//h4[@class='title']")
	List<WebElement> Items;
	By loc1 = By.xpath("(//img[@class='lazy-load'])[1]");
	
	public void ViewItemsFromMegaMenu(String Item)
	{
		Actions a = new Actions(driver);
		a.moveToElement(megaMenu);
		a.moveToElement(driver.findElement(By.xpath("//a[contains(text(),'"+Item+"')]"))).click().build().perform();
		Wait(loc1);
		DisplyItem();
	}
	
	public void DisplyItem()
	{
		System.out.println("Total "+Items.size()+" items are available");
		for(WebElement item:Items)
		System.out.println(item.getText());
	}
	
	
}
