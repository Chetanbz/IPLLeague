package iplanalysis;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;

public class IPLBollingTest {
    private static final String IPL_BATTING_FILE_PATH = "D:\\eclipse-java-2020-09-R-win32-x86_64\\Week3,Workspace Eclipse\\IPLLeague\\src\\test\\resources\\IPL2019FactsheetMostRuns.csv";
    private static final String IPL_BOLLING_FILE_PATH = "D:\\eclipse-java-2020-09-R-win32-x86_64\\Week3,Workspace Eclipse\\IPLLeague\\src\\test\\resources\\IPL2019FactsheetMostWkts.csv";


    @Test
    public void given_IPLBollingCSV_ShouldReturn_Count() {
        try {
            IPLBollingAnalyser iplBollingAnalyser = new IPLBollingAnalyser();
            int numOfRecords = iplBollingAnalyser.loadIPlBolling(IPL_BOLLING_FILE_PATH);
            Assert.assertEquals(99,numOfRecords);
        } catch (CSVBuilderException e) { System.out.println("Error");}
    }

    @Test
    public void given_IPLBollingCSV_ShouldSortAndReturnLowAverage() {
        try {
            IPLBollingAnalyser iplBollingAnalyser = new IPLBollingAnalyser();
            int numOfRecords = iplBollingAnalyser.loadIPlBolling(IPL_BOLLING_FILE_PATH);
            List<IPLBolling> iplBollingCSVList = iplBollingAnalyser.getSortedBollingbyAverageList();
            Assert.assertEquals("Anukul Roy", iplBollingCSVList.get(0).playerName);
        } catch (CSVBuilderException e) {
            System.out.println("Error");
        }
    }

    @Test
    public void given_IPLBollingCSV_ShouldSortAndReturnBestStrikeRate() {
        try {
            IPLBollingAnalyser iplBollingAnalyser = new IPLBollingAnalyser();
            int numOfRecords = iplBollingAnalyser.loadIPlBolling(IPL_BOLLING_FILE_PATH);
            List<IPLBolling> iplBollingCSVList =  iplBollingAnalyser.getSortedBollingbyStrikeList();
            Assert.assertEquals("Alzarri Joseph", iplBollingCSVList.get(0).playerName);
        } catch (CSVBuilderException e) {
            System.out.println("Error");
        }
    }

    @Test
    public void given_IPLBollingCSV_ShouldSortAndReturnBestEconomy() {
        try {
            IPLBollingAnalyser iplBollingAnalyser = new IPLBollingAnalyser();
            int numOfRecords = iplBollingAnalyser.loadIPlBolling(IPL_BOLLING_FILE_PATH);
            List<IPLBolling> iplBollingCSVList = iplBollingAnalyser.getSortedBollingbyEconomyList();
            Assert.assertEquals("Shivam Dube", iplBollingCSVList.get(0).playerName);
        } catch (CSVBuilderException e) {
            System.out.println("Error");
        }
    }

    @Test
    public void given_IPLBollingCSV_BestStrikeRate_4W() {
        try {
            IPLBollingAnalyser iplBollingAnalyser = new IPLBollingAnalyser();
            int numOfRecords = iplBollingAnalyser.loadIPlBolling(IPL_BOLLING_FILE_PATH);
            List<IPLBolling> iplBollingCSVList = iplBollingAnalyser.getMAxStrikeRate4W();
            int size = iplBollingCSVList.size();
            Assert.assertEquals("Lasith Malinga", iplBollingCSVList.get(size-1).playerName);
        } catch (CSVBuilderException e) {
            System.out.println("Error");
        }
    }

    @Test
    public void given_IPLBollingCSV_BestStrikeRate_5W() {
        try {
            IPLBollingAnalyser iplBollingAnalyser = new IPLBollingAnalyser();
            int numOfRecords = iplBollingAnalyser.loadIPlBolling(IPL_BOLLING_FILE_PATH);
            List<IPLBolling> iplBollingCSVList = iplBollingAnalyser.getMaxAvgThenMaxStrike();
            int size = iplBollingCSVList.size();
            Assert.assertEquals("Krishnappa Gowtham", iplBollingCSVList.get(size-1).playerName);
        } catch (CSVBuilderException e) {
            System.out.println("Error");
        }
    }

    @Test
    public void given_IPLBollingCSV_BestAverage_BestStrikeRate() {
        try {
            IPLBollingAnalyser iplBollingAnalyser = new IPLBollingAnalyser();
            int numOfRecords = iplBollingAnalyser.loadIPlBolling(IPL_BOLLING_FILE_PATH);
            List<IPLBolling> iplBollingCSVList = iplBollingAnalyser.getMaxAvgThenMaxStrike();
            int size = iplBollingCSVList.size();
            Assert.assertEquals("Mujeeb Ur Rahman", iplBollingCSVList.get(0).playerName);
        } catch (CSVBuilderException e) {
            System.out.println("Error");
        }
    }

    @Test
    public void given_IPLBollingCSV_Best_BestStrikeRate() {
        try {
            IPLBollingAnalyser iplBollingAnalyser = new IPLBollingAnalyser();
            int numOfRecords = iplBollingAnalyser.loadIPlBolling(IPL_BOLLING_FILE_PATH);
            List<IPLBolling> iplBollingCSVList = iplBollingAnalyser.maxWicketBestAvg();
            int size = iplBollingCSVList.size();
            Assert.assertEquals("Imran Tahir", iplBollingCSVList.get(size-1).playerName);
        } catch (CSVBuilderException e) {
            System.out.println("Error");
        }
    }





}
