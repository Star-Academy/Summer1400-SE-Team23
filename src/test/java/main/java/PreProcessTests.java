package main.java;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;


public class PreProcessTests {


    @Test
    public void CheckQueries(){
        PreProcess preProcess = new PreProcess();
        String query = "and1 +or1 +or2 -ex1 +or3 -ex2";
        preProcess.processQuery(query);
        ArrayList <String> andList = new ArrayList<>();
        ArrayList <String> orList = new ArrayList<>();
        ArrayList <String> exList = new ArrayList<>();
        andList.add("and1");
        orList.add("+or1");
        orList.add("+or2");
        orList.add("+or3");
        exList.add("-ex1");
        exList.add("-ex2");
        assertTrue(orList.equals(preProcess.getOrQueries()));
        /*assertTrue(orList.equals(preProcess.getOrQueries()));
        assertTrue(exList.equals(preProcess.getExcludeQueries()));*/
    }
}
