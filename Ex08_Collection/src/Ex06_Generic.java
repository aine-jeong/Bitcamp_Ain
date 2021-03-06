import java.util.ArrayList;

/*
 ### TODAY POINT ###
 Generic -> JDK1.5부터 나왔당 (C#에도 있고 ... 필수기능이다!!)
 
 Collection 클래스 >> 데이터 저장 공간의 타입을 Object로 만들었다 (뭐든 넣을 수 있어야 하니까)
 1. Object 타입에 대한 저항: 타입 문제 >> 해결: 처음 객체를 생성할 때 Type을 강제하게 만들자 >> Generic
 2. Type의 안정성을 보장(Generic) : 타입의 강제성을 가지면서 안정성도 확보한 것
 3. 강제 형변환(casting)이 줄어들게 되었다: (Car c = (Car)obj -> X)
 
 class MyGen<Object> { // type parameter / 이 설계도를 사용할 떄 <T>에다가 집어넣어라..
    Object obj;
    void add(Object obj) {
        this.obj = obj;
    }
    Object get() {
        return this.obj;
    }
}
 
 */

// 클래스를 설계할 때 Generic을 적용해서 만들 수 있다.
class MyGen<T> { // type parameter / 이 설계도를 사용할 떄 <T>에다가 타입을 집어넣어라..
    T obj;
    void add(T obj) {
        this.obj = obj;
    }
    T get() {
        return this.obj;
    }
}

class Person extends Object {
    int age = 100;
}


public class Ex06_Generic {
    public static void main(String[] args) {
        
        MyGen<String> mygen = new MyGen<String>();
        mygen.add("문자열");
        String str = mygen.get();
        System.out.println(str);
        
        ArrayList list = new ArrayList();
        // 내부적인 저장 공간의 타입 : Object[] elements
        list.add(10);
        list.add(new Person());
        list.add("홍길동"); // 넣을때는 편하당...
        
        for(Object obj : list) {
            // 꺼낼 때는 방 안에 있는 애들의 "타입 정보를 알아야" 한다...
            // 값타입, 객체타입 casting ...
            if(obj instanceof Person) { // 타입을 확인
                Person p = (Person)obj; // 다운캐스팅
                System.out.println(p.age);
            }else {
                System.out.println(obj);
            }
        }
        
        ArrayList<Person> plist = new ArrayList<Person>();
        plist.add(new Person()); // 타입을 강제해 두었으므로, Person타입의 객체의 주소값만 넣을 수 있게 된다.
        plist.add(new Person()); // 확장성은 없지만 안정성이 생김
        
        for(Person p : plist) { // 먹은 타입을 이미 알고있으므로 뱉을 때 편해진다.
            System.out.println(p.age);
        }
        
        
        
        
        
    }
}
