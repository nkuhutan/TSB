package NKuhutan.TSB.TestNG;

import java.util.List;
import java.util.Objects;
import java.util.Properties;

import org.testng.Assert;
import org.testng.annotations.Test;

import NKuhutan.TSB.APIConnector;
import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

//import com.mashape.unirest.http.HttpResponse;
//import com.mashape.unirest.http.JsonNode;
//import com.mashape.unirest.http.Unirest;

public class APITest extends APIConnector {
	
	private String hostapi;
	public APITest(Properties p) {
		hostapi = p.getProperty("tmapi");
	}
	
	public void getUsedCarsTotalCount() {
		//Get if there's listings	
		JSONObject resListings = sendRequest(hostapi + "v1/Search/Motors/Used.json");
		int listingCount = Integer.parseInt(resListings.get("TotalCount").toString());
//		System.out.println("Cars: " + resListings.get("TotalCount"));
		Assert.assertTrue(listingCount > 0);
	}
	
	public void searchKia() {
		//Search if there is KIA
		JSONObject kiaListings = sendRequest(hostapi + "v1/Search/Motors/Used.json?Make=Kia");		
//		System.out.println("KIAs: " + kiaListings.get("TotalCount"));
		int kias = Integer.parseInt(kiaListings.get("TotalCount").toString());
		Assert.assertTrue(kias >= 0);
	}
	
	public void verifyKeyDetails(String strSearch, String strMake, List<String> data) {

		//Specific Search
		JSONArray generalList = sendRequestArr(hostapi + "v1/Search/Motors/Used.json?Make="+strMake);		
		JSONObject joSearch = new JSONObject();
		String searchedTitle = "";
		for(Object obj : generalList) {
			joSearch = (JSONObject) obj;
			searchedTitle = joSearch.getString("Title");
			if(searchedTitle.equals(strSearch)) {	
				for(String dat : data) {
					boolean keyFound = (joSearch.get(dat) == null) ? false : true;
//					System.out.println(dat + ": " + joSearch.getString(dat));
					Assert.assertTrue(keyFound);				
				}				
				break;
			}		
		}
		
//		System.out.println(joSearch.toString());
//		System.out.println("Title: " + searchedTitle);					
//		System.out.println("Number plate: " + joSearch.get("NumberPlate").toString());
//		System.out.println("Kilometres: " + joSearch.getString("Odometer"));
//		System.out.println("Body: " + joSearch.getString("BodyStyle"));
//		System.out.println("Seats: " + joSearch.getString("Seats"));
//		System.out.println("Fuel type: " + joSearch.getString("Fuel"));
//		System.out.println("Engine: " + joSearch.getString("EngineSize"));
//		System.out.println("Transmission: " + joSearch.getString("Transmission"));
//		System.out.println("History: " + joSearch.getString("ImportHistory"));
//		System.out.println("Registration expires: " + joSearch.getString("RegistrationExpires"));
//		System.out.println("WoF expires: " + joSearch.getString("WofExpires"));
//		System.out.println("Model detail: " + joSearch.getString("Model"));			
	}
}
