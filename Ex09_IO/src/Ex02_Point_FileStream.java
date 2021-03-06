import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

// ### TODAY POINT ###

/*
 read, write의 대상이 File ( .txt 등)
 
 >> FileInputStream
 >> FileOutputStream
 
 ## C드라이브에 Temp폴더에 a.txt 생성했음
 
 
 
 */
public class Ex02_Point_FileStream {
    public static void main(String[] args) {
        FileInputStream fs = null;
        FileOutputStream fos = null;

        String path = "C:\\Temp\\a.txt"; // 실제 파일의 경로

        try {

            fs = new FileInputStream(path); // 빨대 꽂았다
            fos = new FileOutputStream("C:\\Temp\\new.txt",true); // 우리는 아직 new.txt를 안만들어 뒀다
                                                            
            
            //FileOutputStram
            //1. write하는 파일이 존재하지 않으면 파일을 생성한다.
            //new FileOutputStream("C:\\Temp\\new.txt",false)
            //overwrite
            
            //true값을 추가하면 해당 파일에 계속 실행내용을 추가해준다.
            //append >> true

            int data = 0; // char는 정수다~!~! 인트랑 호환 가능
            while ((data = fs.read()) != -1) { // data = fs.read() -> char의 아스키코드를 정수로 받아둔다.
                System.out.println("정수: " + data); // 104 101 108 108 111
                // 문자값으로 바꿔줘야겠지?
                System.out.println("문자: " + (char) data);

                fos.write(data);
                // @@
                // new.txt 파일에 data값을 write하겠다.
                // FileOutputStream가 write하려고 하는 파일이 없다면 파일을 생성한다(생성 기능도 가지고 있다!)
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // 정상이든 비정상이든 코드를 수행한다(강제적 실행) return있어도 실행된다.
            // 명시적인 자원 해제(객체) >> 가비지 컬렉터가 관리한다.
            // 관리하지 못하는 자원: I/O, NetWork ...
            // ㄴ> 이런 자원들은 개발자가 명시적으로 자원을 해제시켜줘야 한다.
            // ㄴ> ex> 엑셀파일 작업하고 있을 때 다른사람이 열면 읽기 전용으로 열리거나 수정 불가하다고 한다는 것 처럼..
            // 생성자 <-> 소멸자

            try {
                fs.close();
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        // 합쳐서 오뚜케 뽑지
//            data = 0;
//            while((data = fs.read()) != -1) { // data = fs.read() -> char의 아스키코드를 정수로 받아둔다.
//                System.out.print((char)data);
//            }

    }
}
