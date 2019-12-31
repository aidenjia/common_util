package com.jia.demo.paixu;

public class TwoSplitFindDemo {

    /**
     * 二分法查找
     *
     * @param array
     * @param a
     * @return
     */
    public static int biSearch(int[] array, int a) {
        int begin = 0;
        int hi = array.length - 1;
        int mid;
        while (begin <= hi) {
            mid = (begin + hi) / 2;
            if (array[mid] == a) {
                return mid + 1;
            } else if (array[mid] < a) {
                begin = mid + 1;
            } else {
                begin = mid - 1;
            }
        }
        return -1;
    }
}
