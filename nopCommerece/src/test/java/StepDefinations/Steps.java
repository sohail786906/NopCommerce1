package StepDefinations;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import com.google.common.io.Files;

import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.*;
import io.github.bonigarcia.wdm.WebDriverManager;
import junit.framework.Assert;
import pageObject.AddcustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;

public class Steps extends BaseClass {
	@Before
	public void setup() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		System.out.println("Setup method executed");
	}
	@BeforeStep
	public void BeforeStepDemo() throws IOException {
		System.out.println("Before step demo");
	
	}
	
	
  
	@Given("User Launch Chrome browser")
	public void user_launch_chrome_browser() {
		
	   lp=new LoginPage(driver);
	}

	@When("User opens URL {string}")
	public void user_opens_URL(String url) {
	driver.get(url);
	driver.manage().window().maximize();
	}
	@When("User enters Email as {string} and Password as {string}")
	public void user_enters_Email_as_and_Password_as(String email, String password) {
	   lp.setUserName(email);
	   lp.setPassword(password);
	}

	@When("Click on Login")
	public void click_on_login() throws InterruptedException {
	   lp.clickLogin();
	   Thread.sleep(3000);
	   
	}

	@Then("Page Title should be {string}")
	public void page_Title_should_be(String title) throws InterruptedException {
	    if(driver.getPageSource().contains("Login was unsuccessful.")) {
	    driver.close();
	    
	    Assert.assertTrue(false);
	    }
	    else {
	     Assert.assertEquals(title, driver.getTitle());
	    }
	    Thread.sleep(3000);
	    
	}

	@When("User click on Log out link")
	public void user_click_on_Log_out_link() throws InterruptedException {
	  lp.clickLogout();
	  Thread.sleep(3000);
	
	}

	@Then("close browser")
	public void close_browser() {
		  driver.quit();
	}

//Customer feature stepDefination...................
	
	@Then("User can view Dashboad")
	public void user_can_view_dashboad() {
	    addCust = new AddcustomerPage(driver);
	    Assert.assertEquals("Dashboard / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User click on customers Menu")
	public void user_click_on_customers_menu() throws InterruptedException {
		Thread.sleep(3000);
	   addCust.clickOnCustomerMenu();
	}

	@When("click on customers Menu Item")
	public void click_on_customers_menu_item() throws InterruptedException {
		Thread.sleep(3000);
	    addCust.clickOnCustmerMenuItem();
	}

	@When("click on Add new button")
	public void click_on_add_new_button() throws InterruptedException {
		
		addCust.clickOnAddnew();
		Thread.sleep(2000);
	}

	@Then("User can view Add new customer page")
	public void user_can_view_add_new_customer_page() {
	  Assert.assertEquals("Add a new customer / nopCommerce administration", addCust.getPageTitle());
	}

	@When("User enter customer info")
	public void user_enter_customer_info() throws InterruptedException {
	   String email = randomestring()+"@gmail.com";
	   addCust.setEmail(email);
	   addCust.setPassword("test123");
                	   //Registered - default
	                     //The customer cannot be in both 'Guests' and 'Registered' customer roles
	             //Add the customer to 'Guests' or 'Registered' customer role
	   addCust.setFirstName("sohaa");
	   addCust.setLastName("mohammed");
	   addCust.setGender("Male");
	   addCust.setDob("09/05/1999");
	   
	   addCust.setCompanyName("My_info_amazo_flip_ali-baba");
	   
	   
   //addCust.setCustomerRoles("Forum Moderators");
   
   
   addCust.setManagerOfVendor("Vendor 2");
   
  
   addCust.setAdminContent("This is for testing..... ");
	}

	@When("click on Save button")
	public void click_on_save_button() throws InterruptedException {
		addCust.ClickOnSave();
		Thread.sleep(2000);
	}

	@Then("User can view confirmation message {string}")
	public void user_can_view_confirmation_message(String msg) {
	    Assert.assertTrue(driver.findElement(By.tagName("body")).getText().contains("The new customer has been added successfully"));
		
	}
	//Steps for searching a customer using Email ID....
	@When("Enter customer EMail")
	public void enter_customer_e_mail() {
	   searchCust = new SearchCustomerPage(driver);
	   searchCust.setEmail("admin@yourStore.com");
	}

	@When("Click on search button")
	public void click_on_search_button() throws InterruptedException {
	   searchCust.clickSearch();
	   Thread.sleep(3000);
	   
	}

	@Then("User should found Email in the Search table")
	public void user_should_found_email_in_the_search_table() {
	  boolean status = searchCust.searchCustomerByEmail("admin@yourStore.com");
	Assert.assertEquals(false, status);


	}
//steps for searching a customer by using first name and last name
	@When("User click on Customers Menu")
	public void user_click_on_customers_menu1() {
		 addCust.clickOnCustomerMenu();
	}

	
	@When("Enter customer FirstName")
	public void enter_customer_first_name() 
	{
		searchCust = new SearchCustomerPage(driver);
		 searchCust.setFirstName("Soha");

	}
	@When("Enter customer LastName")
	public void enter_customer_last_name() {
		searchCust.setLastName("mohd");
		searchCust.clickSearch();
	}
	@Then("User should found Name in the Search table")
	public void user_should_found_name_in_the_search_table() {
boolean status = searchCust.searchCustomerByName("Soha mohd");
searchCust.clickSearch();


	Assert.assertEquals(false, status);
	}
	@After
	public void teardown() {
		System.out.println("Tear Down message executed:");
		driver.quit();
	}
	@AfterStep
	public void AfterStepMethodDemo(Scenario sc) throws IOException {
		System.out.println("After Step Method Demo");
		if(sc.isFailed()==true) {
			String filepath = "C:\\Users\\Mohammed Sohail\\git\\repository\\nopCommerece\\Screenshots\\failedScreenshots.png";
		TakesScreenshot shots = ((TakesScreenshot)driver);
		File srcfl= shots.getScreenshotAs(OutputType.FILE);
		File DestFile = new File (filepath);
		Files.copy(srcfl, DestFile);
		}
		}


}
