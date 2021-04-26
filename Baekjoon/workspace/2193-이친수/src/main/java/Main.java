import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException   {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		long[][] dp = new long[91][2];
		// 1 -> 1
		// 10 ->  0
		// 100 , 101 -> 1
		// 1000, 1001, 1010 -> 1
		// 10000, 10001, 10010, 10100, 10101 -> 2
		// 100001 -> 3
		
		dp[1][0] = 0;
		dp[1][1] = 1;
		
		for(int i=2;i<=N;i++) {
			
			for(int j=0; j<2;j++) {
				if(j == 0) {
					dp[i][j] = dp[i-1][0] + dp[i-1][1];
				} else {
					dp[i][j] = dp[i-1][0];
				}
			}
		}
		
		bw.write((dp[N][0] + dp[N][1]) + "");
		bw.flush();
		bw.close();
		
		br.close();
		
	}
	
}
