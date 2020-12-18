package iplanalysis;

import com.opencsv.bean.CsvToBean;
import com.opencsv.bean.CsvToBeanBuilder;

import java.io.Reader;
import java.util.Iterator;
import java.util.List;

public class OpenCsvBuilder <E> implements ICSVBuilder<E> {
    @Override
    public Iterator<E> givenCSViterator(Reader reader, Class csvClass) throws CSVBuilderException {
        return getCSVToBean(reader,csvClass).iterator();
    }

    @Override
    public List<E> givenList(Reader reader, Class csvClass) throws CSVBuilderException {
        return getCSVToBean(reader,csvClass).parse();
    }
    private  CsvToBean<E> getCSVToBean(Reader reader, Class csvClass) throws CSVBuilderException {
        try {
            return (CsvToBean<E>) new CsvToBeanBuilder<E>(reader).withType(csvClass).withIgnoreLeadingWhiteSpace(true).build();
        }
        catch (IllegalStateException e){
            throw new CSVBuilderException(e.getMessage(), CSVBuilderException.ExceptionType.UNABLE_TO_PARSE);
        }
    }
}
