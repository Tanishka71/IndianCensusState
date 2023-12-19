package com.bridgelabz.census;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

/**
 * @desc: Main class to demonstrate the loading of State Census data from a CSV file.
 */
class Main {
    /**
     * @desc: Main method to execute the program.
     * @param args Command-line arguments (not used in this program).
     * @return none
     */
    public static void main(String[] args) {
        try {
            List<StateCensus> stateCensusList = CSVStateCensus
                    .loadCSV("C:\\Users\\tanishka\\eclipse-workspace\\IndianStatesCensus\\StateCensus.csv");


            Iterator<StateCensus> iterator = stateCensusList.iterator();
            while (iterator.hasNext()) {
                System.out.println(iterator.next());
            }


            System.out.println("Number of records: " + stateCensusList.size());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
