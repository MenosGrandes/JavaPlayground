package mg.containers.array;

import mg.containers.container.SortableContainerI;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Array<T> implements SortableContainerI<T> {
    private int size = 0;
    private static final int DEFAULT_CAPACITY = 10;
    private int capacity = DEFAULT_CAPACITY;
    private Object elements[];
    public Object[] getElements()
    {
        return elements;
    }

    public Array() {
        elements = new Object[capacity];
    }

    @Override
    public void add(T e) {
        if (size == elements.length) {
            enlarge();
        }
        elements[size++] = e;
    }

    @Override
    public void set( int position, T value ) {
        if (position>= elements.length || position <0) {
            throw new IndexOutOfBoundsException("Index: " + position + ", Size " + position );
        }
        elements[position] = value;
    }

    public int getCapacity()
    {
        return capacity;
    }

    public boolean isEmpty()
    {
        return elements.length==0;
    }

    @Override
    public int size() {
        return elements.length;
    }

    private void enlarge() {
        int newSize = elements.length * 2;
        elements = Arrays.copyOf(elements, newSize);
        capacity = newSize;
    }
    @Override
    public T get(int i) {
        if (i>= elements.length || i <0) {
            throw new IndexOutOfBoundsException("Index: " + i + ", Size " + i );
        }
        return (T) elements[i];
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayIterator(elements);
    }
    public  class ArrayIterator implements Iterator<T> {
        private final Object[] _array;

        private int internal_size = 0;

        public ArrayIterator(Object[] array) {
            _array = array;
        }


        public boolean hasNext()  {
            return internal_size < elements.length;
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return (T) _array[internal_size++];
        }
    }
}