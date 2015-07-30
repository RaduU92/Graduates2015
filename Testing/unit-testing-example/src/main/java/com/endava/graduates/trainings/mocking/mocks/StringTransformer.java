package com.endava.graduates.trainings.mocking.mocks;

import java.util.ArrayList;
import java.util.List;

public class StringTransformer {
	
	MockClass mockClass;
	
	public List<String> transformListToUpperCase (List<String> input){
		List<String> output = new ArrayList<String>();
		mockClass = new MockClass();
		for(String s : input){
			output.add(mockClass.transformToUpperCase(s));
		}
		return output;
	}

}
