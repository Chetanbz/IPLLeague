package iplanalysis;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.Map;

public class IPLBattingTest {
    private static final String IPL_BATTING_FILE_PATH = "D:\\eclipse-java-2020-09-R-win32-x86_64\\Week3,Workspace Eclipse\\IPLLeague\\src\\test\\resources\\IPL2019FactsheetMostRuns.csv";
    private static final String IPL_BOLLING_FILE_PATH = "D:\\eclipse-java-2020-09-R-win32-x86_64\\Week3,Workspace Eclipse\\IPLLeague\\src\\test\\resources\\IPL2019FactsheetMostWkts.csv";

    @Test
    public void given_IPLBattingCSV_ShouldReturn_Count() {
        try {
            IPLTeamAnalyser iplTeamAnalyser = new IPLTeamAnalyser();
            int numOfRecords = iplTeamAnalyser.loadIPlBatting(IPL_BATTING_FILE_PATH);
            Assert.assertEquals(101, numOfRecords);
        } catch (CSVBuilderException e) {
            System.out.println("Error");
        }
    }


    @Test
    public void given_IPLBattingCSV_ShouldSortAndReturnMaximumAverage() {
        try {
            IPLTeamAnalyser iplTeamAnalyser = new IPLTeamAnalyser();
            int numOfRecords = iplTeamAnalyser.loadIPlBatting(IPL_BATTING_FILE_PATH);
            String sortedBattingJason = iplTeamAnalyser.getSortedBattingbyAverageList();
            IPLBatting[] censusCSV = new Gson().fromJson(sortedBattingJason, IPLBatting[].class);
            Assert.assertEquals("MS Dhoni", censusCSV[numOfRecords - 1].playerName);

        } catch (CSVBuilderException e) {
            System.out.println("Error");
        }
    }

    @Test
    public void given_IPLBattingCSV_ShouldSortAndReturnMaximumStrikeRate() {
        try {
            IPLTeamAnalyser iplTeamAnalyser = new IPLTeamAnalyser();
            int numOfRecords = iplTeamAnalyser.loadIPlBatting(IPL_BATTING_FILE_PATH);
            String sortedBattingJason = iplTeamAnalyser.getSortedBattingbyStrikeList();
            IPLBatting[] censusCSV = new Gson().fromJson(sortedBattingJason, IPLBatting[].class);
            Assert.assertEquals("Ishant Sharma", censusCSV[numOfRecords - 1].playerName);

        } catch (CSVBuilderException e) {
            System.out.println("Error");
        }
    }

    @Test
    public void given_IPLBattingCSV_ShouldSortAndReturnMaximumSixAndFour() {
        try {
            IPLTeamAnalyser iplTeamAnalyser = new IPLTeamAnalyser();
            int numOfRecords = iplTeamAnalyser.loadIPlBatting(IPL_BATTING_FILE_PATH);

            String sortedBattingJason = iplTeamAnalyser.getSortedBattingbySixList();
            IPLBatting[] censusCSV = new Gson().fromJson(sortedBattingJason, IPLBatting[].class);
            Assert.assertEquals("Andre Russell", censusCSV[numOfRecords - 1].playerName);

            String sortedBattingJason2 = iplTeamAnalyser.getSortedBattingbyFourList();
            IPLBatting[] censusCSV2 = new Gson().fromJson(sortedBattingJason2, IPLBatting[].class);
            Assert.assertEquals("Shikhar Dhawan", censusCSV2[numOfRecords - 1].playerName);

        } catch (CSVBuilderException e) {
            System.out.println("Error");
        }
    }

    @Test
    public void given_IPLBattingCSV_ShouldSortAndReturnMaximumStrikeRateSixAndFour() {
        try {
            IPLTeamAnalyser iplTeamAnalyser = new IPLTeamAnalyser();
            int numOfRecords = iplTeamAnalyser.loadIPlBatting(IPL_BATTING_FILE_PATH);
            List<IPLBatting> sortedAverageGoodStrikeRateList = iplTeamAnalyser.getSortedBattingbyAverageGoodStrikeRateList();
            int size = sortedAverageGoodStrikeRateList.size();
            Assert.assertEquals("Andre Russell", sortedAverageGoodStrikeRateList.get(size - 1).playerName);

        } catch (CSVBuilderException e) {
            System.out.println("Error");
        }
    }

    @Test
    public void given_IPLBattingCSV_MaxRunWithGoodAverage() {
        try {
            IPLTeamAnalyser iplTeamAnalyser = new IPLTeamAnalyser();
            int numOfRecords = iplTeamAnalyser.loadIPlBatting(IPL_BATTING_FILE_PATH);
            List<IPLBatting> MaxRunGoodAvg = iplTeamAnalyser.getMaxRunGoodAvgList();
            int size = MaxRunGoodAvg.size();
            Assert.assertEquals("David Warner ", MaxRunGoodAvg.get(size - 1).playerName);

        } catch (CSVBuilderException e) {
            System.out.println("Error");
        }
    }

    @Test
    public void given_IPLAllrounderBestBattingBowlingAverage() {
        try {
            IPLTeamAnalyser iplTeamAnalyser = new IPLTeamAnalyser();
            iplTeamAnalyser.loadIPlBatting(IPL_BATTING_FILE_PATH);
            iplTeamAnalyser.loadIPlBolling(IPL_BOLLING_FILE_PATH);
            List<IPLBatting> allrounderList  = iplTeamAnalyser.bestBattingBollingAvg();
            int size = allrounderList.size();
            Assert.assertEquals("Marcus Stoinis", allrounderList.get(size-1).playerName);

        } catch (CSVBuilderException e) {
            System.out.println("Error");
        }
    }

    @Test
    public void given_IPLAllrounderMaxRunMaxWicket() {
        try {
            IPLTeamAnalyser iplTeamAnalyser = new IPLTeamAnalyser();
            iplTeamAnalyser.loadIPlBatting(IPL_BATTING_FILE_PATH);
            iplTeamAnalyser.loadIPlBolling(IPL_BOLLING_FILE_PATH);
            List<IPLBatting> allrounderList  = iplTeamAnalyser.MostRunAndWicket();
            int size = allrounderList.size();
            Assert.assertEquals("Hardik Pandya", allrounderList.get(size-1).playerName);

        } catch (CSVBuilderException e) {
            System.out.println("Error");
        }
    }



}
