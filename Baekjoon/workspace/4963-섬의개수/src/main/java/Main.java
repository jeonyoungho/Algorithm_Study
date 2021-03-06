import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	private static int[] dx = {1, 0 , -1, 0, 1, -1, -1, 1};
	private static int[] dy = {0, 1, 0, -1, 1, -1, 1, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		while(true) {
			String str = br.readLine();
			if(str.equals("0 0")) {
				break;
			}
			
			String[] splited = str.split(" ");
			int width = Integer.parseInt(splited[0]);
			int height = Integer.parseInt(splited[1]);
			
			int[][] map = new int[height][width];
			for(int i=0;i<height;i++) {
				String[] s = br.readLine().split(" ");
				for(int j=0;j<s.length;j++) {
					map[i][j] = Integer.parseInt(s[j]);
				}
			}
			
			int cnt = 0;
			for(int i=0;i<map.length;i++) {
				for(int j=0;j<map[i].length;j++) {
					if(map[i][j] == 1) {
						dfs(map, i, j, width, height);
						cnt++;
					}
				}
			}
			System.out.println(cnt);
			
		}
		
		bw.flush();
		bw.close();

		br.close();
	}

	public static void dfs(int[][] map, int x, int y, int width, int height) {
		
		map[x][y] = 0;
		
		for(int i=0;i<8;i++) {
			int targetX = x + dx[i];
			int targetY = y + dy[i];
			
			if(targetX<0 || targetY<0 || targetX >= height || targetY >= width) {
				continue;
			} else if(map[targetX][targetY] == 1) {
				dfs(map, targetX, targetY, width, height);
			}
			
		}
	}

}
