package com.endava.graduates.trainings.patterns;

import java.util.List;

public class SuperAgentPattern {
	
	public boolean checkIfSuperAgent(List<String> inputList){
		boolean output = false;
		if(inputList!=null){
			for(String s: inputList){
				if(s.equals("Super Secret Agent")){
					output = true;
					break;
				}
			}
		}
		return output;
	}

}
