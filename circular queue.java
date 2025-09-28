//Circular queue
class MyCircularQueue {
    private int[] q;
    private int head, size, cap;

    public MyCircularQueue(int k) {
        cap = k;
        q = new int[k];
        head = 0;
        size = 0;
    }

    public boolean enQueue(int value) {
        if (isFull()) return false;
        int tail = (head + size) % cap;
        q[tail] = value;
        size++;
        return true;
    }

    public boolean deQueue() {
        if (isEmpty()) return false;
        head = (head + 1) % cap;
        size--;
        return true;
    }

    public int Front() {
        return isEmpty() ? -1 : q[head];
    }

    public int Rear() {
        if (isEmpty()) return -1;
        int tail = (head + size - 1) % cap;
        return q[tail];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == cap;
    }

    public static void main(String[] args) {
        MyCircularQueue cq = new MyCircularQueue(3);

        System.out.println(cq.enQueue(1));
        System.out.println(cq.enQueue(2));
        System.out.println(cq.enQueue(3));
        System.out.println(cq.enQueue(4));

        System.out.println("Rear: " + cq.Rear());
        System.out.println("IsFull: " + cq.isFull());

        System.out.println(cq.deQueue());
        System.out.println(cq.enQueue(4));

        System.out.println("Rear: " + cq.Rear());
        System.out.println("Front: " + cq.Front());
    }
}
