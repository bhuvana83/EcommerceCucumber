package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;



public class Base {

	public WebDriver driver;
	public Properties prop;
	public static Logger log = LogManager.getLogger(Base.class.getName());
	
	
	public WebDriver intialization() throws IOException
	{
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\Data.properties");
		
		prop.load(fis);
		
		String broswerName = prop.getProperty("browser");
		
		System.out.println(broswerName);
		
		
			
		if (broswerName.contains("chrome"))
		{
			   // remove path hard coding using fis2 and place all .exe under resources
			System.setProperty("webdriver.chrome.driver", "D:\\InstalledApps\\chromedriver_win32\\chromedriver.exe");
			
			ChromeOptions options = new ChromeOptions();
			if(broswerName.contains("headless"))
			{
				options.addArguments("--headless");
			}
			
			driver = new ChromeDriver(options);
			
		}
		else if(broswerName.equals("firefox"))
		{
			System.setProperty("webdriver.gecko.driver", "D:\\InstalledApps\\geckodriver-v0.29.0-win64\\geckodriver.exe");
			driver = new FirefoxDriver();
		}
		else if(broswerName.equals("IE"))
		{
			
		}
		
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		return driver;
		
	}
	
	public  String getURL()
	{
		String link = prop.getProperty("url");
		System.out.println(link);
		return link;
	}
	
	
	
	public String getScreenshot(String testCasename, WebDriver driver) throws IOException
	{
		TakesScreenshot ts = (TakesScreenshot)driver;
		File src = ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCasename+".png";
		FileUtils.copyFile(src,new File(destinationFile));
		return destinationFile;
	}
}
