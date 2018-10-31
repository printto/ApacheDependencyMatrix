import java.io.File;

public class Main {

    final static String PATH = "/Users/printto/Desktop/giraph/giraph-core/src/main/java/";
    final static String outerPackage = "org/apache/giraph/";

    public static void main(String[] args){
        File jcdFile = new File(PATH + outerPackage);
        String[] jcdFiles = jcdFile.list();
        for(String myFile : jcdFiles)
        {
            if(!myFile.contains(".")){
                Util.run(PATH+"/",myFile,outerPackage);
            }
        }
    }

}
