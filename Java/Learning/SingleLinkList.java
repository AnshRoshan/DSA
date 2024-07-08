
// Define the Node class representing each node in the linked list
class Node {
    int data; // Data stored in the node
    Node next; // Reference to the next node in the list

    // Constructor to create a new node with given data
    Node(int data) {
        this.data = data;
        this.next = null; // Initially, the next reference is set to null
    }
}

// Define the LinkedList class to manage the linked list
public class SingleLinkList {
    Node head; // Reference to the first node in the list

    // Constructor to create an empty linked list
    SingleLinkList() {
        this.head = null; // Initially, the head reference is set to null
    }

    // Method to insert a new node at the beginning of the list
    public void insertAtBeginning(int data) {
        Node newNode = new Node(data); // Create a new node
        newNode.next = head; // Set the next reference of the new node to the current head
        head = newNode; // Update the head to point to the new node
    }

    // Method to insert a new node at the end of the list
    public void insertAtEnd(int data) {
        Node newNode = new Node(data); // Create a new node
        if (head == null) {
            head = newNode; // If the list is empty, make the new node as the head
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next; // Traverse the list until the last node
        }
        temp.next = newNode; // Set the next reference of the last node to the new node
    }

    // Method to display the elements of the linked list
    public void display() {
        Node temp = head;
        System.out.print("Linked List: ");
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next; // Move to the next node
        }
        System.out.println();
    }

    // Method to delete a node with a given key from the list
    public void deleteNode(int key) {
        Node temp = head;
        Node prev = null;
        // If the key is found at the head
        if (temp != null && temp.data == key) {
            head = temp.next; // Change the head
            return;
        }
        // Search for the key to be deleted, keeping track of the previous node
        while (temp != null && temp.data != key) {
            prev = temp;
            temp = temp.next;
        }
        // If the key is not present in the list
        if (temp == null) {
            return;
        }
        // Unlink the node from the list
        prev.next = temp.next;
    }

    // Method to reverse the linked list
    public void reverse() {
        Node prev = null;
        Node current = head;
        Node next = null;
        while (current != null) {
            next = current.next; // Store the next node
            current.next = prev; // Reverse the current node's pointer
            prev = current; // Move pointers one position ahead
            current = next;
        }
        head = prev; // Set the head to the last node
    }

    public static void main(String[] args) {
        // Create a new linked list
        SingleLinkList list = new SingleLinkList();

        // Insert elements into the linked list
        list.insertAtEnd(10);
        list.insertAtEnd(20);
        list.insertAtBeginning(5);
        list.insertAtEnd(30);

        // Display the linked list
        list.display(); // Output: Linked List: 5 10 20 30

        // Delete a node from the linked list
        list.deleteNode(20);

        // Display the updated linked list
        list.display(); // Output: Linked List: 5 10 30

        // Reverse the linked list
        list.reverse();

        // Display the reversed linked list
        list.display(); // Output: Linked List: 30 10 5
    }
}
