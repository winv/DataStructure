package com.lion;

import org.jetbrains.annotations.NotNull;

public class ArraySort {
    //冒泡基础版 时间复杂度0(n2)
    public static void bubbleSortBase(@NotNull int[] a) {
        int exec=0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a,j,j+1);
                }
                exec++;
            }
            exec++;
            System.out.print("第一"+i+"趟排序：");
            printArray(a);
            System.out.println("");
        }
        System.out.println("执行次数："+exec);
    }
    //基础改进版，时间复杂度为O(n2)
    public static void bubbleSort(@NotNull int[] a) {
        int exec=0;
        for (int i = 0; i < a.length - 1; i++) {
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a,j,j+1);
                }
                exec++;
            }
            exec++;
            System.out.print("第一"+i+"趟排序：");
            printArray(a);
            System.out.println("");
        }
        System.out.println("执行次数："+exec);
    }
    //进阶版，时间复杂度最大为O(n2)，最小为O(n)
    public static void bubbleSortAdvance(@NotNull int[] a) {
        int exec=0;
        for (int i = 0; i < a.length - 1; i++) {
            boolean exchange=false;
            for (int j = 0; j < a.length - i - 1; j++) {
                if (a[j] > a[j + 1]) {
                    swap(a,j,j+1);
                    exchange=true;
                }
                exec++;
            }
            if(!exchange)
                break;
            exec++;
        }

        System.out.println("执行次数："+exec);
    }

    //交换方法
    public static void swap(@NotNull int arr[], int a , int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //打印方法
    public  static void printArray(@NotNull int[] arr){
        for(int k=0;k<arr.length;k++){
            System.out.print(arr[k]+" ");
        }
    }
}
