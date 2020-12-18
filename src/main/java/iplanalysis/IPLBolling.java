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
    public int wicketTaken;

    @CsvBindByPosition (position = 8)
    public double bollingAverage;

    @CsvBindByPosition (position = 9)
    public double bollingEconomy;

    @CsvBindByPosition (position = 10)
    public double bollingStrikerate;

    @CsvBindByPosition (position = 11)
    public int four_W;

    @CsvBindByPosition (position = 12)
    public int five_W;

    public String toString() {
        return "IndiaStateCode{" +
                "Player='" + playerName + '\'' ;

    }


}
