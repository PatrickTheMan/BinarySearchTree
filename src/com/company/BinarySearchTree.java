package com.company;

public class BinarySearchTree {

    public Node root;

    public BinarySearchTree(){}

    public void addNode(Node newNode){

        if (root == null){
            root = newNode;
        }

        // Check if it should check/add to the left or right side node
        if (newNode.value > root.value){

            // If the rightside node ...
            if (root.right != null){
                // ... isn't null, then the method will be replayed
                repeatAddNode(newNode,root.right);
            } else {
                // ... is null, then the node is added
                root.right=newNode;
            }

        } else {

            // If the leftside node ...
            if (root.left != null){
                // ... isn't null, then the method will be replayed
                repeatAddNode(newNode,root.left);
            } else {
                // ... is null, then the node is added
                root.left=newNode;
            }

        }

    }

    private void repeatAddNode(Node newNode, Node rootNode){

        if (root == null){
            root = newNode;
        }

        // Check if it should check/add to the left or right side node
        if (newNode.value > rootNode.value){

            // If the rightside node ...
            if (rootNode.right != null){
                // ... isn't null, then the method will be replayed
                repeatAddNode(newNode,rootNode.right);
            } else {
                // ... is null, then the node is added
                rootNode.right=newNode;
            }

        } else {

            // If the leftside node ...
            if (rootNode.left != null){
                // ... isn't null, then the method will be replayed
                repeatAddNode(newNode,rootNode.left);
            } else {
                // ... is null, then the node is added
                rootNode.left=newNode;
            }

        }

    }

    public Node getNode(int value){

        // Check if it should check/add to the left or right side node
        if (value > root.value){

            // If the rightside node ...
            if (root.right != null){
                // ... isn't null, then the method will be replayed
                repeatGetNode(value,root.right);
            } else {
                // ... is null, then the node is added
                return root;
            }

        } else {

            // If the leftside node ...
            if (root.left != null){
                // ... isn't null, then the method will be replayed
                repeatGetNode(value,root.left);
            } else {
                // ... is null, then the node is added
                return root;
            }

        }

        return null;
    }

    private Node repeatGetNode(int value, Node rootNode){

        // Check if the node has the search
        if (value == rootNode.value){
            return rootNode;
        }

        // Check if it should check/add to the left or right side node
        if (value > rootNode.value){

            // If the rightside node ...
            if (rootNode.right != null){
                // ... isn't null, then the method will be replayed
                repeatGetNode(value,rootNode.right);
            } else {
                // ... is null, then the node is found
               return rootNode;
            }

        } else {

            // If the leftside node ...
            if (rootNode.left != null){
                // ... isn't null, then the method will be replayed
                repeatGetNode(value,rootNode.left);
            } else {
                // ... is null, then the node is added
                return rootNode;
            }

        }

        return null;
    }

    public float getRootTotalBalance(){
        return root.getTotalBalance();
    }

    private Node search(){

        return null;
    }


    public void clear(){
        //set children of root to null
    }

}

class Node{

    int value;
    Node left;
    Node right;

    Node(int value) {
        this.value = value;
        right = null;
        left = null;
    }


    /**
     * this method calculates the balance of a tree structure considering the balance of all nodes through recursion
     * 0 = not balanced at all, 1 = perfectly balanced
     * @return balance
     */
    public float getTotalBalance (){

        //size -1 to get the size of all children but not this node
        int size = this.getSize() - 1;
        double halveSize = 0.5 * size;
        double totalbalance, balanceR, balanceL;
        int sizeL;

        //finds the ratio between size on the left size and halve of the total size

        if(left != null) {
            sizeL = left.getSize();
        } else {
            sizeL = 0;
        }
        double balance = sizeL / halveSize;

        //convert balance to have it output a range from 0 (unbalanced) to 1 (perfectly balanced)
        balance = Math.abs( (balance - 0.5) * 2 );


        //get balance from left node
        if (left != null){
            balanceL = left.getTotalBalance();
        } else {
            balanceL = 1;
        }

        //get balance from right node
        if (right != null){
            balanceR = right.getTotalBalance();
        } else {
            balanceR = 1;
        }

        //calculate total balance
        totalbalance = balanceR * balanceL * balance;


        return (float) totalbalance;
    }

    /**
     * this method calculates the balance for this node
     * 0 = not balanced at all, 1 = perfectly balanced
     * @return
     */
    public float getBalance (){

        //size -1 to get the size of all children but not this node
        int size = this.getSize() - 1;
        double halveSize = 0.5 * size;
        int sizeL;

        //finds the ratio between size on the left size and halve of the total size

        if(left != null) {
            sizeL = left.getSize();
        } else {
            sizeL = 0;
        }
        double balance = sizeL / halveSize;

        //convert balance to have it output a range from 0 (unbalanced) to 1 (perfectly balanced)
        balance = Math.abs( (balance - 0.5) * 2 );



        return (float) balance;
    }


    /**
     * this method calculates the size (the number of nodes belonging to it)
     * @return size
     */
    public int getSize (){

        int size;
        int sizeR, sizeL;

        //get size of left node
        if (left != null){
            sizeL = left.getSize();
        } else {
            sizeL = 0;
        }

        //get size of right node
        if (right != null){
            sizeR = right.getSize();
        } else {
            sizeR = 0;
        }

        //calculate sum of sizes
        size = sizeL + sizeR + 1;

        return size;
    }

}
