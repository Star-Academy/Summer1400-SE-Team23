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
            processQuery(query.toLowerCase());
            for(String word : orQueries){
                if(!dictionary.containsKey(word.substring(1)))
                    continue;
                result.addAll(dictionary.get(word.substring(1)));
            }

            if(result.isEmpty()){
                for(String word : andQueries){
                    if(dictionary.containsKey(word)){
                        result.addAll(dictionary.get(word));
                        break;
                    }
                }
            }

            for(String word : andQueries){
                if(!dictionary.containsKey(word)) {
                    result.clear();
                    break;
                }
                result.removeIf(document -> !dictionary.get(word).contains(document));
            }

            for(String word : excludeQueries){
                if(!dictionary.containsKey(word.substring(1)))
                    continue;
                for(String document : dictionary.get(word.substring(1))){
                    result.remove(document);
                }
            }

            for (String document : result)
                System.out.print(document + " ");
            result.clear();
            System.out.println("");
        }
    }

    private void processQuery(String query){
        if(!orQueries.isEmpty())
            orQueries.clear();
        if(!andQueries.isEmpty())
            andQueries.clear();
        if(!excludeQueries.isEmpty())
            excludeQueries.clear();
        String[] words = query.split("\\s");
        for(String word : words){
            if(word.startsWith("+")){
                orQueries.add(word);
            }else if(word.startsWith("-")){
                excludeQueries.add(word);
            }else{
                andQueries.add(word);
            }
        }
    }
}
