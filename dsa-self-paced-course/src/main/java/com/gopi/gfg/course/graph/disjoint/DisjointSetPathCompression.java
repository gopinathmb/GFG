/**
 * Created by gopinath_mb on Oct 23, 2021
 */
package com.gopi.gfg.course.graph.disjoint;

/**
 * @author gopinath_mb
 */
public class DisjointSetPathCompression {

  private int[] parent;

  public DisjointSetPathCompression(int size) {
    parent = new int[size];
    for(int i = 0; i < size; i++) {
      parent[i] = i;
    }
  }

  public int find(int x) {
    if (x == parent[x]) {
      return x;
    }
    parent[x] = find(parent[x]);
    return parent[x];
  }

  public void union(int x, int y) {
    int rootX = find(x);
    int rootY = find(y);
    if (rootX != rootY) {
      parent[rootY] = rootX;
    }
  }

  public boolean connected(int x, int y) {
    return find(x) == find(y);
  }

  public static void main(String[] args) throws Exception {
    DisjointSetPathCompression uf = new DisjointSetPathCompression(10);
    // 1-2-5-6-7 3-8-9 4
    uf.union(1, 2);
    uf.union(2, 5);
    uf.union(5, 6);
    uf.union(6, 7);
    uf.union(3, 8);
    uf.union(8, 9);
    System.out.println(uf.connected(1, 5)); // true
    System.out.println(uf.connected(5, 7)); // true
    System.out.println(uf.connected(4, 9)); // false
    // 1-2-5-6-7 3-8-9-4
    uf.union(9, 4);
    System.out.println(uf.connected(4, 9)); // true
  }

}
