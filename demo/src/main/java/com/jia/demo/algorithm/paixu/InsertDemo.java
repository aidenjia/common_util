package com.jia.demo.algorithm.paixu;

public class InsertDemo {

    public static void main(String[] args) {
        int[] arr = {6, 5, 3, 1, 8, 7, 2, 4};
        System.out.println("排序之前：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        // 直接插入排序
        insertSort2(arr);
        System.out.println();
        System.out.println("排序之后：");
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    /**
     * 直接插入排序
     */
    private static void insertSort2(int[] arr) {
        int j; // 已排序列表下标
        int t; // 待排序元素
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                t = arr[i]; // 赋值给待排序元素
                for (j = i - 1; j >= 0 && arr[j] > t; j--) {
                    arr[j + 1] = arr[j]; // 从后往前遍历已排序列表，逐个和待排序元素比较，如果已排序元素较大，则将它后移
                }
                arr[j+1] = t; // 将待排序元素插入到正确的位置
            }
        }
    }

    private static void insertSort(int[] arr){
        for(int i=1;i<arr.length;i++){
            int temp =arr[i];
            int j=i;
            // 从已经排序的序列最右边开始比较，找到比其小的数
            while (j>0 && temp<arr[j-1]){
                arr[j]=arr[j-1];
                j--;
            }
            // 存在比其小的数，则插入
            if(j!=i){
                arr[j]=temp;
            }
            System.out.println();
            for (int index = 0; index < arr.length;index++) {
                System.out.print(arr[index] + " ");
            }
            System.out.println();
        }
    }


}
