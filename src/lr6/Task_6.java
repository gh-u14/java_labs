package lr6;

import java.util.Arrays;

public class Task_6 {
    public static void main(String[] args) {
        int[] array = {12, 4, 56, 7, 89, 34, 3, 150, 2, 77, 64, 101};
        System.out.println("Массив: " + Arrays.toString(array));
        System.out.println("Сумма: " + sumParallel(array));
    }

    public static long sumParallel(int[] array) {
        if (array == null || array.length == 0) {
            return 0;
        }

        int cores = Runtime.getRuntime().availableProcessors();
        int threadCount = Math.min(cores, array.length);
        int chunkSize = (array.length + threadCount - 1) / threadCount;

        long[] partialSums = new long[threadCount];
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            int threadIndex = i;
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, array.length);

            threads[i] = new Thread(() -> {
                long localSum = 0;
                for (int j = start; j < end; j++) {
                    localSum += array[j];
                }
                partialSums[threadIndex] = localSum;
            });

            threads[i].start();
        }

        for (Thread thread : threads) {
            try {
                thread.join();
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                throw new RuntimeException("Вычисление прервано", e);
            }
        }

        long result = 0;
        for (long partialSum : partialSums) {
            result += partialSum;
        }
        return result;
    }
}
