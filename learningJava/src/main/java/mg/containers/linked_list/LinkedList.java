package mg.containers.linked_list;

import mg.containers.container.MutableContainerI;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedList<T> implements MutableContainerI<T> {
    private Node<T> first;    // beginning of bag
    protected int size = 0;
    public LinkedList() {
        first = null;
         size = 0;
    }
    private static class Node<T> {
        private T item;
        private Node<T> next;
    }
    @Override
    public void add( T value ) {
        Node<T> oldfirst = first;
        first = new Node<T>();
        first.item = (T) value;
        first.next = oldfirst;
        size++;
    }

    @Override
    public boolean isEmpty() {
        return first == null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object[] getElements() {
        return new Object[0];
    }

    @Override
    public void set( int position, T value ) {

    }

    public Iterator<T> iterator()  {
        return new LinkedIterator(first);
    }

    private class LinkedIterator implements Iterator<T> {
        private Node<T> current;

        public LinkedIterator( Node<T> first) {
            current = first;
        }

        public boolean hasNext()  {
            return current != null;
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            T item = current.item;
            current = current.next;
            return item;
        }
    }


}

