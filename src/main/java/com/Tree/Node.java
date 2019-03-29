package com.Tree;

//定义属节点
public class Node {
    Person person;
    Node leftChild;
    Node rightChild;

    public Node(Person person) {
       this.person.setAge(person.getAge());
        this.person.setName(person.getName());
    }

    public void displayNode() {
        System.out.println("name：" + person.getName() + ",age：" + person.getAge());
    }
}
