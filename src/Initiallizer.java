import java.util.ArrayList;
import java.util.HashMap;

public class Initiallizer {
    private HashMap<String, ArrayList<String>> dictionary;

    public void initialize(HashMap <String, String> documentsContent){
        dictionary = new HashMap<>();
        for(String s : documentsContent.keySet()){
            String s1 = documentsContent.get(s);
            String[] s2 = s1.split(" ");
            for(String s3 : s2) {
                ArrayList<String> documentsSet;
                if(dictionary.containsKey(s3))
                    documentsSet = dictionary.get(s3);
                else
                    documentsSet = new ArrayList<>();

                if(documentsSet.lastIndexOf(s) == -1){
                    documentsSet.add(s);
                }
                dictionary.put(s3, documentsSet);
            }
        }
    }

    public HashMap<String, ArrayList<String>> getDictionary() {
        return dictionary;
    }
}
