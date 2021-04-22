# char 숫자 또는 대소문자 판별

### 1. char타입의 값이 문자인지 숫자인지 판별할 때 사용하는 메서드
- char타입의 문자, 숫자 구분을 위한 메서드
    - public static boolean isDigit(char ch)
    - public static boolean isDigit(int codePoint)
- 예시
~~~
System.out.println(Character.isDigit('a')); // false 리턴
System.out.println(Character.isDigit('97')); // true 리턴
System.out.println(Character.isDigit(97)); // int 타입 97은 유니코드로 소문자 a를 의미하므로 false 리턴
~~~

### 2. char타입의 값이 대소문자 판별 및 변환과 관련된 메서드(String도 고유 포함된 메소드로 인해 동일하게 사용 가능)
- 대소문자 판별을 위한 메서드
    - public boolean Character.isUpperCase(char ch)
    - public boolean Character.isUpperCase(int codePoint)
    - public boolean Character.isLowerCase(char ch)
    - public boolean Character.isLowerCase(int codePoint)

- 대소문자 변환을 위한 메서드
    - public char Character.toUpperCase(char ch)
    - public char Character.toUpperCase(int codePoint)
    - public char Character.toLowerCase(char ch)
    - public char Character.toLowerCase(int codePoint)

- 예시
~~~
import java.io.IOException;


public class Main {

	public static void main(String[] args) throws IOException {
		char c1 = '1';
		char c2 = 'a';
		char c3 = 'A';
		
		System.out.println("1 is Upper case? -> " + Character.isUpperCase(c1));
		System.out.println("a is Upper case? -> " + Character.isUpperCase(c2));
		System.out.println("A is Upper case? -> " + Character.isUpperCase(c3));
		
		System.out.println();
		
		System.out.println("1 is Lower case? -> " + Character.isLowerCase(c1));
		System.out.println("a is Lower case? -> " + Character.isLowerCase(c2));
		System.out.println("A is Lower case? -> " + Character.isLowerCase(c3));
		
		System.out.println();
		
		System.out.println("1 convert Upper case -> " + Character.toUpperCase(c1));
		System.out.println("a convert Upper case -> " + Character.toUpperCase(c2));
		System.out.println("A convert Upper case -> " + Character.toUpperCase(c3));
		
		System.out.println();
		
		System.out.println("1 convert Lower case -> " + Character.toLowerCase(c1));
		System.out.println("a convert Lower case -> " + Character.toLowerCase(c2));
		System.out.println("A convert Lower case -> " + Character.toLowerCase(c3));
	}

}
~~~