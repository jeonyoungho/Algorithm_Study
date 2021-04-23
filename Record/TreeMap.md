# TreeMap

## TreeMap이란?
- 이진트리를 기반으로 한 Map 컬렉션
- <b>같은 Tree구조로 이루어진 TreeSet과의 차이점은 TreeSet은 그냥 값만 저장한다면 TreeMap은 키와 값이 저장된 Map, Etnry를 저장한다는 점</b>
- <b>TreeMap에 객체를 저장하면 자동으로 정렬되는데, 키는 저장과 동시에 자동 오름차순으로 정렬되고 숫자 타입일 경우에는 값으로, 문자열 타입일 경우에는 유니코드로 정렬</b>
- 정렬 순서는 기본적으로 부모 키값과 비교해서 키 값이 낮은 것은 왼쪽 자식 노드에 키값이 높은 것은 오른쪽 자식 노드에 Map.Etnry 객체를 저장
- TreeMap은 일반적으로 Map으로써의 성능이 HashMap보다 떨어짐. TreeMap은 데이터를 저장할 때 즉시 정렬하기에 추가나 삭제가 HashMap보다 오래 걸립니다.
- <b>하지만 정렬된 상태로 Map을 유지해야 하거나 정렬된 데이터를 조회해야 하는 범위 검색이 필요한 경우 TreeMap을 사용하는 것이 효율성면에서 좋습니다.</b>

- <b>TreeMap은 이진탐색트리 중에서도 성능을 향상시킨 [레드-블랙 트리(Red-Black Tree)](https://github.com/jeonyoungho/TIL/blob/master/DataStructure/red-black%20%ED%8A%B8%EB%A6%AC%20%26%20AVL%20%ED%8A%B8%EB%A6%AC.md)로 구현</b>
- 이진 탐색트리는 정렬된 데이터가 삽입 될시 트리가 한쪽으로 치우치게되어 검색의 효율이 떨어진다. red-black트리는 이를 보완하여 restructuring과 recoloring연산을 통해 균형된 트리를 유지한다.


## TreeMap 사용법
- 기본적인 메소드의 사용법 자체는 HashMap과 동일

### TreeMap 선언
- 생성하는 명령어는 HashMap과 크게 다르지 않으나 선언 시 크기를 지정해줄 수는 없음
~~~
TreeMap<Integer,String> map1 = new TreeMap<Integer,String>();//TreeMap생성
TreeMap<Integer,String> map2 = new TreeMap<>();//new에서 타입 파라미터 생략가능
TreeMap<Integer,String> map3 = new TreeMap<>(map1);//map1의 모든 값을 가진 TreeMap생성
TreeMap<Integer,String> map6 = new TreeMap<Integer,String>(){{//초기값 설정
    put(1,"a");
}};
~~~

### TreeMap 값 추가
- TreeMap에 값을 추가하려면 put(key, value) 메소드를 사용
- 만약 입력되는 키 값이 TreeMap 내부에 존재한다면 기존의 값은 새로 입력되는 값으로 대치
~~~
TreeMap<Integer,String> map = new TreeMap<Integer,String>();//TreeMap생성
map.put(1, "사과");//값 추가
map.put(2, "복숭아");
map.put(3, "수박");
~~~

### TreeMap 값 삭제
- 오직 키값으로만 TreeMap의 요소를 삭제
~~~
TreeMap<Integer, String> map = new TreeMap<Integer,String>(){{//초기값 설정
    put(1, "사과");//값 추가
    put(2, "복숭아");
    put(3, "수박");
}};
map.remove(1); //key값 1 제거
map.clear(); //모든 값 제거
~~~

### TreeMap 단일 값 출력
- TreeMap은 HashMap과는 달리 Tree구조로 이루어져 있기에 항상 정렬이 되어있어 최솟값, 최댓값을 바로 가져오는 다양한 메소드를 지원
    - firstEntry는 최소 Entry값, firstKey는 최소 Key값, lastEntry는 최대 Entry값, lastKey는 최대 Key값을 리턴
~~~
TreeMap<Integer,String> map = new TreeMap<Integer,String>(){{//초기값 설정
    put(1, "사과");//값 추가
    put(2, "복숭아");
    put(3, "수박");
}};
		
System.out.println(map); //전체 출력 : {1=사과, 2=복숭아, 3=수박}
System.out.println(map.get(1));//key값 1의 value얻기 : 사과
System.out.println(map.firstEntry());//최소 Entry 출력 : 1=사과
System.out.println(map.firstKey());//최소 Key 출력 : 1
System.out.println(map.lastEntry());//최대 Entry 출력: 3=수박
System.out.println(map.lastKey());//최대 Key 출력 : 3
~~~

### TreeMap 전체 값 출력
- <b>대부분 코드가 간단한 keySet을 활용하는데 key값을 이용해서 value를 찾는 과정에서 시간이 많이 소모되므로 많은 양의 데이터를 가져와야 한다면 entrySet()이 좋음(약 20%~200% 성능 저하가 있음)</b>
~~~
TreeMap<Integer,String> map = new TreeMap<Integer,String>(){{//초기값 설정
    put(1, "사과");//값 추가
    put(2, "복숭아");
    put(3, "수박");
}};

//entrySet() 활용
for (Entry<Integer, String> entry : map.entrySet()) {
    System.out.println("[Key]:" + entry.getKey() + " [Value]:" + entry.getValue());
}
//[Key]:1 [Value]:사과
//[Key]:2 [Value]:복숭아
//[Key]:3 [Value]:수박

//KeySet() 활용
for(Integer i : map.keySet()){ //저장된 key값 확인
    System.out.println("[Key]:" + i + " [Value]:" + map.get(i));
}
//[Key]:1 [Value]:사과
//[Key]:2 [Value]:복숭아
//[Key]:3 [Value]:수박
~~~

### Iterator 사용
~~~
TreeMap<Integer,String> map = new TreeMap<Integer,String>(){{//초기값 설정
    put(1, "사과");//값 추가
    put(2, "복숭아");
    put(3, "수박");
}};
		
//entrySet().iterator()
Iterator<Entry<Integer, String>> entries = map.entrySet().iterator();
while(entries.hasNext()){
    Map.Entry<Integer, String> entry = entries.next();
    System.out.println("[Key]:" + entry.getKey() + " [Value]:" +  entry.getValue());
}
//[Key]:1 [Value]:사과
//[Key]:2 [Value]:복숭아
//[Key]:3 [Value]:수박
		
//keySet().iterator()
Iterator<Integer> keys = map.keySet().iterator();
while(keys.hasNext()){
    int key = keys.next();
    System.out.println("[Key]:" + key + " [Value]:" +  map.get(key));
}
//[Key]:1 [Value]:사과
//[Key]:2 [Value]:복숭아
//[Key]:3 [Value]:수박
~~~

### 전체 테스트 코드
~~~
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
~~~

#### 출처
- https://coding-factory.tistory.com/557