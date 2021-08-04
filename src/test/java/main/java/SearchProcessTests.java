package main.java;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SearchProcessTests {

    ArrayList<String> orQueries;
    ArrayList<String> andQueries;
    ArrayList<String> exQueries;
    HashMap<String, ArrayList<String>> dictionary;

    @Test
    public void SearchTest(){
        orQueries = new ArrayList<>();
        andQueries = new ArrayList<>();
        exQueries = new ArrayList<>();
        dictionary = new HashMap<>();


        orQueries.add("+google");
        orQueries.add("+facebook");

        andQueries.add("samsung");
        andQueries.add("apple");


        exQueries.add("-map");

        ArrayList <String> tmp = new ArrayList<>();
        tmp.add("Doc1");
        tmp.add("Doc2");
        tmp.add("Doc3");
        dictionary.put("google",tmp);
        ArrayList <String> tmp1 = new ArrayList<>();
        tmp1.add("Doc4");
        tmp1.add("Doc2");
        tmp1.add("Doc3");
        dictionary.put("facebook",tmp1);
        ArrayList <String> tmp2 = new ArrayList<>();
        ArrayList <String> tmp3 = new ArrayList<>();
        ArrayList <String> tmp4 = new ArrayList<>();
        tmp2.add("Doc4");
        tmp2.add("Doc2");
        tmp2.add("Doc1");
        tmp2.add("Doc5");
        dictionary.put("samsung",tmp2);
        tmp3.add("Doc4");
        tmp3.add("Doc2");
        tmp3.add("Doc1");
        tmp3.add("Doc6");
        dictionary.put("apple",tmp3);
        tmp4.add("Doc1");
        tmp4.add("Doc6");
        dictionary.put("map",tmp4);
        SearchProcess searchProcess = new SearchProcess();
        ArrayList <String> test = searchProcess.middleProcess(orQueries,andQueries,exQueries,dictionary);
        assertTrue(test.contains("Doc2"));
        assertTrue(test.contains("Doc4"));
        //assertTrue(test.contains("Doc1"));
        assertEquals(test.size(),2);
    }


}
