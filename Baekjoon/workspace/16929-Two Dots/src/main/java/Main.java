import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;

public class Main {
	
	private static int[] dx = {-1, 0, 1, 0};
	private static int[] dy = {0, 1, 0, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] splited = br.readLine().split(" ");
		
		int N = Integer.parseInt(splited[0]);
		int M = Integer.parseInt(splited[1]);
		
		char[][] map = new char[N][M];
		for(int i=0;i<N;i++) {
			String s = br.readLine();
			for(int j=0;j<M;j++) {
				map[i][j] = s.charAt(j);
			}
		}
		
		for(int i=0;i<map.length;i++) {
			for(int j=0;j<map[i].length;j++) {
				boolean found = dfs(map, -1, -1, i, j, new boolean[N][M], map[i][j]);
				if(found) {
					bw.write("Yes");
					bw.flush();
					bw.close();
					br.close();
					return;
				}
			}
			
		}

		bw.write("No");
		bw.flush();
		bw.close();
		br.close();
	}
	
	public static boolean dfs(char[][] map, int prevX, int prevY, 
		int x, int y, boolean[][] visit, char color) {
		// prevX, prevY -> 이전 노드를 다시 방문하지 않기 위해
		if(visit[x][y]) return true;
		visit[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int targetX = x + dx[i];
			int targetY = y + dy[i];
			 
			if(targetX >=0 && targetY >=0 && targetX < map.length && targetY < map[0].length) {
				
				if(!(targetX == prevX && targetY == prevY) && map[targetX][targetY] == color) {
					
					if(dfs(map, x, y, targetX, targetY, visit, color)) {
						return true;
					}
						
				}
				
			}
			
		}
		
		return false;
	}

}
