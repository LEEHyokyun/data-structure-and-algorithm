## 1. Day3

[DFS]
- 문제조건 정리부터 차근차근.
  - dfs(start point, *만약 계층/촌수 등의 부가정보 필요 시 depth)
  - dfs에서 초기화 필요없다? 그대로, 초기화 필요있으면 백트래킹 조건 추가.
    - int result = dfs(next, depth + 1, target); .. dfs를 받을 결과변수를 만든다.

- dfs통해 받은 결과를 result에 누적, result를 받았다는 것은 촌수가 존재함, 그대로 return..

```java
for(int next : list[from]){
            if(!visited[next]){
                int result = dfs(next, depth + 1, target);
                if(result != -1) return result; //return 받았다? 촌수 찾은것, -1이다? 촌수 못찾은것.
            }
        }
        
        return -1;
```

[list<Integer>[] 형태 정의/선언 복습]

```java
List<Integer>[] list = new ArrayList[m+1];
```
```java
for(int i = 1 ; i <= m ; i++){
            StringTokenizer people = new StringTokenizer(br.readLine());
            list[i] = new ArrayList<>();
            
            int u = Integer.parseInt(people.nextToken());
            int v = Integer.parseInt(people.nextToken());
            
            list[u].add(v);
            list[v].add(u);
        }   
```
```java
순회시,
        for(list next : list)..{       ->list list list = list!
        for (int next : list[cur]) {   ->list[i] : int int int int ....
```
[초기화 하고 넣자.]

- NG(초기화 전에 넣으려고 시도)

```java
list = new ArrayList[n+1]; //사람관계
        for(int i = 1 ; i <= m ; i++){
            StringTokenizer people = new StringTokenizer(br.readLine());
            list[i] = new ArrayList<>();
            
            int u = Integer.parseInt(people.nextToken());
            int v = Integer.parseInt(people.nextToken());
            
            list[u].add(v);
            list[v].add(u);
        }    
```

- GOOD(온전하게 초기화 후 넣음)

```java
list = new ArrayList[n+1]; //사람관계
        for(int i = 1 ; i <= n ; i++){
            list[i] = new ArrayList<>();
        }
        for(int i = 1 ; i <= m ; i++){
            StringTokenizer people = new StringTokenizer(br.readLine());
            
            
            int u = Integer.parseInt(people.nextToken());
            int v = Integer.parseInt(people.nextToken());
            
            list[u].add(v);
            list[v].add(u);
        }    
```