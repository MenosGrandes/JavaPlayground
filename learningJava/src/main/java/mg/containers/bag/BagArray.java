package mg.containers.bag;
import mg.containers.array.Array;

import java.util.Iterator;

public class BagArray<Item> extends Bag<Item> {
    private Array<Item> container;
    public BagArray() {
        container = new Array<>();
    }
    public boolean isEmpty() {
        return container.isEmpty();
    }

    public int size() {
        return container.size();
    }

    @Override
    public void add( Object item) {
        container.add( (Item) item );
    }

    public Iterator<Item> iterator()  {
        return container.iterator();
    }


}


