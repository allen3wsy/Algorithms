package interviewFLGT;

public interface Sequence<T> {
    void add(T o);   // add to the end of the 
    T get(int index);  // what if the index is not valid? return null  (either way)
    int size();
    boolean remove(T o); // 
}