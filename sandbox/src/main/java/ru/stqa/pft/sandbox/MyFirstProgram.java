package ru.stqa.pft.sandbox;

public class MyFirstProgram {

    public static void main(String[] args) {
        hello("world");
        hello("cat");



        Square s = new Square(5);

        System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

        Point p1 = new Point(6,6);
        Point p2 = new Point(2,5);

        System.out.println("Расстояние между двумя точками p =  "+ distance(p1,p2));

        Rectangle r = new Rectangle(4,6);

        System.out.println("Площадь прямоугольника со стороной " + r.a + " и " + r.b + " = " + area(r));
    }

    public static void hello(String somebody) {

        System.out.println("Hello, " + somebody + "!");
    }

    public static double distance(Point p1, Point p2) {
        return Math.sqrt(Math.pow((p2.x-p1.x),2) + Math.pow((p2.y-p1.y),2));
    }

    public static double area(Rectangle r) {
        return r.a * r.b;
    }

}
