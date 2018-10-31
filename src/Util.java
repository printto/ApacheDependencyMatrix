import java.io.File;

public class Util {

    public static void run(String pathOfTheFile, String packageName, String outerPackage) {

        PackageInfo info = new PackageInfo();
        info.packageName = packageName;
        String path = pathOfTheFile;

        System.out.println(path + outerPackage + info.packageName);

        File jcdFile = new File(path + outerPackage + info.packageName);
        String[] jcdFiles = jcdFile.list();
        Counter read = new Counter();
        System.out.println("\nLocation: "+path);
        System.out.println("Package name: "+info.packageName);
        System.out.println("Files Found: "+jcdFiles.length);

        for(String myFile : jcdFiles)
        {
            if(myFile.endsWith(".java")){
                read.count(jcdFile.getPath()+"/"+myFile, info);
            }
            else if(!myFile.contains(".")){
                Util.recur(jcdFile.getPath(), myFile, info);
            }
        }

        File jcdFileCa = new File(path);
        String[] jcdFilesCa = jcdFileCa.list();
        for(String myFile : jcdFilesCa){
            if(myFile.endsWith(".java")){
                read.countCa(jcdFileCa.getPath()+"/"+myFile, info, outerPackage);
            }
            else if(myFile.equals(info.packageName)){

            }
            else if(!myFile.contains(".")){
                recurCa(jcdFileCa.getPath(), myFile, info, outerPackage);
            }
        }
        System.out.println("Ca = "+info.ca);
        System.out.println("Ce = "+info.ce);
        System.out.println("Na = "+info.na);
        System.out.println("Nc = "+info.nc);
        System.out.println("A  = "+info.getAbstactness());
        System.out.println("I  = "+info.getInstability());

    }

    public static void recur(String path, String folder, PackageInfo info){
        String newPath = path+"/"+folder;
        File jcdFile = new File(newPath);
        String[] jcdFiles = jcdFile.list();
        Counter read = new Counter();
        for(String myFile : jcdFiles) {
            if (myFile.endsWith(".java")) {
                read.count(jcdFile.getPath() + "/" + myFile, info);
            } else if (!myFile.contains(".")) {
                recur(jcdFile.getPath(), myFile, info);
            }
        }
    }

    public static void recurCa(String path, String folder,PackageInfo info, String outerPackage){
        String newPath = path+"/"+folder;
        File jcdFile = new File(newPath);
        String[] jcdFiles = jcdFile.list();
        Counter read = new Counter();
        for(String myFile : jcdFiles)
        {
            if(myFile.endsWith(".java")){
                read.countCa(jcdFile.getPath()+"/"+myFile, info, outerPackage);
            }
            else if(!myFile.contains(".")){
                recurCa(jcdFile.getPath(), myFile, info, outerPackage);
            }
        }
    }

}