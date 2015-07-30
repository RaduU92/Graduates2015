package com.endava.graduates.trainings.mocking.stubs;

import java.util.ArrayList;
import java.util.List;

import com.endava.graduates.trainings.mocking.stubs.StubInterface;

public class StubImplementation implements StubInterface{

	public List<String> execute(List<String> input) {
		List<String> output = new ArrayList<String>();
		output.add("stub");
		return output;
	}

}
