package com.dp.strategy;

public class Sorter <T>{

    public void sort(T[]arr, Comparator<T>comparator){
        for (int i = 0; i < arr.length -1; i++) {
            int minPos = i;
            for (int j = i+1; j < arr.length ; j++) {
                minPos = comparator.compare(arr[j],arr[minPos]) == -1?j:minPos;
            }
            swap(arr, i,minPos);

            }


    }


    private  void swap(T[] arr, int i, int j) {
        T temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }




    public static void sort(int []arr){
        for (int i = 0; i < arr.length -1; i++) {
            int minPos = i;
            for (int j = i+1; j < arr.length ; j++) {
                minPos = arr[j] < arr[minPos]? j:minPos;

            }
            swap(arr, i,minPos);
        }
    }



    public static void sort(Cat []arr){
        for (int i = 0; i < arr.length -1; i++) {
            int minPos = i;
            for (int j = i+1; j < arr.length ; j++) {
                minPos = arr[j].compareTo(arr[minPos]) == -1? j:minPos;

            }
            swap(arr, i,minPos);
        }
    }

    public static void sort(Comparable []arr){
        for (int i = 0; i < arr.length -1; i++) {
            int minPos = i;
            for (int j = i+1; j < arr.length ; j++) {
                minPos = arr[j].compareTo(arr[minPos]) == -1? j:minPos;

            }
            swap(arr, i,minPos);
        }
    }

    private static void swap(Comparable[] arr, int i, int j) {
        Comparable temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }



    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


    private static void swap(Cat[] arr, int i, int j) {
        Cat temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
