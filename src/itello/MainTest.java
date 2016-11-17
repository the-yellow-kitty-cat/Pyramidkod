package itello;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by cof on 2016-11-15.
 */
public class MainTest {
    @org.junit.Test
    public void createPyramidList() throws Exception {
        String input = "HEJ";
        List<String> pyramidList = Main.createPyramidList(input);
        assertEquals(pyramidList.size(), 2);
        assertEquals("H", pyramidList.get(0));
        assertEquals("EJ", pyramidList.get(1));

    }
    @org.junit.Test
    public void stringTooLong() throws Exception {
        String input = "HEJPÅDEJ";
        List<String> pyramidList = Main.createPyramidList(input);
        assertEquals(pyramidList.size(), 4);
        assertEquals("H", pyramidList.get(0));
        assertEquals("EJ", pyramidList.get(1));
        assertEquals("PÅD",pyramidList.get(2));
        assertEquals("EJHE", pyramidList.get(3));

    }

    @org.junit.Test
    public void prepareString() throws Exception {
        String input = "Hej! Hur är läget? :)";
        String pyramidEncryption=Main.prepareString(input);
        assertEquals("HEJHURÄRLÄGET", pyramidEncryption);
    }

    @org.junit.Test
    public void createPyramid()throws Exception {
        String input = "HEJHURÄRLÄGET";
        List<String> pyramidList = Main.createPyramidList(input);
        assertEquals(pyramidList.size(), 5);
        assertEquals("H", pyramidList.get(0));
        assertEquals("EJ", pyramidList.get(1));
        assertEquals("HUR", pyramidList.get(2));
        assertEquals("ÄRLÄ", pyramidList.get(3));
        assertEquals("GETHE", pyramidList.get(4));
    }

    @Test
    public void encryptPyramid(){
        List<String> pyramid=Arrays.asList("H","EJ","HUR","ÄRLÄ","GETHE");
        String encryptPyramid= Main.encryptPyramid(pyramid);
        assertEquals("GÄHEHERUJTLRHÄE",encryptPyramid);
    }

    @Test
    public void rebecka(){
        String input="==>Rebecka!<==";
        String pyramidString= Main.getPyramidEncryption(input);
        assertEquals("AEERRCBEKB", pyramidString);
    }
}