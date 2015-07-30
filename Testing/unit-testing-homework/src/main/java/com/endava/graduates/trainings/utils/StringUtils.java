package com.endava.graduates.trainings.utils;

public class StringUtils {
	
	public static String toUpperCase (String input){
		return input.toUpperCase();
	}
	
	public static String concatStrings (String firstString, String secondString){
		return firstString + secondString;
	}
	
	public static String substringValue (String input, int outputValueLenght){
		String output = "";
		if(outputValueLenght < input.length()){
			output = input.substring(outputValueLenght);
		}
		return output;
	}

}
