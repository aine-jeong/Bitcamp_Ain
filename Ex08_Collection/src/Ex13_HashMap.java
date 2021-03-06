import java.util.HashMap;
import java.util.Scanner;

public class Ex13_HashMap {
    public static void main(String[] args) {
        //지역번호, 출석부, 우편번호, 회원가입 등등 ...
        HashMap loginmap = new HashMap();
        loginmap.put("kim", "kim1004");
        loginmap.put("scott", "tiger");
        loginmap.put("lee", "kim1004");
        
        // 회원가입은 처리 끝났다 (회원 정보를 가지고 있다)
        
        // 로그인 경우의 수
        // id(O), pwd(O) >> 로그인 성공
        // id(O), pwd(X) >> 비밀번호 틀림 / 비밀번호 입력다시 받거
        // id(X), pwd(O) >> 아이디 틀림(비밀번호 검증과정 불필요)
        // id(X), pwd(X) >> 아이디 틀림(비밀번호 검증과정 불필요)
        
        Scanner sc = new Scanner(System.in);
        while(true) {
            System.out.println("아이디와 비밀번호를 입력해주세요.");
            System.out.print("ID: ");
            String id = sc.nextLine().trim().toLowerCase(); // 아이디 받아서, 양쪽 공백 제거, 모두 소문자로 바꿈
            
            System.out.print("Password: ");
            String pwd = sc.nextLine().trim(); // 비밀번호 받아서, 양쪽 공백 제거
            
            
            if(!loginmap.containsKey(id)) {
                // ID를 틀린 경우
                System.out.println("ID가 잘못되었습니다. 재입력해주세요.");
            } else {
                // ID는 맞음
                if(loginmap.get(id).equals(pwd)) {
                    System.out.println("회원님, 반갑습니다.");
                    break; // 둘다 맞음. while 탈출
                } else {
                    System.out.println("비밀번호가 잘못되었습니다. 재입력해주세요. ");
                }
            }
        }
        
        
        
        
    } // main
}//class
