package iplanalysis;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.Map;

public class IPLBattingTest {
    private static final String IPL_BATTING_FILE_PATH = "D:\\eclipse-java-2020-09-R-win32-x86_64\\Week3,Workspace Eclipse\\IPLLeague\\src\\test\\resources\\IPL2019FactsheetMostRuns.csv";
    private static final String IPL_BOLLING_FILE_PATH = "D:\\eclipse-java-2020-09-R-win32-x86_64\\Week3,Workspace Eclipse\\IPLLeague\\src\\test\\resources\\IPL2019FactsheetMostWkts.csv";

    @Test
    public void given_IPLBattingCSV_ShouldReturn_Count() {
        try {
            IPLTeamAnalyser censusAnalyser = new IPLTeamAnalyser();
            int numOfRecords = censusAnalyser.loadIPlBatting(IPL_BATTING_FILE_PATH);
            Assert.assertEquals(101,numOfRecords);
        } catch (CSVBuilderException e) { System.out.println("Error");}
    }

    @Test
    public void given_IPLBollingCSV_ShouldReturn_Count() {
        try {
            IPLTeamAnalyser censusAnalyser = new IPLTeamAnalyser();
            int numOfRecords = censusAnalyser.loadIPlBolling(IPL_BOLLING_FILE_PATH);
            Assert.assertEquals(99,numOfRecords);
        } catch (CSVBuilderException e) { System.out.println("Error");}
    }

    @Test
    public void given_IPLBattingCSV_ShouldSortAndReturnMaximumAverage() {
        try {
            IPLTeamAnalyser censusAnalyser = new IPLTeamAnalyser();
            int numOfRecords = censusAnalyser.loadIPlBatting(IPL_BATTING_FILE_PATH);
            String sortedBattingJason = censusAnalyser.getSortedBattingbyAverageList();
            IPLBatting[] censusCSV = new Gson().fromJson(sortedBattingJason, IPLBatting[].class);
            Assert.assertEquals("MS Dhoni", censusCSV[numOfRecords-1].playerName);

        } catch (CSVBuilderException e) {
            System.out.println("Error");
        }
    }

    @Test
    public void given_IPLBattingCSV_ShouldSortAndReturnMaximumStrikeRate() {
        try {
            IPLTeamAnalyser censusAnalyser = new IPLTeamAnalyser();
            int numOfRecords = censusAnalyser.loadIPlBatting(IPL_BATTING_FILE_PATH);
            String sortedBattingJason = censusAnalyser.getSortedBattingbyStrikeList();
            IPLBatting[] censusCSV = new Gson().fromJson(sortedBattingJason, IPLBatting[].class);
            Assert.assertEquals("Ishant Sharma", censusCSV[numOfRecords-1].playerName);

        } catch (CSVBuilderException e) {
            System.out.println("Error");
        }
    }

    @Test
    public void given_IPLBattingCSV_ShouldSortAndReturnMaximumSixAndFour() {
        try {
            IPLTeamAnalyser censusAnalyser = new IPLTeamAnalyser();
            int numOfRecords = censusAnalyser.loadIPlBatting(IPL_BATTING_FILE_PATH);

            String sortedBattingJason = censusAnalyser.getSortedBattingbySixList();
            IPLBatting[] censusCSV = new Gson().fromJson(sortedBattingJason, IPLBatting[].class);
            Assert.assertEquals("Andre Russell", censusCSV[numOfRecords-1].playerName);

            String sortedBattingJason2 = censusAnalyser.getSortedBattingbyFourList();
            IPLBatting[] censusCSV2 = new Gson().fromJson(sortedBattingJason2, IPLBatting[].class);
            Assert.assertEquals("Shikhar Dhawan", censusCSV2[numOfRecords-1].playerName);

        } catch (CSVBuilderException e) {
            System.out.println("Error");
        }
    }

    @Test
    public void given_IPLBattingCSV_ShouldSortAndReturnMaximumStrikeRateSixAndFour() {
        try {
            IPLTeamAnalyser censusAnalyser = new IPLTeamAnalyser();
            int numOfRecords = censusAnalyser.loadIPlBatting(IPL_BATTING_FILE_PATH);
            String sortedBattingJason = censusAnalyser.getSortedStrikeRatebyFourSixList();
            IPLBatting[] censusCSV = new Gson().fromJson(sortedBattingJason, IPLBatting[].class);
            Assert.assertEquals("Kagiso Rabada", censusCSV[numOfRecords-1].playerName);

        } catch (CSVBuilderException e) {
            System.out.println("Error");
        }
    }

    


}
