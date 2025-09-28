//designing a stack with increment operaation
class CustomStack
 {
    private int[] stack;
    private int[] inc;
    private int size; 
    private int maxSize;

    public CustomStack(int maxSize) 
    {
        this.maxSize = maxSize;
        this.stack = new int[maxSize];
        this.inc = new int[maxSize];
        this.size = 0;
    }
    public void push(int x) 
    {
        if (size < maxSize) 
        {
            stack[size] = x;
            inc[size] = 0;
            size++;
        }
    }
    public int pop() 
    {
        if (size == 0) 
        {
            return -1;
        }
        int i = size - 1;
        int res = stack[i] + inc[i];
        if (i > 0) 
        {
            inc[i - 1] += inc[i];
        }
        size--;
        return res;
    }
    public void increment(int k, int val) 
    {
        if (size == 0) return;
        int i = Math.min(k, size) - 1;
        inc[i] += val;
    }
}
