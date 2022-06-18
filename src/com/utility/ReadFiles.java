package com.utility;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public class ReadFiles {
	public List<String> filenames = new ArrayList<String>();
	public String dir = "C:\\Users\\NRABHA\\eclipse-workspace\\KeywordChecker\\Resources";
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
 