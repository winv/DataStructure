package com.lion;

public class DoubleLink {

    private int age;
    private String name;
    private DoubleLink next;  //指向下一个链结点
    private DoubleLink previous;  //指向前一个链结点

    //构造方法
    public DoubleLink(int age, String name) {
        this.age = age;
        this.name = name;
    }

    //打印该链结点的信息
    public void displayLink() {
        System.out.println("name:" + name + ",age:" + age);
    }
}
