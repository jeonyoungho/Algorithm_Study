import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	private static int[] dx = {-2, -1, 1, 2, 2, 1, -1, -2};
	private static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int T = Integer.parseInt(br.readLine());
		
		for(int t=0;t<T;t++) {
			int I = Integer.parseInt(br.readLine());
			int[][] map = new int[I][I];
			
			String[] splited = br.readLine().split(" ");
			int startX = Integer.parseInt(splited[0]);
			int startY = Integer.parseInt(splited[1]);
			map[startX][startY] = 1;
			
			splited = br.readLine().split(" ");
			int endX = Integer.parseInt(splited[0]);
			int endY = Integer.parseInt(splited[1]);
			
			bfs(map, new Point(startX, startY), new Point(endX, endY), I);
		}

		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void bfs(int[][] map, Point startPoint, Point endPoint, int mapSize) {
		
		Queue<Point> queue = new LinkedList<>();
		queue.add(startPoint);
		int cnt = 0;
		
		if(startPoint.x == endPoint.x &&
				startPoint.y == endPoint.y) {
			System.out.println(cnt);
			return;
		}
		
		while(!queue.isEmpty()) {
			
			int size = queue.size();
			for(int i=0;i<size;i++) {
				Point point = queue.poll();
				
				for(int j=0;j<8;j++) {
					int targetX = point.x + dx[j];
					int targetY = point.y + dy[j];
					
					if(targetX == endPoint.x && targetY == endPoint.y) {
						System.out.println(++cnt);
						return;
					}
					
					if(targetX >= 0 && targetX < mapSize && 
							targetY >= 0 && targetY < mapSize) {
						if(map[targetX][targetY] == 0) {
							queue.add(new Point(targetX, targetY));
							map[targetX][targetY] = 1;
						}
					}
					
				}
			}
			cnt++;
		}
		
	}

}
