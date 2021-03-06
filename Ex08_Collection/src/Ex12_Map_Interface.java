import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/*
 Map 인터페이스
 Map (key, value) 쌍의 구조를 갖는 배열
 ex) (02, 서울) (031, 경기) : key값을 던지면 거기에 mapping되는 value값을 찾을 수 있다.
 
 - key : 중복이 허용되지 않음
 - value : 중복 허용
 
 - generic 지원 (key, value에 대해서도 타입을 강제할 수 있다)
 
 Map 인터페이스 구현
 - Hashtable(구버전) : 동기화 보장 (lock을 가지고 있다)
 - HashMap(신버전): 동기화를 강제하지 않는다 -> 성능을 고려하여 설계하였다.
 
 key-value > 아이디-패스워드 , 
             카카오톡 <채팅방번호, 참여자> 
              ㄴ> HashMap<String,ArrayList> room = new HashMap<String,ArrayList>();
             ### Map과 List를 혼합해서 사용하는 경우가 많다. ###
             +      room.add("1",new ArrayList())     이런식으로 사용할 수 있당~~~
 
 
 */

public class Ex12_Map_Interface {
    public static void main(String[] args) {
        // HashMap<K, V>
        HashMap map = new HashMap();
        map.put("Tiger", "1004");
        map.put("scott", "1004");
        map.put("superman", "1004");
        //사용자 ID,PWD 
        // 중복아이디 검사할 수 있겠넹!
        System.out.println(map.containsKey("tiger")); // >> false (대소문자 구분)
        
        System.out.println(map.containsKey("scott")); // >> true
        System.out.println(map.containsKey("1004")); // >> true / value값도 검색 가능(있는지없는지! 몇개인지는 x)
        System.out.println(map.containsKey("1007")); // >> false
        
        //point
        //key 제공하면 value값을 알 수 있다.
        System.out.println(map.get("superman")); // >> 1004
        System.out.println(map.get("hong")); // >> null / 해당 key에 해당하는 value가 없으면 null값을 리턴한다.
        
        map.put("Tiger","1007"); // key 중복안된다. > key가 동일한 값을 넣으면 value값을 overwrite한다.
        System.out.println(map.get("Tiger")); // >> 1007
        System.out.println(map.size()); // >> 3
        
//        map.remove("superman"); // 이렇게 삭제만 할 수도 있다!
        Object value = map.remove("superman"); // 삭제할 값을 받아줄 수도 있다.
        System.out.println("value: " + value); // >> value: 1004
        
        System.out.println(map); // = map.toString() / >> {scott=1004, Tiger=1007}
        
        //map.keySet(); >> 리턴값이 Set 
        //                ㄴ> key들의 집합을 뽑는 함수 -> key의 집합은 순서가 없고 중복이 없다 > so, Set으로 뱉는다!
        Set set = map.keySet();
        Iterator it = set.iterator(); // 순차적인
        while(it.hasNext()) {
            System.out.println(it.next());
        }
        
        // map.values(); >> 리턴값이 Collection (value는 중복값이 있으니까!)
        Collection clist = map.values();
        System.out.println(clist.toString());
        
        
        
        
        
    }
}
