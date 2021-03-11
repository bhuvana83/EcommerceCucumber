package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class loginPage {
	
    WebDriver localdriver;
	
	public loginPage(WebDriver driver)
	{
		this.localdriver = driver;
	}
	
	
	private By email = By.xpath("//input[@id='Email']");
	private By password = By.xpath("//input[@id='Password']");
	private By login = By.xpath("//input[@type='submit']");
	private By Rememberme = By.xpath("//input[@id='RememberMe']");
	
	
	public WebElement getEmail()
	{
		return localdriver.findElement(email);
	}
	
	public WebElement getPassword()
	{
		return localdriver.findElement(password);
	}
	
	public WebElement doLogin()
	{
		return localdriver.findElement(login);
	}
	
	public WebElement doRemember()
	{
		return localdriver.findElement(Rememberme);
	}
	
}
