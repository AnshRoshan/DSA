/**
 * DeleteNthLast
 */
public class DeleteNthLast {

    public static void main(String[] args) {
        LinkedList llList = new LinkedList();
        llList.append(29);
        llList.append(30);
        llList.append(31);
        llList.append(32);
        llList.append(33);
        System.out.println(llList.toString());
        Node curr = llList.head;
        int size = 0;
        while (curr != null) {
            size++;
            curr = curr.next;
        }
        System.out.println("The Size of the List--> " + size);

        // deleting code in main
        int delete = 2;
        int index = size - delete - 1;
        System.out.println(index);

        Node operate = llList.head;
        while (index != 0) {
            operate = operate.next;
            index--;
        }
        System.out.println(operate.value);

        Node twoAhead = operate.next.next;
        operate.next = twoAhead;
        System.out.println(twoAhead.value);
    }
}

/**
 * Node
 */
class Node {
    int value;
    Node next;

    Node(int value) {
        this.value = value;
        this.next = null;
    }
}

class LinkedList {
    Node head;

    LinkedList() {
        this.head = null;
    }

    // insert at the end of the list
    void append(int value) {
        Node newNode = new Node(value);
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

    void prepend(int value) {
        Node newNode = new Node(value);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    // @Override
    public String toString() {
        String str = "";
        Node curr = head;
        while (curr != null) {
            str = str + " " + curr.value;
            curr = curr.next;
        }
        return str;
    }
}
