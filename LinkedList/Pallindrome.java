/**
 * Pallindrome : Check if the Linklist is Pallindrome
 */
public class Pallindrome {

    static class Node {
        int value;
        Node next;

        Node(int value) {
            this.value = value;
            this.next = null;
        }
    }

    static class LinkedList {
        Node head;

        LinkedList() {
            this.head = null;
        }

        void append(int data) {
            Node newnode = new Node(data);
            if (head == null) {
                head = newnode;
            } else {
                Node curr = head;
                while (curr.next != null) {
                    curr = curr.next;
                }
                curr.next = newnode;
            }
        }

        void reverse() {
            Node prev = null;
            Node curr = head;
            Node ahead = curr.next;
            while (ahead != null) {
                curr.next = prev;
                prev = curr;
                curr = ahead;
                ahead = ahead.next;
            }
            // this is necessary at one edge case is left
            curr.next = prev;
            head = curr;
        }

        @Override
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

    public static void main(String[] args) {
        LinkedList llList = new LinkedList();
        llList.append(10);
        llList.append(20);
        llList.append(20);
        llList.append(10);
        System.out.println(llList);
        llList.reverse();
        System.out.println(llList);
        Node mid = findMid(llList.head);
        System.out.println(mid.value);
        Node tail = secondHead(mid);
        System.out.println(tail.value);
        boolean flag = true;
        Node head = llList.head;
        while (head != mid.next) {
            if (head.value != tail.value) {
                flag = false;
                break;
            }
            head = head.next;
            tail = tail.next;
        }
        if (flag)
            System.out.println("The LinkedList is Pallindrome");
        else
            System.out.println("The LinkedList is Not a Pallindrome");
    }

    static Node findMid(Node head) {
        Node temp = head;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        // int mid = (int) Math.ceil(count / 2);
        int mid = (count) / 2 - 1;
        temp = head;
        while (mid > 0) {
            temp = temp.next;
            mid--;
        }
        return temp;
    }

    static Node secondHead(Node mid) {
        Node prev = null;
        Node curr = mid;
        while (curr != null) {
            Node ahead = curr.next;
            curr.next = prev;
            prev = curr;
            curr = ahead;
        }
        return prev;
    }
}
