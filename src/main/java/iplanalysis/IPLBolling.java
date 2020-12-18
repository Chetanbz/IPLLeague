package iplanalysis;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class IPLBolling {

    @CsvBindByPosition (position = 0)
    public String pos;

    @CsvBindByPosition (position = 1)
    public String playerName;

    @CsvBindByPosition (position = 5)
    public int runsGiven;

    @CsvBindByPosition (position = 6)
    public String wicketTaken;

    @CsvBindByPosition (position = 8)
    public String bollingAverage;

    @CsvBindByPosition (position = 9)
    public String bollingEconomy;

    @CsvBindByPosition (position = 10)
    public String bollingStrikerate;

    public String toString() {
        return "IndiaStateCode{" +
                "Player='" + playerName + '\'' ;

    }


}
