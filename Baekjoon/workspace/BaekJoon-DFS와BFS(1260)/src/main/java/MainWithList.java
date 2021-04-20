import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Queue;

public class MainWithList {
	
	
	static ArrayList<ArrayList<Integer>> adj;
	static BufferedReader br;
	static BufferedWriter bw;
	
	public static void main(String[] args) throws NumberFormatException, IOException   {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] splited = br.readLine().split(" ");
		int N = Integer.parseInt(splited[0]);
		int M = Integer.parseInt(splited[1]);
		int V = Integer.parseInt(splited[2]);
		
		adj = new ArrayList<>();
		adj.add(new ArrayList<Integer>()); // 0번 노드가 있다는 가정하에 하나 추가시켜줌
		for(int i=1;i<=N;i++) {
			adj.add(new ArrayList<Integer>());
		}
		
		for(int i=0;i<M;i++) {
			String[] edges = br.readLine().split(" ");
			int v = Integer.parseInt(edges[0]) ;
			int w = Integer.parseInt(edges[1]);
			
			adj.get(v).add(w);
			adj.get(w).add(v);
		}
		
		for(int i=1;i<=N;i++) {
			Collections.sort(adj.get(i));
		}
		
//		for(int i=1;i<adj.size();i++) {
//			System.out.print("i: " + i + " -> ");
//			for(int j=0;j<adj.get(i).size();j++) {
//				System.out.print(adj.get(i).get(j) + " ");
//			}
//			System.out.println();
//		}
		
		
		// Invoke DFS
		boolean[] isVisited = new boolean[N+1];
		isVisited[0] = true;
		dfs(isVisited, V);
		bw.write("\n");

		// Invoke BFS
		bfs(N, V);
		bw.write("\n");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	private static void dfs(boolean[] isVisited, int start) throws IOException {
		isVisited[start] = true;
		bw.write(start + " ");

		for(int i=0;i<adj.get(start).size();i++) {
			int node = adj.get(start).get(i);
			if(isVisited[node] == false) {
				dfs(isVisited, node);
			}
			
		}
		
	}
	
	private static void bfs(int nodeCnt, int start) throws IOException {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		
		boolean[] isVisited = new boolean[nodeCnt+1];
		isVisited[0] = true;
		isVisited[start] = true;
		bw.write(start + " ");
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			for(int i=0;i<adj.get(node).size();i++) {
				int adjNode = adj.get(node).get(i);
				if(isVisited[adjNode] == false) {
					isVisited[adjNode] = true;
					bw.write(adjNode + " ");
					queue.offer(adjNode);
				}
				
			}
			
		}
		
	}
	
}
