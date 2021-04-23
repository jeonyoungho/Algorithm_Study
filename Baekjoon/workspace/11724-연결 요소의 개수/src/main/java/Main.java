import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.HashMap;

public class Main {
	
	static int[] arr;
	
	public static void main(String[] args) throws NumberFormatException, IOException   {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] inputSplited = br.readLine().split(" ");
		
		int N = Integer.parseInt(inputSplited[0]);
		int M = Integer.parseInt(inputSplited[1]);
		
		arr = new int[N+1];
		for(int i=1;i<=N;i++) {
			arr[i] = i;
		}
		for(int i=0;i<M;i++) {
			String[] splited = br.readLine().split(" ");
			int v = Integer.parseInt(splited[0]);
			int w = Integer.parseInt(splited[1]);
			
			union(v, w);
		}
		
		HashMap<Integer, Integer> map = new HashMap<>();
		for(int i=1;i<=N;i++) {
			int r1 = find(i);
			map.put(r1, map.getOrDefault(r1, 0) + 1);
		}
		
		bw.write(map.size() + "");
		bw.flush();
		bw.close();
		
		br.close();
		
	}
	
	private static int find(int v) {
		if(arr[v] == v)
			return v;
		
		return arr[v] = find(arr[v]);
	}
	
	private static void union(int v, int w) {
		int r1 = find(v);
		int r2 = find(w);
		
		if(r1 > r2) {
			arr[r1] = r2; 
		} else if (r1 < r2) {
			arr[r2] = r1;
		}
	}
	
}
