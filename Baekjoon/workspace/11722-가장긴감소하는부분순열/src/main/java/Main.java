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
		int[] arr = new int[N];
		
		String[] splited = br.readLine().split(" ");
		for(int i=0;i<N;i++) {
			arr[i] = Integer.parseInt(splited[i]);
		}
		
		int[] dp = new int[N];
		int max = 1;
		for(int i=0;i<N;i++) {
			dp[i] = 1;
			for(int j=0;j<i;j++) {
				if(arr[j] > arr[i])
					dp[i] = Math.max(dp[j]+1, dp[i]);
			}
			
			max = max > dp[i] ? max : dp[i];
		}
		
		bw.write("" + max);
		bw.flush();
		bw.close();
		br.close();
	}

}
