@NKuhutan
Feature: NKuhutan Test Solution
  Check
	
	@WebTest
  Scenario: Web Version Test
    Given Go to TradeMe and navigate Categories    
    Then Check there is at least one listing in the TradeMe UsedCars category
    Then Check that the make Kia exists
    Then Query any existing Used Car listing and confirm that the following details are shown for that car
		| 2010 Audi A3	        |
		| Number plate          |
		| Kilometres            |    
		| Body		        |
		| Seats		        |
		| Fuel type	        |
		| Engine		|
		| Transmission          |
		| History		|
		| Registration expires	|
		| WoF expires	        |		
		| Model detail          |																		
  
  @APITest
  Scenario: API Version Test
    Given There is more than 1 listing of Used Cars in the API
    Then Check if Kia exists from the API
    Then Query the API car details of an specific searched car
		| 2010 Audi A3		    |
		| Audi			    |    
		| NumberPlate		    |
		| Odometer	            |
		| BodyStyle	            |		
		| Seats			    |
		| Fuel	  		    |
		| EngineSize	  	    |
		| Transmission        	    |
		| ImportHistory		    |
		| RegistrationExpires	    |
		| WofExpires		    |		
		| Model                     |	    
    
