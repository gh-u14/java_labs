package lr4;

/**
 * Пример 8. Генерация исключения в методе, finally всегда выполняется.
 * Исправление: в main перехват RuntimeException, иначе аварийное завершение.
 */
public class Example8 {

    public static int m() {
        try {
            System.out.println("0");
            throw new RuntimeException();
        } finally {
            System.out.println("1");
        }
    }

    public static void main(String[] args) {
        try {
            System.out.println(m());
        } catch (RuntimeException e) {
            System.out.println("Перехвачено в main: " + e);
        }
    }
}
