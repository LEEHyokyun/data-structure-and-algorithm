## 1. Day5

[DFS]
- Notes
  - 트리구조의 순회방법
    - 전위 : 루트 > 왼쪽 자식 > 오른쪽 자식
    - 중위 : 왼쪽 자식 > 루트 > 오른쪽 자식
    - 후위 : 왼쪽 자식 > 오른쪽 자식 > 루트
      - 필수조건 : "루트노드"를 찾아야 함.
      - 필수정렬조건 : "트리구성" -> root -> 자식 별 정렬 (*길찾기 게임의 경우 : level 별 정렬(왼/오자식))
  - 트리 구성
    - 각 항목이 자동적으로 자식노드를 의미한다 -> 프로퍼티 그대로 활용
      1. 노드들 생성, 내부적으로 프로퍼티를 자식노드 구성 필요X
         - 단순히 x = 왼쪽 자식, y = 오른쪽 자식
    - 각 항목이 자식노드가 아니며, 별도의 노드정의를 해야한다 -> 내부적으로 노드 프로퍼티 필요
      1. 노드들을 y 내림차순으로 정렬
      2. 첫 번째 노드를 루트로 설정
      3. 이후 노드들을 하나씩 "이진 탐색 트리 규칙(x 기준)"으로 삽입
      4. 완성된 트리를 전위 / 후위 순회
      5. 최종출력? 노드번호 = i+1

[additional]

StringTokenizer는 말그대로 String 형 반환, char형태로 변환을 위해서는 반드시 charAt(0) 필요.

inner class를 사용하면서 상기할 겸 정리
- 동일한 클래스 내의 inner class .. getter/setter 없어도 프로퍼티에 바로 접근 가능

| 선언                   | 접근 가능 범위    |
| -------------------- | ----------- |
| `private`            | 해당 클래스 내부   |
| `default` (아무것도 안 씀) | 같은 패키지      |
| `protected`          | 같은 패키지 + 상속 |
| `public`             | 어디서나        |

[출력방법]
- 문자열 -> StringBuilder / System.out.println(sb);
- 배열 -> ArrayList, int[][] answer -> answer[0][i] = list.get(i); 
- [[],[],[]] -> x의 개수 = 행, 내부적인 배열의 크기 = 열

[노드구성]

노드구성방법

```java
//root
        Node root = nodes[0];
        for(int i = 1 ; i < n ; i++){
            insert(root, nodes[i]);
        }
```

1차 : 루트노드 구성(y좌표가 가장 큰 노드)
그 이후는 각 계층별로 왼쪽, 오른쪽 자식으로 정렬된 상태

```java
static void insert(Node parent, Node child){
        if(child.x < parent.x){
            if(parent.left == null) parent.left = child;
            else insert(parent.left, child);
        }else{
            if(parent.right == null) parent.right = child;
            else insert(parent.right, child);
        }
    }
```

root노드를 고정한 상태에서
- 재귀적으로 왼쪽노드를 부모로 하고 그 다음의 자식을 구성하는 방안 
- 재귀적으로 오른쪽노드를 부모로 하고 그 다음의 자식을 구성하는 방안