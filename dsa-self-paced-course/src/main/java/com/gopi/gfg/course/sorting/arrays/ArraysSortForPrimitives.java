/**
 * Created by gopinath_mb on Sep 8, 2021
 */
package com.gopi.gfg.course.sorting.arrays;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

/**
 * @author gopinath_mb
 */
public class ArraysSortForPrimitives {

  public static void main(String[] args) {
    // Our arr contains 8 elements
    int[] arr1 = { 5, 20, 12, 30 };
    char[] arr2 = { 'B', 'B', 'A', 'C', 'A' };

    // Sorting the first array
    Arrays.sort(arr1);

    // Displaying the first array
    System.out.println(Arrays.toString(arr1));

    // Sorting the second array
    Arrays.sort(arr2);

    // Displaying the second array
    System.out.println(Arrays.toString(arr2));

    int[] arr3 = { 5, 30, 20, 10, 8 };

    // Sort subarray from index 1 to 3, i.e.,
    // only sort subarray {30, 20, 10} and
    // keep other elements as it is.
    Arrays.sort(arr3, 1, 4);

    System.out.println(Arrays.toString(arr3));

    Integer[] arr4 = { 5, 20, 10, 12 };

    // Note that we have Integer here instead of
    // int[] as Collections.reverseOrder doesn't
    // work for primitive types.
    Arrays.sort(arr4, Collections.reverseOrder());

    System.out.println(Arrays.toString(arr4));

    // Integer array
    Integer[] arr = { 5, 20, 10, 3, 12 };

    // Sorting arrays by passing
    // arr and MyCmp object
    Arrays.sort(arr, new MyCmp());

    // Displaying the sorted array
    System.out.println(Arrays.toString(arr));
  }
}

class MyCmp implements Comparator<Integer> {

  // Sorts the Integers
  public int compare(Integer a, Integer b) {
    return a % 2 - b % 2;
  }
}
