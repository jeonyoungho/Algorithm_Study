# TreeSet

## TreeSet이란?
- jdk1.2부터 제공
- HashSet과 마찬가지로 Set인터페이스를 구현한 클래스로써 <b>객체 중복 저장 불가하고 저장 순서 유지 안됨</b>
- HashSet과는 달리 TreeSet은 이진 탐색 트리(BinarySearchTree) 구조임
- HashSet보다 데이터의 추가와 삭제는 시간이 더 걸리지만 검색과 정렬에는 유리
    - 이진 탐색 트리는 추가와 삭제에는 시간이 조금 더 걸리지만 정렬, 검색에 높은 성능
- TreeSet은 데이터를 저장할 시 이진탐색트리(BinarySearchTree)의 형태로 데이터를 저장하기에 기본적으로 nature ordering를 지원한다.
- 생성자의 매개변수로 Comparator객체를 입력하여 정렬 방법을 임의로 지정 가능
- <b>TreeSet은 이진탐색트리 중에서도 성능을 향상시킨 [레드-블랙 트리(Red-Black Tree)](https://github.com/jeonyoungho/TIL/blob/master/DataStructure/red-black%20%ED%8A%B8%EB%A6%AC%20%26%20AVL%20%ED%8A%B8%EB%A6%AC.md)로 구현</b>
- 이진 탐색트리는 정렬된 데이터가 삽입 될시 트리가 한쪽으로 치우치게되어 검색의 효율이 떨어진다. red-black트리는 이를 보완하여 restructuring과 recoloring연산을 통해 균형된 트리를 유지한다.

## TreeSet 사용법
### TreeSet 선언
- HashSet과 크게 다르지 않으나 선언 시 크기를 지정해줄 수는 없습니다.
~~~
TreeSet<Integer> set1 = new TreeSet<Integer>();//TreeSet생성
TreeSet<Integer> set2 = new TreeSet<>();//new에서 타입 파라미터 생략가능
TreeSet<Integer> set3 = new TreeSet<Integer>(set1);//set1의 모든 값을 가진 TreeSet생성
TreeSet<Integer> set4 = new TreeSet<Integer>(Arrays.asList(1,2,3));//초기값 지정
~~~

### TreeSet 값 추가
~~~
TreeSet<Integer> set = new TreeSet<Integer>();//TreeSet생성
set.add(7); //값추가
set.add(4);
set.add(9);
set.add(1);
set.add(5);
~~~
- 7,4,9,2,5를 차례대로 TreeSet에 저장한다면 아래와 같은 과정이 일어남</br>
![1](https://user-images.githubusercontent.com/44339530/115815784-916b9900-a432-11eb-98b0-d2e9cc0a9448.png)</br>

### TreeSet 값 삭제
~~~
TreeSet<Integer> set = new TreeSet<Integer>();//TreeSet생성
set.remove(1);//값 1 제거, 삭제 후 boolean값 리턴
set.clear();//모든 값 제거
~~~

### TreeSet 크기 구하기
~~~
TreeSet<Integer> set = new TreeSet<Integer>(Arrays.asList(1,2,3));//초기값 지정
System.out.println(set.size());//크기 : 3
~~~

### TreeSet값 출력
~~~
TreeSet<Integer> set = new TreeSet<Integer>(Arrays.asList(4,2,3));//초기값 지정
System.out.println(set); //전체출력 [2,3,4]
System.out.println(set.first());//최소값 출력
System.out.println(set.last());//최대값 출력
System.out.println(set.higher(3));//입력값보다 큰 데이터중 최소값 출력 없으면 null
System.out.println(set.lower(3));//입력값보다 작은 데이터중 최대값 출력 없으면 null
		
Iterator iter = set.iterator();	// Iterator 사용
while(iter.hasNext()) {//값이 있으면 true 없으면 false
    System.out.println(iter.next());
}
~~~

### 전체 테스트 코드
~~~
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.TreeSet;

public class Main {
	
	public static void main(String[] args) throws NumberFormatException, IOException   {
		TreeSet<Integer> set1 = new TreeSet<Integer>(Arrays.asList(7,4,9));//초기값 지정
		TreeSet<Integer> set2 = new TreeSet<Integer>(set1);//set1의 모든 값을 가진 TreeSet생성
		set2.add(1);
		set2.add(5);
		
		set2.remove(1);//값 1 제거, 삭제 후 boolean값 리턴
		set1.clear();//모든 값 제거
		
		System.out.println("set1 size: " + set1.size());
		System.out.println("set2 size: " + set2.size());
		
		System.out.println("Print all data in set2: " + set2); //전체출력 [4,5,7,9]
		System.out.println("Print min data in set2: " + set2.first());//최소값 출력 -> 4
		System.out.println("Print max data in set2: " + set2.last());//최대값 출력 -> 9
		System.out.println("Print higher data than 3 in set2: " + set2.higher(3));//입력값보다 큰 데이터중 최소값 출력 없으면 null
		System.out.println("Print lower data than 3 in set2: " + set2.lower(3));//입력값보다 작은 데이터중 최대값 출력 없으면 null
				
		System.out.println("===== iterator =====");
		Iterator iter = set2.iterator();	// Iterator 사용
		while(iter.hasNext()) {//값이 있으면 true 없으면 false
		    System.out.println("iterator next data:" + iter.next());
		}
	}
	
}
~~~

#### 출처
- https://coding-factory.tistory.com/555