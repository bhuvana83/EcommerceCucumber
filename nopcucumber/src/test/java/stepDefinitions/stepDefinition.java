package stepDefinitions;


import junit.framework.*;
import java.util.List;

import org.openqa.selenium.WebDriver;



import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import cucumber.api.DataTable;
import cucumber.api.java.en.*;
import pageObjects.addCustomerPage;
import pageObjects.customerSearch;
import pageObjects.loginPage;
import pageObjects.userPage;
import resources.Base;

public class stepDefinition extends Base {
	
	WebDriver localdriver;
	loginPage lp;
	userPage up;
	addCustomerPage cp;
	customerSearch cs;
	public static Logger log = LogManager.getLogger(stepDefinition.class.getName());

	@Given("^user launch chrome browser with url$")
	public void user_launch_chrome_browser_with_url() throws Throwable {
		
		
		localdriver = intialization();
		String url = getURL();
		lp = new loginPage(localdriver);
		up = new userPage(localdriver);
		cp = new addCustomerPage(localdriver);
		cs = new customerSearch(localdriver);
		log.info("inside launching");
		localdriver.get(url);
		localdriver.manage().window().maximize();
		
	}

	
	  @Given("^user enters Email as \"([^\"]*)\" and Password as \"([^\"]*)\"$")
	  public void user_enters_Email_as_and_Password_as(String email, String pwd)
	  throws Throwable {
	  
	  lp.getEmail().clear(); 
	  lp.getEmail().sendKeys(email);
	  lp.getPassword().clear(); 
	  lp.getPassword().sendKeys(pwd);
	  log.info("inside login");
	  
	  }
	 
	
	@Given("^user enters Email as <Email> and Password as <Password>$")
	public void user_enters_Email_as_Email_and_Password_as_Password(DataTable arg1) throws Throwable {
	    
		 List<List<String>> data = arg1.raw();
		 lp.getEmail().clear();
		 lp.getEmail().sendKeys(data.get(0).get(0));
		 lp.getPassword().clear();
		 lp.getPassword().sendKeys(data.get(0).get(1));
	}

	@When("^click on login$")
	public void click_on_login() throws Throwable {
	    
		lp.doLogin().click();
		Thread.sleep(2000);
	}

	@Then("^Page title should be \"([^\"]*)\"$")
	public void page_title_should_be(String title) throws Throwable {
	    
		Assert.assertEquals(localdriver.getTitle(), title);
	}

	@When("^click on logout$")
	public void click_on_logout() throws Throwable {
	    
		up.doLogout().click();
		Thread.sleep(2000);
		log.info("inside logout");
	}

	@Then("^close browser$")
	public void close_browser() throws Throwable {
	    
		localdriver.quit();
	}

	
	/*  Add customer details  */
	
	@When("^click on Customer menu and move to Customer section$")
	public void click_on_Customer_menu_and_move_to_Customer_section() throws Throwable {
	    
		up.doCustomermenu();
		up.doCustomerlist();
	}

	@When("^click on add new button$")
	public void click_on_add_new_button() throws Throwable {
	    up.addCustomer();
	}

	@And("^Add new customer info$")
	public void add_new_customer_info() throws Throwable {
	    cp.setEmail("use15@yourstore.com");
	    cp.setPwd("abcde");
	    cp.setfirstname("sss");
	    cp.setlastname("yyy");
	    cp.setGender("male");
	    cp.setdob("8/18/2011");
	    cp.setCompany("ABC");
	    cp.setTax("yes");
	    cp.setNewlt("Test store 2");
	    cp.setCusrole("Guests");
	    cp.setvendor("Vendor 2");
	    cp.setActive("yes");
	    cp.setComment("This is done");
	    
	    
	}

	@When("^click on save$")
	public void click_on_save() throws Throwable {
	    
		cp.doSave();
		Thread.sleep(3000);
	}

	@Then("^user see the confirmation message$")
	public void user_see_the_confirmation_message() throws Throwable {
	    
		if(localdriver.getPageSource().contains(" The new customer has been added successfully"))
		
			Assert.assertTrue(true);
			
			
	}
	/*  Search customer details using EmailID */
	
	@When("^user enters Email as \"([^\"]*)\" and click on Search button$")
	public void user_enters_Email_as_and_click_on_Search_button(String arg1) throws Throwable {
	    cs.putEmail(arg1);
	    cs.submit();
	    Thread.sleep(2000);
	   
	    
	}

	@Then("^user see the Customer related to\"([^\"]*)\" in the table below$")
	public void user_see_the_Customer_related_to_in_the_table_below(String arg1) throws Throwable {
		 
		Assert.assertEquals(cs.searchCustomerByEmail(arg1), true);
	}
	
	/*  Search customer details using FirstName */
	
	@When("^user enters name as \"([^\"]*)\" and \"([^\"]*)\" click on Search button$")
	public void user_enters_name_as_and_click_on_Search_button(String arg1, String arg2) throws Throwable {
	   
		cs.putfirstname(arg1);
		cs.putlastname(arg2);
		cs.submit();
		Thread.sleep(2000);
	}

	@Then("^user see the Customerdetails related to \"([^\"]*)\" and \"([^\"]*)\" in the table below$")
	public void user_see_the_Customerdetails_related_to_and_in_the_table_below(String arg1, String arg2) throws Throwable {
	    
		//Assert.assertEquals(actual, expected);
		Assert.assertEquals(cs.searchCustomerByName(arg1, arg2), true);
		Thread.sleep(2000);
	}

	
}
