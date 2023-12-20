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
import com.bridgelabz.census.main.InvalidDataTypeException;
import com.bridgelabz.census.main.InvalidDelimiterException;
import com.bridgelabz.census.main.InvalidHeaderException;
import com.bridgelabz.census.main.StateCensus;

import junit.framework.Assert;

class StateCensusTest {



	//<------------------TESE CASE 1.1--------------->
	/*
	 * @desc:happy test case to test the size
	 * @params: none
	 * @return: none
	 */
	@Test
	void happyTestToCheckSize() throws  IOException, InvalidCSVFormatException, InvalidDataTypeException, InvalidDelimiterException {
		List<StateCensus> stateCensusList = CSVStateCensus.loadCSV("C:\\Users\\tanishka\\eclipse-workspace\\IndianStatesCensus\\StateCensus.csv");
		 int expectedNumberOfRecords = 37;
		 Assert.assertEquals(expectedNumberOfRecords,stateCensusList.size(), 0);
	}
	


	//<------------------TESE CASE 1.2--------------->
	/*
	 * @desc:sad test case to throw custom exception for incorrect csv format
	 * @params: none
	 * @return: none
	 */
//    @Test
    void testInvalidCSVFormat() {
        // Specify the path to an incorrect State Census CSV file
        String incorrectFilePath = "C:\\\\Users\\\\tanishka\\\\eclipse-workspace\\\\IndianStatesCensus\\\\IncorrectFormat.csv";

        // Use JUnit's assertThrows to check if the custom exception is thrown
        assertThrows(InvalidCSVFormatException.class, () -> {
            CSVStateCensus.loadCSV(incorrectFilePath);
        }, "Expected InvalidCSVFormatException but it was not thrown.");
    }
    
  //<------------------TESE CASE 1.3--------------->
  	/*
  	 * @desc:sad test case to throw custom exception for incorrect data type in csv
  	 * @params: none
  	 * @return: none
  	 */
//    @Test
    void testIncorrectDataType() {
        // Specify the path to a CSV file with incorrect data type
        String incorrectDataTypeFilePath = "C:\\Users\\tanishka\\eclipse-workspace\\IndianStatesCensus\\IncorrectType.csv";

        // Use JUnit's assertThrows to check if the custom exception is thrown
        assertThrows(InvalidDataTypeException.class, () -> {
            CSVStateCensus.loadCSV(incorrectDataTypeFilePath);
        }, "Expected InvalidDataTypeException but it was not thrown.");
    }
    
  //<------------------TESE CASE 1.4--------------->
  	/*
  	 * @desc:sad test case to throw custom exception for incorrect delimiter in csv
  	 * @params: none
  	 * @return: none
  	 */
    @Test
    void testIncorrectDelimiter() {
        // Specify the path to a CSV file with incorrect delimiter
        String incorrectDelimiterFilePath = "C:\\\\Users\\\\tanishka\\\\eclipse-workspace\\\\IndianStatesCensus\\\\IncorrectDelimiter.csv";
        String expectedDelimiter = ";";  // Set the expected delimiter

        // Use JUnit's assertThrows to check if the custom exception is thrown
        assertThrows(InvalidDelimiterException.class, () -> {
            CSVStateCensus.loadCSV(incorrectDelimiterFilePath);
        }, "Expected InvalidDelimiterException but it was not thrown.");
    }
    
    @Test
    void testIncorrectHeader() {
        // Specify the path to a CSV file with incorrect header
        String incorrectHeaderFilePath = "C:\\Users\\tanishka\\eclipse-workspace\\IndianStatesCensus\\StateCensus.csv";
        String expectedHeader = "SNO,State,Population,Code";  // Set the expected header

        // Use JUnit's assertThrows to check if the custom exception is thrown
        assertThrows(InvalidHeaderException.class, () -> {
            CSVStateCensus.loadCSV(incorrectHeaderFilePath);
        }, "Expected InvalidHeaderException but it was not thrown.");
    }

}
