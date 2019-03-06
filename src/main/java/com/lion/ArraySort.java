package com.lion;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;

public class ArraySort {
    private static int len;
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
            //printArray(arr);
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
    public  static int[] quickSort(@NotNull int[] sourceArr){
        int[] arr = Arrays.copyOf(sourceArr, sourceArr.length);
        return  quickSortBase(arr,0,arr.length-1);
    }
    //快速排序
    private  static int[]  quickSortBase(int[] arr, int left, int right) {
        if (left < right) {
            int paritionIndex = partiton(arr, left, right);
            quickSortBase(arr, left, paritionIndex - 1);
            quickSortBase(arr, paritionIndex + 1, right);
        }
        return arr;
    }
    private static  int partiton(int[] arr,int left,int right) {
        int pivot = left;
        int index = pivot + 1;
        for (int i = index; i <= right; i++) {
            if (arr[i] < arr[pivot]) {
                swap(arr, i, index);
                index++;
            }
        }
        swap(arr, pivot, index - 1);
        return index - 1;
    }
    public  static int[] heapSort(int[] arr){
        buildMaxHeap(arr);
        for (int i = arr.length - 1; i > 0; i--) {
            swap(arr, 0, i);
            len--;
            heapify(arr, 0);
        }
        return arr;
    }
    public  static void heapify(int[] arr,int i) {
        int left = 2 * i + 1,
                right = 2 * i + 2,
                largest = i;

        if (left < len && arr[left] > arr[largest]) {
            largest = left;
        }

        if (right < len && arr[right] > arr[largest]) {
            largest = right;
        }
        if (largest != i) {
            swap(arr, i, largest);
            heapify(arr, largest);
        }
    }
    public  static void  buildMaxHeap(int[] arr){
        len = arr.length;
        for (int i = Math.abs(len/2); i >= 0; i--) {
            heapify(arr, i);
        }
    }
    //计数排序
    public static int[] countingSort(int[] arr, int maxValue) {
        int[] bucket = new int[maxValue + 1];
        int sortedIndex = 0;
        int arrLen = arr.length;
        int bucketLen = maxValue + 1;
        for (int i = 0; i < arrLen; i++) {
            if (bucket[i]!=arr[i]) {
                bucket[arr[i]] = 0;
            }
            bucket[arr[i]]++;
        }
        for (int j = 0; j < bucketLen; j++) {
            while (bucket[j] > 0) {
                arr[sortedIndex++] = j;
                bucket[j]--;
            }
        }
        return arr;
    }
    //桶排序
    public static int[] bucketSorts(int[] sourceArr){
        int[] arr=Arrays.copyOf(sourceArr,sourceArr.length);
        return bucketSort(arr,5);
    }
    private static int[] bucketSort(int[] arr,int bucketsize) {
        if (arr.length == 0)
            return arr;
        int minValue = arr[0];
        int maxValue = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < minValue)
                minValue = arr[i];
            else if (maxValue > arr[i])
                maxValue = arr[i];
        }
        int bucketCount = (int) Math.floor((maxValue - minValue) / bucketsize) + 1;
        int[][] buckets = new int[bucketCount][0];
        for (int i = 0; i < arr.length; i++) {
            int index = (int) Math.floor((maxValue - minValue) / bucketsize);
            buckets[index] = arrAppend(buckets[index], arr[i]);
        }
        int arrIndex = 0;
        for (int[] bucket : buckets) {
            if (bucket.length <= 0) {
                continue;
            }
            bucket = insertSort(bucket);
            for (int value : bucket) {
                arr[arrIndex++] = value;
            }
        }
        return arr;
    }
    private static int[] arrAppend(int[] arr,int value) {
        arr = Arrays.copyOf(arr, arr.length + 1);
        arr[arr.length - 1] = value;
        return arr;
    }

    //基数排序
    public static int[] redixSort(int[] sourceArr){
        int[] arr=Arrays.copyOf(sourceArr,sourceArr.length);
        int maxDigit=getMaxDigit(arr);
        return redixSort(arr,maxDigit);
    }
    private static int[] redixSort(int[] arr,int maxDigit) {
        int mod = 10;
        int dev = 1;
        for (int i = 0; i < maxDigit; i++, dev *= 10, mod *= 10) {
            int[][] counter=new int[mod*2][0];
            for(int j=0;j<arr.length;j++) {
                int bucket = ((arr[j] % mod) / dev) + mod;
                counter[bucket]=arrAppend(counter[bucket],arr[j]);
            }
            int pos=0;
            for(int[] bucket:counter){
                for(int value:bucket){
                    arr[pos++]=value;
                }
            }
        }
        return arr;
    }
    /**
     * 获取最高位数
     */
    private static int getMaxDigit(int[] arr){
        int maxValue=getMaxValue(arr);
        return getNumLength(maxValue);
    }
    private static int getMaxValue(int[] arr){
        int maxValue=arr[0];
        for(int value:arr){
            if(maxValue<value)
                maxValue=value;
        }
        return  maxValue;
    }
    protected static int getNumLength(long num){
        if(num==0)
            return 1;
        int lenght=0;
        for(long temp=num;temp!=0;temp/=10){
            lenght++;
        }
        return  lenght;
    }
    //交换方法
    private static void swap(@NotNull int arr[], int a , int b){
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
