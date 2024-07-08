
public class BinarySearchTree {

    public static void main(String[] args) {
        BST tree = new BST();
        tree.populate(new int[] { 5, 2, 7, 1, 4, 9, 8, 3, 10, 6 });
        tree.display();
        System.out.println(tree.isBalanced());
        tree.inorder(tree.getRoot());
        System.out.println();
        tree.preorder(tree.getRoot());
        System.out.println();
        tree.postorder(tree.getRoot());
    }

    // BFS - breadth first search
    // DFS - depth first search
    // BFS is faster than DFS
    // BFT - breadth first traversal
    // DFT - depth first traversal

}

// Binary Search Tree
class BST {

    public class Node {
        private int data;

        public int getData() {
            return data;
        }

        private Node left;
        private Node right;
        private int height;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
            this.height = 1;
        }

    }

    private Node root;

    public Node getRoot() {
        return root;
    }

    public int height(Node node) {
        if (node == null) {
            return -1;
        }
        return node.height;
    }

    public boolean isEmpty() {
        return root == null;
    }

    public void insert(int data) {
        root = insert(data, root);
    }

    private Node insert(int value, Node node) {
        if (node == null) {
            return new Node(value);
        }

        if (value < node.data) {
            node.left = insert(value, node.left);
        } else if (value > node.data) {
            node.right = insert(value, node.right);
        }

        node.height = Math.max(height(node.left), height(node.right)) + 1;
        return node;
    }

    public boolean isBalanced() {
        return isBalanced(root);
    }

    private boolean isBalanced(Node node) {
        if (node == null) {
            return true;
        }
        return (Math.abs(height(node.left) - height(node.right)) <= 1)
                && isBalanced(node.left)
                && isBalanced(node.right);
    }

    public void display() {
        display(root, "Root Node\t: ");
    }

    public void populate(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            insert(nums[i]);
        }
    }

    public void populatedSorted(int[] nums) {
        populatedSorted(nums, 0, nums.length - 1);
    }

    public void populatedSorted(int[] nums, int start, int end) {
        if (start <= end) {
            int mid = start + (end - start) / 2;
            insert(nums[mid]);
            populatedSorted(nums, start, mid - 1);
            populatedSorted(nums, mid + 1, end);
        }
    }

    public void display(Node node, String indent) {
        if (node == null) {
            return;
        }
        System.out.println(indent + node.data);
        display(node.left, "Left of " + node.data + "\t: ");
        display(node.right, "Right of " + node.data + "\t: ");

    }

    // tree preorder traversal
    public void preorder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + "\t");
        preorder(node.left);
        preorder(node.right);
    }

    public void inorder(Node node) {
        if (node == null) {
            return;
        }
        inorder(node.left);
        System.out.print(node.data + "\t");
        inorder(node.right);
    }

    public void postorder(Node node) {
        if (node == null)
            return;
        postorder(node.left);
        postorder(node.right);
        System.out.print(node.data + "\t");
    }

}