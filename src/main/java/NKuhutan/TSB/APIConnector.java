package NKuhutan.TSB;

import kong.unirest.HttpResponse;
import kong.unirest.JsonNode;
import kong.unirest.Unirest;
import kong.unirest.json.JSONArray;
import kong.unirest.json.JSONObject;

public class APIConnector {
	
	public APIConnector() {
		
	}
	
	public JSONObject sendRequest(String req) {
		HttpResponse<JsonNode> response = Unirest.get(req).header("accept",  "*/*").asJson();
		return response.getBody().getObject();
	}
	
	public JSONArray sendRequestArr(String req) {
		HttpResponse<JsonNode> response = Unirest.get(req).header("accept",  "*/*").asJson();
		return (JSONArray) response.getBody().getObject().get("List");
	}

}
