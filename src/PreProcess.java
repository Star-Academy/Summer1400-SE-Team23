import java.util.ArrayList;

public class PreProcess {
    private ArrayList<String> orQueries = new ArrayList<>();
    private ArrayList<String> andQueries = new ArrayList<>();
    private ArrayList<String> excludeQueries = new ArrayList<>();


    public void processQuery(String query){
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

    public ArrayList<String> getAndQueries() {
        return andQueries;
    }

    public ArrayList<String> getExcludeQueries() {
        return excludeQueries;
    }

    public ArrayList<String> getOrQueries() {
        return orQueries;
    }
}
