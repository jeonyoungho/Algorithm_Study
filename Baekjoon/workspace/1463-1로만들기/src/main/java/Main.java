import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int X = Integer.parseInt(br.readLine());
		int[] dp = new int[X+1];
		// 1 -> 0
		// 2 -> 1
		// 3 -> 1
		
		// 4 -> 2
		// 5 -> 3
		
		// 6 -> 2
		// 7 -> 3
		// 8 -> 3
		
		// 9 -> 2
		// 10 -> 3
		// 11 -> 3
		
		// 12 -> 3
		// 13 -> 4
		// 14 -> 4
		
		// 15 -> 4
		// 16 -> 4 
		
		bw.write(recur(dp, X) + ""); 

		br.close();
		bw.flush();
		bw.close();
	}
	
	private static int recur(int[] dp, int X) {
		if(X == 1)
			return 0;
		if(dp[X] > 0)
			return dp[X];
		
		dp[X] = recur(dp, X-1) + 1;
		if(X % 2 == 0) {
			int tmp = recur(dp, X/2) + 1;
			if(dp[X] > tmp)
				dp[X] = tmp;
		}
		
		if(X % 3 == 0) {
			int tmp = recur(dp, X/3) + 1;
			if(dp[X] > tmp)
				dp[X] = tmp;
		}
		
		return dp[X];
	}

}
