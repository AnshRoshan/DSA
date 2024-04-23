package Recursion;

import java.util.Scanner;

class BinaryTreesmine {

    protected static class Node {
        int data;
        Node left;
        Node right;

        protected Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public Node root;

    public void populate(Scanner sc) {
        System.out.println("Enter the root node:");
        String inputData = sc.nextLine();
        if (!inputData.isEmpty()) {
            int data = Integer.parseInt(inputData);
            root = new Node(data);
            populate(root, sc);
        }
    }

    public void populate(Node node, Scanner sc) {
        System.out.println("Enter the left node or leave empty of node - " + node.data);
        String left = sc.nextLine();
        if (!left.isEmpty()) {
            int data = Integer.parseInt(left);
            node.left = new Node(data);
            populate(node.left, sc);
        }

        System.out.println("Enter the Right node or leave empty of node - " + node.data);
        String right = sc.nextLine();
        if (!right.isEmpty()) {
            int data = Integer.parseInt(right);
            node.right = new Node(data);
            populate(node.right, sc);

        }
    }

    // kunal kushwaha code
    // public void populate(Node node, Scanner sc) {
    // System.out.println("Do you want the left node");
    // boolean left = sc.nextBoolean();
    // if (left) {
    // System.out.println("Enter the left node");
    // int data = sc.nextInt();
    // node.left = new Node(data);
    // populate(node.left, sc);
    // }

    // System.out.println("Do you want the right node");
    // boolean right = sc.nextBoolean();
    // if (right) {
    // System.out.println("Enter the right node");
    // int data = sc.nextInt();
    // node.right = new Node(data);
    // populate(node.right, sc);

    // }
    // }

    public void display(Node node) {
        display(node, " ");
    }

    public void display(Node node, String indent) {
        if (node == null) {
            return;

        }
        System.out.println(indent + node.data);
        display(node.left, indent + "\t");
        display(node.right, indent + "\t");
    }

    public void prettyPrintTree(Node node, int space) {
        if (node == null) {
            return;
        }

        prettyPrintTree(node.right, space + 1);
        printSpaces(space);
        System.out.println("|-----> " + node.data);
        prettyPrintTree(node.left, space + 1);
    }

    private void printSpaces(int count) {
        for (int i = 0; i < count; i++) {
            System.out.print("|\t");
        }
    }

}

public class BinaryTreeIntro {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        BinaryTreesmine tree = new BinaryTreesmine();
        tree.populate(sc);
        tree.display(tree.root);
        tree.prettyPrintTree(tree.root, 0);
    }
}
