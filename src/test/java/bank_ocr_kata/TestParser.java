package bank_ocr_kata;

import bank_ocr_kata.exceptions.IncorrectLineLengthException;
import bank_ocr_kata.exceptions.IncorrectNumberOfLinesException;
import bank_ocr_kata.exceptions.NoBlankLineException;
import org.junit.Before;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;

/**
 * Created with IntelliJ IDEA.
 * User: ollyshaw
 * Date: 21/03/2014
 * Time: 19:44
 * To change this template use File | Settings | File Templates.
 */
public class TestParser {
    Converter converter;
    List<String> lines;

    @Before
    public void setup() {
        converter = mock(Converter.class);
         lines = Arrays.asList(new String[]{"bla1", "bla2", "bla3", "bla4"});
    }

    @Test
    public void testParserSendsEveryFourLinesToConverter() throws IncorrectLineLengthException, IncorrectNumberOfLinesException, NoBlankLineException {

        Parser p = new Parser(converter);
        for (int ii = 0; ii < 4; ii++) {
            p.receiveLine("bla" + (ii + 1));
        }

        verify(converter).convert(lines);
    }

    @Test
    public void testParserReadsLines() throws IncorrectLineLengthException, IncorrectNumberOfLinesException, NoBlankLineException {
        String input = "bla1\nbla2\nbla3\nbla4\n";
        Parser p = new Parser(converter);
        p.parse(input);
        verify(converter).convert(lines);
    }
}
