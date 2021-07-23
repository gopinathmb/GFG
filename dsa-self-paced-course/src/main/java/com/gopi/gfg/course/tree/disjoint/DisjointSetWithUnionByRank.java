/**
 * Created by gopinath_mb on Jul 23, 2021
 */
package com.gopi.gfg.course.tree.disjoint;

/**
 * @author gopinath_mb
 */
public class DisjointSetWithUnionByRank {

  static int parent[];
  static int ranks[];

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

    if (ranks[x_rep] < ranks[y_rep])
      parent[x_rep] = y_rep;

    else if (ranks[y_rep] < ranks[x_rep])
      parent[y_rep] = x_rep;

    else {
      parent[y_rep] = x_rep;
      ranks[x_rep]++;
    }

  }

  public static void main(String[] args) {

    int n = 5;

    parent = new int[5];
    ranks = new int[5];

    initialize();

    union(3, 4);
    union(2, 3);
    union(1, 2);
    union(0, 1);

    System.out.println(parent[3]);
    System.out.println(ranks[3]);
  }
}
