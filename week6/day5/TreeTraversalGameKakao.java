package week6.day5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TreeTraversalGameKakao {
    static class Node{
        int x,y,idx;
        //x!= left, y != right
        Node left;
        Node right;

        Node(int x, int y, int idx){
            this.x = x;
            this.y = y;
            this.idx = idx;
        }
    }

    //list
    static List<Integer> preOrderList = new ArrayList<>();
    static List<Integer> postOrderList = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        int n = nodeinfo.length;
        Node[] nodes = new Node[n];

        for(int i = 0 ; i < n ; i++){
            nodes[i] = new Node(nodeinfo[i][0], nodeinfo[i][1], i+1);
        }

        //root -> level 별 정렬(왼/오자식)
        Arrays.sort(nodes, (a, b) -> {
            if(a.y == b.y) return a.x - b.x;  //x 오름차순
            return b.y - a.y;  //y 내림차순
        });

        //root
        Node root = nodes[0];
        for(int i = 1 ; i < n ; i++){
            insert(root, nodes[i]);
        }

        preOrder(root);
        postOrder(root);

        int[][] answer = new int[2][n];
        for(int i = 0 ; i < n ; i++){
            answer[0][i] = preOrderList.get(i);
            answer[1][i] = postOrderList.get(i);
        }

        return answer;
    }

    static void insert(Node parent, Node child){
        if(child.x < parent.x){
            if(parent.left == null) parent.left = child;
            else insert(parent.left, child);
        }else{
            if(parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }

    static void preOrder(Node node){
        if(node == null) return;
        preOrderList.add(node.idx);
        preOrder(node.left);
        preOrder(node.right);
    }

    static void postOrder(Node node){
        if(node == null) return;
        postOrder(node.left);
        postOrder(node.right);
        postOrderList.add(node.idx);
    }
}
