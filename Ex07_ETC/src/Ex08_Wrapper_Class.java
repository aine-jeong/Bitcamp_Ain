import java.util.ArrayList;

/*
 자바가 가지는 8가지 기본 타입(값타입) : JAVA API가 제공하는 자원
 8가지 기본 타입에 대해서 설계도를 만들어 두었다. 
   ㄴ> 8가지 기본 타입도 객체 형태로 사용할 수 있다. >> wrapper class
 
 값 타입 대신에 객체 형태의 타입을 사용하는 곳 >> Generic(: 참조형태의 parameter만 사용 가능)
 1. 매개변수로 객체 타입이 요구될 때
 2. 기본형 값이 아닌 객체로 저장되길 원할 때
 3. 객체간 값 비교
 4. 타입 변환시 비교
 
 
 */


public class Ex08_Wrapper_Class {
    public static void main(String[] args) {
        int i = 100;
        
        Integer n = new Integer(100); // 밑줄: is deprecated 추후 버전에서 사라질고야 ... 사용하지마..
        System.out.println(n); // 사실은 n 주소값이 출력되어야 한다 (-> toString을 재정의해뒀구나!)
        System.out.println(n.MAX_VALUE); // >> 2147483647
        System.out.println(n.MIN_VALUE); // >> -2147483648
        
        // ###POINT###
        // generic이 받는 parameter는 참조값만 들어올 수 있기 때문에
        // generic 에서 정수를 받고싶을 때 int 가 아니라 Integer로 넣어야 한다
        ArrayList<Integer> li = new ArrayList<Integer>();
        li.add(100);
        //li.add("A");  못넣는다
        
        for(int value : li) {
            System.out.println(value);
        }
        
        // char Character 
        // int  Integer
        // 나머지는 앞글자 대문자 (Boolean, Short 등)
        
        
    }
}
