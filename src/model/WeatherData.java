
package model;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;

import org.json.JSONArray;
import org.json.JSONObject;

public class WeatherData {
	private static Weather getWeatherFromApi(String LATITUDE, String LONGITUDE) {
		
		final String API_KEY = "000970d0a40ad1fe1764468b9c731e76";
		final int KELVIN = 273;

		String urlString = "http://api.openweathermap.org/data/2.5/weather?lat=" + LATITUDE + "&lon=" + LONGITUDE
				+ "&appid=" + API_KEY;
			
		StringBuilder result = new StringBuilder();
		URL url;

		try {
			System.setProperty("http.proxyHost", "10.23.201.11");
			System.setProperty("http.proxyPort", "3128");
			url = new URL(urlString);
			HttpURLConnection conn = (HttpURLConnection) url.openConnection();

			BufferedReader rd = new BufferedReader(new InputStreamReader((conn.getInputStream())));
			String line;
			while ((line = rd.readLine()) != null) {
				result.append(line);
			}
			rd.close();

		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		String JsonString = new String(result.toString());

		JSONObject obj = new JSONObject(JsonString);
		Weather weather = new Weather();

		weather.setTemperature((int) Math.floor(obj.getJSONObject("main").getDouble("temp") - KELVIN));
		weather.setTemp_min((int) Math.floor(obj.getJSONObject("main").getDouble("temp_min") - KELVIN));
		weather.setTemp_max((int) Math.floor(obj.getJSONObject("main").getDouble("temp_max") - KELVIN));
		weather.setHumidity((int) Math.floor(obj.getJSONObject("main").getDouble("humidity")));
		weather.setCity(obj.getString("name")); 
		JSONArray arr = obj.getJSONArray("weather");
		weather.setDescription(arr.getJSONObject(0).getString("description"));
		weather.setIconId(arr.getJSONObject(0).getString("icon"));
		weather.setCountry(obj.getJSONObject("sys").getString("country"));
		
		
		return weather;

	}

	public static Weather getWeather(String city) {
		
		Weather weather =new Weather();
		String[] coord;
		HashMap<String, String[]> cityCoord = new HashMap<String, String[]>();
		coord = new String[] { "34.020000", "-6.830000" };
		cityCoord.put("Rabat", coord);
		coord = new String[] { "35.7595", "-5.8340" };
		cityCoord.put("Tanger", coord);
		coord = new String[] { "30.421440", "-9.583039" };
		cityCoord.put("Agadir", coord);
		coord = new String[] { "27.158507", "-13.207878" };
		cityCoord.put("Laayoune", coord);
		coord = new String[] { "33.590000", "-7.610000" };
		cityCoord.put("Casablanca", coord);

		String LATITUDE = cityCoord.get(city)[0];
		String LONGITUDE = cityCoord.get(city)[1];

		weather = getWeatherFromApi(LATITUDE, LONGITUDE);
		return weather;

	}

}