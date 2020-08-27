package NKuhutan.TSB.TestNG;

import org.testng.annotations.Test;
import org.testng.AssertJUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.Test;

import NKuhutan.TSB.POM;
import NKuhutan.TSB.WebConnector;

public class WebTest extends WebConnector
{
	public POM pom;
	public WebTest() {		
		initChromeDriver();	
		pom = new POM(getDriver());
	}

	public void waitTillPresent(String strXPath) {
		Wait<WebDriver> wait = new FluentWait<WebDriver>(driver).withTimeout(5, TimeUnit.SECONDS).pollingEvery(5, TimeUnit.SECONDS).ignoring(Exception.class);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(By.xpath(strXPath)));
	}

	public void viewAllCategories(String tmURL) {
			driver.get(tmURL);
		    //View all categories	
			pom.vallcat.click();
	}

	public void verifyUsedCarsListings() {
		
	       //Get index of li
	       waitTillPresent(pom.xallmotors);	       
	       List<WebElement> motorList = pom.allmotors;	       
//	       System.out.println(motorList.size());
	       int lnkCtr = 0;
	       for(WebElement motor : motorList) {
	    	   String linkName = motor.getText(); 
//	    	   System.out.println(linkName);
	    	   lnkCtr = lnkCtr + 1;
	    	   if(linkName.equals("Cars")) {
//	    		   System.out.println(linkName);
//	    		   System.out.println(lnkCtr);
	    		   break;
	    	   }
	       }
	       
	       //Get index of div
	       waitTillPresent(pom.allcategories);
	       List<WebElement> categoryList = pom.lallcategories;
//	       System.out.println(categoryList.size());
	       int catCtr = 0;
	       for(WebElement cat : categoryList) {
	    	   String catName = cat.getAttribute("name");  
	    	   catCtr = catCtr + 1;
	    	   if(catName.equals("TradeMeMotors")) {
//	    		   System.out.println(catName);
//	    		   System.out.println(catCtr);
	    		   break;
	    	   }
	       }
	       
	       //Get List Count
	       String carsCountXPath = "//*[@id=\"fullCat\"]/tbody/tr/td[2]/div["+ catCtr +"]/ul/li["+ lnkCtr +"]/span";
	       String carsListCount = driver.findElement(By.xpath(carsCountXPath)).getText();
//	       System.out.println(carsListCount);
	       carsListCount = carsListCount.replace("(", "");
	       carsListCount = carsListCount.replace(")", "");
	       int carsCnt = Integer.parseInt(carsListCount);
	       Assert.assertTrue(carsCnt > 0);
	       
	}

	public void gotoTradeMeMotors() {
			pom.cars.click();
	}

	public void checkKiaExists() {
	       waitTillPresent(pom.lkia);
	       List<WebElement> kiaList = pom.kias;	       	
	       Assert.assertTrue(kiaList.size() > 0);
	}

	public void checkKeyDetails(String srcQuery, List<String> data) {
	       //Search and check details
//	       String searchQuery = "2010 Audi A3";
		   String searchQuery = srcQuery;
	       waitTillPresent(pom.xbutton);
	       pom.inputSearch.sendKeys(searchQuery);
	       pom.search.click();
	       
	       waitTillPresent("//div[contains(text(),'"+ searchQuery +"')]");
	       driver.findElement(By.xpath("//div[contains(text(),'"+ searchQuery +"')]")).click();
	       waitTillPresent(pom.xdetails);
	       List<WebElement> carDetails = pom.cardetails;
//	       System.out.println(carDetails.size());
	       
	       List<String> keyDetails = new ArrayList<String>();
	       for(WebElement det : carDetails) {
	    	   String detail = det.getText();
//	    	   System.out.println(detail);
	    	   keyDetails.add(detail);
	       }
	       
	       for(String dat : data) {
//	    	   System.out.println("Searching for: " + dat);
	    	   Assert.assertTrue(keyDetails.contains(dat));
	       }
	       		
	}
	
}
