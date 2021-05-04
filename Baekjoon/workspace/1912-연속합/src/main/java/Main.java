import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

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
		
		dp[0] = arr[0];
		for(int i=1;i<arr.length;i++) {
			
			if(arr[i] < dp[i-1] + arr[i]) {
				dp[i] = dp[i-1] + arr[i];
			} else {
				dp[i] = arr[i];
			}
			
		}
		Arrays.sort(dp);
		
		bw.write(dp[dp.length-1] + "");
		bw.flush();
		bw.close();
		
		br.close();
		
	}
	
}
