package com.company;

import java.util.Arrays;
import java.util.Scanner;

public class Main
{
    public static void quickSort(int[] nums2, int leftBorder, int rightBorder) {
        int leftMarker = leftBorder;
        int rightMarker = rightBorder;
        int pivot = nums2[(leftMarker + rightMarker) / 2];
        do {
            // Двигаем левый маркер слева направо пока элемент меньше, чем pivot
            while (nums2[leftMarker] < pivot) {
                leftMarker++;
            }
            // Двигаем правый маркер, пока элемент больше, чем pivot
            while (nums2[rightMarker] > pivot) {
                rightMarker--;
            }
            // Проверим, не нужно обменять местами элементы, на которые указывают маркеры
            if (leftMarker <= rightMarker) {
                // Левый маркер будет меньше правого только если мы должны выполнить swap
                if (leftMarker < rightMarker) {
                    int tmp = nums2[leftMarker];
                    nums2[leftMarker] = nums2[rightMarker];
                    nums2[rightMarker] = tmp;
                }
                // Сдвигаем маркеры, чтобы получить новые границы
                leftMarker++;
                rightMarker--;
            }
        } while (leftMarker <= rightMarker);

        // Выполняем рекурсивно для частей
        if (leftMarker < rightBorder) {
            quickSort(nums2, leftMarker, rightBorder);
        }
        if (leftBorder < rightMarker) {
            quickSort(nums2, leftBorder, rightMarker);
        }
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите кол-во элеметов массива:");
        int ch = scanner.nextInt();
        int[] nums = new int[ch];
        for (int i = 0; i <= (ch-1); i++){
            System.out.println("Введите число с " + i + " индексом:");
            nums[i] = scanner.nextInt();
        }
        int ch1 = nums.length;
        int ch2 = ch1 - 5;
        System.out.println("Исходный массив: " + Arrays.toString(nums));
        int[] nums1 = Arrays.copyOfRange(nums, 0, ch2);
        int[] nums2 = Arrays.copyOfRange(nums, ch2, nums.length);
        int low = 0;
        int high = nums2.length - 1;
        quickSort(nums2, low, high);
        for(int i = 0; i < nums2.length / 2; i++)
        {
            int temp = nums2[i];
            nums2[i] = nums2[nums2.length - i - 1];
            nums2[nums2.length - i - 1] = temp;
        }
        int[]nums3 = new int[nums1.length+nums2.length];
        int count = 0;
        for(int i = 0; i<nums1.length; i++) {
            nums3[i] = nums1[i];
            count++;
        }
        for (int k : nums2) {
            nums3[count++] = k;
        }

        System.out.println("Отсортерованный массив: " + Arrays.toString(nums3));

    }
}
