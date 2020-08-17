package org.example.study.array;

/**
 * @author lsx
 * @date 2020/8/14 20:45
 */
public class AlgorithmArray {

    public static void main(String[] args) {
        int[] firstArray = {
                1, 3, 5, 6, 7, 10, 18
        };
        int[] secondArray = {
                2, 4, 6, 9, 10, 13, 15
        };
        int[] newArray = mergeSortedArray(firstArray, secondArray);
        for (int i = 0; i < newArray.length; i++) {
            System.out.println(newArray[i]);
        }
    }

    /**
     * 空间复杂度O(m+n)，时间复杂度O(max(m,n))
     * @param firstArray
     * @param secondArray
     * @return
     */
    private static int[] mergeSortedArray(int[] firstArray, int[] secondArray) {
        int[] mergedArray = new int[firstArray.length + secondArray.length];
        int k = 0;
        int i = 0;
        int j = 0;
        for (; i < firstArray.length && j < secondArray.length; ) {
            if (firstArray[i] <= secondArray[j]) {
                mergedArray[k] = firstArray[i];
                k++;
                i++;
            } else {
                mergedArray[k] = secondArray[j];
                k++;
                j++;
            }
        }
        if (i < firstArray.length) {
            for (int m = i; m < firstArray.length; m++) {
                mergedArray[k] = firstArray[m];
                k++;
            }
        }
        if (j < secondArray.length) {
            for (int n = j; n < secondArray.length; n++) {
                mergedArray[k] = secondArray[n];
                k++;
            }
        }
        return mergedArray;
    }
}
