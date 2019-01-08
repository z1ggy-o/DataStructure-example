/**
 * This is a Array class to show how to build a Array data structure.
 * 
 * Generic types.
 * 
 * Finally make it a dynamic array. 
 */
public class GenericArray<T> {
    private int size;  // number of element
    private T[] array;

    public GenericArray(int capacity) {
        size = 0;
        // because of Type Erasure, and here is non-bound type
        array = (T[])new Object[capacity];
    }

    public GenericArray() {
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
    public void add(int index, T e) throws ArrayIndexOutOfBoundsException, ArrayStoreException
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

    public void addLast(T e)
    {
        add(size, e);
    }

    public void addFirst(T e) {
        add(0, e);
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Index out of space.");
        }

        return array[index];
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