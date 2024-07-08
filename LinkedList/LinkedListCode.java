
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        head = null;
    }

    // Insertion at the end of the list
    void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newNode;
        }
    }

    void insertFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // void insertIndex(int data, int index) {
    // insertIndex(data, null, head, index);
    // }

    // void insertIndex(int data, Node prev, Node current, int index) {
    // if (index == 0) {
    // // create node and attach it to that of the linkedList.
    // Node newNode = new Node(data);
    // newNode.next = current;
    // if (prev != null) {
    // prev.next = newNode;
    // } else
    // head = newNode;
    // return;
    // }
    // if (current == null) {
    // return;
    // }
    // insertIndex(data, current, current.next, index - 1);
    // }

    Node insertIndex(int data, int index) {
        return insertIndex(data, index, head);
    }

    Node insertIndex(int data, int index, Node current) {
        if (index == 0) {
            Node newNode = new Node(data);
            newNode.next = current;
            if (current == head)
                head = newNode;
            return newNode;
        }
        current.next = insertIndex(data, index - 1, current.next);
        return current;
    }

    Node replaceIndex(int data, int index) {
        return replaceIndex(data, index, head);
    }

    Node replaceIndex(int data, int index, Node current) {
        if (index == 0) {
            Node newNode = new Node(data);
            if (current == head) {
                newNode.next = head.next;
                head = newNode;
            }
            return newNode;
        }
        current.next = replaceIndex(data, index - 1, current.next);
        return current;
    }

    Node removeDuplicate() {
        return removeDuplicate(head);
    }

    Node removeDuplicate(Node current) {
        // Base case: if the current node or its next node is null, no duplicates to
        // remove
        if (current.next == null) {
            return current;
        }
        if (current.data == removeDuplicate(current.next).data) {
            current.next = current.next.next;
        }
        return current;
    }

    // Deletion by value
    void delete(int data) {
        if (head == null)
            return;

        if (head.data == data) {
            head = head.next;
            return;
        }

        Node temp = head;
        while (temp.next != null) {
            if (temp.next.data == data) {
                temp.next = temp.next.next;
                return;
            }
            temp = temp.next;
        }
    }

    // Traversal
    void display() {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }
}

public class LinkedListCode {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(1);
        list.insert(2);
        list.insert(3);
        list.insert(4);
        list.display(); // Output: 1 2 3 4

        list.delete(3);
        list.display(); // Output: 1 2 4

        list.insertIndex(22, 1);
        list.insertIndex(22, 2);
        list.insertIndex(67, 0);
        list.display();
        list.removeDuplicate();
        list.display();
        list.replaceIndex(66, 2);
        list.replaceIndex(87, 0);
        list.display();
    }
}
