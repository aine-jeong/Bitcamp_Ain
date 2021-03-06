import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/*
 ### 상황에 따라 알맞은 자료구조를 사용하는 것이 중요하다 ###
 
 HashMap<K,V> : generic 지원 > 타입 강제 가능
 
 HashMap<String, String>
 HashMap<Integer, String>
 HashMap<String, Emp> >> value에 여러개의 값을 가진다.
 >> put("kim", new Emp()); // kim 의 여러가지 정보를 넣을 수가 있다.
 
 */

class Student{
    int kor;
    int math;
    int eng;
    String name;
    
    public Student(int kor, int math, int eng, String name) {
        super(); // 안써도 문제 없당 
        /// 당신이 만약에 오버로딩한게 있다면 상위에 값을 전달할 때 얘 써먹어라~~하고 만들어주는고
        this.kor = kor;
        this.math = math;
        this.eng = eng;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student [kor=" + kor + ", math=" + math + ", eng=" + eng + ", name=" + name + "]";
    }
    
    
}

public class Ex14_HashMap {
    public static void main(String[] args) {
        // 선생님 학생마다 ID 부여
        HashMap<String, Student> sts = new HashMap<String, Student>();
        sts.put("hong", new Student(100, 99, 88, "홍길동"));
        sts.put("kim", new Student(50, 40, 60, "김유신"));
        // ... 이런식으로 반 학생 20명 관리
        
        Student std = sts.get("hong");
        System.out.println(std);
        
        
        // Tip 1
        // Map -> key, value로 관리
        // 두가지를 한번에 볼 수 있는 방법
        // sts.entrySet(); >> [key + "=" + value]를 하나의 문자열로 만들어서 관리한다.
        // 중복값이 없으니까 Set으로 관리한다
        Set set = sts.entrySet();
        Iterator it = set.iterator();
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        // >> 출력값
        // hong=Student [kor=100, math=99, eng=88, name=홍길동]
        // kim=Student [kor=50, math=40, eng=60, name=김유신]
        // 오버라이드 해놨으니까 주소값 아니고 내용물이 나오는고다~!~!
        
        //Tip2
        //분리된 key, value를 획득할 방법.
        // class Entry {Object key, Object value}
        // Map{ Entry[] elements } > 맵 인터페이스 안에 key와 value를 멤버필드로 갖는 애를 객체로 갖는 배열이 있다
        // Map.Entry 인터페이스
        for(Map.Entry m : sts.entrySet()) {
            // entrySet을 Set에 직접 담지 않고, Map 인터페이스가 가지고 있는 Entry에 담는 것
            System.out.println(m.getKey() + "/" + m.getValue());
        }
     // entrySet을 Set에 받으면 결합된 모양으로 얻을 수 있고,
     // Map 인터페이스가 가지고 있는 Entry(Map.Entry)에 받으면 key와 value를 분리해서 얻을 수 있다.
        
     // m.getValue() 안의 값을 또 각각 받고싶다면, m.getValue()를 다운캐스팅하면 된다.
     // System.out.println(m.getKey() + "/" + ((Student)m.getValue()).name);
        
        
    }
}
