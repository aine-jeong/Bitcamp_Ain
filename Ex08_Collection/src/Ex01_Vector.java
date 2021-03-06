import java.util.Vector;

/*
 Collection FrameWork 
 : "다수의 데이터"를 다루는 "표준화된 인터페이스"를 구현하고 있는 클래스의 집합
 
 Collection 인터페이스 -> List 인터페이스가 상속 (확장) -> ArrayList가 상속(구현: 수많은 약속들을 이행)
                    -> Set 인터페이스가 상속        -> HashSet , TreeSet (구현)
                    
 Map 인터페이스 -> HashMap(구현)
 ( ㄴ> key, value (key를 주면 value를 제공하는 데이터)) 
 
 1. List(줄을 서시오: 번호표): 순서를 보장, 중복 허용 >> 내부적으로 데이터(자료, 객체)들을 "#배열#"(동적배열)로 관리하는 것
      예) [홍길동][홍길동][홍길동]
 
 > 구현하고 있는 클래스
 1.1. Vector(구버전)     -> 동기화 보장(멀티 스레드) -> Lock장치 o -> 성능이 조금 떨어질 수 있다 -> 안정성을 보장받는다
 1.2. ArrayList(신버전)  -> 동기화를 보장받지 못한다(멀티 스레드 환경에서) 
                             ㄴ> Lock장치 x: 필요에 따라서 쓸 수 있다 -> 성능을 우선시한다 -> 안정성은 조금 떨어진다.
 
--------------------------------------------------------------------------------
 * 기존에 여러개의 같은 타입의 데이터를 관리하기 위해 사용한 것: Array(정적(고정)배열)
     > 방의 개수가 한번 정해지면, 방의 크기는 변경 불가)
     > int[] arr = new int[5];
     > 사용하다가 방의 개수를 늘려야 한다면?
     > int[] arr2 = new int[10];
     > 새로 만들고, 추가로 arr 자원을 arr2로 옮기는 작업이 필요하다.
 
 Array
 1. 배열의 크기가 고정된다 : Car[] cars = {new Car(), new Car()}; // 방 2개
 2. 접근 방법 [index] > 방 번호로 접근: car[0] ,,, n번째 방(length-1)까지
 3. 초기 설정 불가
 
 <-> Collection
 List > Vector , ArrayList
 1. 배열의 크기를 동적으로 확장, 축소가 가능하다. >> 프로그램적으로 말도 안되는 이야기당.... 
     >> 사실은 [배열의 재할당]을 이용하는 것이다.
 2. 순서를 유지(내부적으로 index를 사용(배열 사용)한다)할 수 있다. / 중복값 허용
 3. 데이터의 저장 공간으로 Array를 사용한다.
 
 
 */
public class Ex01_Vector {
    public static void main(String[] args) {
        Vector v = new Vector();
        System.out.println("초기 default(용량): " + v.capacity()); // 10개짜리 배열을 만들어준다.
        System.out.println("size: " + v.size());
        
        v.add("AA");
        v.add("AA");
        v.add("AA");
        
        System.out.println("데이터의 크기(size): " + v.size());
        System.out.println(v.toString()); // 출력: [AA, AA, AA] -> toString 재정의되어있다
        // Array의 length = Collection의 size
        
        for(int i = 0 ; i < v.size() ; i++) {
            System.out.println(v.get(i));
            // array[i] 이렇게 쓰던 것을 함수 사용한 것! (함수get())
        }
        
        // 각 배열의 타입은 Object이다.
        for(Object obj : v) {
            System.out.println(obj);
        }

        ////# 추후에 학습할 내용! (맛보기로 해보쟈)////
        //제너릭 >> 타입을 강제할 수 있다
        Vector<String> v2 = new Vector<String>();
        v2.add("hello"); // String만 넣게 강제되었다.
        v2.add("world");
        v2.add("king");
        
        for(String str : v2) {
            System.out.println(str);
        }
        ////////////////////////////////////////
        
        Vector v3 = new Vector();
        System.out.println(v3.capacity()); // 10개
        v3.add("A");
        v3.add("A");
        v3.add("A");
        v3.add("A");
        v3.add("A");
        v3.add("A");
        v3.add("A");
        v3.add("A");
        v3.add("A");
        v3.add("A");
        v3.add("A"); // 11개를 넣었당
        System.out.println(v3.capacity()); // 방의 크기가 20개가 되었다!
        System.out.println(v3.size());
        
        
    }
}
