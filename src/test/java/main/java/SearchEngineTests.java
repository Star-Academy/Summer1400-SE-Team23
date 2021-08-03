package main.java;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;

public class SearchEngineTests {

    private final ByteArrayOutputStream output = new ByteArrayOutputStream();
    private final HashMap<String, ArrayList<String>> dictionary;

    public SearchEngineTests() {
        FileReader fileReader = new FileReader();
        Initiallizer initiallizer = new Initiallizer();
        try {
            HashMap<String, String> hashMap = fileReader.getDocumentsContent();
            initiallizer.initialize(hashMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        this.dictionary = initiallizer.getDictionary();
    }

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(output));
    }

    @After
    public void cleanUpStreams() {
        System.setOut(null);
    }

    @Test
    public void singleWordSearch() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream(("LDL\n\n").getBytes());
        System.setIn(in);


        SearchEngine searchEngine = new SearchEngine(dictionary);
        searchEngine.search();
        assertEquals("59284 59419 58049 \n", output.toString());
    }

    @Test
    public void andWordsSearch() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream(("LDL HDL\n\n").getBytes());
        System.setIn(in);


        SearchEngine searchEngine = new SearchEngine(dictionary);
        searchEngine.search();
        assertEquals("59284 59419 58049 \n", output.toString());
    }

    @Test
    public void emptyOrWordSearch() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream(("+baghali\n\n").getBytes());
        System.setIn(in);


        SearchEngine searchEngine = new SearchEngine(dictionary);
        searchEngine.search();
        assertEquals("\n", output.toString());
    }

    @Test
    public void excludeWordSearch() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream(("LDl hdL -forgEt\n\n").getBytes());
        System.setIn(in);


        SearchEngine searchEngine = new SearchEngine(dictionary);
        searchEngine.search();
        assertEquals("59284 59419 \n", output.toString());
    }

    @Test
    public void combinatorialQuerySearch() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream(("LDl hdL -forgEt +baghali\n\n").getBytes());
        System.setIn(in);


        SearchEngine searchEngine = new SearchEngine(dictionary);
        searchEngine.search();
        assertEquals("59284 59419 \n", output.toString());
    }

    @Test
    public void combinatorialQuerySearch2() throws Exception {
        ByteArrayInputStream in = new ByteArrayInputStream(("hdl -forgEt +instead +LDL\n\n").getBytes());
        System.setIn(in);


        SearchEngine searchEngine = new SearchEngine(dictionary);
        searchEngine.search();
        assertEquals("59284 59419 \n", output.toString());
    }

}
