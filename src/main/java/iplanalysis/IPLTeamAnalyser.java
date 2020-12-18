package iplanalysis;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;

public class IPLTeamAnalyser {
    List<IPLBatting> iplBattingCSVList = null;
    List<IPLBatting> iplBollingCSVList = null;

    private <E> void sort( List<E> list, Comparator<E> censusCSVComparator) {
        for (int i =0; i<list.size(); i++){
            for (int j =0; j < list.size()-i-1; j++){
                E objectCSV1 = list.get(j);
                E objectCSV2 = list.get(j+1);
                if(censusCSVComparator.compare(objectCSV1,objectCSV2)>0){
                    list.set(j,objectCSV2);
                    list.set(j+1,objectCSV1);
                }
            }
        }
    }

    public int loadIPlBatting(String csvFilePath) throws CSVBuilderException {

        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createBuilder();
            iplBattingCSVList = csvBuilder.givenList(reader, IPLBatting.class);
            return iplBattingCSVList.size();
        } catch (RuntimeException e) {
            throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.DATA_IMPROPER);
        } catch (IOException e) {
            if (!(csvFilePath.matches("^.+\\.csv$"))) {
                throw new CSVBuilderException("Invalid File", CSVBuilderException.ExceptionType.INVALID_FILE_TYPE);
            }
            throw new CSVBuilderException(e.getMessage(),
                    CSVBuilderException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

    public int loadIPlBolling(String csvFilePath) throws CSVBuilderException {
        try (Reader reader = Files.newBufferedReader(Paths.get(csvFilePath))) {
            ICSVBuilder csvBuilder = CSVBuilderFactory.createBuilder();
            iplBollingCSVList = csvBuilder.givenList(reader, IPLBolling.class);
            return iplBollingCSVList.size();
        } catch (RuntimeException e) {
            throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.DATA_IMPROPER);
        } catch (IOException e) {
            if (!(csvFilePath.matches("^.+\\.csv$"))) {
                throw new CSVBuilderException("Invalid File", CSVBuilderException.ExceptionType.INVALID_FILE_TYPE);
            }
            throw new CSVBuilderException(e.getMessage(),
                    CSVBuilderException.ExceptionType.CENSUS_FILE_PROBLEM);
        }
    }

    public String getSortedBattingbyAverageList() throws CSVBuilderException {
        if(iplBattingCSVList.size() == 0){
            throw new CSVBuilderException("Invalid File", CSVBuilderException.ExceptionType.No_DATA);
        }
        Comparator <IPLBatting> iplCSVComparator = Comparator.comparing(iplBatting -> iplBatting.average);
        this.sort(iplBattingCSVList,iplCSVComparator);
        String sortedStateCensusJason = new Gson().toJson(iplBattingCSVList);
        return sortedStateCensusJason;
    }

    public String getSortedBattingbyStrikeList() throws CSVBuilderException {
        if(iplBattingCSVList.size() == 0){
            throw new CSVBuilderException("Invalid File", CSVBuilderException.ExceptionType.No_DATA);
        }
        Comparator <IPLBatting> iplCSVComparator = Comparator.comparing(iplBatting -> iplBatting.strikeRate);
        this.sort(iplBattingCSVList,iplCSVComparator);
        String sortedStateCensusJason = new Gson().toJson(iplBattingCSVList);
        return sortedStateCensusJason;
    }

    public String getSortedBattingbySixList() throws CSVBuilderException {
        if(iplBattingCSVList.size() == 0){
            throw new CSVBuilderException("Invalid File", CSVBuilderException.ExceptionType.No_DATA);
        }
        Comparator <IPLBatting> iplCSVComparator = Comparator.comparing(iplBatting -> iplBatting.six);
        this.sort(iplBattingCSVList,iplCSVComparator);
        String sortedStateCensusJason = new Gson().toJson(iplBattingCSVList);
        return sortedStateCensusJason;
    }

    public String getSortedBattingbyFourList() throws CSVBuilderException {
        if(iplBattingCSVList.size() == 0){
            throw new CSVBuilderException("Invalid File", CSVBuilderException.ExceptionType.No_DATA);
        }
        Comparator <IPLBatting> iplCSVComparator = Comparator.comparing(iplBatting -> iplBatting.four);
        this.sort(iplBattingCSVList,iplCSVComparator);
        String sortedStateCensusJason = new Gson().toJson(iplBattingCSVList);
        return sortedStateCensusJason;
    }

}
