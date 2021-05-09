import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;

public class TestKakaoInternship {

	static class Row {
		int num;
		String deleted;

		public Row(int num, String deleted) {
			this.num = num;
			this.deleted = deleted;
		}
	}

	public static String solution(int n, int k, String[] cmd) {
		ArrayList<Row> list = new ArrayList<Row>();
		Stack<Row> stack = new Stack<Row>(); // 삭제된 행을 담을 스택
		for (int i = 0; i < n; i++) {
			list.add(new Row(i, "O"));
		}

		int current = k;
		for (int i = 0; i < cmd.length; i++) {

			String command = cmd[i];
			if (command.charAt(0) == 'U') {
				int up = Integer.parseInt(command.split(" ")[1]);
				current -= up;
			} else if (command.charAt(0) == 'D') {
				int down = Integer.parseInt(command.split(" ")[1]);
				current += down;
			} else if (command.charAt(0) == 'C') {
				Row row = list.remove(current);
				row.deleted = "X";
				stack.push(row);
				if (list.size() <= current) {
					current = list.size() - 1;
				}

			} else if (command.charAt(0) == 'Z') {
				Row row = stack.pop();
				row.deleted = "O";

				if (list.size() < row.num) {
					list.add(row);
				} else {
					list.add(row.num, row);
					current += 1;
				}

			}

			// System.out.println("[" + current + "]: " + command);
			// for(int z=0;z<list.size();z++) {
			// System.out.println(list.get(z));
			// }
		}

		while (!stack.isEmpty()) {
			Row row = stack.pop();
			list.add(row);
		}

		Collections.sort(list, new Comparator<Row>() {
			@Override
			public int compare(Row r1, Row r2) {
				return r1.num - r2.num;
			}
		});

		String answer = "";
		for (int i = 0; i < list.size(); i++) {
			Row row = list.get(i);
			answer += row.deleted;
		}

		return answer;
	}

	public static void main1(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = 8;
		int k = 2;
		String[] cmd = {"D 2","C","U 3","C","D 4","C","U 2","Z","Z"};
		String result = solution(n, k, cmd);

		bw.write("");
		bw.flush();
		bw.close();

		br.close();

	}

}
