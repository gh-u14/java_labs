package lr4;

/**
 * Пример 9. return в try и выполнение finally.
 */
public class Example9 {

    public static int m() {
        try {
            System.out.println("0");
            return 55;
        } finally {
            System.out.println("1");
        }
    }

    public static void main(String[] args) {
        System.out.println(m());
    }
}
