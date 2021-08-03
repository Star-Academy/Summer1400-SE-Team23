package main.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;


public class InitiallizerTests {

    @Test
    public void check(){
        HashMap<String, String> documentsContent = new HashMap<>();
        documentsContent.put("Doc1", "salam salam khoobi ya na?");
        documentsContent.put("Doc2", "salam chetori ya na?");
        Initiallizer initiallizer = new Initiallizer();
        initiallizer.initialize(documentsContent);
        HashMap<String, ArrayList<String>> result = initiallizer.getDictionary();
        ArrayList<String> salam = result.get("salam");
        ArrayList<String> khoobi = result.get("khoobi");
        ArrayList<String> ya = result.get("ya");
        ArrayList<String> na = result.get("na?");
        ArrayList<String> chetori = result.get("chetori");
        assertEquals(2,salam.size());
        assertEquals(1,khoobi.size());
        assertEquals(2,ya.size());
        assertEquals(2,na.size());
        assertEquals(1,chetori.size());
        assertTrue(salam.contains("Doc1"));
        assertTrue(salam.contains("Doc2"));
        assertTrue(khoobi.contains("Doc1"));
        assertTrue(ya.contains("Doc1"));
        assertTrue(ya.contains("Doc2"));
        assertTrue(na.contains("Doc1"));
        assertTrue(na.contains("Doc2"));
        assertTrue(chetori.contains("Doc2"));

    }

}
