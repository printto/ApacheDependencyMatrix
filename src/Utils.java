import java.io.File;

public class Utils {

    public static void main(String[] args) {

        PackageInfo info = new PackageInfo();
        info.packageName = "b";
        String path = "/Users/theeruthborisuth/Downloads/PackageDependencyMetrics-master/src/test/";
        File jcdFile = new File(path+info.packageName);
        //Get list of files and store in our array
        String[] jcdFiles = jcdFile.list();
        readFile read = new readFile();


        //Print out number of files
        System.out.println("Files Found: "+jcdFiles.length);

        //Add blank line
        System.out.println("");

        //Enhance loop through all files in the directory or folder
        for(String myFile : jcdFiles)
        {
            if(myFile.endsWith(".java")){
                //System.out.println(myFile.toString()+":");
                read.readFile(jcdFile.getPath()+"/"+myFile, info);
                //System.out.println(myFile);
            }
            else if(!myFile.contains(".")){
                Utils.recur(jcdFile.getPath(), myFile, info);
            }
        }

        File jcdFileCa = new File(path);
        //Get list of files and store in our array
        String[] jcdFilesCa = jcdFileCa.list();
        for(String myFile : jcdFilesCa){
            if(myFile.endsWith(".java")){
                //System.out.println(myFile.toString()+":");
                read.readFileCa(jcdFileCa.getPath()+"/"+myFile, info, -1);
                //System.out.println(myFile);
            }
            else if(myFile.equals(info.packageName)){

            }
            else if(!myFile.contains(".")){
                recurCa(jcdFileCa.getPath(), myFile, info, -1);
            }
        }

        System.out.println("=======");
        System.out.println("Ca = "+info.ca);
        System.out.println("Ce = "+info.ce);
        System.out.println("Na = "+info.na);
        System.out.println("Nc = "+info.nc);
        System.out.println(info.getAbstactness());
        System.out.println(info.getInstability());

    }

    public static void recur(String path, String folder, PackageInfo info){
        String newPath = path+"/"+folder;
        File jcdFile = new File(newPath);
        String[] jcdFiles = jcdFile.list();
        readFile read = new readFile();
        for(String myFile : jcdFiles) {
            if (myFile.endsWith(".java")) {
                //System.out.println(myFile.toString()+":");
                read.readFile(jcdFile.getPath() + "/" + myFile, info);
                //System.out.println(myFile);
            } else if (!myFile.contains(".")) {
                recur(jcdFile.getPath(), myFile, info);
            }
        }
    }

    public static void recurCa(String path, String folder,PackageInfo info, int recurLevel){
        recurLevel++;
        String newPath = path+"/"+folder;
        System.out.println("recur: "+newPath);
        File jcdFile = new File(newPath);
        String[] jcdFiles = jcdFile.list();
        readFile read = new readFile();
        for(String myFile : jcdFiles)
        {
            System.out.println("MyFileCa: "+myFile);
            if(myFile.endsWith(".java")){
                //System.out.println(myFile.toString()+":");
                read.readFileCa(jcdFile.getPath()+"/"+myFile, info, recurLevel);
                //System.out.println(myFile);
            }
            else if(!myFile.contains(".")){
                recurCa(jcdFile.getPath(), myFile, info, recurLevel);
            }
        }
    }

}