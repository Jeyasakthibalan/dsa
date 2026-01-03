package org.example;

public class BinaryTreeImpl {
    public static void main(String[] args) {
        BinaryTree root = new BinaryTree();
        root.insertNode(5);
        root.insertNode(1);
        root.insertNode(4);
        root.insertNode(10);
        root.insertNode(8);
        root.printTree(root.root);
    }
}

class BinaryTree {
    Node root;

    public BinaryTree() {
        this.root = new Node();
    }

    public boolean insertNode(int val) {
        Node temp = root;
        if (temp == null) {
            temp = new Node(val);
            return true;
        }
        while (temp != null) {
            if (val > temp.val) {
                temp = temp.right;
                if (temp == null) {
                    temp = new Node(val);
                    break;
                }
            } else if (val < temp.val) {
                temp = temp.left;
                if (temp == null) {
                    temp = new Node(val);
                    break;
                }
            }
        }
        return true;
    }

    public void printTree(Node root) {
        printTree(root.left);
        System.out.println(root.val);
        printTree(root.right);
    }

}

class Node {
    int val;
    Node left;
    Node right;

    public Node() {
    }

    ;

    public Node(int val) {
        this.val = val;
    }
}
