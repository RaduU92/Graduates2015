package com.endava.graduates.trainings.mocking.stubs;

import java.util.ArrayList;
import java.util.List;

public class RealImplementation implements StubInterface {

	public List<String> execute(List<String> input) {
		List<String> output = new ArrayList<String>();
		for(String s : input){
			output.add(s.toUpperCase());
		}
		return output;
	}

}
