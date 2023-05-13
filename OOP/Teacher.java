
//Teacher
public class Teacher {
    String name,gender;
    int phone;
    /*void setInfo(String a, String b, int c){
        name =a;
        gender =b;
        phone = c;

    }*/
    Teacher(String a, String b, int c)
    {
        name = a;
        gender =b;
        phone = c;

    }
    void displayInformation(){
        System.out.println("Name: "+name);
        System.out.println("Gender: "+gender);
        System.out.println("phone: "+phone);
        
    }
    
}
