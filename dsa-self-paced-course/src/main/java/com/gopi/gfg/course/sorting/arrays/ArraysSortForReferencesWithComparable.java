/**
 * Created by gopinath_mb on Sep 8, 2021
 */
package com.gopi.gfg.course.sorting.arrays;

import java.util.Arrays;

/**
 * @author gopinath_mb
 */
public class ArraysSortForReferencesWithComparable {

  public static void main(String[] args) {
    // Array of 3 objects
    PointX arr[] = { new PointX(10, 20), new PointX(3, 12), new PointX(5, 7) };

    // Sorting the object containing array
    Arrays.sort(arr);
    for(int i = 0; i < arr.length; i++)
      System.out.println(arr[i].x + " " + arr[i].y);
  }
}

//A user-defined Point class implementing 
//Comparable interface
class PointX implements Comparable<PointX> {

  int x, y;

  // Costructor intialising x & y
  PointX(int x, int y) {
    this.x = x;
    this.y = y;
  }

  // compareTo() function defining the
  // nature of sorting i.e., according to
  // x-coordinate
  public int compareTo(PointX P) {
    // Comparing two objects by
    // Subtracting the passed object
    // from current object
    return this.x - P.x;
  }
}
