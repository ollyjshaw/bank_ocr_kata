package bank_ocr_kata;

import bank_ocr_kata.exceptions.IncorrectLineLengthException;
import bank_ocr_kata.exceptions.IncorrectNumberOfLinesException;
import bank_ocr_kata.exceptions.NoBlankLineException;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    List<String> buffer;
    Converter converter;

    public Parser(Converter converter) {
        this.converter = converter;
        buffer = new ArrayList<String>(4);
    }


    public void receiveLine(String bla) throws IncorrectLineLengthException, IncorrectNumberOfLinesException, NoBlankLineException {
        buffer.add(bla);

        if (buffer.size() == 4) {
            converter.convert(buffer);
            buffer = new ArrayList<String>(4);
        }

    }

    public void parse(String input) throws IncorrectLineLengthException, IncorrectNumberOfLinesException, NoBlankLineException {
        String[] lines = input.split("\n");
        for (String line : lines) {
            receiveLine(line);
        }
    }
}
