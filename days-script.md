# Script

1일 1문제를 위한 코딩테스트 문제 내역 작성을 챗지피티에게 요청하기 위한 스크립트.

나는 하루에 1문제씩, 월요일부터 토요일까지 6일 분량의 알고리즘 문제를 꾸준히 풀어보고자 한다.

다만 단순히 문제 나열이 아니라, "4월 30일까지의 코딩테스트 로드맵"이라는 것을 고려해서 빈출하는 개념 및 유형에 대해 확실히 익히고 실력도 점진적으로 향상할 수 있는 방향으로 "12주차 코딩테스트 스케쥴표"를 작성해줘. 
</br>
하루 1문제씩 6일치를 해주고, 이때 월/수/금 - 백준, 화/목/토 - 프로그래머스의 문제로 구성해줘. 

유의할 점, 문제를 선별할때 프로그래머스 214288번(모비스/멘토지정문제) 문제와 같이 "경진대회 수준의" 지나치게 어려운 문제는 시간낭비일뿐이니 코딩테스트 준비에 적합한, 적절한 난이도로 고려해줘. 표 형식은

다만 골드 중후반의 문제들은 코딩테스트에서 빈출되는 구간이므로, 배제 항목에서 제외(문제 리스트로 고려).

| 요일 | 난이도 | 문제 1 | 문제 2 | 오늘의 포인트 | 
| ------- | ---- | ------------------------------------------------------------------------------------------------ | ----------------------------------------------------------------------------------------------- | -------------------- |
| **월요일** | 실버 5 | **1181 단어 정렬** — [https://www.acmicpc.net/problem/1181](https://www.acmicpc.net/problem/1181) | **1427 소트인사이드** — [https://www.acmicpc.net/problem/1427](https://www.acmicpc.net/problem/1427) | 문자열 + 정렬 감각 |
| **화요일** | 실버 5 | **2751 수 정렬하기 2** — [https://www.acmicpc.net/problem/2751](https://www.acmicpc.net/problem/2751) | **2108 통계학** — [https://www.acmicpc.net/problem/2108](https://www.acmicpc.net/problem/2108) | 정렬 + 구현 사고력 | 
| **수요일** | 실버 4 | **9012 괄호** — [https://www.acmicpc.net/problem/9012](https://www.acmicpc.net/problem/9012) | **4949 균형잡힌 세상** — [https://www.acmicpc.net/problem/4949](https://www.acmicpc.net/problem/4949) | 스택 기본 패턴 체화 | 
| **목요일** | 실버 4 | **2164 카드2** — [https://www.acmicpc.net/problem/2164](https://www.acmicpc.net/problem/2164) | **18258 큐 2** — [https://www.acmicpc.net/problem/18258](https://www.acmicpc.net/problem/18258) | 큐 / 자료구조 직접 구현 | 
| **금요일** | 실버 3 | **2579 계단 오르기** — [https://www.acmicpc.net/problem/2579](https://www.acmicpc.net/problem/2579) | **1463 1로 만들기** — [https://www.acmicpc.net/problem/1463](https://www.acmicpc.net/problem/1463) | DP 점화식 설계 경험 |
| **토요일** | 실버 3 | **1697 숨바꼭질** — [https://www.acmicpc.net/problem/1697](https://www.acmicpc.net/problem/1697) | **2667 단지번호붙이기** — [https://www.acmicpc.net/problem/2667](https://www.acmicpc.net/problem/2667) | BFS 기본 → 그 다음 DFS 응용 | 

이 형태 그대로 참고해줘.

아래와 같이, 지금까지 3개월 동안 풀었던 문제 및 링크를 스케쥴 표를 통해 공유해줄테니, 
지금까지 풀었던 문제를 살펴보고 내가 위에서 말했던 실력향상에 적절한 6일치 문제를 알려줘.

## WEEK 1. 

| 요일 | 난이도 | 문제 1 | 문제 2 | 오늘의 포인트 | 
| ------- | ---- | ------------------------------------------------------------------------------------------------ | ----------------------------------------------------------------------------------------------- | -------------------- | 
| **월요일** | 실버 5 | **1181 단어 정렬** — [https://www.acmicpc.net/problem/1181](https://www.acmicpc.net/problem/1181) | **1427 소트인사이드** — [https://www.acmicpc.net/problem/1427](https://www.acmicpc.net/problem/1427) | 문자열 + 정렬 감각 | 
| **화요일** | 실버 5 | **2751 수 정렬하기 2** — [https://www.acmicpc.net/problem/2751](https://www.acmicpc.net/problem/2751) | **2108 통계학** — [https://www.acmicpc.net/problem/2108](https://www.acmicpc.net/problem/2108) | 정렬 + 구현 사고력 | 
| **수요일** | 실버 4 | **9012 괄호** — [https://www.acmicpc.net/problem/9012](https://www.acmicpc.net/problem/9012) | **4949 균형잡힌 세상** — [https://www.acmicpc.net/problem/4949](https://www.acmicpc.net/problem/4949) | 스택 기본 패턴 체화 | 
| **목요일** | 실버 4 | **2164 카드2** — [https://www.acmicpc.net/problem/2164](https://www.acmicpc.net/problem/2164) | **18258 큐 2** — [https://www.acmicpc.net/problem/18258](https://www.acmicpc.net/problem/18258) | 큐 / 자료구조 직접 구현 | 
| **금요일** | 실버 3 | **2579 계단 오르기** — [https://www.acmicpc.net/problem/2579](https://www.acmicpc.net/problem/2579) | **1463 1로 만들기** — [https://www.acmicpc.net/problem/1463](https://www.acmicpc.net/problem/1463) | DP 점화식 설계 경험 | 
| **토요일** | 실버 3 | **1697 숨바꼭질** — [https://www.acmicpc.net/problem/1697](https://www.acmicpc.net/problem/1697) | **2667 단지번호붙이기** — [https://www.acmicpc.net/problem/2667](https://www.acmicpc.net/problem/2667) | BFS 기본 → 그 다음 DFS 응용 | 

## WEEK 2. 

| 요일 | 난이도 | 문제 1 | 문제 2 | 오늘의 포인트 |
| ------- | ------ | --------------------------------------------------------------------------------------------------------------------------------------------------- | -------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------- | 
| **월요일** | Lv.1 | **K번째수** — [https://school.programmers.co.kr/learn/courses/30/lessons/42748](https://school.programmers.co.kr/learn/courses/30/lessons/42748) | **문자열 내 마음대로 정렬하기** — [https://school.programmers.co.kr/learn/courses/30/lessons/12915](https://school.programmers.co.kr/learn/courses/30/lessons/12915) | 정렬 감각 / Comparator 감각 | 
| **화요일** | Lv.1 | **완주하지 못한 선수** — [https://school.programmers.co.kr/learn/courses/30/lessons/42576](https://school.programmers.co.kr/learn/courses/30/lessons/42576) | **폰켓몬** — [https://school.programmers.co.kr/learn/courses/30/lessons/1845](https://school.programmers.co.kr/learn/courses/30/lessons/1845) | 해시맵 기본 / 카운팅 사고 | 
| **수요일** | Lv.1~2 | **같은 숫자는 싫어** — [https://school.programmers.co.kr/learn/courses/30/lessons/12906](https://school.programmers.co.kr/learn/courses/30/lessons/12906) | **기능개발** — [https://school.programmers.co.kr/learn/courses/30/lessons/42586](https://school.programmers.co.kr/learn/courses/30/lessons/42586) | 스택/큐 기초 패턴 체화 | 
| **목요일** | Lv.1~2 | **체육복** — [https://school.programmers.co.kr/learn/courses/30/lessons/42862](https://school.programmers.co.kr/learn/courses/30/lessons/42862) | **최소직사각형** — [https://school.programmers.co.kr/learn/courses/30/lessons/86491](https://school.programmers.co.kr/learn/courses/30/lessons/86491) | 그리디 사고력 / 규칙성 관찰 | 
| **금요일** | Lv.2 | **올바른 괄호** — [https://school.programmers.co.kr/learn/courses/30/lessons/12909](https://school.programmers.co.kr/learn/courses/30/lessons/12909) | **타겟 넘버** — [https://school.programmers.co.kr/learn/courses/30/lessons/43165](https://school.programmers.co.kr/learn/courses/30/lessons/43165) | 스택 + DFS/BFS 로직 감각 | 
| **토요일** | Lv.2 | **카펫** — [https://school.programmers.co.kr/learn/courses/30/lessons/42842](https://school.programmers.co.kr/learn/courses/30/lessons/42842) | **더 맵게** — [https://school.programmers.co.kr/learn/courses/30/lessons/42626](https://school.programmers.co.kr/learn/courses/30/lessons/42626) | 구현 + 우선순위 큐(PQ) 패턴 | 

## WEEK 3. 

| 요일 | 난이도 | 문제 1 | 문제 2 | 오늘의 포인트 | 
| ------- | ---------- | ---------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------ | ------------------------------ | 
| **월요일** | Silver 5 | **덩치** — [https://www.acmicpc.net/problem/7568](https://www.acmicpc.net/problem/7568) | **단어 정렬** — [https://www.acmicpc.net/problem/1181](https://www.acmicpc.net/problem/1181) | 브루트포스 기본 / 문자열 정렬 Comparator | 
| **화요일** | Silver 1~3 | **신입 사원** — [https://www.acmicpc.net/problem/1946](https://www.acmicpc.net/problem/1946) | **두 수의 합** — [https://www.acmicpc.net/problem/3273](https://www.acmicpc.net/problem/3273) | 정렬 후 조건 처리 / 투포인터 패턴 | 
| **수요일** | Silver 3 | **스택 수열** — [https://www.acmicpc.net/problem/1874](https://www.acmicpc.net/problem/1874) | **프린터 큐** — [https://www.acmicpc.net/problem/1966](https://www.acmicpc.net/problem/1966) | 스택·큐 시뮬레이션 패턴 완벽 이해 | 
| **목요일** | Silver 1~3 | **바이러스** — [https://www.acmicpc.net/problem/2606](https://www.acmicpc.net/problem/2606) | **단지번호붙이기** — [https://www.acmicpc.net/problem/2667](https://www.acmicpc.net/problem/2667) | DFS/BFS 방문처리 · recursion 흐름 읽기 | 
| **금요일** | Silver 3 | **N과 M (2)** — [https://www.acmicpc.net/problem/15650](https://www.acmicpc.net/problem/15650) | **시리얼 번호** — [https://www.acmicpc.net/problem/1431](https://www.acmicpc.net/problem/1431) | 백트래킹 순열/조합 패턴 · 다중 정렬기준 | 
| **토요일** | Silver 3~4 | **1, 2, 3 더하기** — [https://www.acmicpc.net/problem/9095](https://www.acmicpc.net/problem/9095) | **ATM** — [https://www.acmicpc.net/problem/11399](https://www.acmicpc.net/problem/11399) | DP 점화식 사고력 · Greedy 최소합 전략 | 

## WEEK 4. 

| 요일 | 난이도 | 문제 1 | 문제 2 | 오늘의 포인트 | 
| ------- | ------ | ------------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------ | 
| **월요일** | Lv.1 | **정수 내림차순으로 배치하기** — [https://school.programmers.co.kr/learn/courses/30/lessons/12933](https://school.programmers.co.kr/learn/courses/30/lessons/12933) | **문자열 다루기 기본** — [https://school.programmers.co.kr/learn/courses/30/lessons/12918](https://school.programmers.co.kr/learn/courses/30/lessons/12918) | 문자열 처리 / 숫자 처리 감각 | 
| **화요일** | Lv.1 | **시저 암호** — [https://school.programmers.co.kr/learn/courses/30/lessons/12926](https://school.programmers.co.kr/learn/courses/30/lessons/12926) | **약수의 개수와 덧셈** — [https://school.programmers.co.kr/learn/courses/30/lessons/77884](https://school.programmers.co.kr/learn/courses/30/lessons/77884) | 수학적 사고 / 문자열 + 반복문 처리 | 
| **수요일** | Lv.1~2 | **삼총사** — [https://school.programmers.co.kr/learn/courses/30/lessons/131705](https://school.programmers.co.kr/learn/courses/30/lessons/131705) | **두 개 뽑아서 더하기** — [https://school.programmers.co.kr/learn/courses/30/lessons/68644](https://school.programmers.co.kr/learn/courses/30/lessons/68644) | 조합 / 순열 / 중복 처리 패턴 | 
| **목요일** | Lv.2 | **기능개발(스택/큐 변형)** — [https://school.programmers.co.kr/learn/courses/30/lessons/42586](https://school.programmers.co.kr/learn/courses/30/lessons/42586) | **주식 가격** — [https://school.programmers.co.kr/learn/courses/30/lessons/42584](https://school.programmers.co.kr/learn/courses/30/lessons/42584) | 스택/큐 응용 / 시간 복잡도 고려 | 
| **금요일** | Lv.2 | **멀리 뛰기** — [https://school.programmers.co.kr/learn/courses/30/lessons/12914](https://school.programmers.co.kr/learn/courses/30/lessons/12914) | **타일 장식물** — [https://school.programmers.co.kr/learn/courses/30/lessons/12902](https://school.programmers.co.kr/learn/courses/30/lessons/12902) | DP 기초 / 점화식 도출 연습 | 
| **토요일** | Lv.2~3 | **더 큰 수 만들기** — [https://school.programmers.co.kr/learn/courses/30/lessons/42883](https://school.programmers.co.kr/learn/courses/30/lessons/42883) | **조이스틱** — [https://school.programmers.co.kr/learn/courses/30/lessons/42860](https://school.programmers.co.kr/learn/courses/30/lessons/42860) | 그리디 + 구현 / 문자열 최적화 패턴 연습 | 

## WEEK 5. 

| 요일 | 난이도 | 문제 1(백준) | 문제 2(프로그래머스) | 오늘의 포인트 | 
| ------- | ---- | ------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------ | 
| **월요일** | 실버 3 | **2805 나무 자르기** — [https://www.acmicpc.net/problem/2805](https://www.acmicpc.net/problem/2805) | **입국 심사** — [https://school.programmers.co.kr/learn/courses/30/lessons/43238](https://school.programmers.co.kr/learn/courses/30/lessons/43238) | 이분 탐색 핵심 패턴(조건 → mid 판단) | 
| **화요일** | 실버 3 | **21921 블로그** — [https://www.acmicpc.net/problem/21921](https://www.acmicpc.net/problem/21921) | **연속 부분 수열 합의 개수** — [https://school.programmers.co.kr/learn/courses/30/lessons/131701](https://school.programmers.co.kr/learn/courses/30/lessons/131701) | 누적합 + 슬라이딩 윈도우 사고력 | 
| **수요일** | 실버 2 | **11279 최대 힙** — [https://www.acmicpc.net/problem/11279](https://www.acmicpc.net/problem/11279) | **디스크 컨트롤러** — [https://school.programmers.co.kr/learn/courses/30/lessons/42627](https://school.programmers.co.kr/learn/courses/30/lessons/42627) | 우선순위 큐(PQ) 심화 / 스케줄링 패턴 | 
| **목요일** | 실버 2 | **18352 특정 거리의 도시 찾기** — [https://www.acmicpc.net/problem/18352](https://www.acmicpc.net/problem/18352) | **가장 먼 노드** — [https://school.programmers.co.kr/learn/courses/30/lessons/49189](https://school.programmers.co.kr/learn/courses/30/lessons/49189) | BFS 기반 최단거리(=다익스트라 입문) | 
| **금요일** | 실버 2 | **2003 수들의 합 2** — [https://www.acmicpc.net/problem/2003](https://www.acmicpc.net/problem/2003) | **숫자의 표현** — [https://school.programmers.co.kr/learn/courses/30/lessons/12924](https://school.programmers.co.kr/learn/courses/30/lessons/12924) | 투포인터 + 부분합 케이스 분할 능력 | 
| **토요일** | 실버 1 | **14888 연산자 끼워넣기** — [https://www.acmicpc.net/problem/14888](https://www.acmicpc.net/problem/14888) | **카카오 2020 - 괄호 변환** — [https://school.programmers.co.kr/learn/courses/30/lessons/60058](https://school.programmers.co.kr/learn/courses/30/lessons/60058) | 백트래킹 + 구현 / 문자열 재귀 패턴 |

## WEEK 6.

| 요일      | 난이도     | 문제 1(백준)                                                                                             | 문제 2(프로그래머스)                                                                                                                                         | 오늘의 포인트               |
| ------- | ------- | ---------------------------------------------------------------------------------------------------- | ---------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------- |
| **월요일** | 실버 2    | **1654 랜선 자르기** — [https://www.acmicpc.net/problem/1654](https://www.acmicpc.net/problem/1654)       | **징검다리** — [https://school.programmers.co.kr/learn/courses/30/lessons/43236](https://school.programmers.co.kr/learn/courses/30/lessons/43236)        | 이분 탐색 심화(조건 → mid 검증) |
| **화요일** | 실버 1    | **12919 A와 B 2** — [https://www.acmicpc.net/problem/12919](https://www.acmicpc.net/problem/12919)    | **N-Queen** — [https://school.programmers.co.kr/learn/courses/30/lessons/12952](https://school.programmers.co.kr/learn/courses/30/lessons/12952)     | 백트래킹 핵심 로직 구조 완전 이해   |
| **수요일** | 실버 1    | **1149 RGB 거리** — [https://www.acmicpc.net/problem/1149](https://www.acmicpc.net/problem/1149)       | **정수 삼각형** — [https://school.programmers.co.kr/learn/courses/30/lessons/43105](https://school.programmers.co.kr/learn/courses/30/lessons/43105)      | DP 점화식 구성 능력 향상       |
| **목요일** | 실버 2    | **11724 연결 요소의 개수** — [https://www.acmicpc.net/problem/11724](https://www.acmicpc.net/problem/11724) | **전력망을 둘로 나누기** — [https://school.programmers.co.kr/learn/courses/30/lessons/86971](https://school.programmers.co.kr/learn/courses/30/lessons/86971) | 그래프 연결성 + 분할/트리 구조 이해 |
| **금요일** | 실버 1    | **1991 트리 순회** — [https://www.acmicpc.net/problem/1991](https://www.acmicpc.net/problem/1991)        | **길 찾기 게임** — [https://school.programmers.co.kr/learn/courses/30/lessons/42892](https://school.programmers.co.kr/learn/courses/30/lessons/42892)     | 트리 구조/순회 패턴 체화        |
| **토요일** | 골드 5 입문 | **1753 최단경로** — [https://www.acmicpc.net/problem/1753](https://www.acmicpc.net/problem/1753)         | **배달** — [https://school.programmers.co.kr/learn/courses/30/lessons/12978](https://school.programmers.co.kr/learn/courses/30/lessons/12978)          | 다익스트라(최단 거리)의 정석 패턴   | 

## WEEK 7.

| 요일      | 난이도  | 문제 1 (백준)                                                                                        | 문제 2 (프로그래머스)                                                                                                                                    | 오늘의 포인트              |
| ------- | ---- | ------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------ | -------------------- |
| **월요일** | 실버 1 | **1931 회의실 배정** — [https://www.acmicpc.net/problem/1931](https://www.acmicpc.net/problem/1931)   | **구명보트** — [https://school.programmers.co.kr/learn/courses/30/lessons/42885](https://school.programmers.co.kr/learn/courses/30/lessons/42885)    | 그리디의 정석(정렬 기준 설계)    |
| **화요일** | 실버 1 | **11047 동전 0** — [https://www.acmicpc.net/problem/11047](https://www.acmicpc.net/problem/11047)  | **큰 수 만들기** — [https://school.programmers.co.kr/learn/courses/30/lessons/42883](https://school.programmers.co.kr/learn/courses/30/lessons/42883) | 그리디 최적 선택 증명 감각      |
| **수요일** | 실버 2 | **1260 DFS와 BFS** — [https://www.acmicpc.net/problem/1260](https://www.acmicpc.net/problem/1260) | **게임 맵 최단거리** — [https://school.programmers.co.kr/learn/courses/30/lessons/1844](https://school.programmers.co.kr/learn/courses/30/lessons/1844) | BFS / DFS 비교 + 방문 처리 |
| **목요일** | 실버 1 | **2178 미로 탐색** — [https://www.acmicpc.net/problem/2178](https://www.acmicpc.net/problem/2178)    | **네트워크** — [https://school.programmers.co.kr/learn/courses/30/lessons/43162](https://school.programmers.co.kr/learn/courses/30/lessons/43162)    | 그래프 연결성 + BFS 실전화    |
| **금요일** | 골드 5 | **7576 토마토** — [https://www.acmicpc.net/problem/7576](https://www.acmicpc.net/problem/7576)      | **단어 변환** — [https://school.programmers.co.kr/learn/courses/30/lessons/43163](https://school.programmers.co.kr/learn/courses/30/lessons/43163)   | BFS 레벨 개념 + 상태 전이    |
| **토요일** | 골드 5 | **9663 N-Queen** — [https://www.acmicpc.net/problem/9663](https://www.acmicpc.net/problem/9663)  | **피로도** — [https://school.programmers.co.kr/learn/courses/30/lessons/87946](https://school.programmers.co.kr/learn/courses/30/lessons/87946)     | 백트래킹 가지치기 완성         |

## WEEK 8.

| 요일      | 난이도  | 문제 1 (백준)                                                                                                  | 문제 2 (프로그래머스)                                                                                                                                           | 오늘의 포인트               |
| ------- | ---- | ---------------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------- |
| **월요일** | 실버 1 | **14501 퇴사** — [https://www.acmicpc.net/problem/14501](https://www.acmicpc.net/problem/14501)              | **상담원 인원** — [https://school.programmers.co.kr/learn/courses/30/lessons/214288](https://school.programmers.co.kr/learn/courses/30/lessons/214288)       | DP vs 그리디 판단 / 일정 최적화 |
| **화요일** | 실버 1 | **1806 부분합** — [https://www.acmicpc.net/problem/1806](https://www.acmicpc.net/problem/1806)                | **연속된 부분 수열의 합** — [https://school.programmers.co.kr/learn/courses/30/lessons/178870](https://school.programmers.co.kr/learn/courses/30/lessons/178870) | 투포인터 최소/최대 길이 패턴      |
| **수요일** | 실버 2 | **2644 촌수계산** — [https://www.acmicpc.net/problem/2644](https://www.acmicpc.net/problem/2644)               | **가장 먼 노드** — [https://school.programmers.co.kr/learn/courses/30/lessons/49189](https://school.programmers.co.kr/learn/courses/30/lessons/49189)        | BFS 거리 계산 / 레벨 개념 재확인 |
| **목요일** | 실버 1 | **6236 용돈 관리** — [https://www.acmicpc.net/problem/6236](https://www.acmicpc.net/problem/6236)              | **입국 심사 (복습)** — [https://school.programmers.co.kr/learn/courses/30/lessons/43238](https://school.programmers.co.kr/learn/courses/30/lessons/43238)     | 이분 탐색 조건 설계 완성        |
| **금요일** | 실버 1 | **11053 가장 긴 증가하는 부분 수열** — [https://www.acmicpc.net/problem/11053](https://www.acmicpc.net/problem/11053) | **정수 삼각형 (복습)** — [https://school.programmers.co.kr/learn/courses/30/lessons/43105](https://school.programmers.co.kr/learn/courses/30/lessons/43105)    | DP 상태 정의 / 점화식 감각     |
| **토요일** | 골드 5 | **10026 적록색약** — [https://www.acmicpc.net/problem/10026](https://www.acmicpc.net/problem/10026)            | **여행경로** — [https://school.programmers.co.kr/learn/courses/30/lessons/43164](https://school.programmers.co.kr/learn/courses/30/lessons/43164)           | DFS 응용 + 방문 처리 심화     | 

## WEEK 9.

| 요일      | 난이도     | 문제 1 (백준)                                                                                           | 문제 2 (프로그래머스)                                                                                                                                             | 오늘의 포인트                 |
| ------- | ------- | --------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------- | ----------------------- |
| **월요일** | 실버 1    | **2512 예산** — [https://www.acmicpc.net/problem/2512](https://www.acmicpc.net/problem/2512)          | **예산** — [https://school.programmers.co.kr/learn/courses/30/lessons/12982](https://school.programmers.co.kr/learn/courses/30/lessons/12982)               | 이분탐색 vs 그리디 판단 / 상한선 개념 |
| **화요일** | 실버 2    | **11048 이동하기** — [https://www.acmicpc.net/problem/11048](https://www.acmicpc.net/problem/11048)     | **땅따먹기** — [https://school.programmers.co.kr/learn/courses/30/lessons/12913](https://school.programmers.co.kr/learn/courses/30/lessons/12913)             | DP 2차원 상태 전이 / 이전 상태 활용 |
| **수요일** | 실버 1    | **7562 나이트의 이동** — [https://www.acmicpc.net/problem/7562](https://www.acmicpc.net/problem/7562)     | **미로 탈출** — [https://school.programmers.co.kr/learn/courses/30/lessons/159993](https://school.programmers.co.kr/learn/courses/30/lessons/159993)          | BFS 최단거리 + 상태 분리        |
| **목요일** | 실버 1    | **20922 겹치는 건 싫어** — [https://www.acmicpc.net/problem/20922](https://www.acmicpc.net/problem/20922) | **연속 부분 수열 합의 개수** — [https://school.programmers.co.kr/learn/courses/30/lessons/131701](https://school.programmers.co.kr/learn/courses/30/lessons/131701) | 투포인터 / 슬라이딩 윈도우 완성      |
| **금요일** | 실버 1    | **1189 컴백홈** — [https://www.acmicpc.net/problem/1189](https://www.acmicpc.net/problem/1189)         | **피로도** — [https://school.programmers.co.kr/learn/courses/30/lessons/87946](https://school.programmers.co.kr/learn/courses/30/lessons/87946)              | DFS 백트래킹 / 방문 처리 설계     |
| **토요일** | 골드 5 입문 | **12851 숨바꼭질 2** — [https://www.acmicpc.net/problem/12851](https://www.acmicpc.net/problem/12851)   | **단어 변환** — [https://school.programmers.co.kr/learn/courses/30/lessons/43163](https://school.programmers.co.kr/learn/courses/30/lessons/43163)            | BFS 레벨 개념 + 경우의 수 관리    |

## WEEK 10.

| 요일      | 난이도     | 문제 1 (백준)                                                                                               | 문제 2 (프로그래머스)                                                                                                                                             | 오늘의 포인트               |
| ------- | ------- | ------------------------------------------------------------------------------------------------------- | --------------------------------------------------------------------------------------------------------------------------------------------------------- | --------------------- |
| **월요일** | 실버 1    | **1309 동물원** — [https://www.acmicpc.net/problem/1309](https://www.acmicpc.net/problem/1309)             | **멀리 뛰기 (복습 관점)** — [https://school.programmers.co.kr/learn/courses/30/lessons/12914](https://school.programmers.co.kr/learn/courses/30/lessons/12914)    | DP 점화식 단순화 / 경우의 수 압축 |
| **화요일** | 실버 1    | **21736 헌내기는 친구가 필요해** — [https://www.acmicpc.net/problem/21736](https://www.acmicpc.net/problem/21736) | **게임 맵 최단거리 (복습)** — [https://school.programmers.co.kr/learn/courses/30/lessons/1844](https://school.programmers.co.kr/learn/courses/30/lessons/1844)     | BFS 탐색 범위/조건 처리 안정화   |
| **수요일** | 실버 1    | **2468 안전 영역** — [https://www.acmicpc.net/problem/2468](https://www.acmicpc.net/problem/2468)           | **전력망을 둘로 나누기 (복습)** — [https://school.programmers.co.kr/learn/courses/30/lessons/86971](https://school.programmers.co.kr/learn/courses/30/lessons/86971) | DFS/BFS + 연결요소 사고 전환  |
| **목요일** | 실버 1    | **1932 정수 삼각형** — [https://www.acmicpc.net/problem/1932](https://www.acmicpc.net/problem/1932)          | **땅따먹기 (복습)** — [https://school.programmers.co.kr/learn/courses/30/lessons/12913](https://school.programmers.co.kr/learn/courses/30/lessons/12913)        | DP 2차원 → 1차원 전이 감각    |
| **금요일** | 실버 1    | **16401 과자 나눠주기** — [https://www.acmicpc.net/problem/16401](https://www.acmicpc.net/problem/16401)      | **예산 (복습)** — [https://school.programmers.co.kr/learn/courses/30/lessons/12982](https://school.programmers.co.kr/learn/courses/30/lessons/12982)          | 이분탐색 vs 그리디 판단 기준     |
| **토요일** | 골드 5 입문 | **15686 치킨 배달** — [https://www.acmicpc.net/problem/15686](https://www.acmicpc.net/problem/15686)        | **피로도 (복습)** — [https://school.programmers.co.kr/learn/courses/30/lessons/87946](https://school.programmers.co.kr/learn/courses/30/lessons/87946)         | 백트래킹 + 조합 최적화 감각      |

## WEEK 11. 

| 요일      | 난이도     | 문제 1                                                                                                   | 문제 2                                                                                                                                              | 오늘의 포인트                |
| ------- | ------- | ------------------------------------------------------------------------------------------------------ | ------------------------------------------------------------------------------------------------------------------------------------------------- | ---------------------- |
| **월요일** | 실버 1    | **1389 케빈 베이컨의 6단계 법칙** — [https://www.acmicpc.net/problem/1389](https://www.acmicpc.net/problem/1389) | **가장 먼 노드** — [https://school.programmers.co.kr/learn/courses/30/lessons/49189](https://school.programmers.co.kr/learn/courses/30/lessons/49189)  | BFS 거리 누적 / 최단거리 배열 활용 |
| **화요일** | 실버 1    | **2293 동전 1** — [https://www.acmicpc.net/problem/2293](https://www.acmicpc.net/problem/2293)           | **등굣길** — [https://school.programmers.co.kr/learn/courses/30/lessons/42898](https://school.programmers.co.kr/learn/courses/30/lessons/42898)      | DP 경우의 수 / 중복 제거 설계    |
| **수요일** | 실버 1    | **15649 N과 M (1)** — [https://www.acmicpc.net/problem/15649](https://www.acmicpc.net/problem/15649)    | **소수 찾기** — [https://school.programmers.co.kr/learn/courses/30/lessons/42839](https://school.programmers.co.kr/learn/courses/30/lessons/42839)    | 백트래킹 기본형 + 순열 상태관리     |
| **목요일** | 실버 1    | **2805 나무 자르기 (복습 관점)** — [https://www.acmicpc.net/problem/2805](https://www.acmicpc.net/problem/2805) | **징검다리 건너기** — [https://school.programmers.co.kr/learn/courses/30/lessons/64062](https://school.programmers.co.kr/learn/courses/30/lessons/64062) | 이분탐색 조건 판단 / mid 검증    |
| **금요일** | 실버 1    | **1912 연속합** — [https://www.acmicpc.net/problem/1912](https://www.acmicpc.net/problem/1912)            | **최댓값과 최솟값** — [https://school.programmers.co.kr/learn/courses/30/lessons/12939](https://school.programmers.co.kr/learn/courses/30/lessons/12939) | DP 1차원 압축 / 상태 유지      |
| **토요일** | 골드 5 입문 | **1759 암호 만들기** — [https://www.acmicpc.net/problem/1759](https://www.acmicpc.net/problem/1759)         | **메뉴 리뉴얼** — [https://school.programmers.co.kr/learn/courses/30/lessons/72411](https://school.programmers.co.kr/learn/courses/30/lessons/72411)   | 조합 + 조건 필터링 / 문자열 처리   |

## WEEK 12.

| 요일      | 난이도  | 문제 1 (백준)                                                                                             | 문제 2 (프로그래머스)                                                                                                                                           | 오늘의 포인트                   |
| ------- | ---- | ----------------------------------------------------------------------------------------------------- | ------------------------------------------------------------------------------------------------------------------------------------------------------- | ------------------------- |
| **월요일** | 실버 1 | **11659 구간 합 구하기 4** — [https://www.acmicpc.net/problem/11659](https://www.acmicpc.net/problem/11659) | **구간 합 구하기** — [https://school.programmers.co.kr/learn/courses/30/lessons/12980](https://school.programmers.co.kr/learn/courses/30/lessons/12980)       | 누적합 기본형 / 전처리 vs 쿼리 분리 사고 |
| **화요일** | 실버 1 | **2003 수들의 합 2** — [https://www.acmicpc.net/problem/2003](https://www.acmicpc.net/problem/2003)       | **연속된 부분 수열의 합** — [https://school.programmers.co.kr/learn/courses/30/lessons/178870](https://school.programmers.co.kr/learn/courses/30/lessons/178870) | 투포인터 시작·종료 조건 완전 고정       |
| **수요일** | 실버 1 | **16953 A → B** — [https://www.acmicpc.net/problem/16953](https://www.acmicpc.net/problem/16953)      | **숫자 변환하기** — [https://school.programmers.co.kr/learn/courses/30/lessons/154538](https://school.programmers.co.kr/learn/courses/30/lessons/154538)      | BFS vs 그리디 판단 / 상태 전이 설계  |
| **목요일** | 실버 1 | **9465 스티커** — [https://www.acmicpc.net/problem/9465](https://www.acmicpc.net/problem/9465)           | **땅따먹기** — [https://school.programmers.co.kr/learn/courses/30/lessons/12913](https://school.programmers.co.kr/learn/courses/30/lessons/12913)           | DP 2차원 → 1차원 압축 사고        |
| **금요일** | 실버 1 | **15663 N과 M (9)** — [https://www.acmicpc.net/problem/15663](https://www.acmicpc.net/problem/15663)   | **메뉴 리뉴얼 (복습)** — [https://school.programmers.co.kr/learn/courses/30/lessons/72411](https://school.programmers.co.kr/learn/courses/30/lessons/72411)    | 중복 제거 백트래킹 / 조합 설계        |
| **토요일** | 골드 5 | **18428 감시 피하기** — [https://www.acmicpc.net/problem/18428](https://www.acmicpc.net/problem/18428)     | **거리두기 확인하기** — [https://school.programmers.co.kr/learn/courses/30/lessons/81302](https://school.programmers.co.kr/learn/courses/30/lessons/81302)      | 완전탐색 + 조건 검증 / 구현 마무리     |

## WEEK 13.

| 요일      | 난이도  | 문제 1                                                                                                                                                      | 
| ------- | ---- |-----------------------------------------------------------------------------------------------------------------------------------------------------------| 
| **월요일** | 실버 1 | **1743 음식물 피하기** — [https://www.acmicpc.net/problem/1743](https://www.acmicpc.net/problem/1743)                                                           |  
| **화요일** | Lv.2 | **42587 큐와 우선순위 큐** — [https://school.programmers.co.kr/learn/courses/30/lessons/42587](https://school.programmers.co.kr/learn/courses/30/lessons/42587)  |  
| **수요일** | 실버 1 | **1629 거듭제곱** — [https://www.acmicpc.net/problem/1629](https://www.acmicpc.net/problem/1629)                                                              |           
| **목요일** | Lv.2 | **86971 전력망 둘로 나누기** — [https://school.programmers.co.kr/learn/courses/30/lessons/86971](https://school.programmers.co.kr/learn/courses/30/lessons/86971) |
| **금요일** | 골드 4 | **9019 A to B** — [https://www.acmicpc.net/problem/9019](https://www.acmicpc.net/problem/9019)                                                            |  
| **토요일** | Lv.3 | **43162 Networks** — [https://school.programmers.co.kr/learn/courses/30/lessons/43162](https://school.programmers.co.kr/learn/courses/30/lessons/43162)   | 
