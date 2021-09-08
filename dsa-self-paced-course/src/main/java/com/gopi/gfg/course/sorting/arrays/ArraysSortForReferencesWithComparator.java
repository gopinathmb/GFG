/**
 * Created by gopinath_mb on Sep 8, 2021
 */
package com.gopi.gfg.course.sorting.arrays;

import java.util.Arrays;
import java.util.Comparator;

/**
 * @author gopinath_mb
 */
public class ArraysSortForReferencesWithComparator {

  public static void main(String[] args) {
    // Array of 3 objects
    Point arr[] = { new Point(10, 20), new Point(3, 12), new Point(5, 7) };

    // Sorting the object containing the array
    // by passing the array and object MyCmp
    Arrays.sort(arr, new MyPtCmp());

    // Displaying the sorted array
    for(int i = 0; i < arr.length; i++)
      System.out.println(arr[i].x + " " + arr[i].y);
  }
}

class Point {

  int x, y;

  Point(int x, int y) {
    this.x = x;
    this.y = y;
  }
}

// This class implements 
// Comparator interface to compare 
class MyPtCmp implements Comparator<Point> {

  // Sorts the Point objects according
  // to x-coordinates in natural order
  public int compare(Point p1, Point p2) {
    return p1.x - p2.x;
  }
}
