import com.sun.nio.sctp.AbstractNotificationHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class SearchEngine {

    private final Scanner scanner;
    private final HashMap<String, ArrayList<String>> dictionary;


    public SearchEngine(HashMap<String, ArrayList<String>> dictionary) {
        this.scanner = new Scanner(System.in);
        this.dictionary = dictionary;
    }

    public void search(){
        String query;

        while((query = scanner.nextLine()) != "\n"){
            for (String document : dictionary.get(query))
                System.out.println(document + " ");
        }
        System.out.println("\n");
    }
}