package com;

import com.lion.ArraySort;

public class main {
    public static void main(String[] args) {

        System.out.println("");
        int[] sourceArr={10,9,8,7,6,5,4,3,2,1};

        //冒泡 不做任何改进
        //ArraySort.printArray(ArraySort.bubbleSortBase(sourceArr));
        //冒泡 改进内存循环机制
        //ArraySort.printArray(ArraySort.bubbleSort(sourceArr));
        //进阶版，达到最优时间复杂度为0(n) 平均时间复杂度为0(n2)
        //ArraySort.printArray(ArraySort.bubbleSortAdvance(sourceArr));

        //选择排序
        //ArraySort.printArray(ArraySort.selectionSort(sourceArr));

        //ArraySort.printArray(ArraySort.insertSort(sourceArr));
        //ArraySort.printArray(ArraySort.shellSort(sourceArr));
        //ArraySort.printArray(ArraySort.mergeSort(sourceArr));
        ArraySort.printArray(ArraySort.quickSort(sourceArr));

    }
}
