package com.endava.graduates.trainings.mocking.spy;

import java.util.ArrayList;
import java.util.List;

public class StringTransformerSpy {

	public List<String> transformListToUpperCase (List<String> input){
		System.out.println("part1");
		List<String> output = new ArrayList<String>();
		for(String s : input){
			output.add(transformToUpperCase(s));
		}
		return output;
	}
	
	public String transformToUpperCase(String input){
		System.out.println("part2");
		return input.toUpperCase();
	}
	
}
