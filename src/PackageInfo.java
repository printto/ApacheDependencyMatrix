public class PackageInfo {

    String packageName;

    //The number of classes outside this package.
    double ca;
    //The number of classes inside this package.
    double ce;

    public double getInstability(){
        return ce/(ca+ce);
    }

    //numbers of abstract class in package.
    double na;
    //numbers of class in package.
    double nc;

    public double getAbstactness(){
        return na/nc;
    }

}
