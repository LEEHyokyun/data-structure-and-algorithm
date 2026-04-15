[day2]

[슬라이딩 윈도우]

- Sum of Numbers
  - DP/연속합을 통한 합산도출 -> 길이가 정해져 있지 않다 -> 이중반복을 불가피 -> O(N^2)
  - 무조건 슬라이딩 윈도우
    - 합산이 동일하다면 윈도우 크기 조절(작아지거나 커지거나)
    - while right <= N -> right이 크기가 넘어간 시점에서도 left 조정을 통해 가능할 수도 있다(right == N일때)
      - while true, right 크기는 내부에서
      - right > N인 상태에서 합산을 시도할때, 그때 break.
  
- "연속된" 부분 수열의 합
  - 

[슬라이딩 윈도우를 적용하고자 하는 관점]
- 고정된 윈도우에서 right++를 하면서 누적시킨다면 원소들은 모두 자연수이기에 최종 합산은 반드시 증가
- 각 고정된 길이별로 start, end를 조정해가면서 가능한 합산을 추출한다면 무조건 OOM/시간제한
  - for (int len = 1; len <= N; len++) {
    // 길이가 len인 모든 연속 구간을 슬라이딩 윈도우로 검사
    }
  - O(N*N) -> 고정된 길이별로 부분합을 지속.
- 중요한 것은 한번의 연산으로 진행해야 한다는 점
  - 단순히, 어차피 원소들은 모두 "자연수"이므로, 길이자체를 늘리면 무조건 증가, 짧게 하면 감소
    - SUM > M -> 길이 감소 / SUM = M -> count++ / SUM < M -> 길이 증가.

> 즉, 연속합의 단조성은 정렬된 배열에서의 "해", 정렬되어있지 않은 배열에서의 "길이" 두가지 방향으로 접근해야 한다.
- 길이가 길어지면 합산은 당연히 증가하고, 짧아지면 감소한다. -> 길이에 대한 단조성
  - SUM > M -> 길이 감소 / SUM = M -> count++ / SUM < M -> 길이 증가.
- 만약 일부 원소에 대해서만 pick, 원소의 크기를 고려해야 한다면 -> 해에 대한 단조성

(*하지만 보통은 길이에 대한 단조성으로 충분히 해결 가능)

[슬라이딩 윈도우 길이 조절]
- start + len -> start를 포함한 len만큼 더 (직사각형 블록으로 생각할 것, start + len -> start 포함 len 블록 더)
- start 포함 len길이라면 마지막 제거(start를 포함한 len 길이라면, 마지막 블록 제거)

[key point]
- 합이 작으면 더한다, 그 후 right++
- 합이 크면 뺀다, 그 후 left++
- 반복 순회는 while(true) .. right = len - 1 이후, len으로 인덱스 밖에 나가더라도, 해당 조건에서도 left까지 움직일 수 있다.
  - while (true), sum < k 조건일때 right++하기 직전에, right == len 이라면 break 조건으로 탈출 
- 연속합 "길이"
  - 인덱스? left index는 그대로, right index는 right ++ 의 -1.
  - 이때의 길이 ? right - left (right - 1 ~ left 까지의 길이 = right - left) 
    - 만약 부합하는 해 도출 시 sum = sum - left, left++
- 고정길이에 대한 순환
  - len 순회 -> i = 0 부터 len까지(i < len) 최초 고정길이에 대한 합산 도출
  - start 이동하면서 고정길이 슬라이딩 -> i = start ; i < N (start 지점만 조정하는것)
  - sum -= start -1
  - sum += (start ~ len 길이만큼의 합 = len 마지막 1개 제거)

[tip]
- [1,2] -> int[]
- ["1", "2"] -> String[] -> ArrayList.toArray(new String[0])