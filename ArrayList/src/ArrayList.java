import java.util.Iterator;

public class ArrayList<T> implements java.lang.Iterable<T>{

    private Object[] elements;
    private int size;
    private final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public void add(T elem) {
        if(size == elements.length) {
            resize();
        }
        elements[size++] = elem;
    }

    public T get(int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        return (T) elements[index];
    }

    public void remove(int index) {
        if(index < 0 || index >= size) {
            throw new ArrayIndexOutOfBoundsException();
        }
        for (int i = index; i < size - 1; i++) {
            elements[i] = elements[i + 1];
        }
        elements[--size] = null;
    }

    public int size() {
        return size;
    }

    private void resize() {
        Object[] newElements = new Object[elements.length * 2];
        System.arraycopy(elements, 0, newElements, 0, elements.length);
        elements = newElements;
    }

    @Override
    public Iterator<T> iterator() {
        Iterator<T> it = new Iterator<T>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size && elements[currentIndex] != null;
            }

            @Override
            public T next() {
                return (T) elements[currentIndex++];
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}