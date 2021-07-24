import java.util.ArrayList;
import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader();
            Initiallizer initiallizer = new Initiallizer();
            HashMap <String, String> hashMap = fileReader.getDocumentsContent();
            initiallizer.initialize(hashMap);
            HashMap <String, ArrayList<String>> dictionary = initiallizer.getDictionary();
            SearchEngine searchEngine = new SearchEngine(dictionary);
            searchEngine.search();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

