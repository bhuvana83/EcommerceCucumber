package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class customerSearch {
	 WebDriver localdriver;
		
		public customerSearch(WebDriver driver)
		{
			this.localdriver = driver;
		}
		
		
		private By Email = By.id("SearchEmail");
		private By FName = By.id("SearchFirstName");
		private By LName = By.id("SearchLastName");
		private By Search = By.id("search-customers");
		private By Table = By.id("customers-grid");
		private By tableRow = By.xpath("//table[@id='customers-grid']/tbody/tr");
		private By tableCol = By.xpath("//table[@id='customers-grid']/tbody/tr/td");
		
		public void putEmail(String email)
		{
			localdriver.findElement(Email).sendKeys(email);
		}
		
				
		public void putfirstname(String Fname)
		{
			localdriver.findElement(FName).sendKeys(Fname);
		}
		
		public void putlastname(String Lname)
		{
			localdriver.findElement(LName).sendKeys(Lname);
		}
		
		
		public void submit()
		{
			localdriver.findElement(Search).click();
		}
		
		public int getRowCount()
		{
			return localdriver.findElements(tableRow).size();
		}
		
		public int getColCount()
		{
			return localdriver.findElements(tableCol).size();
		} 
		
		public boolean searchCustomerByEmail(String email) {
			boolean flag = false;
			System.out.println("row count is "+getRowCount());
			for (int i = 1; i <= getRowCount(); i++) {
				String emailid = localdriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[2]"))
						.getText();

						
				
				System.out.println(emailid);

				if (emailid.equals(email)) {
					flag = true;
					break;
				}
			}

			return flag;

		}

		public boolean searchCustomerByName(String Name1,String Name2) {
			boolean flag = false;

			for (int i = 1; i <= getRowCount(); i++) {
				String Cusname = localdriver.findElement(By.xpath("//table[@id='customers-grid']/tbody/tr[" + i + "]/td[3]"))
						.getText();
				System.out.println(Cusname);
				String Cusnames[] = Cusname.split(" ");
				
				if (Cusnames[0].contains(Name1) && Cusnames[1].contains(Name2)) {
					flag = true;
					break;
				}
			}

			return flag;

		}
}
