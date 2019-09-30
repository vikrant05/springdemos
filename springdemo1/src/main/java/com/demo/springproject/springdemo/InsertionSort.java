package com.demo.springproject.springdemo;

public class InsertionSort {

    public static void main(String[] args) {
        //int[] array = {10,5,1,3,5,7};
        int[] array = {10,9,8,7,6,5};

        System.out.println("Before sorting : ");
        printArray(array);

        System.out.println();
        sort(array, array.length);

        System.out.println("After sorting : ");
        printArray(array);
    }

    private static void sort(int[] array, int size) {
        /*for (int i=1; i<size; i++) {
            for(int j=0; j<i;j++) {
                if(array[i] < array[j]) {
                    int temp = array[i];
                    for (int k=i; k>j; k--){
                        array[k] = array[k-1];
                    }
                    array[j] = temp;
                }
            }
        }*/

        for (int i = 1; i < size; ++i) {
            int key = array[i];
            int j = i - 1;

            /* Move elements of arr[0..i-1], that are
               greater than key, to one position ahead
               of their current position */
            while (j >= 0 && array[j] > key) {
                array[j + 1] = array[j];
                j = j - 1;
            }
            array[j + 1] = key;
        }

    }

    private static void printArray(int[] array) {
        int size = array.length;
        for(int i=0; i<size; i++) {
            System.out.print(array[i] + " ");
        }
        System.out.println();
    }
}
