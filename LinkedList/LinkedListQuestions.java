public class LinkedListQuestions {

    static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }

    }

    static class LinkedList {

        Node head;
        Node tail;

        LinkedList() {
            this.head = null;
            this.tail = null;
        }

        void insert(int data) {
            Node newNode = new Node(data);
            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        void display() {
            System.out.println("Call from questions");
            Node move = head;
            while (move != null) {
                System.out.print(move.data + " -> ");
                move = move.next;
            }
            System.out.println("End");
        }

        // Floyd's cycle detection algorithm or "tortoise and hare" algorithm
        // fast and slow pointer , are all same algorithm
        boolean hasCycle() {
            boolean flag = false;
            Node fast = head;
            Node slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (fast == slow) {
                    return true;
                }
            }
            return flag;
        }

        Node startCycle() {
            Node fast = head;
            Node slow = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
                if (fast == slow) {
                    break;
                }
            }
            if (fast == null || fast.next == null) {
                return null;
            }
            // now run then both at same speed
            slow = head;
            while (slow != fast) {
                slow = slow.next;
                fast = fast.next;
            }

            return slow;
        }

        int genHappy(int n) {
            int sum = 0;
            while (n > 0) {
                sum += n % 10;
                n /= 10;
            }
            return sum;
        }

        boolean isHappy(int num) {
            int slow = num;
            int fast = genHappy(num);
            while (fast != 1 && fast != slow) {
                slow = genHappy(num);
                fast = genHappy(genHappy(num));
            }
            return fast == 1;
        }

        Node middleElement() {
            Node slow = head;
            Node fast = head;
            while (fast != null && fast.next != null) {
                slow = slow.next;
                fast = fast.next.next;
            }
            return slow;
        }

        static LinkedList mergeList(LinkedList first, LinkedList sec) {
            LinkedList sol = new LinkedList();
            Node fhead = first.head;
            Node shead = sec.head;
            while (fhead != null && shead != null) {
                if (fhead.data <= shead.data) {
                    sol.insert(fhead.data);
                    fhead = fhead.next;
                } else {
                    sol.insert(shead.data);
                    shead = shead.next;
                }
            }

            // Append remaining nodes from the non-empty list
            if (fhead == null) {
                sol.tail.next = shead;
            }
            if (shead == null) {
                sol.tail.next = fhead;
            }

            return sol;
        }

        Node merge(Node head1, Node head2) {
            Node dumy = new Node(-1);
            Node movHead = dumy;

            // Traverse both lists and merge nodes
            while (head1 != null && head2 != null) {
                if (head1.data <= head2.data) {
                    movHead.next = head1;
                    head1 = head1.next;
                } else {
                    movHead.next = head2;
                    head2 = head2.next;
                }
                movHead = movHead.next;
            }

            // apply the rest of node
            tail.next = (head1 == null) ? head2 : head1;
            return dumy.next;
        }

        Node mergeSort(Node head) {
            // bise
            if (head != null && head.next != null) {
                return head;
            }
            Node mid = middleElement();
            Node left = mergeSort(head);
            Node right = mergeSort(mid);
            return merge(left, right);
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        list.insert(50);
        list.insert(60);
        list.insert(75);
        list.insert(80);
        list.insert(90);
        // list.tail.next = list.head.next;
        System.out.println("The cycle is present " + list.hasCycle());
        if (list.hasCycle()) {
            System.out.println("The Start of the cycle is :- " + list.startCycle().data);
        } else {
            list.display();
            System.out.println("Middle Number :- " + list.middleElement().data);
        }
        System.out.println("Happy Number :- " + list.isHappy(90));
        LinkedList list2 = new LinkedList();
        list2.insert(52);
        list2.insert(55);
        list2.insert(70);
        list2.insert(80);
        list2.insert(85);
        list2.display();
        System.out.println("Merged List :-");
        // list = list.merge(list, list2);
        // list.display();
        LinkedList mergelist = LinkedList.mergeList(list, list2);
        mergelist.display();

    }
}
