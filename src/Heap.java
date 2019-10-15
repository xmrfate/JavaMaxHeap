public class Heap {

    private int maxHeap[];
    private int size;
    private int cap;

    Heap(int capacity) {
        maxHeap = new int[capacity];
        size = 0;
        cap = capacity;
    }

    public void init() {
        for(int i=0;i<cap;i++){
            maxHeap[i] = 0;
        }

        size = 0;
    }

    public int get_size() {
        return size;
    }

    public int get_cap() {
        return cap;
    }

    public int get_top() {
        return maxHeap[1];
    }

    public void print_heap() {
        for(int i=1;i<size+1;i++){
            System.out.print(maxHeap[i] + " ");
        }
    }

    private void extra_capacity() {
        cap = cap*2;
        int temp[] = new int[cap];

        //copy array
        System.arraycopy(maxHeap, 0, temp, 0, maxHeap.length);
        maxHeap = temp;
    }

    public void insert(int value) {
        if((size+1) == cap){
            extra_capacity();
        }

        if(size==0){
            maxHeap[size + 1] = value;
            size++;
        } else{
            maxHeap[size + 1] = value;
            int parent = (size+1)/2;

            size++;
            if(maxHeap[size] > maxHeap[parent]){
                heapUp();
            }
        }

        //size++;
    }

    public void extract_max() {
        maxHeap[1] = maxHeap[size];
        maxHeap[size] = 0;
        size--;

        heapDown(1);
    }

    private void swap(int a, int b) {
        int temp;

        temp = maxHeap[a];
        maxHeap[a] = maxHeap[b];
        maxHeap[b] = temp;
    }

    private void heapUp() {
        int current_pos = size;
        int parent = (size+1) / 2;
        int a, b;

        while(maxHeap[current_pos] > maxHeap[parent]){
            a = current_pos;
            b = parent;

            swap(a, b);

            current_pos = parent;
            parent  = (current_pos+1) / 2;
        }
    }

    private void heapDown(int n) {
        int largest = n;
        int left = 2*n;
        int right = (2*n) + 1;

        if(left <= maxHeap.length && maxHeap[left] > maxHeap[largest]){
            largest = left;
        }

        if(right <= maxHeap.length && maxHeap[right] > maxHeap[largest]){
            largest = right;
        }

        if(largest != n){
            swap(n, largest);
            heapDown(largest);
        }
    }
}
