package com.endava.graduates.trainings.patterns;

public class FileContentPattern {

    public String verifyContent(String inputString, int inputInt) throws Exception {
        String output = null;
        if (inputString != null) {
            if (inputString.equals("agent") && inputInt < 5) {
                output = "Secret Agent";
            } else if (inputString.equals("superAgent") && inputInt >= 5) {
                output = "Super Secret Agent";
//            } else if (inputString.equals("superAgent") && inputInt < 5) {
            } else if (inputString.equals("superAgent")) {
                throw new Exception("Illegal situation");
            }
        }
        return output;
    }

}
