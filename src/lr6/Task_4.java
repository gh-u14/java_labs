package lr6;

public class Task_4 {
    public static void main(String[] args) {
        Thread[] threads = new Thread[10];

        for (int i = 0; i < threads.length; i++) {
            int threadNumber = i + 1;
            threads[i] = new Thread(() -> System.out.println("Номер потока: " + threadNumber));
            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
