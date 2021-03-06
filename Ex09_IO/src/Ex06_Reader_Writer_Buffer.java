import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Ex06_Reader_Writer_Buffer {
    
    public static void main(String[] args) throws Exception{
        //Lotto
        FileWriter fw = new FileWriter("Lotto.txt" , true);
        BufferedWriter bw = new BufferedWriter(fw);
        
        bw.write("로또");
        bw.newLine();
        bw.write("1,3,6,8,9");
        bw.newLine();
        bw.flush();
        
        // 예외처리 안한것... 빠르게 하려고 ........
        // 중요한 것: 버퍼는 엔터키(newLine)을 사용할 수 있다는 것~~~~~~~~~~~
        
        
    }
    
    public static void main02(String[] args) {
        
        FileReader fr = null;
        BufferedReader br = null;
        
        try {
            fr = new FileReader("Ex01_Stream.java"); // 2byte씩 하나씩... 읽는즁...
            br = new BufferedReader(fr); // 다형성 /     ㄴ> 한번에 태워서 보내자!!!!
            
            //line 처리 (라인단위로 읽기)
            String line="";
            for(int i = 0; (line = br.readLine()) != null; i++) {
//                System.out.println(line); // 라인단위로 읽기
                if(line.indexOf(";") != -1) { // indexOf(): 어떤 문자를 주면 걔의 인덱스값을 뽑아내기
                           // ㄴ> ;이 있는 문장만 뽑아라!!!!
                    System.out.println(line);
                }
                
            }
            
        } catch (Exception e) {
            // TODO: handle exception
        } finally {
            try {
                fr.close();
                br.close();
            } catch (Exception e2) {
                // TODO: handle exception
            }
        }
        
    }
}
