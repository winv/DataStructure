package com.lion;

//链结点的封装类
public class Link {

    public int age;
    public String name;
    public Link next;  //指向该链结点的下一个链结点
    public Link previous;

    //构造方法
    public Link(int age,String name){
        this.age = age;
        this.name = name;
    }

    //打印该链结点的信息
    public void displayLink(){
        System.out.println("name:"+name+",age:"+age);
    }
}




