import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

//https://cafe.naver.com/bit2021/282

//format이 리턴하는것 => String


public class Ex10_Format_Date {
    public static void main(String[] args) {
        Date curdate = new Date();
        Calendar cal = Calendar.getInstance();
        System.out.println("date : " + curdate); //날짜 형식  >> format 
        System.out.println("cal : " + cal); //문자열 결합
        System.out.println("cal getTime()  함수 : " + cal.getTime()); // getTime >> format
        
        //Calendar에서 날짜형식을 받으려면 cal.getTime
        
        System.out.println("************************************************");
        
        SimpleDateFormat dateformat = new SimpleDateFormat("yyyyMMddHHmm");
        System.out.println(dateformat.format(curdate)); // format함수는 parameter(인자)로 Date형식만 받는다.
        System.out.println(dateformat.format(cal.getTime())); // Calender를 Date형식으로 줘야되니까 cal.getTime
        
        //사이트 정보 입력
        //문자열 >> 날짜 형식으로 변환 
        String StringDate = "202102171151";
        try { 
                        Date stringdate =  dateformat.parse(StringDate); // 문자열 형식을 날짜열로 바꾸기
                        System.out.println("stringdate : " + stringdate); 
                        
                        long datelong =  stringdate.getTime(); // 
                        System.out.println(datelong);
        } catch (ParseException e) {
                    e.printStackTrace();
        }
    
        
        
        double money = 123456.5678;
        DecimalFormat df = new DecimalFormat("0.0"); // 123456.6 (반올림)
        System.out.println(df.format(money));

         DecimalFormat df2 = new DecimalFormat("0"); // 123457 (반올림)
        System.out.println(df2.format(money));

    
       //반올림 처리 확인
        DecimalFormat df3 = new DecimalFormat("0.000");
        System.out.println(df3.format(money));

        DecimalFormat df4 = new DecimalFormat("-#.#");
        System.out.println(df4.format(money));

         DecimalFormat df5 = new DecimalFormat("#%");
        System.out.println(df5.format(money));

        Date today = new Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-----MM/dd");
        System.out.println(s.format(today));

        

        SimpleDateFormat s2 = new SimpleDateFormat("yyyy년 MMM dd일 E요일");
        System.out.println(s2.format(today));

        

        SimpleDateFormat s3 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:sss");
        System.out.println(s3.format(today));

        

        //혼용
        Calendar c = Calendar.getInstance();
        Date d = c.getTime(); //Calendar 형식을 Date 형식
        System.out.println(s3.format(d));
        
    }

}

