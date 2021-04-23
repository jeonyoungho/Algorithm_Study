import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	static int dp[];
	
	public static void main(String[] args) throws NumberFormatException, IOException   {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		String[] splited = br.readLine().split(" ");
		
		int dp[] = new int[N+1];
		for(int i=0;i<splited.length;i++) {
			dp[i+1] = Integer.parseInt(splited[i]);
		}
		
		for(int i=2;i<=N;i++) {
			for(int j=0;j<=i/2;j++) {
				dp[i] = Math.min(dp[i-j] + dp[j], dp[i]);
			}
		}
		
		bw.write(dp[N] + "");
		bw.flush();
		bw.close();
		
		br.close();
		
	}
	
}
