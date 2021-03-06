package iplanalysis;

import org.junit.Assert;
import org.junit.Test;

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

}
