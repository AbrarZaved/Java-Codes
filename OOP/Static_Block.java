
public class Static_Block {
    static int id;
    static String name;

    static{
        id=101;
        name ="Abrar Javed";

    }
    static void display()
    {
        System.out.println("ID: "+id);
        System.out.println("Name: "+name);
    }
    public static void main(String[] args) {
        display();
    }

}
