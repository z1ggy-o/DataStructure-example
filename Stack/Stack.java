public interface Stack<E> {
    void push(E item);
    E pop();
    E top();
    int getSize();
    boolean isEmpty();
} 