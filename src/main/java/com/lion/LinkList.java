package com.lion;

//链表的封装类
public class LinkList {

    private Link first;  //指向链表中的第一个链结点

    public LinkList(){
        first = null;
    }

    //插入到链表的前端
    public void insertFirst(Link link){
        link.next = first;
        first = link;
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
            cur= cur.next;
        }
    }

    //删除属性为指定值的链结点
    public Link delete(int key){
        Link link = null;
        Link cur = first;
        Link next = first.next;
        Link previous = null;
        while(cur.next != null){
            if(cur.age == key){  //找到了要删除的链结点
                link = cur;
                //如果当前链结点的前驱为null，证明当其为链表的第一个链结点，删除该链结点后需要对first属性重新赋值
                if(previous ==null){
                    this.first =next;
                }else{
                    //删除操作，即将前驱的next指针指向当前链结点的next，链表中将去当前链结点这一环
                    previous.next= next;
                }
                break;
            }else if(cur.next ==null){  //当前链结点不是目标且下一个链结点为null，证明没有要删除的链结点
                break;
            }

            //当前链结点不是要删除的目标，则向后继续寻找
            next = next.next;
            cur = cur.next;
            previous = cur;
        }

        return link;
    }

    //查找属性为指定值的链结点
    public Link find(int key){
        Link link = null;
        Link cur = first;
        Link next = first.next;
        //Link previous = null;
        while(cur != null){
            if(cur.age == key){
                link = cur;
                break;
            }else if(next == null){//当前链结点不是要找的目标且下一个链结点为null，则证明没有找到目标
                break;
            }

            //当前链结点不是要找的目标且存在下一个链结点，则向后继续寻找
            //next = next.next;此处源码有问题 next初始值为NULL
            //previous = cur;
            cur = cur.next;
            next=cur;
        }

        return link;
    }

    //判空
    public boolean isEmpty(){
        return (first == null);
    }
}
