package com.bridgelabz.census.test;

import static org.junit.Assert.assertThrows;
import static org.junit.jupiter.api.Assertions.*;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.bridgelabz.census.main.CSVStateCensus;
import com.bridgelabz.census.main.InvalidCSVFormatException;
import com.bridgelabz.census.main.StateCensus;

import junit.framework.Assert;

class StateCensusTest {

	 List<StateCensus> stateCensusList;
	@BeforeEach
	void setUp() {

	           try {
	            stateCensusList = CSVStateCensus.loadCSV("C:\\Users\\tanishka\\eclipse-workspace\\IndianStatesCensus\\StateCensus.csv");
	           

	            Iterator<StateCensus> iterator = stateCensusList.iterator();
	            while (iterator.hasNext()) {
	                System.out.println(iterator.next());
	            
	           }
	           }
	           catch (IOException e) {
	               e.printStackTrace();
	           }
	}

	//<------------------TESE CASE 1.1--------------->
	/*
	 * @desc:happy test case to test the size
	 * @params: none
	 * @return: none
	 */
	@Test
	void happyTestToCheckSize() {
		 int expectedNumberOfRecords = 37;
		 Assert.assertEquals(expectedNumberOfRecords,stateCensusList.size(), 0);
	}
	


	//<------------------TESE CASE 1.2--------------->
	/*
	 * @desc:sad test case to throw custom exception for incorrect csv format
	 * @params: none
	 * @return: none
	 */
    @Test
    void testInvalidCSVFormat() {
        // Specify the path to an incorrect State Census CSV file
        String incorrectFilePath = "C:\\\\Users\\\\tanishka\\\\eclipse-workspace\\\\IndianStatesCensus\\\\Incorrect.csv";

        // Use JUnit's assertThrows to check if the custom exception is thrown
        assertThrows(InvalidCSVFormatException.class, () -> {
            CSVStateCensus.loadCSV(incorrectFilePath);
        }, "Expected InvalidCSVFormatException but it was not thrown.");
    }

}
