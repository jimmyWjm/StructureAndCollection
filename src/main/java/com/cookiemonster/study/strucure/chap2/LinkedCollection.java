package com.cookiemonster.study.strucure.chap2;

import java.util.Collection;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class LinkedCollection implements Collection {
    protected Entry head;


    //为什么是static
    protected static class Entry{
        Object element;
        Entry next;
        protected Entry(){

        }

        protected Entry(Object element, Entry next){
            this.next = next;
            this.element = element;
        }
    }

    private class LinkedCollectionIterator implements Iterator{
        Entry next;

        public LinkedCollectionIterator() {
            this.next = head;
        }

        @Override
        public boolean hasNext() {
            return next!=null;
        }

        //为了使得theElement 能够调用子类方法，在必要的时候把它转化为object的子类
        @Override
        public Object next() {
            Object theElement = next.element;
            next = next.next;
            return theElement;
        }

        @Override
        public void remove() {

        }
    }

    public LinkedCollection() {
        //写不写都一样
        head = null;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int size() {
        int count = 0;
        for(Entry current = head; current != null; current = current.next){
            count ++;
        }
        return count;
    }

    @Override
    public boolean contains(Object o) {
        for(Entry current = head; current != null; current = current.next){
            if(current.element.equals(o)){
                return  true;
            }
        }
        return false;
    }

    @Override
    public boolean containsAll(Collection c) {
        Iterator iterator = c.iterator();
        while(iterator.hasNext()){
            if(!contains(iterator.next())) return  false;
        }
        return true;
    }

    @Override
    public boolean add(Object o) {
        Entry newEntry = new Entry(o,head);
        head = newEntry;
        return true;
    }

    @Override
    public Iterator iterator() {
        return new LinkedCollectionIterator();
    }

    public Object getFirst() throws NoSuchElementException {
        if(head == null) throw  new NoSuchElementException();
        return head;
    }

    @Override
    public Object[] toArray() {
        int size = size();
        Object[] objects = new Object[size];
        Iterator iterator = iterator();
        int count = 0;
        while(iterator.hasNext()){
            objects[count] = iterator.next();
            count ++;
        }
        return objects;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LinkedCollection)) return false;
        LinkedCollection that = (LinkedCollection) o;
        return Objects.equals(head, that.head);
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection c) {
        return false;
    }

    @Override
    public void clear() {

    }

    @Override
    public boolean retainAll(Collection c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection c) {
        return false;
    }



    @Override
    public Object[] toArray(Object[] a) {
        return new Object[0];
    }


}
