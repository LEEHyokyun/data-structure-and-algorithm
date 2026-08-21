package week34;

import java.util.Arrays;

public class BinaryTreePreAndPostOrders_with_DFS_트리만드는_과정에서_root다음이아닌_root부터_넣는다면_root의_자식트리가_root가_되어_순환참조_반복_StackOverFlow {
    static class Node{

        int idx;
        int x;
        int y;
        Node left;
        Node right;

        public Node(int idx, int x, int y){
            this.idx = idx;
            this.x = x;
            this.y = y;
            // this.left = left;
            // this.right = right;
        }

    }

    static int[] pres;
    static int[] posts;
    static int idx1;
    static int idx2;

    // static List<Integer> pres = new ArrayList<>();
    // static List<Integer> posts = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {

        int nodeNums = nodeinfo.length;

        Node[] nodes = new Node[nodeNums];
        for(int i = 0 ; i < nodeNums ; i++){

            int idx = i+1;
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];

            nodes[i] = new Node(idx, x, y);
        }

        Arrays.sort(nodes, (a, b) -> {

            if(b.y == a.y) return a.x - b.x;

            return b.y - a.y;
        });

        Node root = nodes[0];
        for(int i = 1 ; i < nodeNums ; i++) makeTree(root, nodes[i]);

        pres = new int[nodeNums];
        posts = new int[nodeNums];

        preOrder(root, pres);
        postOrder(root, posts);

        //int[] a1 = new int[nodeNums];
        //int[] a2 = new int[nodeNums];

        //for(int i = 0 ; i < a1.length ; i++) a1[i] = pres.get(i);
        //for(int i = 0 ; i < a2.length ; i++) a2[i] = posts.get(i);

        return new int[][]{
                pres,
                posts
        };
    }

    static void makeTree(Node root, Node node){

        if(node.x < root.x){
            if(root.left == null) root.left = node;
            else makeTree(root.left, node);
        }else {
            if(root.right == null) root.right = node;
            else makeTree(root.right, node);
        }

        return;
    }

    //중간 왼쪽 오른쪽
    static void preOrder(Node root, int[] pres){
        pres[idx1++] = root.idx;
        //pres.add(root.idx);
        if(root.left != null) preOrder(root.left, pres);
        if(root.right != null) preOrder(root.right, pres);
    }

    //왼쪽 오른쪽 중간
    static void postOrder(Node root, int[] posts){
        if(root.left != null) postOrder(root.left, posts);
        if(root.right != null) postOrder(root.right, posts);
        posts[idx2++] = root.idx;
        //posts.add(root.idx);
    }
}
