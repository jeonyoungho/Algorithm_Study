import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Main {
	
	static class Edge implements Comparable<Edge> {
		int v, weight;
		
		public Edge(int v, int weight) {
			this.v = v;
			this.weight = weight;
		}
		
		public int compareTo(Edge e) {
			return Integer.compare(this.weight, e.weight);
		}
		
		@Override
		public String toString() {
			return weight + "";
		}
		
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int V = sc.nextInt();
		int E = sc.nextInt();
		List<Edge>[] adj = new ArrayList[V];
		for (int i = 0; i < V; i++)
			adj[i] = new ArrayList<>();
		
		for (int i = 0; i < E; i++) {
			// 첫번째가 출발지, 두번째가 도착지, 세번째가 가중치
			adj[sc.nextInt()].add(new Edge(sc.nextInt(), sc.nextInt()));
		}
		
		// Dijkstra
		PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
		boolean[] check = new boolean[V];
		Edge[] distance = new Edge[V];
		
		
		// 3번에서 출발하는걸로.
		for (int i = 0; i < V; i++) {
			// 원하는 출발지
			if (i == 3) {
				distance[i] = new Edge(i, 0);
			} else {
				distance[i] = new Edge(i, Integer.MAX_VALUE);
			}
			pq.add(distance[i]);
		}
				
		while(!pq.isEmpty()) {
			Edge edge = pq.poll();
			
			// 큐에서 뽑아낸 간선에 해당하는 정점들을 순회
			for(Edge next:adj[edge.v]) { 
				// check되지 않았으면서, D[next.v]가 D[edge.v] + next.weight 보다 더 크다면 갱신
				if(!check[next.v] && distance[next.v].weight > distance[edge.v].weight + next.weight) {
					distance[next.v].weight = distance[edge.v].weight + next.weight;
					// decrease key
					pq.remove(distance[next.v]);
					pq.add(distance[next.v]);
				}
			}
			check[edge.v] = true;
		}
		
		System.out.println(Arrays.toString(distance));
		
		sc.close();

	}

}
