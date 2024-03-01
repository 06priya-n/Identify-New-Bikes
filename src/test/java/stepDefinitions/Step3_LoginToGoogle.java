package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;

import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.LoginToGoogle;

public class Step3_LoginToGoogle{
	
	static WebDriver driver;
	LoginToGoogle login;
	
	@Given("Click on Login or Signup button")
	public void click_on_login_signup_button() throws InterruptedException {
		BaseClass.getLogger().info("----Clicking on Login/signup button----");
		login=new LoginToGoogle(BaseClass.getDriver());
		login.Login();
	   
	}

	@When("Select Google to Login")
	public void select_google_to_login() throws InterruptedException {
		BaseClass.getLogger().info("----Selecting Google to login to the account----");
		login.ClickGoogle();
	}

	@Then("Give Invalid Email Id for Login")
	public void give_invalid_email_id_for_login() throws InterruptedException, IOException {
		BaseClass.getLogger().info("----Giving Invalid Email Id----");
		login.enterDetails();
	    
	}

	@Then("Extract the Error Message Displayed")
	public void extract_the_error_message_displayed() throws InterruptedException {
		BaseClass.getLogger().info("----Extracting the Error Message Displayed----");

	    
	}
}
