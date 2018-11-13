package com.ipo.analysis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import com.ipo.analysis.model.InputVariables;

public class InputHelper {

	public static InputVariables readAndFill(String fileName) throws IOException {
		Path path = Paths.get(fileName);
		InputStream inFile = Files.newInputStream(path);
	    BufferedReader readerInFile = new BufferedReader(new InputStreamReader(inFile));
	    String line = readerInFile.readLine();
	    System.out.println(line);
	    line = readerInFile.readLine();
	    System.out.println(line);
	    int size = Integer.parseInt(line);
		InputVariables input = new InputVariables(size);
	    line = readerInFile.readLine();
	    String[] strArray = line.split(" ");
	    int i=0;
	    for (String string : strArray) {
			input.setQuadBenefit(i, i, Float.parseFloat(string));
			i++;
	    }
	    for (i = 0; i < size; i++) {
	    	line = readerInFile.readLine();
	    	strArray = line.split(" ");
	    	int lineSize=size-1-i;
	    	for (int j=0;j<lineSize;j++) {
	    		input.setQuadBenefit(i, j+i+1, Float.parseFloat(strArray[j]));
	    	}
	    }
	    line = readerInFile.readLine();
	    line = readerInFile.readLine();
	    input.setMaxCapacity(Float.parseFloat(line));
	    line = readerInFile.readLine();
	    strArray = line.split(" ");
	    i=0;
	    for (String string : strArray) {
	    	input.setCapacity(i, Float.parseFloat(string));
			i++;
		}
	    inFile.close();
	    return input;
	}

}
