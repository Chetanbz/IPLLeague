package iplanalysis;

import com.google.gson.Gson;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class IPLTeamAnalyser {
    List<IPLBatting> iplBattingCSVList = null;
    List<IPLBolling> iplBollingCSVList = null;
    int top = 10;

    private <E> void sort(List<E> list, Comparator<E> censusCSVComparator) {
        for (int i = 0; i < list.size(); i++) {
            for (int j = 0; j < list.size() - i - 1; j++) {
                E objectCSV1 = list.get(j);
                E objectCSV2 = list.get(j + 1);
                if (censusCSVComparator.compare(objectCSV1, objectCSV2) > 0) {
                    list.set(j, objectCSV2);
                    list.set(j + 1, objectCSV1);
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
        if (iplBattingCSVList.size() == 0) {
            throw new CSVBuilderException("Invalid File", CSVBuilderException.ExceptionType.No_DATA);
        }
        Comparator<IPLBatting> iplCSVComparator = Comparator.comparing(iplBatting -> iplBatting.average);
        this.sort(iplBattingCSVList, iplCSVComparator);
        String sortedStateCensusJason = new Gson().toJson(iplBattingCSVList);
        return sortedStateCensusJason;
    }

    public String getSortedBattingbyStrikeList() throws CSVBuilderException {
        if (iplBattingCSVList.size() == 0) {
            throw new CSVBuilderException("Invalid File", CSVBuilderException.ExceptionType.No_DATA);
        }
        Comparator<IPLBatting> iplCSVComparator = Comparator.comparing(iplBatting -> iplBatting.strikeRate);
        this.sort(iplBattingCSVList, iplCSVComparator);
        String sortedStateCensusJason = new Gson().toJson(iplBattingCSVList);
        return sortedStateCensusJason;
    }

    public String getSortedBattingbySixList() throws CSVBuilderException {
        if (iplBattingCSVList.size() == 0) {
            throw new CSVBuilderException("Invalid File", CSVBuilderException.ExceptionType.No_DATA);
        }
        Comparator<IPLBatting> iplCSVComparator = Comparator.comparing(iplBatting -> iplBatting.six);
        this.sort(iplBattingCSVList, iplCSVComparator);
        String sortedStateCensusJason = new Gson().toJson(iplBattingCSVList);
        return sortedStateCensusJason;
    }

    public String getSortedBattingbyFourList() throws CSVBuilderException {
        if (iplBattingCSVList.size() == 0) {
            throw new CSVBuilderException("Invalid File", CSVBuilderException.ExceptionType.No_DATA);
        }
        Comparator<IPLBatting> iplCSVComparator = Comparator.comparing(iplBatting -> iplBatting.four);
        this.sort(iplBattingCSVList, iplCSVComparator);
        String sortedStateCensusJason = new Gson().toJson(iplBattingCSVList);
        return sortedStateCensusJason;
    }

    public String getSortedStrikeRatebyFourSixList() throws CSVBuilderException {
        if (iplBattingCSVList.size() == 0) {
            throw new CSVBuilderException("Invalid File", CSVBuilderException.ExceptionType.No_DATA);
        }
        strikeRateWithSixAndFour();
        Comparator<IPLBatting> iplCSVComparator = Comparator.comparing(iplBatting -> iplBatting.emptySpace);
        this.sort(iplBattingCSVList, iplCSVComparator);
        String sortedStateCensusJason = new Gson().toJson(iplBattingCSVList);
        return sortedStateCensusJason;
    }

    public List<IPLBatting> getSortedBattingbyAverageGoodStrikeRateList() throws CSVBuilderException {
        List<IPLBatting> iplBattingList2 = null;
        if (iplBattingCSVList.size() == 0) {
            throw new CSVBuilderException("Invalid File", CSVBuilderException.ExceptionType.No_DATA);
        }
        Comparator<IPLBatting> iplCSVComparator = Comparator.comparing(iplBatting -> iplBatting.average);
        Comparator<IPLBatting> iplCSVComparator2 = Comparator.comparing(iplBatting -> iplBatting.strikeRate);
        int size = iplBattingCSVList.size();
        this.sort(iplBattingCSVList, iplCSVComparator);
        iplBattingList2 = iplBattingCSVList.subList(size - 11, size);
        this.sort(iplBattingList2, iplCSVComparator2);
        return iplBattingList2;
    }

    public List<IPLBatting> getMaxRunGoodAvgList() throws CSVBuilderException {
        List<IPLBatting> iplBattingList2 = null;
        if (iplBattingCSVList.size() == 0) {
            throw new CSVBuilderException("Invalid File", CSVBuilderException.ExceptionType.No_DATA);
        }
        Comparator<IPLBatting> iplCSVComparator = Comparator.comparing(iplBatting -> iplBatting.runScored);
        Comparator<IPLBatting> iplCSVComparator2 = Comparator.comparing(iplBatting -> iplBatting.average);
        int size = iplBattingCSVList.size();
        this.sort(iplBattingCSVList, iplCSVComparator);
        iplBattingList2 = iplBattingCSVList.subList(size - 11, size);
        this.sort(iplBattingList2, iplCSVComparator2);
        return iplBattingList2;
    }

    private void strikeRateWithSixAndFour() throws CSVBuilderException {
        if (iplBattingCSVList.size() == 0) {
            throw new CSVBuilderException("Invalid File", CSVBuilderException.ExceptionType.No_DATA);
        }
        for (IPLBatting i : iplBattingCSVList) {
            int ballFaced = i.six + i.four;
            if (ballFaced == 0) continue;
            Double score = ((double) 6 * i.six + 4 * i.four) / ballFaced;
            i.emptySpace = score;
        }
    }
    public List<IPLBatting> bestBattingBollingAvg() throws CSVBuilderException {
        List<IPLBatting> allRounderList = null;
        List<IPLBatting> allRounderList2 = null;
        giveMaxBattingAndBowllingAvg();
        allRounderList = iplBattingCSVList.stream().filter(allRounder -> (allRounder.emptySpace != 0)).collect(Collectors.toList());
        Comparator<IPLBatting> iplCSVComparator = Comparator.comparing(iplBatting -> iplBatting.average);
        this.sort(allRounderList,iplCSVComparator);
        int size = allRounderList.size();
        Comparator<IPLBatting> iplCSVComparator2 = Comparator.comparing(iplBatting -> iplBatting .emptySpace);
        allRounderList2 = allRounderList.subList(size-top,size);
        this.sort(allRounderList2,iplCSVComparator2);
        return allRounderList2;
    }

    public void  giveMaxBattingAndBowllingAvg() throws CSVBuilderException {
        if (iplBattingCSVList.size() == 0) {
            throw new CSVBuilderException("Invalid File", CSVBuilderException.ExceptionType.No_DATA);
        }
        for (IPLBatting i : iplBattingCSVList) {
            String battingPlayer = i.playerName;
            for(IPLBolling j : iplBollingCSVList){
                String bollingPlayer = j.playerName;
                if(bollingPlayer.equals(battingPlayer)){
                    i.emptySpace = j.bollingAverage;
                    break;
                }
            }
        }
    }

}
