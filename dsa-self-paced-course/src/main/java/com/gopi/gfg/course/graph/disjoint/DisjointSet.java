/**
 * Created by gopinath_mb on Jul 23, 2021
 */
package com.gopi.gfg.course.graph.disjoint;

import static java.lang.System.out;

/**
 * @author gopinath_mb
 */
public class DisjointSet {

  static int parent[];

  static void initialize() {
    for(int i = 0; i < parent.length; i++) {
      parent[i] = i;
    }
  }

  static int find(int x) {
    if (parent[x] == x)
      return x;
    else
      return find(parent[x]);

  }

  static void union(int x, int y) {
    int x_rep = find(x);
    int y_rep = find(y);

    if (x_rep == y_rep)
      return;

    parent[y_rep] = x_rep;
  }

  public static void main(String[] args) {

    int n = 5;

    parent = new int[n];

    initialize();

    union(1, 2);
    out.println(find(2));
    union(2, 3);
    out.println(find(3));
    union(4, 3);
    out.println(find(4));

    out.println(find(2));
    out.println(find(3));

    out.println(find(4));
    out.println(find(0));
  }
}
