import java.util.ArrayList;

import kr.or.bit.Emp;

public class Ex03_ArrayList_Object {
    public static void main(String[] args) {
        //사원 1명을 만드세요
        Emp emp = new Emp(100, "김유신", "군인");
        System.out.println(emp.toString());
        
        //사원 2명을 만드세요
        //Array
        Emp[] emplist = {new Emp(100, "김씨", "일반"), new Emp(200, "박씨", "학생")};
        for(Emp e : emplist) {
            System.out.println(e.toString());
        }
        
        //1명이 새로 입사했어요 추가해주세용
        //기존의 방법
        //Emp[] emplist = new Emp[3];
        //기존의 데이터를 이동시킨 뒤에 한명 추가해야돼...
        
        //Collection
        //ArrayList 등장!
        ArrayList elist = new ArrayList();
        elist.add(new Emp(1, "강", "IT"));
        elist.add(new Emp(2, "김", "IT"));
        // 1명입사
        elist.add(new Emp(3, "이", "IT"));
        System.out.println(elist.size()); //  >> 3
        for(int i = 0; i < elist.size() ; i++) {
//            System.out.println(elist.get(i));
//            Emp e = elist.get(i); -> ArrayList가 가지고 있는 배열의 타입이 Object[] 이다.
                                        // ㄴ> 이렇게 쓰려면 강제 다운캐스팅을 해줘야 한다...
            Object obj = elist.get(i);
//            System.out.println(obj); // Emp가 가지고있는 toString을 재정의해뒀기 때문에 재정의한 toString을 호출한다.
            Emp e = (Emp)obj;
            System.out.println(e.getEmpno() + " / " + e.getEname() + " / " + e.getJob()); 
                    // ㄴ> 각각의 정보를 보고싶다면 위와 같이 다운캐스팅 하면 된다.
            
        }
        
        for(Object e : elist) {
            System.out.println(e.toString()); // 가능
            // 목적에 따라서는 다운캐스팅이 필요할 때도 있다.
            Emp e2 = (Emp)e;
            System.out.println(e2.getEmpno()); // 이로케
        }
        
        // 개발자가 싫어하는 것 : casting 예외
        // Object 싫어 ... 안쓰고싶어 ....
        // JAVA제작자에게 요청
        // "generic타입" 등장 -> 객체 생성 타입을 강제
        // 현업에서 90%가 generic을 씁니다....
        ArrayList<Emp> list2 = new ArrayList<Emp>();
                // ㄴ> Emp타입만 넣어랏 (생성타입 강제)
        list2.add(new Emp(1, "A", "IT"));
        list2.add(new Emp(2, "B", "IT"));
        
        list2.add(0, new Emp(0, "AAA", "CEO"));
        
        System.out.println(list2);
        
        
        for(Emp e : list2) {
//            System.out.println(e.getEmpno()); // 다운캐스팅 필요없당
            System.out.println(e);
        }
        
        
        
    }//main end
}//class end
