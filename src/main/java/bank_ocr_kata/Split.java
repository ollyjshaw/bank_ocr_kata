package bank_ocr_kata;

import javax.swing.plaf.FontUIResource;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ollyshaw
 * Date: 22/03/2014
 * Time: 22:21
 * To change this template use File | Settings | File Templates.
 */
public class Split {

    private static final String ZERO = " _ "+
                                       "| |"+
                                       "|_|";
    private static final String ONE =  "   "+
                                       "  |"+
                                       "  |";
    private static final String FOUR = "   "+
                                       "|_|"+
                                       "  |";
    List<Character> chars = new LinkedList<Character>();

    @Override
    public String toString() {
        char[] result = new char[chars.size()];
        for (int ii = 0; ii < result.length; ii++) {
            result[ii] = chars.get(ii);
        }
        return new String(result);
    }

    public void addString(String substring) {
        for (char c : substring.toCharArray()){
            chars.add(c);
        }
    }

    public int toInt() throws NotANumberException{
        if (toString().equals(ZERO)) return 0;
        if (toString().equals(ONE)) return 1;
      if (toString().equals(FOUR)) return 4;
        throw new NotANumberException();
        //To change body of created methods use File | Settings | File Templates.
    }
}
