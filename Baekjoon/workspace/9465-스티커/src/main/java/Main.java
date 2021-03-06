import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());

		for(int t=0;t<T;t++) {
			
			int n = Integer.parseInt(br.readLine());
			int[][] dp = new int[2][n+1];
			int[][] arr = new int[2][n+1];
			
			for(int i=0;i<2;i++) {
				String[] splited = br.readLine().split(" ");
				
				for(int j=0;j<splited.length;j++) {
					arr[i][j+1] = Integer.parseInt(splited[j]);
				}
				
			}
			
			dp[0][1] = arr[0][1];
			dp[1][1] = arr[1][1];
			
			for(int i=2;i<=n;i++) {
				dp[0][i] = Math.max(dp[1][i-1], dp[1][i-2]) + arr[0][i];
				dp[1][i] = Math.max(dp[0][i-1], dp[0][i-2]) + arr[1][i];
			}
			
			bw.write(Math.max(dp[0][n], dp[1][n]) + "\n");
		}
		
		bw.flush();
		bw.close();
		br.close();

	}

}
