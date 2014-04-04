package bank_ocr_kata;

import java.util.LinkedList;
import java.util.List;

public class Split {

    private static final String ZERO =
            " _ " +
            "| |" +
            "|_|";
    private static final String ONE =
            "   " +
            "  |" +
            "  |";
    private static final String TWO =
            " _ " +
            " _|" +
            "|_  ";
    private static final String THREE =
            " _ " +
            " _|" +
            " _|";
    private static final String FOUR = "   " +
            "|_|" +
            "  |";
    private static final String FIVE =
            " _ " +
            "|_ " +
            " _|";
    private static final String SIX =
            " _ " +
            "|_ " +
            "|_|";
    private static final String SEVEN =
            " _ " +
            "  |" +
            "  |";
    private static final String EIGHT =
            " _ " +
            "|_|" +
            "|_|";
    private static final String NINE =
            " _ " +
            "|_|" +
            " _|";

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
        for (char c : substring.toCharArray()) {
            chars.add(c);
        }
    }

    public int toInt() throws NotANumberException {
        if (toString().equals(ZERO)) return 0;
        if (toString().equals(ONE)) return 1;
        if (toString().equals(TWO)) return 2;
        if (toString().equals(THREE)) return 3;
        if (toString().equals(FOUR)) return 4;
        if (toString().equals(FIVE)) return 5;
        if (toString().equals(SIX)) return 6;
        if (toString().equals(SEVEN)) return 7;
        if (toString().equals(EIGHT)) return 8;
        if (toString().equals(NINE)) return 9;
        throw new NotANumberException();
    }
}
