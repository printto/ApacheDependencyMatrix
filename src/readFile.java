import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.Buffer;

public class readFile {

    public static void readFileCa(String fileToRead, PackageInfo info, int recurLevel){
        String eachLine = "";

        try{

            BufferedReader buffReader = new BufferedReader(new FileReader(fileToRead));
            while ((eachLine = buffReader.readLine()) != null)
            {
                if (eachLine.contains("import "))    {
                    String[] temp = eachLine.split(" ");
                    String packageName = info.packageName.replace('/','.');
                    String startsWith = fileToRead.split("/")[fileToRead.split("/").length - 3 - recurLevel]+"."+packageName;
                    System.out.println("StartsWith = "+startsWith);
                    if(temp[1].startsWith(startsWith)){
                        info.ca++;
                    }
                    break;
                }
            }



            //Close BufferedReader object
            buffReader.close();
        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }

    }

    //Method to read a text file
    public static void readFile(String fileToRead, PackageInfo info)
    {
        String eachLine = "";


        try
        {
            //Count abstract classes in a package.
            BufferedReader buffReader = new BufferedReader(new FileReader(fileToRead));
            while ((eachLine = buffReader.readLine()) != null)
            {
                if (eachLine.contains(" abstract ")) {
                    info.na++;
                    break;
                }
            }


            buffReader = new BufferedReader(new FileReader(fileToRead));
            while ((eachLine = buffReader.readLine()) != null)
            {
                if (eachLine.contains("import "))    {
                    String[] temp = eachLine.split(" ");
                    String packageName = info.packageName.replace('/','.');
                    if(!temp[1].startsWith(packageName)){
                        info.ce++;
                    }
                    break;
                }
            }

            buffReader = new BufferedReader(new FileReader(fileToRead));
            while ((eachLine = buffReader.readLine()) != null)
            {
                if (eachLine.contains("class "))   {
                    info.nc++;
                }
            }

            //Close BufferedReader object
            buffReader.close();

        }
        catch(Exception ex)
        {
            ex.printStackTrace();
        }
    }
}