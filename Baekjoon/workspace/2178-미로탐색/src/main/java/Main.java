import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	private static int[] dx = {1, 0, 0, -1};
	private static int[] dy = {0, 1, -1, 0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] splited = br.readLine().split("\\s");
		
		int N = Integer.parseInt(splited[0]);
		int M = Integer.parseInt(splited[1]);
		
		int[][] map = new int[N+1][M+1];
		
		for(int i=1;i<=N;i++) {
			String line = br.readLine();
			
			for(int j=0;j<line.length();j++) {
				map[i][j+1] = Character.getNumericValue(line.charAt(j));  
			}
		}
		
		
		int count = 0;
		boolean[][] visited = new boolean[N+1][M+1];
		Queue<Point> queue = new LinkedList<>();
		visited[1][1] = true;
		queue.add(new Point(1, 1));
		count += 1;
		
		while(!queue.isEmpty()) {
			boolean found = false;
			boolean end = false;
			
			int size = queue.size();
			for(int i=0;i<size;i++) {
				
				Point point = queue.poll();
				int x = point.x;
				int y = point.y;
				for(int j=0;j<4;j++) {
					int targetX = x + dx[j];
					int targetY = y + dy[j];
					
					if(targetX == N && targetY == M) {
						found = true;
						end = true;
						break;
					}
					
					if(targetX>=0 && targetY>=0 && targetX <= N && targetY <= M) {
						if(visited[targetX][targetY] == false && 
								map[targetX][targetY] == 1) {
							queue.add(new Point(targetX, targetY));
							found = true;
							visited[targetX][targetY] = true;
						}
					}
				}
				
				if(end) break;
			}
			
			if(found) count++;
			if(end) break;
		}
		
		bw.write("" + count);
		bw.flush();
		bw.close();

		br.close();

	}

}
