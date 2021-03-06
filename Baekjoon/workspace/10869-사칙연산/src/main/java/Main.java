import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int A = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		for(int i=str.length()-1;i>=0;i--) {
			int n = str.charAt(i) - '0';
			bw.write((A*n) + "\n");
		}
		bw.write((A*Integer.parseInt(str)) + "\n");
		
		br.close();
		
		bw.flush();
		bw.close();
	}

}
