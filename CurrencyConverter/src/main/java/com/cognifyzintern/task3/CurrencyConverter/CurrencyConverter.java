package com.cognifyzintern.task3.CurrencyConverter;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

import org.json.JSONObject;

public class CurrencyConverter 
{
	
	private static final String API_URL = "https://api.exchangerate-api.com/v4/latest/";
	
	private static double getExchangeRate(String baseCurrency, String targetCurrency) throws Exception {
		String urlString = API_URL + baseCurrency;
		URL url = new URL(urlString);
		HttpURLConnection connection = (HttpURLConnection) url.openConnection();
		connection.setRequestMethod("GET");
		
		BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		String inputLine;
		
		StringBuilder content = new StringBuilder();
		while((inputLine = in.readLine()) != null) {
			content.append(inputLine);
		}
		in.close();
		connection.disconnect();
		
		
		JSONObject json = new JSONObject(content.toString());
		if (!json.getJSONObject("rates").has(targetCurrency)) {
			throw new Exception("Invalid Target Currency !!!");
		}
		return json.getJSONObject("rates").getDouble(targetCurrency);
	}
	
    public static void main( String[] args )
    {
        try(Scanner sc = new Scanner(System.in))
        {
        	System.out.println("Enter the Base Currency (e.g., USD): ");
        	String baseCurrency = sc.next().toUpperCase();
        	
        	System.out.println("Enter the Target Currency (e.g., EUR) :");
        	String targetCurrency = sc.next().toUpperCase();
        	
        	System.out.println("Enter the amount to convert :");
        	double amount = sc.nextDouble();
        	
        	double exchangeRate = getExchangeRate(baseCurrency, targetCurrency);
        	double convertedAmount = amount * exchangeRate;
        	
        	System.out.printf("%.2f %s is equivalent to %.2f %s\n", amount, baseCurrency, convertedAmount, targetCurrency);
        } catch (Exception e) {
			System.out.println("Error :"+e.getMessage());
		}
    }

	
}
