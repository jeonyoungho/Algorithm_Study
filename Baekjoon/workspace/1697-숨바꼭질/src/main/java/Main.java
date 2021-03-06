import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static int N, K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] splited = br.readLine().split(" ");
		
		boolean[] visit = new boolean[100001]; 
		N = Integer.parseInt(splited[0]);
		K = Integer.parseInt(splited[1]);
		
		if(N == K) {
			bw.write("0");
			bw.flush();
			bw.close();
			br.close();
			return;
		}
			
		
		int cnt = 0;
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N);
		visit[N] = true;
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			boolean found = false;
			for(int i=0;i<size;i++) {
				int current = queue.poll();
				
				int n1 = current + 1;
				int n2 = current - 1;
				int n3 = current * 2;
				
				if(n1 == K || n2 == K || n3 == K) {
					found = true;
					break;
				}
				
				if(n1 >= 0 && n1 <= 100000 && !visit[n1]) {
					visit[n1] = true;
					queue.add(n1);
				}
				
				if(n2 >= 0 && n2 <= 100000 && !visit[n2]) {
					visit[n2] = true;
					queue.add(n2);
				}
				
				if(n3 >= 0 && n3 <= 100000 && !visit[n3]) {
					visit[n3] = true;
					queue.add(n3);
				}
				
			}
			
			cnt++;
			if(found) {
				break;
			} 
		}

		bw.write(cnt + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
