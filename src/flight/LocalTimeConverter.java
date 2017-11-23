package flight;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONException;
import org.json.JSONObject;
import org.json.JSONArray;

public class LocalTimeConverter {
	private String GoogleAPIKey = "AIzaSyAD9dZgmw9HV97q1rbJG_wCPt2eVHL-B_A";
	//private String Longitude;
	//private String Latitude;
	
	private String baseURL = "https://maps.googleapis.com/maps/api/timezone/json?location="; 

	public String convertLocalTime (String lon, String lat, String timeStamp) {

		URL url;
		HttpURLConnection connection;
		BufferedReader reader;
		String line;
		StringBuffer result = new StringBuffer();
		
		String jsonTimezones;
		String TimeZoneId;
		//Airports airports;

		try {
			/**
			 * Create an HTTP connection to the server for a GET 
			 */
			url = new URL(baseURL + lat +","+ lon+"&timestamp="+timeStamp+"&key="+GoogleAPIKey);
			connection = (HttpURLConnection) url.openConnection();
			connection.setRequestMethod("GET");

			/**
			 * If response code of SUCCESS read the XML string returned
			 * line by line to build the full return string
			 */
			int responseCode = connection.getResponseCode();
			if (responseCode >= HttpURLConnection.HTTP_OK) {
				InputStream inputStream = connection.getInputStream();
				String encoding = connection.getContentEncoding();
				encoding = (encoding == null ? "UTF-8" : encoding);

				reader = new BufferedReader(new InputStreamReader(inputStream));
				while ((line = reader.readLine()) != null) {
					result.append(line);
				}
				reader.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		jsonTimezones = result.toString();
		
		try {
			JSONObject  jsonObject = new JSONObject(jsonTimezones);
			TimeZoneId = jsonObject.getString("timeZoneId");
			
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			TimeZoneId="";
			e.printStackTrace();
		}
		// 
		return TimeZoneId;
		
	}	
}