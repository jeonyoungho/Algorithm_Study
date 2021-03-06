# DFS와 BFS의 비교

## 구현 방법
|DFS(깊이우선탐색)|BFS(너비우선탐색|
|현재 정점에서 갈 수 있는 점들까지 들어가면서 탐색|현재 정점에 연결된 가까운 점들부터 탐색|
|스택 또는 재귀함수로 구현|FIFO방식인 큐 사용(Prim, Dijkstra 알고리즘과 유사)|

## 시간 복잡도
- 두 알고리즘 모두 조건 내의 모든 노드를 검색한다는 점에서 시간 복잡도는 동일
- N은 노드, E는 간선일 때
    - 인접 리스트 : O(N+E)
    - 인접 행렬 : O(N²)

## 깊이 우선 탐색(DFS)과 너비 우선 탐색(BFS) 활용한 문제 유형/응용
1. <b>그래프의 모든 정점을 방문하는 것이 주요한 문제</b>
- <b>DFS, BFS 아무거나 사용해도 됨</b>

2. <b>각각의 경로마다 특징을 저장해둬야 하는 문제</b>
- <b>DFS사용(BFS는 경로의 특징을 가지지 못함)</b>
- 예를 들면 각 정점에 숫자가 적혀있고 a부터 b까지 가는 경로를 구하는데 경로에 같은 숫자가 있으면 안된다는 문제

3. <b>최단거리를 구하는 문제</b>
- <b>BFS사용(DFS는 처음 발견되는 해답이 최단거리가 아닐 수도 있음)</b>
- 예를 들면, 미로 찾기

4. <b>검색 대상 그래프가 정말 큰 문제</b>
- <b>DFS사용</b>

5. <b>검색 대상의 규모가 크지 않고, 검색 시작 지점으로부터 원하는 대상이 별로 멀지 않은 문제</b>
- <b>BFS사용</b>

#### 출처
- https://gmlwjd9405.github.io/2018/08/15/algorithm-bfs.html
- https://devuna.tistory.com/32