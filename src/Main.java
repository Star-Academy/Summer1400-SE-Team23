public class Main {
    public static void main(String[] args) {
        try {
            FileReader fileReader = new FileReader();
            fileReader.getDocumentsContent();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

