package lr4;

/**
 * Пример 2. Исключение перехвачено перехватчиком предка
 * Исправление: удалена недостижимая строка после throw
 */
public class Example2 {

    public static void main(String[] args) {
        try {
            System.out.println("0");
            throw new RuntimeException("Непроверяемая ошибка");
        } catch (Exception e) {
            System.out.println("2 " + e);
        }
        System.out.println("3");
    }
}
