import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;

public class PriorityQueueTest {

			static class FileInfo implements Comparable<FileInfo> {
		        private String head;
		        private String number;
		        private String tail;
		        
		        public FileInfo(String fileName) {
		            StringBuilder headerSb = new StringBuilder();
		            StringBuilder numberSb = new StringBuilder();
		            boolean isNumber = false;
		            int numCnt = 0;
		            int pos = 0;
		            for(int i=0;i<fileName.length();i++) {
		                char ch = fileName.charAt(i);
		                if(numCnt < 5 && Character.isDigit(ch)) {
		                    numberSb.append(String.valueOf(ch));
		                    isNumber = true;
		                    numCnt++;
		                } else if (numCnt >= 5 || isNumber == true) {
		                  break;  
		                } else { // 숫자가 아니면 StringBuilder 담아서 head에 저장
		                    headerSb.append(String.valueOf(ch));
		                }
		                
		                pos = i;
		            }
		
		            this.head = headerSb.toString();
		            this.number = numberSb.toString();
		            this.tail = fileName.substring(pos+1, fileName.length());
		        }
		        
		        public int compareTo(FileInfo f) {
		            
		            if (this.head.toLowerCase().equals(f.head.toLowerCase())) {
		                int num1 = Integer.parseInt(this.number);
		                int num2 = Integer.parseInt(f.number);
		                return num1 - num2;
		            }
		            
		            return this.head.toLowerCase().compareTo(f.head.toLowerCase());
		        }
		        
		        @Override
		        public String toString() {
		            return this.head + "" + this.number + "" + this.tail;
		        }
		        
		    }
			
		    public static void main1(String[] args) {
		    	String[] files = {"ABC12", "AbC12", "aBc12"};
		        
		    	PriorityQueue<FileInfo> pq = new PriorityQueue<>();
		        for(String fileName:files) {
		            pq.add(new FileInfo(fileName));
		        }
		        
		        ArrayList<String> resList = new ArrayList<String>();
		        while(!pq.isEmpty()) {
		            FileInfo fileInfo = pq.poll();
		            System.out.println(pq.toString());
		            resList.add(fileInfo.head+fileInfo.number+fileInfo.tail);
		        }
		        
		        String[] answer = resList.toArray(new String[resList.size()]);
		        
		        System.out.println(Arrays.toString(answer));
		    }
		
}
