package iplanalysis;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class IPLBatting {
    @CsvBindByPosition (position = 0)
    public String pos;

    @CsvBindByPosition (position = 1)
    public String playerName;

    @CsvBindByPosition(position = 4)
    public int notOuts;

    @CsvBindByPosition (position = 5)
    public int runScored;

    @CsvBindByPosition (position = 6)
    public String highestScore;

    @CsvBindByPosition (position = 7)
    public String average;

    @CsvBindByPosition (position = 9)
    public String strikeRate;

    @CsvBindByPosition (position = 12)
    public int four;

    @CsvBindByPosition (position = 13)
    public int six;


    @Override
    public String toString() {
        return "IndiaStateCode{" +
                "Player='" + playerName + '\'' +
                "Average='" + average + '\'' +
                "StrikeRate='" + strikeRate + '\'' ;

    }

}
