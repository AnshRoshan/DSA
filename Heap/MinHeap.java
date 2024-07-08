import java.util.ArrayList;

public class MinHeap {

    public static void main(String[] args) throws Exception {
        Heap<Integer> heap = new Heap<>();
        heap.insert(22);
        heap.insert(32);
        heap.insert(43);
        heap.insert(12);
        heap.insert(90);
        System.out.println("Heap: " + heap);
        System.out.println("Removed element: " + heap.remove());
        ArrayList<Integer> sortedList = heap.heapSort();
        System.out.println("Sorted list: " + sortedList);
    }

    static class Heap<T extends Comparable<T>> {

        private ArrayList<T> list;

        public Heap() {
            list = new ArrayList<>();
        }

        private void swap(int first, int second) {
            T temp = list.get(first);
            list.set(first, list.get(second));
            list.set(second, temp);
        }

        private int parent(int index) {
            return (index - 1) / 2;
        }

        private int left(int index) {
            return 2 * index + 1;
        }

        private int right(int index) {
            return 2 * index + 2;
        }

        public void insert(T value) {
            list.add(value);
            upheap(list.size() - 1);
        }

        private void upheap(int index) {
            while (index > 0) {
                int p = parent(index);
                if (list.get(index).compareTo(list.get(p)) >= 0) {
                    break;
                }
                swap(index, p);
                index = p;
            }
        }

        public T remove() throws Exception {
            if (list.isEmpty()) {
                throw new Exception("The Heap is already empty");
            }
            T temp = list.get(0);
            T last = list.remove(list.size() - 1);
            if (!list.isEmpty()) {
                list.set(0, last);
                downheap(0);
            }
            return temp;
        }

        private void downheap(int index) {
            int size = list.size();
            while (true) {
                int min = index;
                int left = left(index);
                int right = right(index);

                if (
                    left < size && list.get(left).compareTo(list.get(min)) < 0
                ) {
                    min = left;
                }
                if (
                    right < size && list.get(right).compareTo(list.get(min)) < 0
                ) {
                    min = right;
                }
                if (min == index) {
                    break;
                }
                swap(index, min);
                index = min;
            }
        }

        public ArrayList<T> heapSort() throws Exception {
            ArrayList<T> data = new ArrayList<>();
            while (!list.isEmpty()) {
                data.add(this.remove());
            }
            return data;
        }

        @Override
        public String toString() {
            return list.toString();
        }
    }
}
