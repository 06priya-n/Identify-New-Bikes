package pageObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import utilities.ExcelUtilities;

public class UsedCars extends BasePage {

	public UsedCars(WebDriver driver) {
		super(driver);
	}
	
	public List<String> popularModels=new ArrayList<String>();
	public List<String> usedcar=new ArrayList<String>();
	JavascriptExecutor js=(JavascriptExecutor) driver;
	Actions act=new Actions(driver);

	
	@FindBy(xpath="(//a[@class='c-p'])[4]")
	WebElement usedCars;
	
	@FindBy(xpath="(//span[contains(text(),'Chennai')])[1]")
	WebElement clkChennai;
	
	@FindBy(xpath="//div[contains(text(),'Popular Models')]")
	WebElement scrolltoPopular;
	
	@FindBy(xpath="//div[@class='gsc_thin_scroll']")
	WebElement popularModel;
	
	@FindBy(xpath="//a[@href='/']")
	WebElement back;
	
	@FindBy(xpath = "//ul[@class='zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10']/li")
    List<WebElement> model;//new
	
	@FindBy(xpath = "//ul[@class='zw-sr-secLev usedCarMakeModelList popularModels ml-20 mt-10']/li//input")
    List<WebElement> popular;
	
	@FindBy(xpath = "//a[@data-track-label='Car-name']")
	List<WebElement> carslist;
	 
	@FindBy(xpath = "//span[@class='zw-cmn-price n pull-left mt-3']")
	List<WebElement> carsprice;
	 
	@FindBy(xpath = "//span[@class='zc-7 fnt-14 uLm block']")
	List<WebElement> carslocation;
	
	String filepath=System.getProperty("user.dir")+"./Excel/OutputData.xlsx";
	
	
	public void ClickUsedCars() {
    	act.moveToElement(usedCars).perform();
    	js.executeScript("arguments[0].click();", clkChennai);// moving cursor to Used Cars
	}
	
	public void ExtractPopularModel() throws InterruptedException, IOException {
		
    	js.executeScript("arguments[0].scrollIntoView();",scrolltoPopular);
    	//Thread.sleep(1000);
    	String popmodel=popularModel.getText();  //extracting all popular models
    	usedcar.add(popmodel);
    	System.out.println("Popular Models of Used Cars in Chennai\n\n"+popmodel);
	}
	
	public void PopularCarDetails() throws InterruptedException, IOException {
    	
    	for (int i = 0; i < popular.size(); i++) {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("arguments[0].click()", popular.get(i));
			js.executeScript("window.scrollTo(0,document.body.scrollHeight)");
			//Thread.sleep(5000);
 
			int count1 = 1;
 
			for (int j = 0; j < 2; j++) {
				String s = carslist.get(j).getText();
				popularModels.add(s);
				System.out.println(count1 + " " + s);
				System.out.println(carsprice.get(j).getText());
				try {
					System.out.println(carslocation.get(j).getText());
				} catch (Exception e) {
					System.out.println("not available");
				}
				System.out.println("--------------------------");
				count1 += 1;
			}
			js.executeScript("arguments[0].click()", popular.get(i));
			Thread.sleep(3000);
		}
    	ExcelUtilities.writeBikenames(usedcar,filepath);
		ExcelUtilities.writebikePrice(popularModels,filepath);
		back.click();
	}
}
