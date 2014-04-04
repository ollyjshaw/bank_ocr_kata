package bank_ocr_kata;

import bank_ocr_kata.exceptions.IncorrectLineLengthException;
import bank_ocr_kata.exceptions.IncorrectNumberOfLinesException;
import bank_ocr_kata.exceptions.NoBlankLineException;

import java.util.List;

public class Converter {
    public int convert(List<String> lines) throws IncorrectLineLengthException, IncorrectNumberOfLinesException, NoBlankLineException, NotANumberException {
        //To change body of created methods use File | Settings | File Templates.
        if (lines == null) throw new NullPointerException();
        if(lines.size() != 4) throw new IncorrectNumberOfLinesException();
        if (linesNotCorrectLength(lines)) throw new IncorrectLineLengthException();
        if (!fourthLineEmpty(lines)) throw new NoBlankLineException();
        Splitter s = new Splitter();
        return s.solve(lines);
    }

    private boolean linesNotCorrectLength(List<String> lines) {
        for (String line : lines) {
            if (line.length() != 27) return true;
        }
        return false;
    }

    private boolean fourthLineEmpty(List<String> lines) {
        String fourthLine = lines.get(3);
        if (fourthLine.matches("[ ]+")) return true;
        return false;
    }
}
