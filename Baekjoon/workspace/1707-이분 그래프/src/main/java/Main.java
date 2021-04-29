import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	public static int[] visited;
	public static ArrayList<ArrayList<Integer>> graph;

	public static void main(String[] args) throws NumberFormatException, IOException   {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int K = Integer.parseInt(br.readLine());
		
		for(int tc=0;tc<K;tc++) {
			String[] splited = br.readLine().split(" ");
			int vertex = Integer.parseInt(splited[0]);
			int edge = Integer.parseInt(splited[1]);
			
			graph = new ArrayList<>(); 
			for (int i = 0; i < vertex+1; i++) { 
				graph.add(new ArrayList<>()); 
			}

			for(int i=0;i<edge;i++) {
				String[] edges = br.readLine().split(" ");
				int v = Integer.parseInt(edges[0]);
				int w = Integer.parseInt(edges[1]);
				
				graph.get(v).add(w); 
				graph.get(w).add(v);
			}
			
			visited = new int[vertex+1];
			boolean flag = false;
			for(int i=1;i<vertex;i++) {
				if(visited[i] == 0 && bfs(i) == false) {
					flag = true;
					break;
				}
			}
			
			if(flag == true) {
				bw.write("NO\n");
			} else {
				bw.write("YES\n");
			}
			
		}
		
		bw.flush();
		bw.close();
		
		br.close();
		
	}
	
	private static boolean bfs(int n) {
		Queue<Integer> queue = new LinkedList<>();
		queue.add(n);
		visited[n] = 1;
		
		while(!queue.isEmpty()) {
			int node = queue.poll();
			
			for(Integer i:graph.get(node)) {
				if (visited[node] == visited[i]) {
					return false;
				}
				
				if (visited[i] == 0) {
					visited[i] = visited[node] * -1;
					queue.add(i);
				}
					
			}
		}
		
		return true;
	}
	
}
