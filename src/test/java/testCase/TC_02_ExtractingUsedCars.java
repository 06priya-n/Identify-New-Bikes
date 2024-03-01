package testCase;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObject.UsedCars;
import testBase.BaseClass;

public class TC_02_ExtractingUsedCars extends BaseClass{
	
	@Test(priority=1,groups= {"sanity","regression"})
	public void ClickingUsedCars() throws InterruptedException, IOException {
		
		UsedCars uc=new UsedCars(driver);
		logger.info("----Moved to Used Cars DropDown----");
		uc.ClickUsedCars();
		logger.info("----Clicked Used Cars in Chennai----");
		captureScreen("Used Cars");
	}
	
	@Test(priority=2,groups= {"regression"})
	public void UsedCarsPopularList() throws InterruptedException, IOException {
		
		UsedCars uc=new UsedCars(driver);
		logger.info("----Extracting the Popular Model List ----");
		uc.ExtractPopularModel();
		logger.info("----Extracted the Popular Model List ----");
		captureScreen("Popular models");
	}
	
	@Test(priority=3, groups= {"regression"})
	public void ExtractUsedCarDetails() throws InterruptedException, IOException {
		
		UsedCars uc=new UsedCars(driver);
		uc.PopularCarDetails();
		logger.info("----Extracted popular car details----");
	}
}
