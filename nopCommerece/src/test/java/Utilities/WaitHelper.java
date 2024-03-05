package Utilities;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class WaitHelper {
public WebDriver driver;
public WaitHelper(WebDriver driver) {
	this.driver = driver;
}
public void WaitForElement(WebElement element,long timeOutInSeconds) {
	WebDriverWait wait = new WebDriverWait(driver, timeOutInSeconds);
	wait.until(ExpectedConditions.visibilityOf(element));
}

}