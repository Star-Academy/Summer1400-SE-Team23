package main.java;

import com.sun.nio.sctp.AbstractNotificationHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SearchEngine {

    private final Scanner scanner;
    private final HashMap<String, ArrayList<String>> dictionary;
    private ArrayList<String> orQueries;
    private ArrayList<String> andQueries;
    private ArrayList<String> excludeQueries;


    public SearchEngine(HashMap<String, ArrayList<String>> dictionary) {
        this.scanner = new Scanner(System.in);
        this.orQueries = new ArrayList<>();
        this.andQueries = new ArrayList<>();
        this.excludeQueries = new ArrayList<>();
        this.dictionary = dictionary;
    }

    public void search(){
        String query;
        ArrayList <String> result = new ArrayList<>();
        while(!(query = scanner.nextLine()).equals("")){
            PreProcess preProcess = new PreProcess();
            preProcess.processQuery(query.toLowerCase());
            orQueries = preProcess.getOrQueries();
            andQueries = preProcess.getAndQueries();
            excludeQueries = preProcess.getExcludeQueries();
            SearchProcess searchProcess = new SearchProcess();
            result = searchProcess.middleProcess(orQueries,andQueries,excludeQueries,dictionary);
            for (String document : result)
                System.out.print(document + " ");
            result.clear();
            System.out.println("");
        }
    }
}
