package iplanalysis;

import com.opencsv.bean.CsvBindByName;
import com.opencsv.bean.CsvBindByPosition;

public class IPLBatting2 {

    @CsvBindByName(column = "POS", required = true)
    public String position;


    @CsvBindByName(column = "PLAYER", required = true)
    public String playerName;

    @CsvBindByPosition(position = 4)
    public int notOuts;

    @CsvBindByPosition (position = 5)
    public int runScored;

    @CsvBindByPosition (position = 6)
    public int highestScore;

    @CsvBindByPosition (position = 7)
    public float average;

    @CsvBindByPosition (position = 9)
    public float strikeRate;


    @CsvBindByPosition (position = 12)
    public int four;

    @CsvBindByPosition (position = 13)
    public int six;

    @Override
    public String toString() {
        return "IndiaStateCode{" +
                "Player='" + playerName + '\''+
                "Player='" + playerName + '\'';
    }
}
