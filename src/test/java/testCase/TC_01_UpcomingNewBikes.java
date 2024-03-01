package testCase;

import java.io.IOException;
import org.testng.annotations.Test;
import pageObject.UpcomingBikes;
import testBase.BaseClass;

public class TC_01_UpcomingNewBikes extends BaseClass {
	
	@Test(priority=1,groups= {"sanity"})
	public void ExtractingNewBikes() throws InterruptedException, IOException {
		
		UpcomingBikes hp=new UpcomingBikes(driver);
		logger.info("----Moving to New Bikes----");
		hp.newbikes();
		logger.info("----Upcoming New Bikes Clicked----");
		captureScreen("New bikes");
	}
	
	@Test(priority=2)
	public void SelectingManufacturer() throws InterruptedException {
		
		UpcomingBikes hp=new UpcomingBikes(driver);
		hp.Manufacturerdrpdown();
		logger.info("----Selected Honda from Dropdown----");
		//String ExpTitle="Honda Upcoming Bikes in India in India 2024-25, Check Price, Launch Date, Specs @ ZigWheels";
		//Assert.assertEquals(actTitle, ExpTitle,"Honda Upcoming Bike Page Not Verified");
		hp.clkViewMore();
		logger.info("----Scrolling and clicking view more----");
	}
	
	@Test(priority=3)
	public void ExtractBikeNames() throws IOException, InterruptedException {
		
		UpcomingBikes hp=new UpcomingBikes(driver);
		hp.ExtractBikes();
		logger.info("----Extracting Upcoming Bikes Details----");
		captureScreen("Upcoming Bikes");
	}
	
}
