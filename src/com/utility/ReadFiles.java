package com.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadFiles {
	public List<String> filenames = new ArrayList<String>();
	public String dir = "../KeywordChecker/Resources/";
	
	//method for iterating over the pdf files in the folders
	public ReadFiles() {
		File[] files;
		files = new File(dir).listFiles();
		for (File file : files) {
			if (file.isFile()) {
				filenames.add(file.getName());
			} 
		}
	}
}
 