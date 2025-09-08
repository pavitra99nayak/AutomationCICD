package LambdaTest.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import LambdaTest.AbstractMethods.ReusableMethods;

public class SearchBarPage extends ReusableMethods{
	WebDriver driver;
	public SearchBarPage(WebDriver driver)
	{
		super(driver);
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(xpath="(//input[@placeholder='Search For Products'])[1]")
	WebElement SearchBar;
	By loc = By.xpath("(//li[@class='product-thumb px-3 py-2 m-0 image-left'])[1]");
	@FindBy(xpath="//ul[@class='list-unstyled m-0']//li")
	List<WebElement> ProdDetails;
	@FindBy(xpath="(//div[@class='search-button'])[1]")
	WebElement SearchBtn;
	@FindBy(xpath="(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]")
	WebElement leftSlider;
	
	By loc2= By.xpath("(//span[@class='ui-slider-handle ui-corner-all ui-state-default'])[3]");
	
	@FindBy(xpath="//label[@for='mz-fss-0--1']")
	WebElement checkBox;
	By loc1 = By.xpath("//div[@class='loader-spinner']");
	public void SearchItem(String SearchItem, String ItemNeeded)
	{
		SearchBar.sendKeys(SearchItem);
		Wait(loc);
		driver.findElement(By.xpath("//h4[@class='title']//a[text()='"+ItemNeeded+"']")).click();
	}
	
	public void ItemDetals()
	{
		for(WebElement item : ProdDetails)
			System.out.println(item.getText());
	}
	
	public void SearchUsingFilter(String Item, String ItemRequired)
	{
		SearchBtn.click();
		Actions a = new Actions(driver);
		Wait(loc2);
		a.clickAndHold(leftSlider).moveByOffset(50, 0).release().perform();
		driver.findElement(By.xpath("//label[@class='custom-control-label']//img[@alt='"+Item+"']")).click();
		waitUntilInvisibile(loc1);
		checkBox.click();
		waitUntilInvisibile(loc1);
		ElementClick(By.xpath("//a[normalize-space(text())='"+ItemRequired+"']"));
		driver.findElement(By.xpath("//a[normalize-space(text())='"+ItemRequired+"']")).click();
	}
}
