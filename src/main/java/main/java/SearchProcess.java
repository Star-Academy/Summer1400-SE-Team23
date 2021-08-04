package main.java;

import java.util.ArrayList;
import java.util.HashMap;

public class SearchProcess {

    public ArrayList<String> middleProcess(ArrayList<String> orQueries, ArrayList<String> andQueries, ArrayList<String> excludeQueries, HashMap<String, ArrayList<String>> dictionary){
        ArrayList <String> result = new ArrayList<>();
        for(String word : orQueries){
            if(!dictionary.containsKey(word.substring(1)))
                continue;
            //result.addAll(dictionary.get(word.substring(1)));
            for(String doc : dictionary.get(word.substring(1))){
                if(!result.contains(doc)){
                    result.add(doc);
                }
            }
        }

        if(result.isEmpty()){
            for(String word : andQueries){
                if(dictionary.containsKey(word)){
                    for(String doc : dictionary.get(word.substring(1))){
                        if(!result.contains(doc)){
                            result.add(doc);
                        }
                    }
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
        return result;
    }
}
