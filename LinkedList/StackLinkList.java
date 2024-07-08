/**
 * StackLinkList
 */
public class StackLinkList {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

        @Override
        public String toString() {
            return String.valueOf(this.data);
        }

    }

    static class Stack {
        public Node head;

        boolean isEmpty() {
            return head == null;
        }

        void push(int data) {
            Node newNode = new Node(data);
            if (isEmpty())
                head = newNode;
            else {
                newNode.next = head;
                head = newNode;
            }
        }

        Node pop() {
            if (isEmpty())
                return head;
            Node temp = head;
            head = head.next;
            return temp;
        }

    }

    public static void main(String[] args) {
        Stack disk = new Stack();
        disk.push(20);
        disk.push(21);
        disk.push(22);
        disk.push(23);
        System.out.println(disk.pop().data);
        System.out.println(disk.pop());
        System.out.println(disk.pop());
        System.out.println(disk.pop());
        System.out.println(disk.pop());
        System.out.println(disk.pop());

    }
}
