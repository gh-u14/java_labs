package lr2.task5_rectangle;

public class Main {

    public static void main(String[] args) {
        Rectangle rect = new Rectangle(5.0, 3.0);
        System.out.println("Длина: " + rect.getLength() + ", ширина: " + rect.getWidth());
        System.out.println("Площадь: " + rect.getArea());
        System.out.println("Периметр: " + rect.getPerimeter());
    }
}
