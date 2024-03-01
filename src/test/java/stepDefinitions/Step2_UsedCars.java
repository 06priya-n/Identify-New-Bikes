package stepDefinitions;

import java.io.IOException;
import factory.BaseClass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pageObject.UsedCars;

public class Step2_UsedCars {
	UsedCars uc;
	
	@Given("Navigate back to home page")
	public void navigate_back_to_home_page() throws InterruptedException {
		BaseClass.getLogger().info("----Navigating back to home page----");
		uc=new UsedCars(BaseClass.getDriver());

	}

	@When("Select Chennai from Used cars dropdown")
	public void select_chennai_from_used_cars_dropdown() throws InterruptedException {
		BaseClass.getLogger().info("----Selecting Used Cars from Chenneai----");
		uc.ClickUsedCars();

	}

	@When("Extract the popular models in chennai")
	public void extract_the_popular_models_in_chennai() throws InterruptedException, IOException {
		BaseClass.getLogger().info("----Exracting the Popular Model List----");
	    uc.ExtractPopularModel();

	}

	@Then("Extract the Used cars details of popular model")
	public void extract_the_used_cars_details_of_popular_model() throws InterruptedException, IOException {
		BaseClass.getLogger().info("----Extracting the details of Popular models in Chennai----");
		uc.PopularCarDetails();
	    
	}
}
