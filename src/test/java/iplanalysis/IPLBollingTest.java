package iplanalysis;

import com.google.gson.Gson;
import org.junit.Assert;
import org.junit.Test;

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
            String sortedBattingJason = iplBollingAnalyser.getSortedBollingbyAverageList();
            IPLBolling[] censusCSV = new Gson().fromJson(sortedBattingJason, IPLBolling[].class);
            Assert.assertEquals("Prasidh Krishna", censusCSV[numOfRecords-1].playerName);

        } catch (CSVBuilderException e) {
            System.out.println("Error");
        }
    }

    


}
