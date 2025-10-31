package algorithm.trie;

import basic.hashTable.HashTable;

import java.util.Hashtable;
import java.util.Set;

public class TrieNode {
    private Hashtable<String, TrieNode> childrenNode = new Hashtable<>();

    //for root
    public TrieNode(){}

    //for not root
    public TrieNode(char ch, TrieNode childrenNode){
        this.childrenNode.put(String.valueOf(ch), childrenNode);
    }

    public TrieNode getChildrenNode(char ch){
        return this.childrenNode.get(String.valueOf(ch));
    }

    public void setChildrenNode(char key, TrieNode childrenNode){
        this.childrenNode.put(String.valueOf(key), childrenNode);
    }

    public Set<String> getKeys(){
        return this.childrenNode.keySet();
    }

//    public boolean containsKey(char key){
//        return childrenNode.get(String.valueOf(key)) != null;
//    }
}
