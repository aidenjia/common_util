package com.jia.demo.paixu;

public class XuanZeDemo {
    /***
     * 第一次遍历,将第一个位置上的数字与后面的数字进行比较,如果后面的
     * 数字比第一个位置上的元素小 则将两个数字的位置进行交换
     * 第二次遍历 将第二个位置上的数字与后面的数字进行比较,如果后面的
     * 数字比第二个位置上的元素小 则将两个数字的位置进行交换
     * 依次进行遍历,位置交换 知道这组数字排序完成
     * @param args
     */
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
        for (int i = 0; i <=array.length - 1; i++) {
            System.out.println(array[i]);
        }
    }
}
