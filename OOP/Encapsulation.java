

public class Encapsulation {
   private int age;
    private String Name;

    public void setName(String Name){
        this.Name=Name;
    }

    public String getName(){
        return Name;
    }
    public void setAge(int a){
        age=a;

    }
    public int getAge(){
        return age;
    }
    /*void display()
    {
        System.out.println("Name: "+Name);
        System.out.println("Age: "+age);

    }*/
}
