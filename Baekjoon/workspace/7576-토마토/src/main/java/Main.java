import java.awt.Point;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	private static int[] dx = {0, 1, 0, -1};
	private static int[] dy = {1, 0, -1, 0};

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		String[] splited = br.readLine().split(" ");
		int M = Integer.parseInt(splited[0]);
		int N = Integer.parseInt(splited[1]);
		int[][] box = new int[N][M];
		
		for(int i=0;i<N;i++) {
			String[] tomatoes = br.readLine().split(" ");
			for(int j=0;j<tomatoes.length;j++) {
				box[i][j] = Integer.parseInt(tomatoes[j]);
			}
		}
		
		
		Queue<Point> queue = new LinkedList<>();
		
		
		for(int i=0;i<box.length;i++) {
			for(int j=0;j<box[i].length;j++) {
				if(box[i][j] == 1) {
					queue.add(new Point(i, j));
				}
			}
		}
		while(queue.isEmpty() == false) {
			int size = queue.size();
			for(int i=0;i<size;i++) {
				Point point = queue.poll();
				
				for(int j=0;j<4;j++) {
					int targetX = point.x + dx[j];
					int targetY = point.y + dy[j];
					if(targetX>=0 && targetY>=0 && targetX<N && targetY<M) {
						if(box[targetX][targetY] != 0) {
							continue;
						}
						
						box[targetX][targetY] = box[point.x][point.y] + 1;
						queue.add(new Point(targetX, targetY));
					}
				}
				
			}
		}
		
		int max = 0;
		
		for(int i=0;i<box.length;i++) {
			for(int j=0;j<box[i].length;j++) {
				
				if(box[i][j] == 0) {
					bw.write(-1 + "");
					bw.flush();
					bw.close();
					return;
				}
				
				max = Math.max(box[i][j], max);
			}
		}

		bw.write((max-1) + "");
		bw.flush();
		bw.close();
		br.close();
	}
	
	private static void print(int[][] arr) {
		System.out.println("=======================");
		for(int i=0;i<arr.length;i++) {
			System.out.println(Arrays.toString(arr[i]));
		}
		System.out.println("=======================");
	}
	
}
