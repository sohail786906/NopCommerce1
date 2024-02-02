package StepDefinations;

import org.apache.commons.lang.RandomStringUtils;
import org.openqa.selenium.WebDriver;

import pageObject.AddcustomerPage;
import pageObject.LoginPage;
import pageObject.SearchCustomerPage;

public class BaseClass {
	 public WebDriver driver;
	  public LoginPage lp;
	  public AddcustomerPage addCust;
	  public SearchCustomerPage searchCust;
	  
	  //Created for generating random string for Unique email
	  public static String randomestring() {
		  String generatedString1 = RandomStringUtils.randomAlphabetic(5);
		  return(generatedString1);
	  }
}
