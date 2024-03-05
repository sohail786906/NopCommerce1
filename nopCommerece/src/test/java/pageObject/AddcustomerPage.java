package pageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddcustomerPage {
public WebDriver ldriver;
public AddcustomerPage(WebDriver rdriver) {
	ldriver = rdriver;
	PageFactory.initElements(ldriver, this);
}
By lnkCustomers_menu=By.cssSelector("body > div:nth-child(3) > aside:nth-child(2) > div:nth-child(2) > div:nth-child(4) > div:nth-child(1) > div:nth-child(1) > nav:nth-child(2) > ul:nth-child(1) > li:nth-child(4) > a:nth-child(1) > p:nth-child(2)"); 
By lnkCustomers_menuitem=By.cssSelector("li[class='nav-item has-treeview menu-is-opening menu-open'] li:nth-child(1) a:nth-child(1)");

By btnAddnew=By.xpath("//i[@class='fas fa-plus-square']"); 
By txtEmail=By.id("Email");
By txtPassword=By.id("Password");


By txtFirstName=By.id("FirstName");
By txtLastName=By.id("LastName");

By rdMaleGender=By.cssSelector("#Gender_Male");
By rdFeMaleGender=By.cssSelector("#Gender_Female");

By txtDob=By.id("DateOfBirth");


By drpmgrOfVendor=By.cssSelector("#VendorId");



By txtCompanyName=By.cssSelector("#Company"); 
/*By txtcustomerRoles=By.xpath("//div[@class='k-widget k-multiselect k-multiselect-clearable k-state-hover']//div[@role='listbox']");

By lstitemAdministrators=By.xpath("//li[normalize-space()='Administrators']");
By lstitemRegistered=By.xpath("//li[@id='e033913e-ced7-4965-a487-82a5795313fa']");
By lstitemGuests=By.xpath("//li[normalize-space()='Guests']");
By lstitemVendors=By.xpath("//li[contains(text(),'Vendors')]");
By lstitemMorum=By.xpath("//li[normalize-space()='Forum Moderators']"); */



By txtAdminContent=By.cssSelector("#AdminComment");

By btnSave=By.cssSelector("button[name='save']");

public String getPageTitle() {
	return ldriver.getTitle();
}

private WebElement listitem;


public void clickOnCustomerMenu() {
	ldriver.findElement(lnkCustomers_menu).click();
}
public void clickOnCustmerMenuItem() {
	ldriver.findElement(lnkCustomers_menuitem).click();
}
public void clickOnAddnew() {
	ldriver.findElement(btnAddnew).click();
}
public void setEmail(String email) {
	ldriver.findElement(txtEmail).sendKeys(email);
}
public void setPassword(String password) {
	ldriver.findElement(txtPassword).sendKeys(password);
}
public void setCustomerRoles(String role) {
	if(!role.equals("Vendors")) {
		ldriver.findElement(By.xpath("//li[@id='6b75da32-bc29-4b9a-910f-ea839d25c074']"));
	}
	else if(role.equals("Administrators")) {
		listitem=ldriver.findElement(By.xpath("//li[contains(text(),'Administrators')]"));
	}
	/*else if(role.equals("Registered")) {
		listitem=ldriver.findElement(lstitemRegistered);
		
	}
	else if(role.equals("Vendors")) {
		listitem=ldriver.findElement(lstitemVendors);
}
	else {
		listitem=ldriver.findElement(lstitemGuests);
	}*/
	listitem.click();
	JavascriptExecutor js = (JavascriptExecutor)ldriver;
	js.executeScript("arguments[0].click();", listitem);
}
public void setManagerOfVendor(String value) {
	Select drp = new Select (ldriver.findElement(drpmgrOfVendor));
	drp.selectByVisibleText(value);
}
public void setGender(String gender) {
	if(gender.equals("Male")) {
		ldriver.findElement(rdMaleGender).click();
	}
	else if(gender.equals("Female")) {
		ldriver.findElement(rdFeMaleGender).click();
	}
	
	else {
		ldriver.findElement(rdMaleGender).click();
	}
}
public void setFirstName(String fname) {
	ldriver.findElement(txtFirstName).sendKeys(fname);
}
public void setLastName(String lname) {
	ldriver.findElement(txtLastName).sendKeys(lname);
}
public void setDob(String dob) {
	ldriver.findElement(txtDob).sendKeys(dob);
}
public void setCompanyName(String comname) {
	ldriver.findElement(txtCompanyName).sendKeys(comname);
}
public void setAdminContent(String content) {
	ldriver.findElement(txtAdminContent).sendKeys(content);
}
 
	public void ClickOnSave() {
		ldriver.findElement(btnSave).click();
	}
}
