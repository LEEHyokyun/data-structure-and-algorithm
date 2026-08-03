package week32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Binary_Search_Tree_with_BST_and_Recursions {
    static class Node{

        int x;
        int y;
        int idx;
        Node left;
        Node right;

        public Node(int x, int y, int idx){
            this.x = x;
            this.y = y;
            this.idx = idx;
        }

    }

    static List<Node> preOrders = new ArrayList<>();
    static List<Node> postOrders = new ArrayList<>();

    public int[][] solution(int[][] nodeinfo) {

        int n = nodeinfo.length;
        Node[] nodes = new Node[n];

        //노드 개수 10000개 이하
        //노드 좌표 배열의 길이도 10000 이하.
        for(int i = 0 ; i < n ; i++){

            int idx = i + 1;
            int x = nodeinfo[i][0];
            int y = nodeinfo[i][1];

            nodes[i] = new Node(x, y, idx);

        }

        //정렬 : NlogN
        Arrays.sort(nodes, (a, b) -> {

            //2차 정렬 기준
            if(a.y == b.y) return a.x - b.x; //x작은 순서대로(오름차순)

            //1차 정렬 기준
            return b.y - a.y; //y큰 순서대로(내림차순)
        });

//         Node root = nodes[0];
//         Node parent = root;
//         Node next = root;
//         for(int i = 1 ; i < n ; i++){
//             /*
//             * 직전 노드가 항상 부모노드일 수는 없다.
//             * y 내림차순 / x 오름차순 정렬로 이루어진 배열에서 산출하는 그래프는 직전의 노드가 다음의 노드의 부모임을 확신할 수 없다.
//             *
//                   8
//                /      \
//              3         11
//               \
//                6
//             * 일때, 정렬상 8 > 3 > 11 > 6
//             * 도식상으로 11은 3의 자식이 아니고, 6은 11의 자식이 아니다.
//             */

//             /*
//             * 삽입 규칙 : BST
//             * 이진탐색트리(를 구성하는 삽입) : 부모를 기준으로 오른쪽 노드에 할당된 값은 왼쪽 노드에 할당된 값보다 반드시 크다.
//             */

//             next = nodes[i];

//             //left
//             if(next.x < parent.x){
//                 parent.left = next;
//             }
//             //right
//             else {
//                 parent.right = next;
//             }

//             parent = nodes[i];
//         }

        /*
         * 새 노드를 넣을때마다 항상 root노드가 탐색을 시작하고 처리의 기준점이 되어야 한다.
         * 즉, 각 노드를 일일이 다 비교해가면서 정확한 위치에 삽입을 해야하는 것이 핵심.
         */
        Node root = nodes[0];
        for(int i = 1 ; i < n ; i++){
            //insert(Node parent, Node child);
            insert(root, nodes[i]);
        }

        preOrder(root);
        postOrder(root);

        int[][] answer = new int[2][n];
        for(int i = 0 ; i < n ; i++){
            answer[0][i] = preOrders.get(i).idx;
            answer[1][i] = postOrders.get(i).idx;
        }


        return answer;

    }

    /*
     * 표면적으로는 최악의 시간복잡도가 1억(10,000 * 10,000)이지만,
     * 트리가 치우치치 않은 트리이기도 하고, 높이가 logN에 가까운 트리(시간복잡도도 이에 근사)이기에 시간복잡도 수용이 가능하다.
     * 즉, 삽입 횟수 N * 처리 logN = NlogN
     */
    static void insert(Node parent, Node child){
        if(child.x < parent.x){
            //왼쪽
            if(parent.left == null){
                parent.left = child;
            }else{
                insert(parent.left, child);
            }
        }else {
            //오른쪽
            if(parent.right == null){
                parent.right = child;
            }else{
                insert(parent.right, child);
            }
        }
    }

    static void preOrder(Node root){
        if(root == null) return;
        preOrders.add(root);
        preOrder(root.left);
        preOrder(root.right);
    }

    static void postOrder(Node root){
        if(root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        postOrders.add(root);
    }
}
