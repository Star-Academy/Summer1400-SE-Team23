import java.io.File;
import java.util.HashMap;
import java.util.Scanner;

public class FileReader {
    private File documentsFolder = new File("resources/documents");
    private HashMap <String, String> documentsContent = new HashMap<>();

    private void readContent() throws Exception {

        //this loop is for reading and saving documents' content
        for (File file : documentsFolder.listFiles()){
            String fileName = file.getName();
            Scanner scanner = new Scanner(file);
            String line;
            StringBuffer content = new StringBuffer();

            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                content.append(line +" ");
            }

            //mapping each document's content to its name
            documentsContent.put(fileName, content.toString());
        }



    }
}
