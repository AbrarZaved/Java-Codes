

public class overloading_constructor {
    String name,gender;
    int phone;

    overloading_constructor(){
        System.out.println("No Information");

    }
    overloading_constructor(String n, String g, int p){
        name = n;
        gender = g;
        phone = p;
    }
    overloading_constructor(String n, String g){
        name = n;
        gender =g;
    }
    void displayInformation()
    {
        System.out.println("Name: "+name);
        System.out.println("Gender: "+gender);
        System.out.println("Phone: "+phone);

    }
}
