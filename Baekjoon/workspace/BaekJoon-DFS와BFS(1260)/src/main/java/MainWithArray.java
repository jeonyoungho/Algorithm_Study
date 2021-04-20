import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class MainWithArray {
	
	static BufferedReader br;
	static BufferedWriter bw;
	
	public static void main(String[] args) throws NumberFormatException, IOException   {
		br = new BufferedReader(new InputStreamReader(System.in));
		bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] splited = br.readLine().split(" ");
		int N = Integer.parseInt(splited[0]);
		int M = Integer.parseInt(splited[1]);
		int V = Integer.parseInt(splited[2]);
		
		int[][] arr = new int[N+1][N+1];
		for(int i=0;i<M;i++) {
			String[] edges = br.readLine().split(" ");
			int v = Integer.parseInt(edges[0]);
			int w = Integer.parseInt(edges[1]);
			arr[v][w] = 1;
			arr[w][v] = 1;
		}
		
		// Invoke DFS
		boolean[] isVisited = new boolean[N+1];
		isVisited[0] = true;
		dfs(arr, isVisited, N, V);
		bw.write("\n");

		// Invoke BFS
		bfs(arr, N, V);
		bw.write("\n");
		
		bw.flush();
		bw.close();
		br.close();
		
	}
	
	private static void dfs(int[][] arr, boolean[] isVisited, int nodeCnt, int start) throws IOException {
		isVisited[start] = true;
		bw.write(start + " ");

		for(int i=1;i<=nodeCnt;i++) {
			if(arr[start][i] == 1 && isVisited[i] == false) {
				dfs(arr, isVisited, nodeCnt, i);
			}
			
		}
		
	}
	
	private static void bfs(int[][] arr, int nodeCnt, int start) throws IOException {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(start);
		
		boolean[] isVisited = new boolean[nodeCnt+1];
		isVisited[0] = true;
		isVisited[start] = true;
		bw.write(start + " ");
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			for(int i=1;i<=nodeCnt;i++) {
				
				if (arr[node][i] == 1 && isVisited[i] == false) {
					isVisited[i] = true;
					bw.write(i + " ");
					queue.offer(i);
				}
			}
			
		}
		
	}
	
}
