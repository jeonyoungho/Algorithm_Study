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
		String[] splited = br.readLine().split(" ");
		
		int[] arr = new int[N];
		int[] dp = new int[N];
		for(int i=0;i<splited.length;i++) {
			arr[i] = Integer.parseInt(splited[i]);
		}
		
		for(int i=0;i<N;i++) {
			dp[i] = 1;
			
			for(int j=0;j<i;j++) {
				
				if(arr[j] < arr[i] && dp[i] < dp[j]+1) {
					dp[i] = dp[j] + 1;
				}
			}
		}
		
		
		int max = dp[0];
		for(int i=1;i<N;i++) {
			max = Math.max(max, dp[i]);
		}
		
		
		bw.write(max + "");
		bw.flush();
		bw.close();
		
		br.close();
		
	}
	
}
