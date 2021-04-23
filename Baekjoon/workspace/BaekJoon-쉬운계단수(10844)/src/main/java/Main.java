import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	static long[][] dp;
	final static long mod = 1000000000;
	
	public static void main(String[] args) throws NumberFormatException, IOException   {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		dp = new long[N+1][10]; // N자리일때 계단수의 갯수, 끝자리가 0이거나 9인것의 갯수
		
		for(int i=1;i<10;i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2;i<=N;i++) {
			
			for(int j=0;j<10;j++) {
				
				if (j == 0) {
					dp[i][j] = dp[i-1][1] % mod;
				}
				
				// j=9라면 이전 자릿수는 8만 가능
				else if (j == 9) {
					dp[i][9] = dp[i - 1][8] % mod;
				}
				// 그 외의 경우 이전 자릿수의 자릿값 +1, -1 의 합이 됨 
				else {
					dp[i][j] = (dp[i - 1][j - 1] + dp[i - 1][j + 1]) % mod;
				}
				
			}
			
		}
		
		long result = 0;
		// 각 자릿값마다의 경우의 수를 모두 더해준다. 
		for(int i = 0; i < 10; i++) {
			result += dp[N][i];
		}
		
		bw.write((result % mod) + "");
		bw.flush();
		bw.close();
		
		br.close();
	}
	
}
