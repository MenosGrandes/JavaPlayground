package mg.containers.bag;
import mg.containers.array.Array;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class BagArray<Item> implements Iterable<Item>, Bag<Item>{
    private Array<Item> container;
    public BagArray() {
        container = new Array<>();
    }
    public boolean isEmpty() {
        return container.isEmpty();
    }

    public int size() {
        return container.getSize();
    }

    public void add(Item item) {
        container.add(item);
    }

    public Iterator<Item> iterator()  {
        return container.iterator();
    }

}


