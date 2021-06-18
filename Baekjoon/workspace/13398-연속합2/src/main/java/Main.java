import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		String[] splited = br.readLine().split(" ");
		int[] arr = new int[n];
		int[][] dp = new int[n][2]; // 행: 수 하나를 제거했을때, 열: 수를 제거하지 않았을 때
		for(int i=0;i<n;i++) {
			arr[i] = Integer.parseInt(splited[i]);
		}
		
		dp[0][0] = 0;
		dp[0][1] = arr[0];
		int max = dp[0][1];
		
		for(int i=1;i<n;i++) {
			dp[i][0] = Math.max(dp[i-1][0] + arr[i], dp[i-1][1]);
			dp[i][1] = Math.max(dp[i-1][1] + arr[i], arr[i]);
			max = Math.max(max, Math.max(dp[i][0], dp[i][1]));
		}

		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

}
