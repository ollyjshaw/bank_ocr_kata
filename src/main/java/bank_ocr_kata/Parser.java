package bank_ocr_kata;

import bank_ocr_kata.exceptions.IncorrectLineLengthException;
import bank_ocr_kata.exceptions.IncorrectNumberOfLinesException;
import bank_ocr_kata.exceptions.NoBlankLineException;

import java.util.ArrayList;
import java.util.List;

public class Parser {
    public static final int LINE_NUMBERS_PER_ACCOUNT = 4;
    List<String> buffer;
    Converter converter;

    public Parser(Converter converter) {
        this.converter = converter;
        buffer = newBuffer();
    }

    private ArrayList<String> newBuffer() {
        return new ArrayList<String>(LINE_NUMBERS_PER_ACCOUNT);
    }


    public void receiveLine(String bla) throws IncorrectLineLengthException, IncorrectNumberOfLinesException, NoBlankLineException, NotANumberException {
        buffer.add(bla);

        if (buffer.size() == LINE_NUMBERS_PER_ACCOUNT) {
            converter.convert(buffer);
            buffer.clear();
        }

    }

    public void parse(String input) throws IncorrectLineLengthException, IncorrectNumberOfLinesException, NoBlankLineException, NotANumberException {
        String[] lines = input.split("\n");
        for (String line : lines) {
            receiveLine(line);
        }
    }
}
