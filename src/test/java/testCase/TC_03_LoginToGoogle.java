package testCase;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObject.LoginToGoogle;
import testBase.BaseClass;

public class TC_03_LoginToGoogle extends BaseClass{
	
	@Test(priority=1,groups= {"sanity"})
	public void LoginSignup() throws InterruptedException, IOException {
		LoginToGoogle login=new LoginToGoogle(driver);
		Thread.sleep(3000);
		login.Login();
		logger.info("----Clicked the Login/Signup Button----");
		captureScreen("Login");
	}
	
	
	@Test(priority=2)
	public void HandlingWindow() throws InterruptedException, IOException {
		LoginToGoogle login=new LoginToGoogle(driver);
		login.ClickGoogle();
		logger.info("----Clicked Google Login----");
		captureScreen("Google");
		
	}
	@Test(priority=3)
	public void InvalidEmail() throws InterruptedException, IOException  {
		LoginToGoogle login=new LoginToGoogle(driver);
		login.enterDetails();
		logger.info("----Entered invalid email id and captured error message----");
		captureScreen("Invalid");
	}
}