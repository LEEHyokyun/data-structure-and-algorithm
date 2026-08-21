package week34;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinaryTreePreAndPostOrders_with_DFS_References {
    static class Node{
        Node left;
        Node right;
        int idx;
        int x;
        int y;

        public Node(Node left, Node right, int idx, int x, int y){
            this.left = left;
            this.right = right;
            this.idx = idx;
            this.x = x;
            this.y = y;
        }

    }

    static List<Integer> pre = new ArrayList<>();
    static List<Integer> post = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {
        /*
         * 이진트리 전 > 후
         */
        Node[] nodes = new Node[nodeinfo.length];

        for(int i = 0 ; i < nodeinfo.length ; i++){
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];
            int idx = i+1;

            //System.out.println("idx : " + idx);

            nodes[i] = new Node(null, null, idx, x, y);
        }

        //트리 순서대로.
        Arrays.sort(nodes, (a, b) -> {
            //정렬 필요 : y 내림차순, x 오름차순
            if(a.y == b.y) return a.x - b.x;

            return b.y - a.y;
        });

        Node root = nodes[0];
        for(int i = 1 ; i < nodeinfo.length ; i++){
            makeTree(root, nodes[i]);
        }

        //System.out.println("root idx : " + root.idx);
        preOrder(root);
        postOrder(root);

        int[][] answer = new int[2][nodeinfo.length];
        for(int i = 0 ; i < nodeinfo.length ; i++){
            answer[0][i] =  pre.get(i);
        }
        for(int i = 0 ; i < nodeinfo.length ; i++){
            answer[1][i] = post.get(i);
        }

        return answer;
    }

    //node 정렬
    static void makeTree(Node root, Node node){
        if(node.x < root.x){
            if(root.left == null) root.left = node;
            else makeTree(root.left, node);
        }else {
            if(root.right == null) root.right = node;
            else makeTree(root.right, node);
        }
    }

    //중간 - 왼쪽 있으면 왼쪽 - 오른쪽 오른쪽 없으면
    static void preOrder(Node node){

        pre.add(node.idx);
        if(node.left != null) preOrder(node.left);
        if(node.right != null) preOrder(node.right);
    }

    //왼쪽있으면 왼쪽 - 오른쪽있으면 오른쪽 - 중간
    static void postOrder(Node node){
        if(node.left != null) postOrder(node.left);
        if(node.right != null) postOrder(node.right);
        post.add(node.idx);
    }
}
