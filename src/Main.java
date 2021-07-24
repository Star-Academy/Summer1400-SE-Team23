import java.util.HashMap;

public class Main {

    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader();
            HashMap <String, String> hashMap = fileReader.getDocumentsContent();
            for(String docName : hashMap.keySet()){
                System.out.println(docName + " " + hashMap.get(docName) + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

