package com.bridgelabz.census.main;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
//@desc: to load the data 
public class CSVStateCensus {
	
	//<------------USE CASE 1--------------->
    /**
     * @desc:Loads state census data from a CSV file.
     * @param filePath The path to the CSV file containing state census data.
     * @return A list of StateCensus objects representing the loaded data.
     * @throws IOException If an I/O error occurs while reading the file.
     */
    public static List<StateCensus> loadCSV(String filePath) throws IOException,InvalidCSVFormatException {
        List<StateCensus> stateCensusList = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            br.readLine(); // Skip the header line
            while ((line = br.readLine()) != null) {
                String[] data = line.split(",");
              
                int expectedColumns = 4;
                if (data.length != expectedColumns) {
                    throw new InvalidCSVFormatException("Invalid number of columns in CSV file. Expected: " + expectedColumns);
                }
                String state = data[1].trim();
                int population = Integer.parseInt(data[2].trim());
                String stateCode = data[3].trim();

                StateCensus stateCensus = new StateCensus(state, population, stateCode);
                stateCensusList.add(stateCensus);
            }
        }

        return stateCensusList;
    }
}
