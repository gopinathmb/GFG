/**
 * Created by gopinath_mb on Jul 24, 2021
 */
package com.gopi.gfg.course.tree.trie;

/**
 * @author gopinath_mb
 */
public class TrieNode {

  TrieNode[] children = new TrieNode[Trie.ALPHABET_SIZE];

  // isEndOfWord is true if the node represents end of a word
  boolean isEndOfWord;

}
