package bank_ocr_kata;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TestSplit {

    @Test (expected = NotANumberException.class)
    public void testUnknownNumberThrowsException() throws NotANumberException {
        Split s = new Split();
        s.addString("123456789");
        s.toInt();
    }

    @Test
    public void testZero() throws NotANumberException {
        Split s = new Split();
        s.addString(    " _ "+
                        "| |"+
                        "|_|");
        assertEquals(0, s.toInt());
    }

    @Test
    public void testOne() throws NotANumberException {
        Split s = new Split();
        s.addString(    "   "+
                        "  |"+
                        "  |");
        assertEquals(1, s.toInt());
    }

    @Test
    public void testTwo() throws NotANumberException {
        Split s = new Split();
        s.addString(" _ " +
                    " _|" +
                    "|_  ");
        assertEquals(2, s.toInt());
    }

    @Test
    public void testThree() throws NotANumberException {
        Split s = new Split();
        s.addString(" _ " +
                    " _|" +
                    " _|");
        assertEquals(3, s.toInt());
    }

    @Test
    public void testFour() throws NotANumberException {
        Split s = new Split();
        s.addString(
                "   " +
                "|_|" +
                "  |");
        assertEquals(4, s.toInt());
    }

    @Test
    public void testFive() throws NotANumberException {
        Split s = new Split();
        s.addString(
                " _ " +
                "|_ " +
                " _|");
        assertEquals(5, s.toInt());
    }

    @Test
    public void testSix() throws NotANumberException {
        Split s = new Split();
        s.addString(
                        " _ " +
                        "|_ " +
                        "|_|");
        assertEquals(6, s.toInt());
    }

    @Test
    public void testSeven() throws NotANumberException {
        Split s = new Split();
        s.addString(
                        " _ " +
                        "  |" +
                        "  |");
        assertEquals(7, s.toInt());
    }

    @Test
    public void testEight() throws NotANumberException {
        Split s = new Split();
        s.addString(
                        " _ " +
                        "|_|" +
                        "|_|");
        assertEquals(8, s.toInt());
    }

    @Test
    public void testNine() throws NotANumberException {
        Split s = new Split();
        s.addString(
                        " _ " +
                        "|_|" +
                        " _|");
        assertEquals(9, s.toInt());
    }
}
