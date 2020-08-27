package NKuhutan.TSB.StepDefs;

import io.cucumber.java.en.Given;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.After;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Before;
import io.cucumber.java.BeforeStep;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.But;

import java.util.List;
import java.util.Properties;

import org.openqa.selenium.WebDriver;

import NKuhutan.TSB.*;
import NKuhutan.TSB.WebConnector;
import NKuhutan.TSB.TestNG.WebTest;
import NKuhutan.TSB.Tools.ReadConfig;
import NKuhutan.TSB.TestNG.APITest;

public class Steps
{
	
  private WebTest wtest;
  private APITest atest;
  private Properties p = new Properties();
  
  @Before
  public void before(Scenario scenario) {
	  try {
		  p = new ReadConfig().getProp("config/config.properties");
	  }catch (Exception e) {
		  System.out.println("NO Config FOUND " + e.getMessage());
	  }		  
	  if(scenario.getName().equals("Web Version Test")) {
		  wtest = new WebTest();
	  }else {
		  atest = new APITest(p);
	  }	    
	  
  }
 
  @Given("^Go to TradeMe and navigate Categories$")
  public void navigate() throws Throwable {	 	  
	  wtest.viewAllCategories(p.getProperty("tmsandbox"));
  }

  @Then("^Check there is at least one listing in the TradeMe UsedCars category$")
  public void checkListings() throws Throwable {
	  wtest.verifyUsedCarsListings();
  }  
  
  @Then("^Check that the make Kia exists$")
  public void checkKia() throws Throwable {
	  wtest.gotoTradeMeMotors();
	  wtest.checkKiaExists();
  }  
  
  @Then("^Query any existing Used Car listing and confirm that the following details are shown for that car$")
  public void checkKeyDetails(DataTable table) throws Throwable {
	  List<String> data = table.asList();
	  wtest.checkKeyDetails("2010 Audi A3", data);
  }  
  
  @After
  public void after(Scenario scenario) {
	  if(scenario.getName().equals("Web Version Test")) {
		  wtest.driver.close(); 
	  }	  
  }
  
  @Given("^There is more than 1 listing of Used Cars in the API$")
  public void apiCheckListings() throws Throwable {	 	  
	  atest.getUsedCarsTotalCount();
  } 
  
  @Then("^Check if Kia exists from the API$")
  public void apiCheckKia() throws Throwable {
	  atest.searchKia();
  } 
  
  @Then("^Query the API car details of an specific searched car$")
  public void apiCheckKeyDetails(DataTable table) throws Throwable {
	  List<String> data = table.asList();
	  atest.verifyKeyDetails("2010 Audi A3", "Audi", data);
  }   
  

}
