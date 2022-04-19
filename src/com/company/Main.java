package com.company;

public class Main {

    public static void main(String[] args) {

        BinarySearchTree test = new BinarySearchTree();


        test.addNode(new Node(9));


        System.out.println(test.root.value);


        test.getRootTotalBalance();

    }
}

