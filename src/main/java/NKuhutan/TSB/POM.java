package NKuhutan.TSB;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class POM {
		
	public POM(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'View all categories')]")
	public WebElement vallcat;
	
	public String xallmotors = "//*[@id='fullCat']/tbody/tr/td/div/ul/li/a[contains(@href,'motors')]";
	
	@FindBy(how = How.XPATH, using = "//*[@id='fullCat']/tbody/tr/td/div/ul/li/a[contains(@href,'motors')]")	
	public List<WebElement> allmotors;	
	
	public String allcategories = "//*[@id='fullCat']/tbody/tr/td/div[@class='category']";	
	
	@FindBy(how = How.XPATH, using = "//*[@id='fullCat']/tbody/tr/td[2]/div[@class='category']/a")	
	public List<WebElement> lallcategories;		
	
	@FindBy(how = How.XPATH, using = "//*[@id='fullCat']/tbody/tr/td/div/ul/li/a[.='Cars']")
	public WebElement cars;	
	
	public String lkia = "//*[@id='makes']/tbody/tr/td/a[.='Kia']";
	
	@FindBy(how = How.XPATH, using = "//*[@id='makes']/tbody/tr/td/a[.='Kia']")
	public List<WebElement> kias;	
	
	public String xbutton = "//button[@value='Search']";
	
	@FindBy(how = How.NAME, using = "searchString")
	public WebElement inputSearch;	
	
	@FindBy(how = How.XPATH, using = "//button[@value='Search']")
	public WebElement search;	
	
	public String xdetails = "//*[@id='AttributesDisplay_attributesSection']/ul/li/div/label[@class='motors-attribute-label']";
	
	@FindBy(how = How.XPATH, using = "//*[@id='AttributesDisplay_attributesSection']/ul/li/div/label[@class='motors-attribute-label']")
	public List<WebElement> cardetails;	
	
}
