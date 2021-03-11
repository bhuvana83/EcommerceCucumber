package resources;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class test {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "D:\\InstalledApps\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.get("https://admin-demo.nopcommerce.com/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@type='submit']")).click();
		driver.findElement(By.cssSelector("div.main-sidebar > div > ul > li:nth-child(4) > a")).click();
		driver.findElement(By.cssSelector("a[href*='/Admin/Customer/List']")).click();
		driver.findElement(By.xpath("//*[@id='SelectedCustomerRoleIds_taglist']/li/span[2]")).click();
		driver.findElement(By.xpath("//div[@class='k-multiselect-wrap k-floatwrap']")).click();
		
		 WebElement listitem;
		 Thread.sleep(5000);
		 
		 listitem = driver.findElement(By.xpath("//li[contains(text(),'Administrators')]"));
 
 
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();", listitem);
		
		
	}

}
