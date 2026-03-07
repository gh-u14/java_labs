package lr2.task9_shapes;

public class Main {

    public static void main(String[] args) {
        Shape circle = new Circle(3);
        Shape square = new Square(4);
        Shape triangle = new Triangle(3, 4, 5);

        System.out.println(
            "\nКруг (r=3): " +
            "\nплощадь = " + circle.getArea() + ", " +
            "\nпериметр = " + circle.getPerimeter()
        );
        System.out.println(
            "\nКвадрат (a=4): " +
            "\nплощадь = " + square.getArea() + ", " +
            "\nпериметр = " + square.getPerimeter()
        );
        System.out.println(
            "\nТреугольник (3,4,5): " +
            "\nплощадь = " + triangle.getArea() + ", " +
            "\nпериметр = " + triangle.getPerimeter()
        );
    }
}
