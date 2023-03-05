package mg.containers.bag;

import mg.containers.container.AddableContainer;
import mg.containers.container.MutableContainerI;


import java.util.Arrays;
import java.util.Iterator;

public class Bag<T> implements AddableContainer {
    MutableContainerI container;
    public Bag(MutableContainerI _m){container = _m;}

    @Override
    public void add( Object value ) {
        container.add(value);
    }

    @Override
    public boolean isEmpty() {
        return container.isEmpty();
    }

    @Override
    public int size() {
        return container.size();
    }

    @Override
    public Object[] getElements() {
        return Arrays.copyOf(container.getElements(),container.size());
    }

    @Override
    public Iterator iterator() {
        return container.iterator();
    }
}
