package pageObject;

import java.io.IOException;
import java.util.Set;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import utilities.ExcelUtilities;

public class LoginToGoogle extends BasePage {

	public LoginToGoogle(WebDriver driver) {
		super(driver);
	}
	JavascriptExecutor js=(JavascriptExecutor) driver;
	@FindBy(xpath="//div[@id='des_lIcon']")
	WebElement login;
	
	@FindBy(xpath="(//span[@class='fnt-14'])[3]")
	WebElement Google;
	
	@FindBy(xpath="(//input[@class='whsOnd zHQkBf'])[1]")
	WebElement email;
	
	@FindBy(xpath="//span[@jsname='V67aGc']")
	WebElement Dismiss;
	
	@FindBy(xpath="(//span[@jsname='V67aGc'])[2]")
	WebElement Next;
	
	@FindBy(xpath="//div[@class='o6cuMc Jj6Lae']")
	WebElement errorMsg;
	
	@FindBy(xpath="//a[@href='/']")
	WebElement back;
	
	
	public void Login() throws InterruptedException {
		//Thread.sleep(3000);
		js.executeScript("arguments[0].click();", login);
	}
	
	public void ClickGoogle() throws InterruptedException {
		Thread.sleep(3000);
		js.executeScript("arguments[0].click();", Google);
		String mainWindowHandle = driver.getWindowHandle(); // Store the current window handle
    	Set<String> windowHandles = driver.getWindowHandles(); // Get all window handles
    	for (String handle : windowHandles) {
    	    if (!handle.equals(mainWindowHandle)) {
    	        driver.switchTo().window(handle); // Switch to the pop-up window
    	        break;
    	    }
    	}
	}
	
	public void enterDetails() throws InterruptedException, IOException {
		
		//entering invalid email id
		String emailid=ExcelUtilities.getCellData("./Excel/InputData.xlsx", "Sheet1", 0, 0);
		Thread.sleep(2000);
    	email.sendKeys(emailid);
    	email.sendKeys(Keys.ENTER);
    	String msg=errorMsg.getText();//getting error message
    	System.out.println("\nError Message for invalid Email ID \n"+ msg);
	}
}

