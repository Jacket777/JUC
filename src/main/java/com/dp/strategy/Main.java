package com.dp.strategy;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
//        int arr[] ={5,7,6,5,3,3,4};
//        Sorter.sort(arr);
//        System.out.println(Arrays.toString(arr));
//
//        Cat cat1 = new Cat(1,1);
//        Cat cat2 = new Cat(3,3);
//        Cat cat3 = new Cat(5,5);
//        Cat arr1[] = {cat3, cat2,cat1};
//        Sorter.sort(arr1);
//        System.out.println(Arrays.toString(arr1));


//        Dog arr2[] = {new Dog(5), new Dog(6), new Dog(3)};
//        Sorter.sort(arr2);
//        System.out.println(Arrays.toString(arr2));

//        Dog arr3[] = {new Dog(5), new Dog(6), new Dog(3)};
//        Sorter<Dog>sorter = new Sorter<>();
//        sorter.sort(arr3, new DogComparator());
//        System.out.println(Arrays.toString(arr3));

                Cat cat1 = new Cat(1,1);
        Cat cat2 = new Cat(8,3);
        Cat cat3 = new Cat(5,5);
        Cat arr1[] = {cat3, cat2,cat1};
        Sorter<Cat>sorter = new Sorter<>();
      //  sorter.sort(arr1,new CatComparator());
        sorter.sort(arr1,(o1,o2)->{
            if(o1.height < o2.height){
                return -1;
            }else if(o1.height > o2.height){
                return 1;
            }else{
                return 0;
            }

        });

        System.out.println(Arrays.toString(arr1));



    }
}
