package sorting;

import java.util.Arrays;

public class Quicksort {

    public static void main(String[] args) {
        int[] array = {5, 4, 3, 2, 1};
        quickSort(array);
        System.out.println(Arrays.toString(array));
    }
    private static void quickSort(int[] array) {
        quickSort(array, 0, array.length - 1);
    }

    private static void quickSort(int[] array, int left, int right) {
        if (left >= right) {
            return;
        }
        int pivot = array[left + (right - left) / 2];
        int index = partition(array, left, right, pivot);
        quickSort(array, left, index -1);
        quickSort(array, index +1 , right);
    }

    private static int partition(int[] array, int left, int right, int pivot) {
        while (left <= right) {
            while(array[left] < pivot){
                left++;
            }
            while (array[right] > pivot){
                right--;
            }
            if (left <= right) {
                swap(array, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    private static void swap(int[] array, int left, int right) {
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }
}
