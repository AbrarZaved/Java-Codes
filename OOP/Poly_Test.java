

public class Poly_Test {
    public static void main(String[] args) {
        //double a,b;
        Poly_Shape s = new Poly_Shape();
        Poly_Shape r = new Poly_Shape_Rectange(10, 20);
        Poly_Shape t = new Poly_Shape_Triangle(10, 20);
        System.out.println(s.area());
        System.out.println(r.area());
        System.out.println(t.area());
    }
}
