package week6.day5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class TreeTraversal {
    static class Node{
        char root;
        char left;
        char right;

        Node(char x, char y, char z){
            root = x;
            left = y;
            right = z;
        }
    }

    static Node[] tree = new Node[26];
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 0 ; i < N ; i++){
            StringTokenizer nodes = new StringTokenizer(br.readLine(), " ");
            char root = nodes.nextToken().charAt(0);
            char left = nodes.nextToken().charAt(0);
            char right = nodes.nextToken().charAt(0);

            tree[root - 'A'] = new Node(root, left, right);
        }

        preOrder(tree[0]);
        sb.append('\n');
        inOrder(tree[0]);
        sb.append('\n');
        postOrder(tree[0]);

        System.out.print(sb);
    }

    static void preOrder(Node node){
        sb.append(node.root);
        if(node.left != '.')
            preOrder(tree[node.left - 'A']);
        if(node.right != '.')
            preOrder(tree[node.right - 'A']);
    }

    static void inOrder(Node node){

        if(node.left != '.')
            inOrder(tree[node.left - 'A']);
        sb.append(node.root);
        if(node.right != '.')
            inOrder(tree[node.right - 'A']);
    }

    static void postOrder(Node node){
        if(node.left != '.')
            postOrder(tree[node.left - 'A']);
        if(node.right != '.')
            postOrder(tree[node.right - 'A']);
        sb.append(node.root);
    }
}
