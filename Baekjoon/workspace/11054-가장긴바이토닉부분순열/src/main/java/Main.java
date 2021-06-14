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

		int N = Integer.parseInt(br.readLine());
		String[] splited = br.readLine().split(" ");
		int[] arr = new int[N];
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(splited[i]);
		}
		
		int[][] dp = new int[N][2];
		
		for(int i=0;i<N;i++) {
			dp[i][0] = 1;
			for(int j=0;j<i;j++) {
				if(arr[j] < arr[i]) {
					dp[i][0] = Math.max(dp[i][0], dp[j][0] + 1); 
				}
			}
		}
		
		for(int i=N-1;i>=0;i--) {
			dp[i][1] = 1;
			for(int j=N-1;j>0;j--) {
				if(arr[j] < arr[i]) {
					dp[i][1] = Math.max(dp[i][1], dp[j][1] + 1); 
				}
			}
		}
		
		int max = 0;
		for(int i=0;i<dp.length;i++) {
			max = Math.max(max, dp[i][0] + dp[i][1]);
		}
		
		bw.write("" + (max-1));
		bw.flush();
		bw.close();
		br.close();
	}

}
