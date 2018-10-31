public class PackageInfo {

    String packageName;
    double ca = 0;
    double ce = 0;

    public double getInstability(){
        return ce/(ca+ce);
    }

    double na = 0;
    double nc = 0;

    public double getAbstactness(){
        return na/nc;
    }

}
