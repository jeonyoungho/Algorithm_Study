import java.util.Arrays;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int V = sc.nextInt();
		int E = sc.nextInt();
		
		int[][] adj = new int[V][V];
		for(int i=0;i<E;i++) {
			adj[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		}
		
//		for(int i=0;i<adj.length;i++) {
//			System.out.println(Arrays.toString(adj[i]));
//		}
		
		int[] distance = new int[V];
		Arrays.fill(distance, Integer.MAX_VALUE);
		boolean[] check = new boolean[V];
		
		distance[3] = 0;
		
		for(int i=0;i<V-1;i++) {
			int min = Integer.MAX_VALUE;
			int idx = -1;
			for(int j=0;j<V;j++) {
				// 아직 처리하지 않았으면서, 가장 짧은 거리라면
				if(!check[j] && min > distance[j]) {
					idx = j;
					min = distance[j];
				}
			}
			
			for(int j=0;j<V;j++) {
				if(!check[j] && adj[idx][j] != 0 && 
						distance[idx] != Integer.MAX_VALUE && distance[idx] + adj[idx][j] < distance[j]) {
					distance[j] = distance[idx] + adj[idx][j];
				}
			}
			check[idx] = true;
		}
		
		System.out.println(Arrays.toString(distance));
		sc.close();
	}

}
