import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		ArrayList<Integer> list = new ArrayList<>();
		list.add(3);
		list.add(6);
		list.add(9);
		print(list);
		
		ArrayList<Integer> cp = new ArrayList<>();
		cp.addAll(list);
		print(cp);
		
		cp.remove(cp.size()-1);
		System.out.println("Remove copy list's last element...");
		print(list);
		print(cp);
		

		bw.write("");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static void print(List<Integer> list) {
		System.out.println("=====================");
		for(Integer n:list) {
			System.out.print(n + " ");
		}
		System.out.println("\n=====================");
	}

}
