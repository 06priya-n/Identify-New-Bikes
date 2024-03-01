package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.UpcomingBikes;

public class Step1_NewBike {
	 static WebDriver driver;
	UpcomingBikes up;
	
	@Given("Launching zigwheels website in web browser")
	public void launching_zigwheels_website_in_web_browser() throws InterruptedException {
		BaseClass.getLogger().info("----Opening zigwheels site----");
		driver=BaseClass.getDriver();
		up=new UpcomingBikes(BaseClass.getDriver());

	}

	@When("Selecting Upcoming bikes from new bikes dropdown")
	public void selecting_upcoming_bikes_from_new_bikes_dropdown() throws InterruptedException {
		BaseClass.getLogger().info("----Selecting Upcoming Bikes and Page navigates----");
	    up.newbikes();
	}
	
	@When("Selecting the manufacturer as Honda")
	public void selecting_the_manufacturer_as_honda() throws InterruptedException {
		BaseClass.getLogger().info("----Selecting Honda Bikes----");
		up.Manufacturerdrpdown();
		up.clkViewMore();
	}


	@Then("Extracting New Bikes of Honda")
	public void extracting_new_bikes_of_honda() throws IOException, InterruptedException {
		BaseClass.getLogger().info("----Extracting details of selected Honda bikes----");
	   up.ExtractBikes();
		Thread.sleep(3000);

	}


}
