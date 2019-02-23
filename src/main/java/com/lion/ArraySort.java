package com.lion;

import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class ArraySort {
    //冒泡基础版 时间复杂度0(n2)
    public static int[] bubbleSortBase(@NotNull int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        int exec = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
                exec++;
            }
            exec++;
            System.out.print("第一" + i + "趟排序：");
            printArray(arr);
            System.out.println("");
        }
        System.out.println("执行次数：" + exec);
        return arr;
    }
    //基础改进版，时间复杂度为O(n2)
    public static int[] bubbleSort(@NotNull int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        int exec=0;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j,j+1);
                }
                exec++;
            }
            exec++;
            System.out.print("第一"+i+"趟排序：");
            printArray(arr);
            System.out.println("");
        }
        System.out.println("执行次数："+exec);
        return arr;
    }
    //进阶版，时间复杂度最大为O(n2)，最小为O(n)
    public static int[] bubbleSortAdvance(@NotNull int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        int exec=0;
        int len=arr.length;
        for (int i = 0; i < len - 1; i++) {
            boolean exchange=false;
            for (int j = 0; j < len - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr,j,j+1);
                    exchange=true;
                }
                exec++;
            }
            if(!exchange) {
               break;
            }
            exec++;
        }
        System.out.println("执行次数："+exec);
        return  arr;
    }
    //选择排序
    public static int[] selectionSort(@NotNull int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        int len = arr.length;
        int minIndex;
        for (int i = 0; i < len - 1; i++) {
            minIndex = i;
            for (int j = i + 1; j < len; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            if (i != minIndex)
                swap(arr, minIndex, i);
        }
        return arr;
    }
    //快速排序
    public  static void  quickSortBase(int[] a){
        //code
    }

    //交换方法
    public static void swap(@NotNull int arr[], int a , int b){
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }

    //打印方法
    public  static void printArray(@NotNull int[] arr){
        System.out.println("");
        for(int k=0;k<arr.length;k++){
            System.out.print(arr[k]+" ");
        }
    }
}
