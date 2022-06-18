package com.main;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

import org.apache.pdfbox.Loader;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.text.PDFTextStripper;

import com.opencsv.CSVWriter;
import com.utility.ReadFiles;
import com.utility.ReadPropertiesFile;

public class KeywordChecker {
	public static void main(String[] args) throws IOException {
		ReadPropertiesFile readProperty = new ReadPropertiesFile();
		ReadFiles readFiles = new ReadFiles();
		List<String> filePath = readFiles.filenames;
		List<Integer> percentage = new ArrayList<Integer>();
		for (String fname : filePath) {
			String path = readFiles.dir + "\\" + fname;
			File tempfile = new File(path);
			PDDocument pdf = Loader.loadPDF(tempfile);
			PDFTextStripper pdfStripper = new PDFTextStripper();
			String docText = pdfStripper.getText(pdf);

			int noOfKeywords = readProperty.prop.size();
			int percentageMatch = 0;
			for (int i = 0; i < noOfKeywords; i++) {
				String key = "keyword" + Integer.toString(i + 1);
				if (docText.toLowerCase().contains(readProperty.prop.getProperty(key))) {
					percentageMatch += (100 / noOfKeywords);
				}
			}
			percentage.add(percentageMatch);
			tempfile = null;
		}
		System.out.println("Resume Name" + "\t" + "-" + "\t" + "PercentageMatch");
		for (int i = 0; i < filePath.size(); i++) {
			System.out.println(readFiles.filenames.get(i) + "\t" + "-" + "\t" + percentage.get(i));
		}
		
		List<String[]> percentageMatch = new ArrayList<String[]>();
		String[] header = { "Resume Name", "Percentage Match" };
		percentageMatch.add(header);
		for (int i = 0; i < filePath.size(); i++) {
			percentageMatch.add(new String[] {readFiles.filenames.get(i), Integer.toString(percentage.get(i))});
		}
		
		Writer outputFile = new FileWriter("PercentageMatch.csv");
		CSVWriter writer = new CSVWriter(outputFile);
		writer.writeAll(percentageMatch);
		writer.close();
		
		System.out.println("\nThe percentage match of the keywords is written in PercentageMatch.csv file successfully.\nUpdate the project file in case not vissible");
		

	}
	

}
