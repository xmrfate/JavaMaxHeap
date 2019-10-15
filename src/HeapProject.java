public class HeapProject {

    public static void main(String[] args) {
        System.out.println("Hello world");

        Heap myHeap = new Heap(10);

        //initialize heap data structure
        myHeap.init();

        int cap = myHeap.get_cap();
        int size = myHeap.get_size();
        int max;

        System.out.println("Heap capacity: " + cap);
        System.out.println("Heap current size: " + size);

        myHeap.insert(20);
        myHeap.print_heap();

        myHeap.insert(10);
        myHeap.insert(5);
        myHeap.insert(30);
        myHeap.insert(50);
        myHeap.insert(75);
        myHeap.insert(90);

        cap = myHeap.get_cap();
        size = myHeap.get_size();

        System.out.println("\n\nHeap capacity: " + cap);
        System.out.println("Heap current size: " + size);
        myHeap.print_heap();

        max = myHeap.get_top();
        System.out.println("\nMax Heap value: " + max);

        myHeap.extract_max();
        myHeap.print_heap();

        max = myHeap.get_top();
        System.out.println("\nMax Heap value: " + max);
    }
}
