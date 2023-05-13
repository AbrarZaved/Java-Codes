

public class overloadingConstructor_Test {
    public static void main(String[] args) {
        overloading_constructor t1 = new overloading_constructor();
        overloading_constructor t2 = new overloading_constructor("Abrar Javed", "Male",1728150570);
        t2.displayInformation();
        overloading_constructor t3= new overloading_constructor("Khairun Nahar", "Female", 1972150570);
        t3.displayInformation();

    }
}
