import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Point {
		int x, y, cnt;
		
		public Point(int x, int y, int cnt) {
			this.x = x;
			this.y = y;
			this.cnt = cnt;
		}
	}
	
	static int[] dx = {1, 0, -1, 0};
	static int[] dy = {0, 1, 0, -1};
	static int[][] map;
	static boolean[][] visited;
	static int N;
	static int answer = Integer.MAX_VALUE;
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		N = Integer.parseInt(br.readLine());
		map = new int[N][N];
		visited = new boolean[N][N];
		for(int i=0;i<N;i++) {
			String[] splited = br.readLine().split(" ");
			for(int j=0;j<N;j++) {
				map[i][j] = Integer.parseInt(splited[j]);
			}
		}
		
		int landNum = 2; //섬 번호이름
		for (int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(!visited[i][j] && map[i][j] == 1) { // 아직 번호이름 없는 섬인 경우
					dfs(i, j, landNum);
					landNum++;
				}
			}
		}
		
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				if(map[i][j] >= 2) {
					visited = new boolean[N][N]; //재초기화
					bfs(i, j);
				}
			}
		}
		
		bw.write(answer + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void bfs(int x, int y) {
		Queue<Point> queue = new LinkedList<Main.Point>();
		queue.offer(new Point(x, y, 0));
		int currentLandNum = map[x][y]; // 현재 섬 번호
		visited[x][y] = true;
		
		while(!queue.isEmpty()) {
			
			Point point = queue.poll();
				
				for(int j=0;j<4;j++) {
					int nx = point.x + dx[j];
					int ny = point.y + dy[j];
					
					if(nx < 0 || nx >= N || ny<0 || ny>=N || visited[nx][ny] == true) {
						continue;
					}
					
					if(!visited[nx][ny] && map[nx][ny] != currentLandNum) { // 방문 안하고 바다 혹은 다른섬인 경우 
						visited[nx][ny] = true;
						if(map[nx][ny] == 0) { //바다
							queue.add(new Point(nx, ny, point.cnt+1));
						} else { // 다른 섬
							answer = Math.min(answer, point.cnt);
						}
					}
				}
				
			}
		
	}

	// 섬 별로 번호이름 붙여주기
	private static void dfs(int x, int y, int landNum) {
		map[x][y] = landNum;
		visited[x][y] = true;
		
		for(int i=0;i<4;i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			
			if(nx < 0 || nx >= N || ny < 0 || ny >= N) {
				continue;
			}
			
			if(!visited[nx][ny] && map[nx][ny] == 1) {
				dfs(nx, ny, landNum);
			}
		}
		
		
	}

}
