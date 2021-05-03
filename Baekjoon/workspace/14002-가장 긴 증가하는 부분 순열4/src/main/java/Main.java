import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException   {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		String[] splited = br.readLine().split(" ");
		
		int[] arr = new int[N];
		List<ArrayList<Integer>> list = new ArrayList<>();
		int[] dp = new int[N];
		int[] path = new int[N]; // 경로를 추적할 인덱스를 담을 배열
		int max = -1;
		int index = -1;
		
		for(int i=0;i<splited.length;i++) {
			list.add(new ArrayList<Integer>());
			arr[i] = Integer.parseInt(splited[i]);
			dp[i] = 1;
			path[i] = -1;
			for(int j=0;j<i;j++) {
				if(arr[i] > arr[j] && dp[i] < dp[j] +1 ) {
					dp[i] = dp[j] + 1;
					path[i] = j;
				}
			}
			
			if(max < dp[i]) {
				max = dp[i];
				index = i;
			}
		}
		StringBuilder sb = new StringBuilder();
		sb.append(max).append("\n");
		
		Stack<Integer> stack = new Stack<>();
		while(index != -1) {
			stack.push(arr[index]);
			index = path[index];
		}
		
        while (!stack.isEmpty()) {
            sb.append(stack.pop()).append(" ");
        }
		
		bw.write(sb.toString());
		bw.flush();
		bw.close();
		
		br.close();
		
	}
	
}
