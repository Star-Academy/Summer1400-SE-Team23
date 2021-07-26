import java.util.ArrayList;
import java.util.HashMap;

public class Initiallizer {
    private HashMap<String, ArrayList<String>> dictionary;

    public void initialize(HashMap <String, String> documentsContent){
        dictionary = new HashMap<>();
        for(String document : documentsContent.keySet()){
            String[] words = documentsContent.get(document).split(" "); // an array of words of the document
            for(String word : words) {
                ArrayList<String> documentsSet;
                if(dictionary.containsKey(word))  //if the word has been seen before
                    documentsSet = dictionary.get(word);
                else
                    documentsSet = new ArrayList<>();

                if(documentsSet.lastIndexOf(document) == -1){  // if the document hasn't been added to the list before
                    documentsSet.add(document);
                }
                dictionary.put(word, documentsSet);
            }
        }
    }

    public HashMap<String, ArrayList<String>> getDictionary() {
        return dictionary;
    }
}
