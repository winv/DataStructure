package com.lion;

public class DoublelyLinkList {
    private Link first;  //指向链表中的第一个链结点
    private Link last;   //指向链表中的最后一个链结点

    public DoublelyLinkList(){
        first = null;
        last = null;
    }

    //插入到链表的前端
    public void insertFirst(Link link){
        if(isEmpty()){  //如果为空链表，则插入的第一个链结点既是表头也是表尾
            last = link;
        }else{  //如果不是空链表，则将链表的first指针指向该链结点
            first.previous = link;
        }
        link.next = first;
        first = link;
    }

    //插入到链表的末端
    public void insertLast(Link link){
        if(isEmpty()){  //如果为空链表，则插入的第一个链结点既是表头也是表尾
            first = link;
        }else{
            last.next = link;
            link.previous = last;
        }
        last = link;
    }

    //删除第一个链结点，返回删除的链结点引用
    public Link deleteFirst() throws Exception{
        if(isEmpty()){
            throw new Exception("链表为空！不能进行删除操作");
        }
        Link temp = first;
        if(first.next == null){
            last = null;  //如果只有一个链结点，则删除后会影响到last指针
        }else{  //如果至少有两个链结点，则将第二个链结点的previous设为null
            first.next.previous = null;
        }
        first = first.next;
        return temp;
    }

    //删除最后一个链结点，返回删除的链结点引用
    public Link deleteLast() throws Exception{
        if(isEmpty()){
            throw new Exception("链表为空！不能进行删除操作");
        }
        Link temp = last;
        if(last.previous == null){
            first = null;  //如果只有一个链结点，则删除后会影响到first指针
        }else{  //如果至少有两个链结点，则将倒数第二个链结点的next设为null
            last.previous.next = null;
        }
        last = last.previous;
        return temp;
    }

    //查找属性为指定值的链结点
    public Link find(int key){
        Link cur = first;
        while(cur != null &&cur.age != key ){
            if(cur.next == null){
                return null;  //当前链结点不是要找的目标且已到达表尾
            }
            cur = cur.next;
        }

        return cur;
    }

    //在指定链结点之后插入，操作成功返回true，操作失败返回false
    public boolean insertAfter(Link link){
        Link target = find(link.age);
        boolean flag = true;
        if(target == null){  //没找到插入的参照链结点
            flag = false;
        }else{  //找到了插入的参照链结点
            if(target.next == null){ //参照链结点为表尾
                insertLast(link);
            }else { //该链表至少有两个链结点
                target.next.previous= link;
                link.next =target.next;
                //必须执行完上面两步，才能执行下面这两步
                //上面两步处理了link和它下一个链结点的关系
                //下面两步处理了link和它上一个链结点的关系
                target.next = link;
                link.previous =target;
            }
        }

        return flag;
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
