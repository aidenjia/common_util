package com.jia.demo.algorithm.paixu;

public class MaoPaoDemo {
    public static void main(String[] args) {
        int[] array = {2, 4, 3, 6,9, 8, 1};
        for (int i = 0; i < array.length; i++) {
            for (int j = 1; j < array.length - i; j++) {
                 if(array[j-1]>array[j]){
                     int temp=array[j-1];
                     array[j-1]=array[j];
                     array[j]=temp;
                 }
            }
            for (int index=0;index<array.length;index++){
                System.out.print(array[index]+"-");
            }
            System.out.println();
        }

    }
}
