package lr6;

import java.util.Arrays;

public class Task_5 {
    public static void main(String[] args) {
        int[] array = {12, 4, 56, 7, 89, 34, 3, 150, 2, 77, 64, 101};
        System.out.println("Массив: " + Arrays.toString(array));
        System.out.println("Максимум: " + findMaxParallel(array));
    }

    public static int findMaxParallel(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("Массив не должен быть пустым");
        }

        int cores = Runtime.getRuntime().availableProcessors();
        int threadCount = Math.min(cores, array.length);
        int chunkSize = (array.length + threadCount - 1) / threadCount;

        int[] partialMax = new int[threadCount];
        Thread[] threads = new Thread[threadCount];

        for (int i = 0; i < threadCount; i++) {
            int threadIndex = i;
            int start = i * chunkSize;
            int end = Math.min(start + chunkSize, array.length);

            threads[i] = new Thread(() -> {
                int localMax = array[start];
                for (int j = start + 1; j < end; j++) {
                    if (array[j] > localMax) {
                        localMax = array[j];
                    }
                }
                partialMax[threadIndex] = localMax;
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

        int result = partialMax[0];
        for (int i = 1; i < partialMax.length; i++) {
            if (partialMax[i] > result) {
                result = partialMax[i];
            }
        }
        return result;
    }
}
