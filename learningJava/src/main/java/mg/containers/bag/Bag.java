package mg.containers.bag;

import java.util.Iterator;

public interface Bag<T> {
    public boolean isEmpty();
    public int size();
    public void add(T t);
}
