package com;

import com.lion.*;
import org.omg.CORBA.INTERNAL;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class main {
    public static void main(String[] args) throws Exception {

        System.out.println("");
        int[] sourceArr = {11, 9, 8, 7, 6, 5, 4, 3, 2, 1};

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
        //ArraySort.printArray(ArraySort.quickSort(sourceArr));
        //ArraySort.printArray(ArraySort.heapSort(sourceArr));
        //ArraySort.printArray(ArraySort.countingSort(sourceArr,11));
        //ArraySort.printArray(ArraySort.bucketSorts(sourceArr));
        //ArraySort.printArray(ArraySort.redixSort(sourceArr));

        //链表操作
        Link link = new Link(1, "lee");
        LinkList ll = new LinkList();
        ll.insertFirst(link);
        ll.insertFirst(new Link(2, "lee2"));
        ll.insertFirst(new Link(3, "lee3"));

        Link findlink = ll.find(2);
        ll.displayList();
        System.out.println(findlink.age);

        DoublelyLinkList dll = new DoublelyLinkList();
        dll.insertFirst(new Link(1, "lee"));
        dll.insertFirst(new Link(2, "lee2"));
        dll.insertFirst(new Link(3, "lee3"));
        dll.insertLast(new Link(4, "lee4"));
        boolean result = dll.insertAfter(new Link(4, "lee5"));
        dll.displayList();
        System.out.println(result);

        //写入有序链表
        SortedLinkList sortedLinkList = new SortedLinkList();
        sortedLinkList.insert(new Link(13, "lee13"));
        sortedLinkList.insert(new Link(12, "lee12"));
        sortedLinkList.insert(new Link(3, "lee3"));
        sortedLinkList.insert(new Link(4, "lee4"));
        sortedLinkList.displayList();

        //写入有序链表
        DoubleEndList doubleEndList = new DoubleEndList();
        doubleEndList.insertFirst(new Link(13, "lee13"));
        doubleEndList.insertFirst(new Link(12, "lee12"));
        doubleEndList.insertLast(new Link(4, "lee4"));
        doubleEndList.insertLast(new Link(3, "lee3"));
        doubleEndList.displayList();

        //System.out.println("输入需要检测的字符串：");
        //String str = getString();
        //BrecketChecker checker = new BrecketChecker(str);
        //checker.check();

        Stack stack = new Stack(5);
        for (int i = 0; i <= 5; i++) {
            stack.push(i);
        }
        for (int i = 0; i < 5; i++) {
            System.out.println(stack.pop());
        }

        Queue queue=new Queue(5);
        for (int i = 0; i < 5; i++) queue.insert(i);
        for (int i = 0; i < 5; i++) {
            System.out.println(queue.pop());
        }
    }

    public static String getString(){
        String str = "";
        try{
            InputStreamReader reader =new InputStreamReader(System.in);
            BufferedReader bReader = new BufferedReader(reader);
            str = bReader.readLine();
        }catch(IOException e){
            e.printStackTrace();
        }
        return str;
    }
}
