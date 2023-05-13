

public class Poly_Shape_Triangle extends Poly_Shape {
    double base, height;
    Poly_Shape_Triangle(double b,double h){
        base =b;
        height=h;
    }
    double area()
    {
        return .5*base*height;
    }
    
}
