package bank_ocr_kata;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static junit.framework.Assert.assertEquals;

/**
 * Created with IntelliJ IDEA.
 * User: ollyshaw
 * Date: 22/03/2014
 * Time: 22:18
 * To change this template use File | Settings | File Templates.
 */
public class TestSplitter {

    @Test
    public void testSplittingProducesCorrectNumberOfResults(){
        List<String> lines = Arrays.asList(new String[]{
                "                           ",
                "|_||_||_||_||_||_||_||_||_|",
                "  |  |  |  |  |  |  |  |  |",
                "                           "});
        Splitter splitter = new Splitter();
        List<Split> splits= splitter.split(lines);
        assertEquals(9, splits.size());
    }

    @Test
    public void testSplittingProducesCorrectFirstResult(){
        List<String> lines = Arrays.asList(new String[]{
                "111aaaaaaaaaaaaaaaaaaaaa666",
                "222aaaaaaaaaaaaaaaaaaaaa777",
                "333aaaaaaaaaaaaaaaaaaaaa888",
                "                           "});
        Splitter splitter = new Splitter();
        List<Split> splits= splitter.split(lines);
        Split split = splits.get(0);
        assertEquals("111222333", split.toString());
        split = splits.get(splits.size()-1);
        assertEquals("666777888", split.toString());
    }





}
