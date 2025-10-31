package algorithm.trie;

import java.util.HashSet;
import java.util.Set;

public class Trie {
    private TrieNode root;

    //root 노드 설정을 위한 생성자
    public Trie(){
        this.root = new TrieNode();
    }

    public TrieNode getRoot(){
        return this.root;
    }

    //insert
    public void insert(String word){
        TrieNode currentNode = this.root;

        //문자열 순회(char)..root 노드 설정 이후를 가정한다.
        for(char ch : word.toCharArray()){
            if(currentNode.getChildrenNode(ch) != null){
                //다음노드정보 존재할 경우 현재노드를 다음노드로 이동
                currentNode = currentNode.getChildrenNode(ch);
            }else{
                //다음노드정보 존재하지 않을 경우 현재노드에 해당 key정보와 다음노드 정보를 넣고 다음노드로 이동
                //중요한 것은 연결정보를 유지하는 것. 다음노드는 노드 그자체로, 다음노드에 대한 정보는 없다.
                TrieNode childrenNode = new TrieNode();
                currentNode.setChildrenNode(ch, childrenNode);
                currentNode = currentNode.getChildrenNode(ch);
            }
        }
    }

    //search
    public TrieNode search(String word, boolean isCounting){
        TrieNode currentNode = this.root;
        for(char ch : word.toCharArray()){
            if(currentNode.getChildrenNode(ch) != null){
                currentNode = currentNode.getChildrenNode(ch);
            }else{
                System.out.println(String.format("%s 단어는 존재하지 않습니다.", word));
                return null;
            }
        }

        System.out.println(String.format("%s 단어는 존재합니다.", word));
        return currentNode;
    }

    //automatic word completion
    public void autoComplete(String word){
        TrieNode currentNode = this.search(word);

        if(currentNode == null){
            System.out.println("검색할 단어가 존재하지 않습니다.");
            return;
        }

        Set<String> chunks = new HashSet<String>();
        Set<String> words = this.getAllWords(currentNode, word, chunks);
        System.out.println(words);
    }

    public Set<String> getAllWords(TrieNode startNode, String word, Set<String> words){
        //루트부터 순회
        TrieNode currentNode = this.root;

        //출발노드를 설정하고 이것이 존재한다면 시작노드는 출발노드.
        if(startNode != null){
            currentNode = startNode;
        }

        for(String key : currentNode.getKeys()){
            if(key == "*"){
                words.add(word);
            }else{
                currentNode = currentNode.getChildrenNode(key.charAt(0));
                this.getAllWords(currentNode, key + word, words);
            }
        }

        System.out.println(words);
        return words;
    }
}
