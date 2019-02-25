package com.lion;

import org.jetbrains.annotations.Contract;
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
    //插入排序
    public  static  int[] insertSort(int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        int len = arr.length;
        for (int i = 1; i < len; i++) {
            int j = i;
            int current = arr[i];
            //此处注意 要先判断J，否则J=0时，j-1=-1会出现下标越界
            while (j > 0 && arr[j - 1] > current) {
                //依次挪动元素
                arr[j] = arr[j - 1];
                j--;
            }
            if (j != i) {
                arr[j] = current;
            }
            printArray(arr);
        }

        return arr;
    }
    //希尔排序 改进后插入排序
    public static  int[] shellSort(int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        int len = arr.length;
        int temp;
        int gap = len / 2;
        while (gap > 0) {
            for (int i = gap; i < len; i++) {
                temp = arr[i];
                int prevIndex = i - gap;
                while (prevIndex >= 0 && arr[prevIndex] > temp) {
                    arr[prevIndex + gap] = arr[prevIndex];
                    prevIndex -=gap;
                }
                arr[prevIndex + gap] = temp;
            }
            gap /= 2;
        }
        return arr;
    }

    //归并排序
    public  static  int[]  mergeSort(@NotNull int[] sourceArr) {
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        if (arr.length < 2)
            return arr;
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        return merge(mergeSort(left), mergeSort(right));
    }
    //归并排序实现
    @Contract(pure = true)
    public  static int[] merge(@NotNull int[] left , @NotNull int [] right) {
        int[] result = new int[left.length + right.length];
        for (int index = 0, i = 0, j = 0; index < result.length; index++) {
            if (i >= left.length)
                result[index] = right[j++];
            else if (j >= right.length)
                result[index] = left[i++];
            else if (left[i] > right[j])
                result[index] = right[j++];
            else
                result[index] = left[i++];
        }
        return result;
    }


    //快速排序
    public  static void  quickSort(int[] a){
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
