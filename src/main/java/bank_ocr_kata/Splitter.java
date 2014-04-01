package bank_ocr_kata;

import java.util.LinkedList;
import java.util.List;

public class Splitter {
    private static final int LENGTH = 27;
    private static final int NUMBER_WIDTH = 3;

    public List<Split> split(List<String> lines) {

        List<Split> toReturn = new LinkedList<Split>();

        for (int ii = 0; ii < LENGTH; ii = ii + NUMBER_WIDTH) {
            Split split = new Split();
            split.addString(lines.get(0).substring(ii, ii + NUMBER_WIDTH));
            split.addString(lines.get(1).substring(ii, ii + NUMBER_WIDTH));
            split.addString(lines.get(2).substring(ii, ii + NUMBER_WIDTH));
            toReturn.add(split);
        }

        return toReturn;
    }
}
