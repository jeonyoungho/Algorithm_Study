import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		String[] splited = str.split(" ");
		int A = Integer.parseInt(splited[0]);
		int B = Integer.parseInt(splited[1]);
		
		if (A > B) {
			bw.write(">\n");
		} else if (A < B) {
			bw.write("<\n");
		} else if (A == B) {
			bw.write("==\n");
		}
		
		br.close();
		
		bw.flush();
		bw.close();
	}

}
