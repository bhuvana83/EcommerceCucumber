package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class userPage {
	
    WebDriver localdriver;
	
	public userPage(WebDriver driver)
	{
		this.localdriver = driver;
	}
	
	
	private By logout = By.cssSelector("[href*='/logout']");
	private By Customermenu = By.cssSelector("div.main-sidebar > div > ul > li:nth-child(4) > a");
	private By Customerlist = By.cssSelector("a[href*='/Admin/Customer/List']");
	private By addCustomer = By.cssSelector("div.pull-right > a");
	
			
	public WebElement doLogout()
	{
		return localdriver.findElement(logout);
	}
	
	public void doCustomermenu()
	{
		 localdriver.findElement(Customermenu).click();;
	}
	
	public void doCustomerlist()
	{
		 localdriver.findElement(Customerlist).click();;
	}
	
	public void addCustomer()
	{
		 localdriver.findElement(addCustomer).click();;
	}
	
	
	
}
