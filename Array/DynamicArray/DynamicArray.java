/**
 * This is a Array class to show how to build a Array data structure.
 * 
 * Generic types. Dynamic array. 
 */
public class DynamicArray<T> {
    private int size;  // number of element
    private T[] array;

    public DynamicArray(int capacity) {
        size = 0;
        // Because of Type Erasure, and here is non-bound type
        array = (T[])new Object[capacity];
    }

    public DynamicArray() {
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

    // Bad style, in real situation do not throw RuntimeException
    public void add(int index, T e) throws ArrayIndexOutOfBoundsException, ArrayStoreException
    {
        // Check whether index valid or not
        if (index < 0 || index > size) {
            throw new ArrayIndexOutOfBoundsException("Invalid index at Add!");
        }

        // Check if array is full
        if (size == array.length) {
            resize();
        } 

        // Move elements at index and after it to right
        for (int i = size; i > index; i--) {
            array[i] = array[i-1];
        }
        
        // Add new element
        array[index] = e;
        // Increase size
        size++;
    }

    public T delete(int index)
    {
        if (index < 0 || index >= size - 1) {
            throw new ArrayIndexOutOfBoundsException("Invalid index at Add!");
        }

        T deleted = array[index];

        for (int i = index; i < size; i++) {
            array[i] = array[i+1];
        }

        size--;
        if (size == array.length / 4) {
            resize();
        }

        return deleted;
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

    private void resize() {
        int capacity;
        if (size == array.length) {
            capacity = array.length * 2;            
        } else {
            capacity = array.length / 2;
        }

        T[] tmp = (T[])new Object[capacity];

        for (int i = 0; i < size; i++) {
            tmp[i] = array[i];
        }

        array = tmp;
        tmp = null;
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