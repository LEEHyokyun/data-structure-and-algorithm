package week34;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

public class MountainPaths_with_Deformed_Dijkstra_가중치가_이미_계산되어_도출된_가중치보다_더_크다면_해당_가중치는_계산이_이루어질_필요가_없다_최적의_해가_아니기에 {
    static class Node{
        int to;
        int weight;

        public Node(int to, int weight){
            this.to = to;
            this.weight = weight;
        }
    }

    static int INF = Integer.MAX_VALUE;
    static List<Node>[] graph;

    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {

        graph = new List[n+1];
        for(int i = 0 ; i <= n ; i++) graph[i] = new ArrayList<>();

        for(int[] path : paths){
            int from = path[0];
            int to = path[1];
            int weight = path[2];

            graph[from].add(new Node(to, weight));
            graph[to].add(new Node(from, weight));
        }

        return dijkstra(gates, summits, n);

    }

    static int[] dijkstra(int[] gates, int[] summits, int n){

        //지금까지 알려진 가중치 중 가장 적은 가중치
        //방문여부는 pq에서 빼내면서 동시에 체크 가능하다.
        PriorityQueue<Node> pq = new PriorityQueue<>((a, b) -> a.weight - b.weight);
        int[] distance = new int[n+1];
        boolean[] isGate = new boolean[n+1];
        boolean[] isSummit = new boolean[n+1];

        Arrays.fill(distance, INF);

        for(int gate : gates) {
            distance[gate] = 0;
            isGate[gate] = true;
            pq.offer(new Node(gate, 0));
        }

        for(int summit : summits){
            isSummit[summit] = true;
        }

        while(!pq.isEmpty()){

            //지금까지 알려진 노드 중 가장 가중치가 작은 노드
            Node toNode = pq.poll();
            int to = toNode.to;
            int weight = toNode.weight;

            //if(isGate[to]) continue; //gate -> summit 경로..이 조건은 세부 경로 조정으로 넣는다.
            if(weight > distance[to]) continue; //이건 우선순위 큐에 의해 나올 수 없음(헷갈리므로 제거)(최적의 경로가 아니면 자연스럽게 경로 후보지에서 제거)
            if(isSummit[to]) continue; //정상 도착하면 다음 경로로(gate)

            //이 세부 경로에서 intensity를 판별한다.
            for(Node adj : graph[to]){

                if(isGate[adj.to]) continue; //세부 경로에서 gate를 지나면 안된다.

                /*
                 * 현재 도착한 node 지점을 기준으로, 향하는 목표점이 다르다는 것에 유의.
                 * weight : node를 거쳐 <to> 노드로 향하는데 필요한 가중치
                 * to.weight : node를 거쳐 <다른 인접> 노드로 향하는데 필요한 가중치
                 * adj.weight : to를 거쳐 adj까지 갈때, 그 경로 상에서의 필요한 가중치
                 * 어디를 가느냐? 가중치가 최대인 곳 -> to 와 to - adj.to 까지의 경로를 종합적으로 비교하는 것임.
                 */
                int maxValue = Math.max(weight, adj.weight);
                //int maxValue = adj.weight;

                /*
                 * 근데, 선택한 최대의 가중치와 향하는 곳이
                 * 인접노드(어차피 가는 곳은 인접노드)로 향하는 가중치보다 작다면 그때 갱신한다.
                 * 이건 돌아가는 길이 아니라는 것을 명시하는 과정.
                 */
                /*
                 * 이때 distance는 일반 다익스트라처럼 인접노드로 가는 최소값의 갱신이 아니라,
                 * 해당 경로까지 알려진 최대의 가중치이다.
                 * 그러니까, 1단계에서 구한 가중치와 그 다음으로 가는 경로의 가중치의 최대를 구하는 것은 매우 자연스럽다.
                 * 여기서 최대를 구하는데, 이것은 일반적인 다익스트라 갱신이다(최적의 경로)
                 */
                if(maxValue < distance[adj.to] ){ //현재의 노드를 거쳐(to) + 거쳐(adj)..
                    distance[adj.to] = maxValue;
                    pq.offer(new Node(adj.to, maxValue));
                }
            }
        }

        //시작점은 특정, 특정 노드로 나아가는 거리
        int number = -1;
        int dist = Integer.MAX_VALUE;

        //후보지 : 정상지점으로 가는 거리
        for(int s : summits){
            if(distance[s] < dist){
                dist = distance[s];
                number = s;
            }else if(distance[s] == dist){
                if(s < number) number = s;
                //number = Math.min(number, s);
            }
        }

        return new int[]{number, dist};
    }
}
