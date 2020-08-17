package org.example.study.array;

import java.util.Arrays;

/**
 * @author lsx
 * @date 2020/8/13 18:29
 */
public class Array {

    private int n = 10;

    private int[] array = new int[n];

    private int size;

    private void checkArgument(int i) {
        if (i < 0 || i >= n) {
            throw new IllegalArgumentException();
        }
    }

    public int get(int i) {
        checkArgument(i);
        return array[i];
    }

    public void update(int i, int value) {
        checkArgument(i);
        array[i] = value;
    }

    public void insert(int i, int value) {
        checkArgument(i);
        if (size == n) {
            resize();
            for (int j = n / 2 - 1; j >= i; j--) {
                array[j + 1] = array[j];
            }
        } else {
            for (int j = n - 2; j >= i; j--) {
                array[j + 1] = array[j];
            }
        }
        array[i] = value;
        size++;
    }

    public int remove(int i) {
        int value = array[i];
        for (int j = i; j < n - 1; j++) {
            array[j] = array[j + 1];
        }
        return value;
    }

    private void resize() {
        int[] newArray = new int[n * 2];
        for (int i = 0; i < n; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
        n *= 2;
    }

    @Override
    public String toString() {
        return "Array{" +
                "n=" + n +
                ", array=" + Arrays.toString(array) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        Array array = new Array();
        array.insert(1, 1);
        array.insert(3, 5);
        array.insert(6, 4);
        array.insert(2, 8);
        array.insert(5, 10);
        System.out.println(array.toString());
        array.remove(1);
        System.out.println(array.toString());
    }
}
