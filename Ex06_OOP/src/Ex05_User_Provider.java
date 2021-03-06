/*
 
 User(사용자) - Provider(제공자)
 
 class A{}
 class B{}
 
 관계) A는 B를 사용합니다
 
 사용방법
 1. 상속: A extends B
 2. 포함: A 라는 클래스는 B를 member field로 가질 수 있다. class A {B b;}
   2.1. 부분집합
   2.2. 전체집합
 ---------------------------------------------------------------
 //# 자동차와 엔진의 관계
 class B{}
 class A{
     int i;
     B b; // A는 B를 (포함관계로) 사용합니다.
     A(){
         b = new B();
     }
  }
 >> B라는 클래스는 독자적인 생성(x) >> A라는 객체가 만들어져야 B가 생성된다.
 >> A a = new A() >> A객체도 생성되고, B객체도 생성된다
 >> 생명주기가 같다 >> "전체집합"
 --------------------------
 //# 학생과 학교의 관계
 class B{}
 class A{
     int i;
     B b; // A는 B를 (포함관계로) 사용합니다.
     A() {
     
     }
     A(B b) {
         this.b = b;
     }
 }
 >> void main()
    A a = new A();
    B b - new B();
    A a2 = new A(b);
 // 각각 만들어질 수 있지만, A가 필요하다면 B를 사용할 수 있다 >> "부분집합"
 // A와 B가 같은 운명체가 아니다.
   
   공통점: member field가 있다
   차이점: new가 밖에서 만들어지냐 안에서 만들어지냐
 ------------------------------------------------------------
 class B{}
 class A{
     int i;
     A(){
     
     }
     void m(B b){ // A는 B에 의존합니다 (함수(funtion)) >> ##B타입의 멤버필드가 없다.## 
         b 객체를 가지고 작업
     }
 >> void main()
 B b = new B()
 A a = new A();
 어떤 상황에는 B객체가 필요하다
 a.m(b) // dependency >> 멤버필드를 갖지 않는다.
     
 */

// ################Today Point ################
class B{
    
}

class A{
    void method(B b) {
        
    }
}

// 현대적인 프로그래밍 기법: 인터페이스 활용
interface Icallable{
    void m();
}

class D implements Icallable{

    @Override
    public void m() {
        System.out.println("D Icallable 인터페이스의 m()을 재정의했다.");
    }  
}

class F implements Icallable{

    @Override
    public void m() {
        System.out.println("F Icallable 인터페이스의 m()을 재정의했다.");
    }
}

// interface POINT >> 유연하게 >> 확장자 
// 현대적인 프로그래밍은 느슨한 관계를 좋아한다.
class User{
    /*
    void method(D d) {
        d.m();
    }
    void method(F f) {
        f.m();
    }
    */
    
    void method(Icallable ic) {
        ic.m();
    }
}

public class Ex05_User_Provider {
    public static void main(String[] args) {
        B b = new B();
        A a = new A();
        a.method(b); // 반드시 B타입의 객체 주소가 와야 한다.
                // >> B 객체를 생성하지 않으면 method를 사용할 수 없다...
        
        
        D d = new D(); // 자동차로 따지면 요기는 타이어부분이다~~~
        F f = new F(); // 타이어를 장착하는 틀(메소드)에 D타이어도 F타이어도 다 들어갈 수 있다~~
        User user = new User();
        user.method(d);
        user.method(f);
        
        
    }
}
