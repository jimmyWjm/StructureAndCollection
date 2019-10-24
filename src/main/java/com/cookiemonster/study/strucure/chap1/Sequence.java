package com.cookiemonster.study.strucure.chap1;

public class Sequence {
    protected  Integer[] data;
    //元素个数而非数组大小
    protected  int size = 0;

    public Sequence(int n) throws IllegalArgumentException{
        if(n<=0) throw new IllegalArgumentException("数组长度应该为正");
        else{
            data = new Integer[n];
        }
    }

    public int size(){
        return  size;
    }

    //插入
    public void append(Integer anInt) throws IllegalStateException{
        if(data.length == size){
            throw new IllegalStateException("数组已满");
        }else{
            data[size] = anInt;
            size++;
        }
    }

    public Integer get(int k) throws IndexOutOfBoundsException{
        if (size - 1 < k){
            throw  new IndexOutOfBoundsException("数组越界");
        }else {
            return  data[k];
        }
    }

    public void set(int k,Integer newInt) throws IndexOutOfBoundsException{
        if (size - 1 < k){
            throw  new IndexOutOfBoundsException("数组越界");
        }else {
            data[k] = newInt;
        }
    }

}
