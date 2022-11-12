package ru.geekbrains;

import java.util.Iterator;

public class MyArrayList<E> implements MyList<E>, Iterable<E> {

    private int size;
    private E[] data;

    public MyArrayList(int initial) {
        if(initial < 0){
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        data = (E[]) new Object[initial];
        size = 0;
    }

    @Override
    public E get(int p) {
        check(p);
        return data[p];
    }

    @Override
    public void add(E element) {
        if( size == data.length){
            E[] tmp = (E[])new Object[size*2+1];
            System.arraycopy(data, 0, tmp, 0, data.length);
            data = tmp;
        }
        data[size] = element;
        size++;
    }

    @Override
    public void insert(int index, E element){
        if( size == data.length){
            E[] tmp = (E[])new Object[size*2+1];
            System.arraycopy(data, 0, tmp, 0, data.length);
            data = tmp;
        }
        for(int i = size-1; i >= index; i--)
            data[i+1] = data[i];

        data[index] = element;
        size++;
    }

    @Override
    public void delete(int p) {
        check(p);
        for(int i = p; i < size-1; i++)
            data[i] = data[i+1];
        --size;
    }

    public void check(int index) {
        if(index < 0 || index > size-1){
            try {
                throw new IndexOutOfBoundsException();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public int size(){
        return size;
    }
    public boolean isEmpty(){
        return size == 0;
    }

    @Override
    public Iterator<E> iterator() {
        Iterator<E> it = new Iterator<E>() {

            private int currentIndex = 0;

            @Override
            public boolean hasNext() {
                return currentIndex < size;
            }

            @Override
            public E next() {
                return get(currentIndex++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
        return it;
    }
}
