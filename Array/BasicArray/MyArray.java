/**
 * This is a Array class to show how to build a Array data structure.
 * 
 * We will try to build a single int type array first then make it working with
 * Generic types.
 * Finally make it a dynamic array. 
 */
public class MyArray {
    private int size;  // number of element
    private int[] array;

    public MyArray(int capacity) {
        this.size = 0;
        array = new int[capacity];
    }

    public MyArray() {
        this(10);
    }

    public int getCapacity()
    {
        return array.length;
    }

    public int getSize()
    {
        return size;
    }

    public boolean isEmpty()
    {
        return size == 0;
    }

    // bad style, in real situation do not throw RuntimeException
    public void add(int index, int e) throws ArrayIndexOutOfBoundsException, ArrayStoreException
    {
        // check whether index valid or not
        if (index < 0 || index >= array.length) {
            throw new ArrayIndexOutOfBoundsException("Invalid index at Add!");
        }

        // check if array is full
        if (size == array.length) throw new ArrayStoreException("Array is full");

        // move elements at index and after it to right
        for (int i = size; i > index; i--) {
            array[i] = array[i-1];
        }
        
        // add new element
        array[index] = e;
        // increase size
        size++;
    }

    public void addLast(int e)
    {
        add(size, e);
    }

    public void addFirst(int e) {
        add(0, e);
    }

    @Override
    public String toString()
    {
        StringBuilder ret = new StringBuilder();
        ret.append(String.format("Array: size = %d, capacity = %d\n", size, array.length));
        ret.append("[");

        for (int i = 0; i < size - 1; i++) {
            ret.append(array[i]);
            ret.append(", ");
        }
        if (size != 0) {
            ret.append(array[size-1]);
        } 
        ret.append("]");

        return ret.toString();
    }
}