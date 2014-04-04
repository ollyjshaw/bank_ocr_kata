package bank_ocr_kata;


import bank_ocr_kata.exceptions.IncorrectLineLengthException;
import bank_ocr_kata.exceptions.IncorrectNumberOfLinesException;
import bank_ocr_kata.exceptions.NoBlankLineException;
import junit.framework.TestCase;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class TestConverter {

    @Test(expected = IncorrectNumberOfLinesException.class)
    public void testParserErrorsWhenTooFewLines() throws IncorrectLineLengthException, IncorrectNumberOfLinesException, NoBlankLineException, NotANumberException {
        Converter converter = new Converter();
        List<String> lines = Arrays.asList(new String[]{"bar"});
        converter.convert(lines);
    }

    @Test(expected = IncorrectNumberOfLinesException.class)
    public void testParserErrorsWhenTooManyLines() throws IncorrectLineLengthException, IncorrectNumberOfLinesException, NoBlankLineException, NotANumberException {
        Converter converter = new Converter();
        List<String> lines = Arrays.asList(new String[]{"bar", "bar", "bar", "bar", "bar"});
        converter.convert(lines);
    }

    @Test(expected = NullPointerException.class)
    public void testParserErrorsWhenNull() throws IncorrectLineLengthException, IncorrectNumberOfLinesException, NoBlankLineException, NotANumberException {
        Converter converter = new Converter();
        converter.convert(null);
    }

    @Test(expected = NoBlankLineException.class)
    public void testParserErrorsWhenFourthLineNotBlank() throws IncorrectLineLengthException, IncorrectNumberOfLinesException, NoBlankLineException, NotANumberException {
        Converter converter = new Converter();
        List<String> lines = Arrays.asList(new String[]{
                "aaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "          x                "});
        converter.convert(lines);
    }

    @Test(expected = IncorrectLineLengthException.class)
    public void testParserErrorsWhenLinesNot27Chars() throws IncorrectLineLengthException, IncorrectNumberOfLinesException, NoBlankLineException, NotANumberException {
        Converter converter = new Converter();
        List<String> lines = Arrays.asList(new String[]{
                "bar",
                "bar",
                "bar",
                " "});
        converter.convert(lines);
    }

    @Test
    public void testSplitting() throws IncorrectNumberOfLinesException, IncorrectLineLengthException, NoBlankLineException, NotANumberException {
        Converter converter = new Converter();
        List<String> lines = Arrays.asList(new String[]{
        " _  _  _  _  _  _  _  _  _ ",
        "  |  |  |  |  |  |  |  |  |",
        "  |  |  |  |  |  |  |  |  |",
        "                           "});
        int result = converter.convert(lines);
        TestCase.assertEquals(777777777, result);
    }
}
