import java.util.Collections;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.TreeMap;

public class Main {
	
	public static void main(String[] args) {
		TreeMap<Integer,String> treeMap1 = new TreeMap<Integer,String>() {{	//초기값 설정
		    put(1,"사과");
		}};
		TreeMap<Integer, String> treeMap2 = new TreeMap<>(treeMap1); //treeMap1의 모든 값을 가진 TreeMap생성
		treeMap2.put(2, "복숭아"); //값 추가
		treeMap2.put(3, "수박"); //값 추가
		TreeMap<Integer,String> treeMap3 = new TreeMap<>(treeMap2);//treeMap2의 모든 값을 가진 TreeMap생성
		
		TreeMap<Integer,String> treeMap4 = new TreeMap<>(Collections.reverseOrder());//key의 역순형태로 저장하는 TreeMap생성
		treeMap4.put(4, "바나나");
		treeMap4.put(5, "배");
		
		treeMap1.clear(); //모든 값 제거
		treeMap2.remove(1); //key값 1 제거
		
		System.out.println("treeMap1 size: " + treeMap1.size());
		System.out.println("treeMap2 size: " + treeMap2.size());
		System.out.println("treeMap3 size: " + treeMap3.size());
		
		System.out.println("Print all data in treeMap3: " + treeMap3);
		System.out.println("Print all data in treeMap4: " + treeMap4);
		System.out.println("Print date with key 2 in treeMap3: " + treeMap3.get(2));
		System.out.println("Print first entry in treeMap3: " + treeMap3.firstEntry());
		System.out.println("Print first key in treeMap3: " + treeMap3.firstKey());
		System.out.println("Print last entry in treeMap3: " + treeMap3.lastEntry());
		System.out.println("Print last key in treeMap3: " + treeMap3.lastKey());
		
		System.out.println("===== [Entry] Print all data with for loop =====");
		for(Entry<Integer, String> entry : treeMap3.entrySet()) {
			System.out.println("[key]: " + entry.getKey() + ", [value]: " + entry.getValue());
		}
		
		System.out.println("===== [Key] Print all data with for loop =====");
		for(Integer i:treeMap3.keySet()) {
			System.out.println("[key]: " + i + ", [value]: " + treeMap3.get(i));
		}
		
		System.out.println("===== [entry iterator] Print all data with while loop =====");
		Iterator<Entry<Integer, String>> iter = treeMap3.entrySet().iterator();
		while(iter.hasNext()) {
			Entry<Integer, String> entry = iter.next();
			System.out.println("[key]: " + entry.getKey() + ", [value]: " + entry.getValue());
		}
		
		
		System.out.println("===== [key iterator] Print all data with while loop =====");
		Iterator<Integer> iter2 = treeMap3.keySet().iterator();
		while(iter2.hasNext()) {
			int i = iter2.next();
			System.out.println("[key]: " + i + ", [value]: " + treeMap3.get(i));
		}
		
	}
	
}
