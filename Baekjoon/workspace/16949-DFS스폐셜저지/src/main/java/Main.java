import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.HashSet;

public class Main {
	
	static ArrayList<Integer>[] adj;
	static int[] answer;
	static boolean[] visited;
	static boolean flag;
	static int N, idx;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		adj = new ArrayList[N+1];
		
		for(int i=1;i<=N;i++) {
			adj[i] = new ArrayList<Integer>();
		}
		
		for(int i=1;i<=N-1;i++) {
			String[] splited = br.readLine().split(" ");
			int start = Integer.parseInt(splited[0]);
			int end = Integer.parseInt(splited[1]);
			adj[start].add(end);
			adj[end].add(start);
		}
		
		answer = new int[N];
		flag = true;
		visited = new boolean[N+1];
		idx = 1;
		
		String[] expected = br.readLine().trim().split(" ");
		for(int i=0;i<expected.length;i++) {
			answer[i] = Integer.parseInt(expected[i]);
		}
		
		dfs(1);
		
		if(flag) {
			bw.write(1 + "");
		} else {
			bw.write(0 + "");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void dfs(int x) {
		if(visited[x]) return;
		
		// x를 방문
		visited[x] = true;
		
		HashSet<Integer> set = new HashSet<>();
		for(Integer next:adj[x]) {
			if(visited[next] == false)
				set.add(next);				
		}
		
		if(set.size() == 0) return;
		
		if(set.contains(answer[idx])) {
			dfs(answer[idx++]);
		} else {
			flag = false;
		}
		
	}
	
}
