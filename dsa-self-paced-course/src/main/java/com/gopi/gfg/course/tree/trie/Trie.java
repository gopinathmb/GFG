/**
 * Created by gopinath_mb on Jul 24, 2021
 */
package com.gopi.gfg.course.tree.trie;

import javax.naming.directory.SearchControls;

/**
 * @author gopinath_mb
 */
//https://www.geeksforgeeks.org/trie-insert-and-search/
//https://www.geeksforgeeks.org/trie-delete/
public class Trie {

  // Alphabet size (# of symbols)
  static final int ALPHABET_SIZE = 26;

  static TrieNode root;

  public Trie() {
    // Always root exists and it will have all the child values as null
    this.root = new TrieNode();
  }

  // If not present, inserts key into trie
  // If the key is prefix of trie node, just marks leaf node
  public void insert(String key) {
    int level;
    int length = key.length();
    int index;
    System.out.println("Inserting ==> " + key);
    TrieNode cur = root;

    // Iterate till n-1 nodes and if in case u found null then u makes ure u add
    // the node.
    for(level = 0; level < length; level++) {
      index = key.charAt(level) - 'a';
      if (cur.children[index] == null)
        cur.children[index] = new TrieNode();

      cur = cur.children[index];
    }

    // mark last node as leaf
    cur.isEndOfWord = true;
  }

  // Returns true if key presents in trie, else false
  public boolean search(String key) {
    System.out.println("Searching ==> " + key);
    int level;
    int length = key.length();
    TrieNode cur = root;

    for(level = 0; level < length; level++) {
      int index = key.charAt(level) - 'a';

      if (cur.children[index] == null) {
        return false;
      }

      cur = cur.children[index];
    }

    return (cur.isEndOfWord);
  }

  public void delete(String key) {
    System.out.println("Deleting ==> " + key);
    delete(root, key, 0);
  }

  // Returns true if root has no children, else false
  private boolean isEmpty(TrieNode root) {
    // If it's root then we shouldn't delete it in any case.
//    if (root == this.root) {
//
//      return false;
//    }
    for(int i = 0; i < ALPHABET_SIZE; i++)
      if (root.children[i] != null)
        return false;
    return true;
  }

  // Recursive function to delete a key from given Trie
  public TrieNode delete(TrieNode root, String key, int depth) {
    // If tree is empty
    if (root == null)
      return null;

    // If last character of key is being processed
    if (depth == key.length()) {

      // This node is no more end of word after
      // removal of given key
      if (root.isEndOfWord)
        root.isEndOfWord = false;

      // If given is not prefix of any other word
      if (isEmpty(root)) {
        root = null;
      }

      return root;
    }

    // If not last character, recur for the child obtained using ASCII value
    int index = key.charAt(depth) - 'a';
    root.children[index] = delete(root.children[index], key, depth + 1);

    // If root does not have any child (its only child got
    // deleted), and it is not end of another word.
    if (isEmpty(root) && root.isEndOfWord == false) {
      root = null;
    }

    return root;
  }

  // Driver
  public static void main(String args[]) {

    Trie trie = new Trie();

    trie.insert("abc");
    trie.delete("abc");
    trie.insert("xyz");
    System.out.println(trie.search("xyz"));
    
    trie.insert("zoom");
    trie.insert("data");
    trie.insert("date");
    trie.insert("database");
    System.out.println(trie.search("database"));
    System.out.println(trie.search("data"));
    System.out.println(trie.search("date"));
    trie.delete("data");
    System.out.println(trie.search("data"));
    System.out.println(trie.search("date"));
    System.out.println(trie.search("database"));
    System.out.println(trie.search("zoom"));

    trie.delete("database");
    System.out.println(trie.search("data"));
    System.out.println(trie.search("date"));
    System.out.println(trie.search("database"));

  }
}
