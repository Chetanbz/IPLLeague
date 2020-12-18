package iplanalysis;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class IPLTeamAnalyser {
    List<IPLBatting> iplBattingCSVList = null;
    List<IPLBatting> iplBollingCSVList = null;

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
}
