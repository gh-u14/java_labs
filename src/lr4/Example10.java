package lr4;

/**
 * Пример 10. return в try и в finally (возвращается значение из finally).
 */
public class Example10 {

    public static int m() {
        try {
            System.out.println("0");
            return 15;
        } finally {
            System.out.println("1");
            return 20;
        }
    }

    public static void main(String[] args) {
        System.out.println(m());
    }
}
