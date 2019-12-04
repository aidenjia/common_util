package com.jia.demo.paixu;

public class XuanZeDemo {
    public static void main(String[] args) {
        int[] array = {2, 4, 3, 6, 8, 9, 1};
        for (int i = 0; i < array.length - 1; i++) {
            int k=i;
            for(int j=i+1;j<array.length-1;j++){
                if(array[j]>array[k]){
                    k=j;
                }
            }
            if(k!=i){
                int t=array[k];
                array[k]=array[i];
                array[i]=t;

            }
        }
        for (int i = 0; i < array.length - 1; i++) {
            System.out.println(array[i]);
        }
    }
}
