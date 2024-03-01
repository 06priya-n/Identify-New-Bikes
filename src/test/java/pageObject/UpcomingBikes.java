package pageObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.Select;
import utilities.ExcelUtilities;

public class UpcomingBikes extends BasePage{

	public UpcomingBikes(WebDriver driver) {
		super(driver);
	}
	
	public List<String> bikenames=new ArrayList<String>();
	public List<String> bikePrice=new ArrayList<String>();
	public List<String> launchDate=new ArrayList<String>();
	
	
	@FindBy(xpath="(//a[@href='/newbikes'])[1]") 
	WebElement newBikes;
	
	@FindBy(xpath="//span[contains(text(),'Upcoming Bikes')]") 
	WebElement UpcomingBikes;
	
	@FindBy(className="custom-select") 
	WebElement Manufacturer;
	
	@FindBy(xpath="//img[@title='Honda Rebel 1100']") 
	WebElement viewMore;
	
	@FindBy(xpath="//span[@class='zw-cmn-loadMore']") 
	WebElement clkViewMore;
	
	@FindBy(xpath="//a[@data-track-label='model-name']")
	List<WebElement> bikeNames;
	
	@FindBy(xpath="//a[@data-track-label='model-name']/following-sibling::div[1]")
	List<WebElement> prices;
	
	@FindBy(xpath="//a[@data-track-label='model-name']/following-sibling::div[2]")
	List<WebElement> launch;
	
	String filepath=System.getProperty("user.dir")+"./Excel/OutputData.xlsx";
	JavascriptExecutor js=(JavascriptExecutor) driver;
	
	
	public void newbikes() throws InterruptedException{
		 Actions act=new Actions(driver);
		 act.moveToElement(newBikes).perform();
		// Thread.sleep(3000);
		 js.executeScript("arguments[0].click();",UpcomingBikes); 
	}
	
	public void Manufacturerdrpdown() throws InterruptedException {
		Select drpdwn= new Select(Manufacturer);
		//Thread.sleep(6000);
    	drpdwn.selectByVisibleText("Honda");
	}
	
	public void clkViewMore() throws InterruptedException {
    	//Thread.sleep(2000);
    	js.executeScript("arguments[0].scrollIntoView();",clkViewMore);
    	js.executeScript("arguments[0].click();", clkViewMore);
	}
	
	public void ExtractBikes() throws IOException, InterruptedException {
		for (int i = 0; i < bikeNames.size(); i++) {
			String str = bikeNames.get(i).getText();
			bikenames.add(str);
			String str1 = prices.get(i).getText();
			bikePrice.add(str1);
			String str2 = launch.get(i).getText();
			launchDate.add(str2);
 
			String priceString = str1.replaceAll("[^\\d.]", "").replaceFirst("\\.(?=.*\\.)", "");
			double price = Double.parseDouble(priceString);
			// Check if the price is under 4 lakh and print the bike details
			if (price < 4.0) {
				System.out.println(str);
				System.out.println(str1);
				System.out.println(str2+"\n");
			}
		}
		ExcelUtilities.writeBikenames(bikenames,filepath);
		ExcelUtilities.writebikePrice(bikePrice,filepath);
		ExcelUtilities.writelaunchDate(launchDate,filepath);
		driver.navigate().back();
	}
}





