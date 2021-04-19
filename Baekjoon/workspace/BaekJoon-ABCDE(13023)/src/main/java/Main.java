import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Main {
	
	static ArrayList<ArrayList<Integer>> graph;
	static boolean[] isVisited;
	
	public static void main(String[] args) throws NumberFormatException, IOException   {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] splited = br.readLine().split(" ");
		int N = Integer.parseInt(splited[0]);
		int M = Integer.parseInt(splited[1]);
		
		graph = new ArrayList<ArrayList<Integer>>();
		
		for(int i=0;i<N;i++)
			graph.add(new ArrayList<Integer>());
		
		for(int i=0;i<M;i++) {
			String[] strs = br.readLine().split(" ");
			
			int v = Integer.parseInt(strs[0]);
			int w = Integer.parseInt(strs[1]);
			
			graph.get(v).add(w);
			graph.get(w).add(v);
		}
		
		for(int i=0;i<N;i++) {
			isVisited = new boolean[N];
			if(dfs(i, 1)) {
				bw.write("1");
				bw.flush();
				bw.close();
				System.exit(0);
			}
		}
		
		bw.write("0");
		bw.flush();
		bw.close();
		
		br.close();
		
	}
	
	private static boolean dfs(int next, int depth) throws IOException {
		if(depth == 5) return true;
		
		isVisited[next] = true;
		for(int i=0;i<graph.get(next).size();i++) {
			int target = graph.get(next).get(i);
			if(isVisited[target] == true) continue;
			if(dfs(target, depth+1)) {
				return true;
			}
		}
		
		isVisited[next] = false;
		return false;
	}
	
}
