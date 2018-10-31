import java.io.BufferedReader;
import java.io.FileReader;

public class Counter {

    public static void countCa(String fileToRead, PackageInfo info, String outerPackage){
        String eachLine = "";

        try{

            BufferedReader buffReader = new BufferedReader(new FileReader(fileToRead));
            while ((eachLine = buffReader.readLine()) != null)
            {
                if (eachLine.contains("import "))    {
                    String[] temp = eachLine.split(" ");
                    String startsWith = outerPackage+info.packageName;
                    String packageName = startsWith.replace('/','.');
                    if(temp[1].startsWith(packageName)){
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
    public static void count(String fileToRead, PackageInfo info)
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