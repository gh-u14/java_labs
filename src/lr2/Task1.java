package lr2;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner id = new Scanner(System.in);
        System.out.println("Введите размер массива и максимальное значение: ");
        int size = id.nextInt();
        int max = id.nextInt();
        System.out.println("Размер массива = " + size);
        System.out.println("Максимальное значение = " + max);

        int[] nums = new int[size];

        Random random = new Random();

        for (int i = 0; i < nums.length; i++) {
            nums[i] = random.nextInt(max);
            System.out.println("Элемент массива ["+i+"] = " + nums[i]);
        }

        int min = nums[0];
        for (int value : nums) {
            if (value < min) {
                min = value;
            }
        }

        List<Integer> indices = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == min) {
                indices.add(i);
            }
        }

        System.out.println("\nМинимальное значение: " + min);
        System.out.println("Индекс(ы) элементов с минимальным значением: " + indices);
    }

}
