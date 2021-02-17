import java.io.FileInputStream;
import java.io.FileOutputStream;

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
            fos = new FileOutputStream("C:\\Temp\\new.txt"); // 우리는 아직 new.txt를 안만들어 뒀다
                                                            //  @@
            
            
            int data = 0; //char는 정수다~!~! 인트랑 호환 가능
            while((data = fs.read()) != -1) { // data = fs.read() -> char의 아스키코드를 정수로 받아둔다.
                System.out.println("정수: "+data); // 104 101 108 108 111 
                //문자값으로 바꿔줘야겠지?
                System.out.println("문자: "+ (char)data);
                
                fos.write(data);
                //@@
                //new.txt 파일에 data값을 write하겠다.
                //FileOutputStream가 write하려고 하는 파일이 없다면 파일을 생성한다(생성 기능도 가지고 있다!)
            }
            
            //합쳐서 오뚜케 뽑지
//            data = 0;
//            while((data = fs.read()) != -1) { // data = fs.read() -> char의 아스키코드를 정수로 받아둔다.
//                System.out.print((char)data);
//            }
            
                
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        
    }
}
