public class Boat extends Vehicle {
    
    public void move()
    {
    System.out.println("Boat moves faster.");
    }
   
    public static void main(String[] args) {
    Boat c1 = new Boat();
    c1.move();
    c1.carry();
    }
}
