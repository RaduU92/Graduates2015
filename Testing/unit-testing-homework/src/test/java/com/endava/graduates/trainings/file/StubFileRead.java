package com.endava.graduates.trainings.file;

import java.io.FileNotFoundException;

/**
 * Created by rursu on 7/30/2015.
 */
public class StubFileRead implements FileReadInterface {
    public String readFromFile() throws FileNotFoundException {
        return "superAgent";
    }
}
