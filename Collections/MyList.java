import java.util.ArrayList;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * MyList
 */
public class MyList {

    static class Student {
        int rollno;
        String name;

        Student(int rollno, String name) {
            this.name = name;
            this.rollno = rollno;
        }

        @Override
        public String toString() {
            return this.name;
        }
    }

    public static void main(String[] args) {

        // List<Integer> list = new ArrayList<Integer>();
        List<Integer> list = new LinkedList<>();
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(8);
        list.add(11);
        // it add 89 at 1 index
        list.add(1, 89);
        System.out.println(list);
        list.remove(Integer.valueOf(8));
        System.out.println(list);
        try {
            list.remove(7);
        } catch (Exception e) {
            e.printStackTrace();
        }
        list.remove(1);
        System.out.println(list);
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.contains(11));
        System.out.println("Setting at O index -->" + list.set(0, 21));
        System.out.println("the element at o index ->" + list.get(0));

        // normal iterator
        Iterator<Integer> itr = list.iterator();
        System.out.print("[ ");
        while (itr.hasNext()) {
            System.out.print(itr.next() + " , ");
        }
        System.out.println(" ]");

        // List iterator
        ListIterator<Integer> listitr = list.listIterator();
        System.out.print("[ ");
        while (listitr.hasNext()) {
            System.out.print(listitr.next() + " , ");
            // it can go back also
            System.out.print(listitr.previous() + " , ");
            listitr.next();
        }
        System.out.println(" ]");

        list.sort(new Comparator<Integer>() {
            public int compare(Integer A, Integer B) {
                return A - B;
            }
        });
        System.out.println(list);
        List<Student> students = new ArrayList<Student>();
        students.add(new Student(17, "Satyam"));
        students.add(new Student(11, "Ansh"));
        students.add(new Student(11, "Alpha"));
        students.add(new Student(17, "Sumanjeet"));

        students.sort(new Comparator<Student>() {
            public int compare(Student A, Student B) {
                // return B.rollno - A.rollno;
                int res = B.rollno - A.rollno;
                if (res == 0) {
                    return B.name.compareToIgnoreCase(A.name);
                }
                return res;
            }
        });
        System.out.println(students);
    }
}
