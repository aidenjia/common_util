package com.jia.demo.paixu;

import java.util.Arrays;

public class FastSortDemo {
    public static void main(String[] args) {
        int[] arr = {65, 58, 95, 10, 57, 62, 13, 106, 78, 23, 85};
        System.out.println("排序前：" + Arrays.toString(arr));
        quickSort(arr, 0, arr.length - 1);
        System.out.println("排序后：" + Arrays.toString(arr));
    }

    public static void quickSort(int[] arr, int low, int high) {
        int p, i, j, temp;
        if (low >= high) {
            return;
        }
        //p是基准数,约定为每个数组的第一个
        p = arr[low];
        i = low;
        j = high;
        while (i < j) {
            //当右边发现大于p的时候停止循环
            while (arr[j] >= p && i < j) {
                j--;
            }
            //当左边发现小于p的时候 停止
            while (arr[i] <= p && i < j) {
                i++;
            }
            temp = arr[j];
            arr[j] = arr[i];
            arr[i] = temp;
        }
        //此时a[i]一定是小于p的，因为在while循环中已经做了比对，所以将i==j时的值与基准值进行交换
        arr[low] = arr[i];
        arr[i] = p;
        quickSort(arr, low, j - 1);  //对左边快排
        quickSort(arr, j + 1, high); //对右边快排
    }
}
