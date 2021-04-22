# Map 정렬

### Key에 따른 정렬
#### 방법1
~~~
Object[] mapkey = map.keySet().toArray();
Arrays.sort(mapkey);
for (String key : map.keySet()) {
    System.out.println("key: " + key + ", value: " + map.get(key));
}
~~~

#### 방법2
~~~
List<String> keySetList = new ArrayList<>(map.keySet());
Collections.sort(keySetList, new Comparator<String>() {
    @Override
    public int compare(String key1, String key2) {
        return key1.compareTo(key2);
    }
});
~~~

### Value에 따른 정렬
~~~
List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
		
Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
    @Override
    public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
        // value 내림차순으로 정렬하고, value가 같으면 key 오름차순으로 정렬
        int comparison = m2.getValue() - m1.getValue();
        return comparison == 0 ? m1.getKey().compareTo(m2.getKey()) : comparison;
    }
});

~~~

### 전체 테스트 코드
~~~
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException   {
		
		Map<String, Integer> map = new HashMap<>();
		
        map.put("A", 4);
        map.put("B", 4);
        map.put("C", 4);
        map.put("D", 2);
        map.put("E", 6);
        map.put("F", 1);
        map.put("G", 2);
		
		System.out.println("===== 정렬 전 =====");
		for(String key:map.keySet()) {
			System.out.println("key: " + key + ", value: " + map.get(key));
		}
		
		System.out.println("===== Key 기준 정렬1 =====");
		Object[] mapkey = map.keySet().toArray();
		Arrays.sort(mapkey);
		for (String key : map.keySet())
		{
			System.out.println("key: " + key + ", value: " + map.get(key));
		}
		
		System.out.println("===== Key 기준 정렬2 =====");
		List<String> keySetList = new ArrayList<>(map.keySet());
		Collections.sort(keySetList, new Comparator<String>() {
			@Override
			public int compare(String key1, String key2) {
				return key1.compareTo(key2);
			}
		});
		
		for (String key : keySetList)
		{
			System.out.println("key: " + key + ", value: " + map.get(key));
		}

		
		System.out.println("===== Value 기준 정렬 =====");
		List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
		
		Collections.sort(list, new Comparator<Map.Entry<String, Integer>>(){
			@Override
			public int compare(Map.Entry<String, Integer> m1, Map.Entry<String, Integer> m2) {
				// value 내림차순으로 정렬하고, value가 같으면 key 오름차순으로 정렬
				int comparison = m2.getValue() - m1.getValue();
				return comparison == 0 ? m1.getKey().compareTo(m2.getKey()) : comparison;
			}
		});
		
		for(Entry<String, Integer> entry:list) {
			System.out.println("key: " + entry.getKey() + ", value: " + entry.getValue());
		}
	}
	
}
~~~
