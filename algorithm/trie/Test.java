package algorithm.trie;

import java.util.HashSet;
import java.util.Set;

public class Test {
    public static void main(String[] args){
        Trie trie = new Trie();

        trie.insert("고등어");
        trie.insert("김치찌개");
        trie.insert("김치");
        trie.insert("김치찜");

        trie.search("두부");
        trie.search("김치찜");
        trie.search("김치");

        //trie.getAllWords(trie.getRoot(), "", new HashSet<String>());
    }

}
