## AVL Trees in Java

### Theory

**AVL Tree Definition**: An AVL (Adelson-Velsky and Landis) tree is a self-balancing binary search tree (BST). It maintains its height to be logarithmic in the number of nodes, ensuring operations like insertion, deletion, and search are efficient.

**Balancing Factor**: For every node in an AVL tree, the height difference between the left and right subtrees (known as the balance factor) can be at most 1. Formally, for any node `N`:
\[ \text{balance\_factor}(N) = \text{height}(\text{left\_subtree}) - \text{height}(\text{right\_subtree}) \]

**Rotations**: When an insertion or deletion operation causes the balance factor to be out of range \([-1, 0, 1]\), the tree needs to be rebalanced. This is done through rotations:
1. **Right Rotation (LL Rotation)**: Used when the left subtree is taller.
2. **Left Rotation (RR Rotation)**: Used when the right subtree is taller.
3. **Left-Right Rotation (LR Rotation)**: Combination of left and right rotation.
4. **Right-Left Rotation (RL Rotation)**: Combination of right and left rotation.

### Code Implementation

Here's a complete implementation of an AVL tree in Java, including node definition, insertion, rotations, and utility functions for balancing.

```java
class AVLTree {

    class Node {
        int key, height;
        Node left, right;

        Node(int d) {
            key = d;
            height = 1;
        }
    }

   

```java
    private Node root;

    // Function to get the height of the tree
    int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // Function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Right rotate subtree rooted with y
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left rotate subtree rooted with x
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get balance factor of node N
    int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    // Insert a key in the subtree rooted with node and returns the new root of the subtree
    Node insert(Node node, int key) {
        // Perform the normal BST insertion
        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;

        // Update height of this ancestor node
        node.height = 1 + max(height(node.left), height(node.right));

        // Get the balance factor of this ancestor node to check whether this node became unbalanced
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the (unchanged) node pointer
        return node;
    }

    // Utility function to print preorder traversal of the tree
    // The function also prints height of every node
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Public wrapper for insert function
    public void insert(int key) {
        root = insert(root, key);
    }

    // Public wrapper for preOrder function
    public void preOrder() {
        preOrder(root);
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        /* The constructed AVL Tree would be
                30
               /  \
             20   40
            /  \     \
           10  25    50
        */
        System.out.println("Preorder traversal of constructed tree is : ");
        tree.preOrder();
    }
}
```

### Explanation

1. **Node Class**: This class represents each node in the AVL tree. Each node has a key, height, and pointers to its left and right children.

2. **Height Calculation**: The height of a node is the maximum height of its left or right subtree plus one.

3. **Rotations**: 
   - **Right Rotation**: Promotes the left child and demotes the root.
   - **Left Rotation**: Promotes the right child and demotes the root.

4. **Balance Factor**: Used to check if a node is balanced. It is the difference between the heights of the left and right subtrees.

5. **Insertion**: Standard BST insertion followed by updating the height and balancing the tree if necessary. This includes handling four cases:
   - Left Left Case
   - Right Right Case
   - Left Right Case
   - Right Left Case

6. **Traversal**: Preorder traversal is used to display the tree.

### Conclusion

This implementation ensures that the AVL tree remains balanced after every insertion, maintaining efficient operations with logarithmic complexity. By understanding and implementing these concepts, you can ensure optimal performance for operations in the AVL tree.## AVL Trees in Java

### Theory

**AVL Tree Definition**: An AVL (Adelson-Velsky and Landis) tree is a self-balancing binary search tree (BST). It maintains its height to be logarithmic in the number of nodes, ensuring operations like insertion, deletion, and search are efficient.

**Balancing Factor**: For every node in an AVL tree, the height difference between the left and right subtrees (known as the balance factor) can be at most 1. Formally, for any node `N`:
\[ \text{balance\_factor}(N) = \text{height}(\text{left\_subtree}) - \text{height}(\text{right\_subtree}) \]

**Rotations**: When an insertion or deletion operation causes the balance factor to be out of range \([-1, 0, 1]\), the tree needs to be rebalanced. This is done through rotations:
1. **Right Rotation (LL Rotation)**: Used when the left subtree is taller.
2. **Left Rotation (RR Rotation)**: Used when the right subtree is taller.
3. **Left-Right Rotation (LR Rotation)**: Combination of left and right rotation.
4. **Right-Left Rotation (RL Rotation)**: Combination of right and left rotation.

### Code Implementation

Here's a complete implementation of an AVL tree in Java, including node definition, insertion, rotations, and utility functions for balancing.

```java
class AVLTree {

    class Node {
        int key, height;
        Node left, right;

        Node(int d) {
            key = d;
            height = 1;
        }
    }

   

    private Node root;

    // Function to get the height of the tree
    int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    // Function to get maximum of two integers
    int max(int a, int b) {
        return (a > b) ? a : b;
    }

    // Right rotate subtree rooted with y
    Node rightRotate(Node y) {
        Node x = y.left;
        Node T2 = x.right;

        // Perform rotation
        x.right = y;
        y.left = T2;

        // Update heights
        y.height = max(height(y.left), height(y.right)) + 1;
        x.height = max(height(x.left), height(x.right)) + 1;

        // Return new root
        return x;
    }

    // Left rotate subtree rooted with x
    Node leftRotate(Node x) {
        Node y = x.right;
        Node T2 = y.left;

        // Perform rotation
        y.left = x;
        x.right = T2;

        // Update heights
        x.height = max(height(x.left), height(x.right)) + 1;
        y.height = max(height(y.left), height(y.right)) + 1;

        // Return new root
        return y;
    }

    // Get balance factor of node N
    int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    // Insert a key in the subtree rooted with node and returns the new root of the subtree
    Node insert(Node node, int key) {
        // Perform the normal BST insertion
        if (node == null)
            return new Node(key);

        if (key < node.key)
            node.left = insert(node.left, key);
        else if (key > node.key)
            node.right = insert(node.right, key);
        else // Duplicate keys not allowed
            return node;

        // Update height of this ancestor node
        node.height = 1 + max(height(node.left), height(node.right));

        // Get the balance factor of this ancestor node to check whether this node became unbalanced
        int balance = getBalance(node);

        // If this node becomes unbalanced, then there are 4 cases

        // Left Left Case
        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        // Right Right Case
        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        // Left Right Case
        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        // Right Left Case
        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        // Return the (unchanged) node pointer
        return node;
    }

    // Utility function to print preorder traversal of the tree
    // The function also prints height of every node
    void preOrder(Node node) {
        if (node != null) {
            System.out.print(node.key + " ");
            preOrder(node.left);
            preOrder(node.right);
        }
    }

    // Public wrapper for insert function
    public void insert(int key) {
        root = insert(root, key);
    }

    // Public wrapper for preOrder function
    public void preOrder() {
        preOrder(root);
    }

    public static void main(String[] args) {
        AVLTree tree = new AVLTree();

        /* Constructing tree given in the above figure */
        tree.insert(10);
        tree.insert(20);
        tree.insert(30);
        tree.insert(40);
        tree.insert(50);
        tree.insert(25);

        /* The constructed AVL Tree would be
                30
               /  \
             20   40
            /  \     \
           10  25    50
        */
        System.out.println("Preorder traversal of constructed tree is : ");
        tree.preOrder();
    }
}
```

### Explanation

1. **Node Class**: This class represents each node in the AVL tree. Each node has a key, height, and pointers to its left and right children.

2. **Height Calculation**: The height of a node is the maximum height of its left or right subtree plus one.

3. **Rotations**: 
   - **Right Rotation**: Promotes the left child and demotes the root.
   - **Left Rotation**: Promotes the right child and demotes the root.

4. **Balance Factor**: Used to check if a node is balanced. It is the difference between the heights of the left and right subtrees.

5. **Insertion**: Standard BST insertion followed by updating the height and balancing the tree if necessary. This includes handling four cases:
   - Left Left Case
   - Right Right Case
   - Left Right Case
   - Right Left Case

6. **Traversal**: Preorder traversal is used to display the tree.

### Conclusion

This implementation ensures that the AVL tree remains balanced after every insertion, maintaining efficient operations with logarithmic complexity. By understanding and implementing these concepts, you can ensure optimal performance for operations in the AVL tree.