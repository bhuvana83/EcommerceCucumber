package pageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class addCustomerPage {

	 WebDriver localdriver;
		
		public addCustomerPage(WebDriver driver)
		{
			this.localdriver = driver;
		}
		
		private By Email = By.cssSelector("input#Email");
		private By Password = By.cssSelector("input#Password");
		private By Firstname = By.cssSelector("input#FirstName");
		private By Lastname = By.cssSelector("input#LastName");
		private By Gendermale = By.cssSelector("input#Gender_Male");
		private By Genderfemale = By.cssSelector("input#Gender_Female");
		private By DOB = By.xpath("//input[@id='DateOfBirth']");
		
		private By Companyname = By.xpath("//input[@id='Company']");
		private By Tax = By.xpath("//input[@id='IsTaxExempt']");
		private By Newsclick = By.xpath("(//div[@class='k-multiselect-wrap k-floatwrap'])[1]");
		private By Customerrole = By.xpath("(//div[@class='k-multiselect-wrap k-floatwrap'])[2]");
		private By Cusroleclear = By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[2]");
		private By Vendor = By.xpath("//*[@id='VendorId']");
		private By Active = By.xpath("//input[@id='Active']");
		private By Comment = By.xpath("//*[@id='AdminComment']");
		
		private By Save = By.xpath("//div[@class='pull-right']/button[1]");
		private By SaveEdit = By.xpath("//div[@class='pull-right']/button[2]");
		
		
		//  Xpath  = "//div[@class='content-header clearfix']/h1/small/a"
		private By Backtolist = By.cssSelector("div[class*='content-header clearfix'] >h1 >small >a");
		
		
		
		
		public void setEmail(String email)
		{
			localdriver.findElement(Email).sendKeys(email);
		}
		
		public void setPwd(String pwd)
		{
			localdriver.findElement(Password).sendKeys(pwd);
		}
		
		public void setfirstname(String Fname)
		{
			localdriver.findElement(Firstname).sendKeys(Fname);
		}
		
		public void setlastname(String Lname)
		{
			localdriver.findElement(Lastname).sendKeys(Lname);
		}
		
		public void setGender(String gender)
		{
			if(gender.equalsIgnoreCase("male"))
			{
				localdriver.findElement(Gendermale).click();
			}
			else if(gender.equalsIgnoreCase("female"))
			{
				localdriver.findElement(Genderfemale).click();
			}
		}
		
		public void setdob(String dob)
		{
			localdriver.findElement(DOB).sendKeys(dob);
		}
		
		public void setCompany(String cname)
		{
			localdriver.findElement(Companyname).sendKeys(cname);
		}
		
		public void setTax(String tx)
		{
			if(tx.equalsIgnoreCase("yes"))
			{
				localdriver.findElement(Tax).click();
			}
			else
			{
				localdriver.findElement(Tax).click();
				localdriver.findElement(Tax).click();
			}
		}
		
		public void setNewlt(String news) throws InterruptedException
		{
			localdriver.findElement(Newsclick).click();
			WebElement newslist;
			Thread.sleep(5000);
			 
			newslist = localdriver.findElement(By.xpath("//li[contains(text(),'"+news+"')]"));
	 
	 
			 JavascriptExecutor js = (JavascriptExecutor) localdriver;
			 js.executeScript("arguments[0].click();", newslist);
						
		
			
		}
		
		public void setCusrole(String role) throws InterruptedException
		{
			localdriver.findElement(Cusroleclear).click();
			localdriver.findElement(Customerrole).click();
			WebElement cuslist;
			Thread.sleep(5000);
			 
			cuslist = localdriver.findElement(By.xpath("//li[contains(text(),'"+role+"')]"));
	 
	 
			 JavascriptExecutor js = (JavascriptExecutor) localdriver;
			 js.executeScript("arguments[0].click();", cuslist);
		}
		
		public void setvendor(String vendor)
		{
			Select s=new Select(localdriver.findElement(Vendor));
			s.selectByVisibleText(vendor); 
		}
		
		public void setActive(String act)
		{
			if(act.equalsIgnoreCase("no"))
			{
				localdriver.findElement(Active).click();
			}
			else
			{
				localdriver.findElement(Active).click();
				localdriver.findElement(Active).click();
			}
		}
		
		public void setComment(String msg)
		{
			localdriver.findElement(Comment).sendKeys(msg);
		}
		
		public void doSave()
		{
			localdriver.findElement(Save).click();
		}
		
		public void doSaveEdit()
		{
			localdriver.findElement(SaveEdit).click();
		}
		
		public void setBacklist()
		{
			localdriver.findElement(Backtolist).click();
		}
	}

