import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] splited = br.readLine().split(" ");
		int N = Integer.parseInt(splited[0]);
		int K = Integer.parseInt(splited[1]);
		
		int[] times = new int[100001];
		Arrays.fill(times, -1);
		
		Queue<Integer> queue = new LinkedList<Integer>();
		queue.add(N);
		times[N] = 0;
		
		while(!queue.isEmpty()) {
			int cur = queue.poll();
			if(cur == K) {
				bw.write(times[K] + "");
				bw.flush();
				bw.close();
				br.close();
				return;
			}
			
			int[] direction = {cur, -1, 1};
			for(int i=0;i<3;i++) {
				int next = cur + direction[i];
				if(next >= 0 && next <= 100000 && times[next] == -1) {
					queue.add(next);
					if(i == 0) { // 순간이동
							times[next] = times[cur];
					} else { // 걷기
							times[next] = times[cur]+1;
					}
				}
			}
		}
	}

}
