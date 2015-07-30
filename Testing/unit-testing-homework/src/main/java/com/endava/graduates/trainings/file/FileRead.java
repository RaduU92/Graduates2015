package com.endava.graduates.trainings.file;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class FileRead implements FileReadInterface{

    public String readFromFile() throws FileNotFoundException {
        File file = new File("dummyvalue");
        FileReader fr = new FileReader(file);
        System.out.println("This shouldn't print to console");
        return "dummy";
    }
}
