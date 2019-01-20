import java.util.ArrayList;

public class ArrayStack<E> implements Stack<E> {
    ArrayList<E> array;
    
    public ArrayStack(int capacity) {
        array = new ArrayList<>(capacity);
    }

    public ArrayStack()
    {
        array = new ArrayList<>();
    }

    public void push(E item)
    {
        array.add(item);
    }

    public E pop()
    {
        return array.remove(array.size()-1);
    }

    public E top()
    {
        return array.get(array.size()-1);
    }

    public int getSize()
    {
        return array.size();
    }

    public boolean isEmpty()
    {
        return array.isEmpty();
    }

    @Override
    public String toString()
    {
        StringBuilder result = new StringBuilder();
        result.append("Stack: ");
        result.append("[");
        for (int i = 0; i < array.size(); i++) {
            result.append(array.get(i));
            if (i != array.size() -1)
                result.append(", ");
        }
        result.append("] <--");
        return  result.toString();
    }
}
