package com.example.demo.exceptions;

import java.util.Random;

public class Main {

    public static void main(String[] args) {

        int[] array = new int[10];

        Random random = new Random(20);
        for (int i = 0; i < array.length; i++) {
            array[i] = (int) (Math.random()*100);
            System.out.print(array[i] + "  ");
        }

        int mm = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < (array.length - i); j++) {


                if (array[j - 1] > array[j]) {

                    mm = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = mm;
                }

            }

        }

        System.out.println();
        for (int i = 0; i < array.length; i++) {

            System.out.print(array[i] + "  ");
        }

    }
}

