import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.LinkedList;
import java.util.Queue;

public class Main {
	
	static class Emotion {
		int clipboard;
		int screen;
		int time;
		
		public Emotion(int clipboard, int screen, int time) {
			this.clipboard = clipboard;
			this.screen = screen;
			this.time = time;
		}
	}
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int S = Integer.parseInt(br.readLine());
		boolean[][] visit = new boolean[1001][1001]; // 행: 클립보드에 있는 이모티콘 수, 열: 화면에 잇는 이모티콘 수
		
		Queue<Emotion> queue = new LinkedList<Main.Emotion>();
		queue.add(new Emotion(0, 1, 0));
		visit[0][1] = true;
		
		while(!queue.isEmpty()) {
			Emotion current = queue.poll();
			if(current.screen == S) {
				bw.write(current.time + "");
				bw.flush();
				bw.close();
				br.close();
				return;
			}
			
			// 1. 화면에 있는 이모티콘을 모두 복사해서 클립보드에 저장한다.
			if(current.clipboard + current.screen <= 1000 && !visit[current.screen][current.screen]) {
				queue.add(new Emotion(current.screen, current.screen, current.time + 1));
				visit[current.screen][current.screen] = true;
				
			}
			
			// 2. 클립보드에 있는 모든 이모티콘을 화면에 붙여넣기
			if(current.clipboard != 0 && current.clipboard + current.screen <= 1000 && !visit[current.clipboard][current.clipboard+current.screen]) {
				queue.add(new Emotion(current.clipboard, current.clipboard + current.screen, current.time + 1));
				visit[current.clipboard][current.clipboard + current.screen] = true;
			}
			
			// 3. 화면에 있는 이모티콘 중 하나를 삭제한다.
			if(current.screen-1 > 0 && !visit[current.clipboard][current.screen-1]) {
				queue.add(new Emotion(current.clipboard, current.screen-1, current.time+1));
				visit[current.clipboard][current.screen-1] = true;
			}
		}
		

	}

}
