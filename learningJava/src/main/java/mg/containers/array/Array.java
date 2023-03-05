package mg.containers.array;

import mg.containers.container.SortableContainerI;

import java.util.Arrays;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Array<T> implements SortableContainerI<T> {
    private int size = 0;
    private int capacity = DEFAULT_CAPACITY;

    private static final int DEFAULT_CAPACITY = 10;

    private Object elements[];
    public Object[] getElements()
    {
        return Arrays.copyOf( elements, size);

    }

    public Array() {

        elements = new Object[capacity];


    }
    public Array(Object[] t) {

        elements = Arrays.copyOf( t,t.length );
        size = t.length;

    }
    public Array(int _capacity) {elements = new Object[_capacity]; }

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
        return size==0;
    }

    @Override
    public int size() {
        return size;
    }

    private void enlarge() {
        System.out.println("ENLARGE FROM" + elements.length + " TO" + elements.length*2);
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
        return new ArrayIterator(elements, size);
    }
    public  class ArrayIterator implements Iterator<T> {
        private final Object[] array;
        private int size = 0;

        private int internal_size = 0;

        public ArrayIterator(Object[] _array, int _size) {
            array = _array;
            size = _size;
        }


        public boolean hasNext()  {
            return internal_size < size;
        }

        public T next() {
            if (!hasNext()) throw new NoSuchElementException();
            return (T) array[internal_size++];
        }
    }
}