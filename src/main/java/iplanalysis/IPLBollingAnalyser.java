package iplanalysis;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class IPLBollingAnalyser {
    List<IPLBolling> iplBollingCSVList = null;
    int top = 10;

    private <E> void sort(List<E> list, Comparator<E> censusCSVComparator) {
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


    public List<IPLBolling> getSortedBollingbyAverageList() throws CSVBuilderException {
        List<IPLBolling> iplBollingCSVList2 = null;
        if(iplBollingCSVList.size() == 0){
            throw new CSVBuilderException("Invalid File", CSVBuilderException.ExceptionType.No_DATA);
        }
        Comparator <IPLBolling> iplCSVComparator = Comparator.comparing(iplbolling -> iplbolling.bollingAverage);
        this.sort(iplBollingCSVList,iplCSVComparator);
        iplBollingCSVList2 = iplBollingCSVList.stream().filter(iplBolling -> (iplBolling.bollingAverage !=0)).collect(Collectors.toList());
        return iplBollingCSVList2;
    }

    public List<IPLBolling> getSortedBollingbyStrikeList() throws CSVBuilderException {
        List<IPLBolling> iplBollingCSVList2 = null;
        if(iplBollingCSVList.size() == 0){
            throw new CSVBuilderException("Invalid File", CSVBuilderException.ExceptionType.No_DATA);
        }
        Comparator <IPLBolling> iplCSVComparator = Comparator.comparing(iplbolling -> iplbolling.bollingStrikerate);
        this.sort(iplBollingCSVList,iplCSVComparator);
        iplBollingCSVList2 = iplBollingCSVList.stream().filter(iplBolling -> (iplBolling.bollingStrikerate !=0)).collect(Collectors.toList());
        return iplBollingCSVList2;
    }

    public List<IPLBolling> getSortedBollingbyEconomyList() throws CSVBuilderException {
        List<IPLBolling> iplBollingCSVList2 = null;
        if(iplBollingCSVList.size() == 0){
            throw new CSVBuilderException("Invalid File", CSVBuilderException.ExceptionType.No_DATA);
        }
        Comparator <IPLBolling> iplCSVComparator = Comparator.comparing(iplbolling -> iplbolling.bollingEconomy);
        this.sort(iplBollingCSVList,iplCSVComparator);
        iplBollingCSVList2 = iplBollingCSVList.stream().filter(iplBolling -> (iplBolling.bollingEconomy !=0)).collect(Collectors.toList());
        return iplBollingCSVList2;
    }

    public List<IPLBolling> getMAxStrikeRate4W() throws CSVBuilderException {
        List<IPLBolling> iplBollingCSVList2 = null;
        if(iplBollingCSVList.size() == 0){
            throw new CSVBuilderException("Invalid File", CSVBuilderException.ExceptionType.No_DATA);
        }
        Comparator <IPLBolling> iplCSVComparator = Comparator.comparing(iplbolling -> iplbolling.bollingStrikerate);
        Comparator <IPLBolling> iplCSVComparator2 = Comparator.comparing(iplbolling -> iplbolling.four_W);
        iplBollingCSVList2 = iplBollingCSVList.stream().filter(iplBolling -> (iplBolling.four_W !=0)).collect(Collectors.toList());
        this.sort(iplBollingCSVList2,iplCSVComparator);
        this.sort(iplBollingCSVList2,iplCSVComparator2);
        return iplBollingCSVList2;
    }

    public List<IPLBolling> getMAxStrikeRate5W() throws CSVBuilderException {
        List<IPLBolling> iplBollingCSVList2 = null;
        if(iplBollingCSVList.size() == 0){
            throw new CSVBuilderException("Invalid File", CSVBuilderException.ExceptionType.No_DATA);
        }
        Comparator <IPLBolling> iplCSVComparator = Comparator.comparing(iplbolling -> iplbolling.bollingStrikerate);
        Comparator <IPLBolling> iplCSVComparator2 = Comparator.comparing(iplbolling -> iplbolling.five_W);
        iplBollingCSVList2 = iplBollingCSVList.stream().filter(iplBolling -> (iplBolling.five_W !=0)).collect(Collectors.toList());
        this.sort(iplBollingCSVList2,iplCSVComparator);
        this.sort(iplBollingCSVList2,iplCSVComparator2);
        return iplBollingCSVList2;
    }

}
