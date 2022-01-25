package fr.banque.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;
import org.json.*;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;


public class ConvertisseurDevise {
	private String input;
	private String output;
	private double val;
	
	public ConvertisseurDevise(String input, String output, double val) {
		super();
		this.input = input;
		this.output = output;
		this.val = val;
	}

	public ConvertisseurDevise(){
		
	}
	
	public String getInput(){
		return input;
	}
	
	public String getOutput(){
		return output;
	}
	
	public Double getVal(){
		return val;
	}
	
	public void setInput(String s){
		input = s;
	}
	
	public void setOutput(String s){
		output = s;
	}
	
	public void setVal(Double d){
		val = d;
	}
	
	
	public double getConvertedVal() throws MalformedURLException, IOException {
		
		URL url = new URL("http://api.currencylayer.com/live?access_key=b9ee44e391f1d588ae67d6808019c426&currencies="+input+","+output+"&format=1");
		BufferedReader bf = new BufferedReader(new InputStreamReader(url.openStream()));
		//l'API de conversion retourne au format json le resultat, Ex:{"USDEUR":0.8855}
		JSONParser parser = new JSONParser();
		JSONObject json = null;
		String inputLine ;
		boolean inverse = false ; 
		String jsonString ="" ;
		  while (( inputLine = bf.readLine()) != null) {
	            jsonString +=inputLine;
	            }
		try {
			json = (JSONObject) parser.parse(jsonString.toString());
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		Object objrateValue =((JSONObject) json.get("quotes")).get(input+""+output);
		if (objrateValue == null) {
		inverse = true ;
		objrateValue =((JSONObject) json.get("quotes")).get(output+""+input);
		
		}
		
		if (objrateValue != null) {
		Double rateValue = Double.valueOf(objrateValue.toString());
		if (inverse) rateValue = 1/rateValue ;
		Double outputAmount = rateValue * val;
		
		return outputAmount;
		}
		return 0;
	}
}
