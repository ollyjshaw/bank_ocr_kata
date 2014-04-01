package bank_ocr_kata;


import bank_ocr_kata.exceptions.IncorrectLineLengthException;
import bank_ocr_kata.exceptions.IncorrectNumberOfLinesException;
import bank_ocr_kata.exceptions.NoBlankLineException;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ollyshaw
 * Date: 21/03/2014
 * Time: 21:03
 * To change this template use File | Settings | File Templates.
 */
public class TestConverter {

    @Test(expected = IncorrectNumberOfLinesException.class)
    public void testParserErrorsWhenTooFewLines() throws IncorrectLineLengthException, IncorrectNumberOfLinesException, NoBlankLineException {
        Converter converter = new Converter();
        List<String> lines = Arrays.asList(new String[]{"bar"});
        converter.convert(lines);
    }

    @Test(expected = IncorrectNumberOfLinesException.class)
    public void testParserErrorsWhenTooManyLines() throws IncorrectLineLengthException, IncorrectNumberOfLinesException, NoBlankLineException {
        Converter converter = new Converter();
        List<String> lines = Arrays.asList(new String[]{"bar", "bar", "bar", "bar", "bar"});
        converter.convert(lines);
    }

    @Test(expected = NullPointerException.class)
    public void testParserErrorsWhenNull() throws IncorrectLineLengthException, IncorrectNumberOfLinesException, NoBlankLineException {
        Converter converter = new Converter();
        converter.convert(null);
    }

    @Test(expected = NoBlankLineException.class)
    public void testParserErrorsWhenFourthLineNotBlank() throws IncorrectLineLengthException, IncorrectNumberOfLinesException, NoBlankLineException {
        Converter converter = new Converter();
        List<String> lines = Arrays.asList(new String[]{
                "aaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "          x                "});
        converter.convert(lines);
    }

    @Test(expected = IncorrectLineLengthException.class)
    public void testParserErrorsWhenLinesNot27Chars() throws IncorrectLineLengthException, IncorrectNumberOfLinesException, NoBlankLineException {
        Converter converter = new Converter();
        List<String> lines = Arrays.asList(new String[]{
                "bar",
                "bar",
                "bar",
                " "});
        converter.convert(lines);
    }

    @Test
    public void testNoExceptionsWhenBasicFormatCorrect() throws IncorrectLineLengthException, IncorrectNumberOfLinesException, NoBlankLineException {
        Converter converter = new Converter();
        List<String> lines = Arrays.asList(new String[]{
                "aaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "aaaaaaaaaaaaaaaaaaaaaaaaaaa",
                "                           "});
        converter.convert(lines);
    }

    @Test
    public void testSplitting(){

    }
}
