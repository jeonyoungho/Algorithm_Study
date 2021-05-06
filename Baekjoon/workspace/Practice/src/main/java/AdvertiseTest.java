import java.util.Comparator;
import java.util.Iterator;
import java.util.PriorityQueue;

public class AdvertiseTest {
	
	static class Advertise {
		private int startTime;
		private int lossValue;
		
		public Advertise(int startTime, int lossValue) {
			this.startTime = startTime;
			this.lossValue = lossValue;
		}
	}
	
	public static int solution(int[][] ads) {
		
		PriorityQueue<Advertise> list = new PriorityQueue<Advertise>(new Comparator<Advertise>() {

			@Override
			public int compare(AdvertiseTest.Advertise o1, AdvertiseTest.Advertise o2) {
				return o1.startTime-o2.startTime;
			}
		});

		for(int i=0;i<ads.length;i++) {
			list.add(new Advertise(ads[i][0], ads[i][1]));
		}
		
		int time = list.peek().startTime;
		int cnt = 0;
		int answer = 0;
		PriorityQueue<Advertise> pq = new PriorityQueue<Advertise>(new Comparator<Advertise>() {

			@Override
			public int compare(Advertise o1, Advertise o2) {
				return o2.lossValue-o1.lossValue;
			}
		});
		pq.add(list.poll());
		while(cnt < ads.length) {
			if(pq.size() > 0) {
				Advertise adv = pq.poll();
				list.remove(adv);
				answer += (time-adv.startTime)*adv.lossValue;
//				for(Advertise advertise:list) {
//					System.out.println("-> " +advertise.startTime + ", " + advertise.lossValue);
//				}
				
				time += 5;
				cnt += 1;
				pq.clear();
			}
			
			boolean found = false;
			Iterator<Advertise> iter = list.iterator();
			while(iter.hasNext()) {
				Advertise advertise = iter.next();
				if(advertise.startTime <= time) {
					found = true;
					pq.add(advertise);
				}
			}
			
			if(found == false) {
				time += 1;
			}
			
		}
		
		return answer;
	}

	public static void main1(String[] args) {
		int[][] ans = {{1,2}, {3,2}, {5,4}, {16, 3}};
		System.out.println(solution(ans));
		
		// 4 + 6 + 10 = 20
	}

}
