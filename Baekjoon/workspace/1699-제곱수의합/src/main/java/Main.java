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
		
		
		// 1 -> 1 (1)
		// 2 -> 2 (1 + 1)
		// 3 -> 3 (1 + 1 + 1)
		// 4 -> 1 (2)
		// 5 -> 2 (2 + 1)
		// 6 -> 3 (2 + 1 + 1)
		// 7 -> 4 (2 + 1 + 1 + 1)
		// 8 -> 2 (2 + 2)
		
		int[] dp = new int[100001];
		dp[1] =1;
		
		for(int i=2;i<=N;i++) {	 // dp 2부터 채우기 시작
			dp[i]=i; //우선 자기자신으로 초기화 해둔다.
			for(int j=1;j*j<=i;j++) { // j는 1부터 제곱 수가 i보다 작을 경우 반복한다.								
				dp[i] = Math.min(dp[i-(j*j)]+1,dp[i]); // 최소항의 개수를 찾기 위해서 저장 된 값과 점화식값을 비교하여 최솟값을 취한다.		
			}
		}
		
		System.out.println(dp[N]);
		
		bw.write("");
		bw.flush();
		bw.close();
		
		br.close();
		
	}
	
}
