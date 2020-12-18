package iplanalysis;

public class CSVBuilderFactory  {

    public static ICSVBuilder createBuilder(){
        return  new OpenCsvBuilder();
    }

}
