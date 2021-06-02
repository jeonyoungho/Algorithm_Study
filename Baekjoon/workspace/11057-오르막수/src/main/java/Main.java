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

		int N = Integer.parseInt(br.readLine());
		
		int[][] dp = new int[N+1][10];
		for(int i=0;i<10;i++) {
			dp[1][i] = 1;
		}
		
		for(int i=2;i<=N;i++) {
			
			for(int j=0;j<10;j++) {
				
				for(int k=j;k<10;k++) {
					dp[i][j] += (dp[i-1][k])%10007;
				}
			}
			
		}
		
		int sum = 0;
		for(int i=0;i<10;i++) {
			sum += dp[N][i];
		}

		bw.write(sum%10007 + "");
		bw.flush();
		bw.close();

		br.close();

	}

}
