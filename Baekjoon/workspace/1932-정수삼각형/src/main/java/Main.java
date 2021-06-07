import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[n][n+1];
		for(int i=0;i<dp.length;i++) {
			Arrays.fill(dp[i], -1);
		}
		
		for(int i=0;i<n;i++) {
			String[] splited = br.readLine().split(" ");
			for(int j=0;j<splited.length;j++) {
				dp[i][j+1] = Integer.parseInt(splited[j]);
			}
		}
		
		for(int i=1;i<n;i++) {
			
			for(int j=1;j<=i+1;j++) {
				dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-1]) + dp[i][j];
			}
		}
		
		int max = 0;
		for(int i=0;i<=n;i++) {
			max = dp[n-1][i] > max ? dp[n-1][i] : max; 
		}
		
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
