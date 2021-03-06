import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException   {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String[] splited = br.readLine().split(" ");
		
		int n = Integer.parseInt(splited[0]);
		int k = Integer.parseInt(splited[1]);
		
		long[][] dp = new long[n+1][k+1];
		
		for(int i=1;i<=k;i++) { //dp배열 초기화
			dp[0][i] =1;
			if(n>0)
				dp[1][i] =i;
		
		}
		for(int i=1;i<=n;i++) { // dp배열 초기화
			dp[i][1]=1;
		}
		
		for(int i=2;i<=n;i++) { 
			for(int j=2;j<=k;j++) { 
				for(int g=0;g<=i;g++) { // 행과 열을 고정해두고 0부터 i까지 반복한다.
					dp[i][j] += dp[i-g][j-1] %1000000000; // 나머지로 저장 범위초과 우려
				}
				dp[i][j] %= 1000000000; // 나머지로 저장 범위초과 우려
				
			}
			
		}
		
		System.out.println(dp[n][k] % 1000000000 ); //출력시에도 나머지로 출력한다.
		
		
		bw.write("");
		bw.flush();
		bw.close();
		
		br.close();
		
	}
	
}
