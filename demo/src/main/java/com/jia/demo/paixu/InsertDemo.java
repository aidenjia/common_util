package com.jia.demo.paixu;

public class InsertDemo {

    public static void sort(int[] ins) {
        for (int i = 1; i < ins.length; i++) {
            for (int j = i; j > 0; j--) {
                if (ins[j] < ins[j - 1]) {
                    int temp = ins[j - 1];
                    ins[j - 1] = ins[j];
                    ins[j] = temp;
                }
            }
        }
    }
}
