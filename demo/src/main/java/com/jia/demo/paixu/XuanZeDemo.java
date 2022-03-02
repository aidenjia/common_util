package com.jia.demo.paixu;

import java.util.Arrays;

public class XuanZeDemo {
    public static void main(String[] args) {
        int[] arr = new int[]{5,8,6,3,9,2,1,7};
        selectSort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void selectSort(int[] arr){
        for(int i=0;i<arr.length-1;i++){
            int min=i;
            for(int j=i+1;j<arr.length;j++){
                if(arr[j]<arr[min]){
                    min=j;
                }
            }
            // 将找到的最小值和i位置所在的值进行交换
            if(i!=min){
                int temp=arr[i];
                arr[i]=arr[min];
                arr[min]=temp;
            }
        }
    }
}
