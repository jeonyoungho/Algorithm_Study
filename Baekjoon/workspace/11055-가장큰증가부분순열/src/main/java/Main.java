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
		int[] arr = new int[splited.length];
		
		for(int i=0;i<splited.length;i++) {
			arr[i] = Integer.parseInt(splited[i]);
		}
		
		int[] dp = new int[arr.length];
		dp[0] = arr[0];
		int max = arr[0];
		for(int i=1;i<arr.length;i++) {
			dp[i] = arr[i];
			for(int j=0;j<i;j++) {
				if(arr[j] < arr[i]) {
					dp[i] = Math.max(dp[i], dp[j] + arr[i]);
				}
			}
			
			max = dp[i] > max ? dp[i] : max;
		}
		
//		System.out.println(Arrays.toString(dp));
		
		bw.write(max + "");
		bw.flush();
		bw.close();
		br.close();
	}

}
