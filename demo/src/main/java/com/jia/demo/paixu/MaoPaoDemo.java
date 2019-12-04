package com.jia.demo.paixu;

public class MaoPaoDemo {


    public static void main(String[] args) {
        int[] array = {2, 4, 3, 6, 8, 9, 1};

        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - 1 - i; j++) {
                 if(array[j]>array[j+1]){
                     int temp=array[j];
                     array[j]=array[j+1];
                     array[j+1]=temp;
                 }
            }
        }
        for (int i=0;i<array.length-1;i++){
            System.out.println(array[i]);
        }
    }
}
