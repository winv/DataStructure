package com.lion;

//有序链表
public class SortedLinkList {
    private Link first;  //指向链表中的第一个链结点

    public SortedLinkList(){
        first = null;
    }

    //插入
    public void insert(Link link){
        Link previous = null;
        Link cur = first;
        while(cur != null &&link.age>cur.age) {  //链表由大到小排列
            previous = cur;
            cur = cur.next;
        }

        if(previous == null){  //如果previous为null，则证明当前链结点为表头
            this.first = link;
        }else{
            previous.next = link;
        }

        link.next = cur;

    }

    //删除第一个链结点，返回删除的链结点引用
    public Link deleteFirst() throws Exception{
        if(isEmpty()){
            throw new Exception("链表为空！不能进行删除操作");
        }
        Link temp = first;
        first = first.next;
        return temp;
    }

    //打印出所有的链表元素
    public void displayList(){
        Link cur = first;
        while(cur != null){  //循环打印每个链结点
            cur.displayLink();
            cur = cur.next;
        }
    }

    //判空
    public boolean isEmpty(){
        return (first == null);
    }
}
