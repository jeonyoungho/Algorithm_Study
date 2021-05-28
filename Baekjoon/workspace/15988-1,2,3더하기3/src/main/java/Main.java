import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        long[] answer = new long[n];
        
        long dp[] = new long[1_000_001];
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 4;
        for(int i = 4; i <= 1_000_000; i++)
        	dp[i] = (dp[i-1] + dp[i-2] + dp[i-3]) % 1_000_000_009;
        
        for(int i = 0; i < n; i++){
        	answer[i] = Integer.parseInt(br.readLine());
        }
        
        for(int i = 0; i < n; i++){
        	System.out.println(dp[(int) answer[i]]);
        }
		
		bw.write("");
		bw.flush();
		bw.close();

		br.close();

	}

}
