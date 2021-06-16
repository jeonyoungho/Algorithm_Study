import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Main {
	
	static int N, K;

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] splited = br.readLine().split(" ");
		N = Integer.parseInt(splited[0]);
		K = Integer.parseInt(splited[1]);
		
		int[] prev = new int[100001]; // i위치일 때 시간
		int[] time =new int[100001]; // i의 이전 위치
		Arrays.fill(time, -1); // 초기화
		
		Stack<Integer> stack = new Stack<>();
		Queue<Integer> queue = new LinkedList<>();
		queue.add(N); // 시작점
		time[N] = 0; //시작 위치에서는 0
		
		while(!queue.isEmpty()) {
			int current = queue.poll();
			if(current == K) { // 도착
				while(current != N) { // K에서 N으로 다시 역추적
					stack.push(current);
					current = prev[current];
				}
				stack.push(N); // 마지막 시작점 추가
				break;
			}
			
			int[] dotX= {-1, 1, current}; // 이동할 수 있는 경우의 수
			for(int j=0;j<3;j++) {
				int next = current + dotX[j];
				if(next >= 0 && next <= 100000 && time[next] == -1) {
					time[next] = time[current] + 1; // 시간 계산
					prev[next] = current; // next의 이전 위치(x) 저장
					queue.add(next);
				}
			}
		}
		
		bw.write(time[K] + "\n");
		while(!stack.isEmpty()) {
			bw.write(stack.pop() + " ");
		}
		
		bw.flush();
		bw.close();
		br.close();
	}

}