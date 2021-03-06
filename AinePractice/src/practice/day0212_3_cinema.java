package practice;
import java.util.Scanner;
import java.util.Random;

public class day0212_3_cinema {
    static final int ROW = 4;
    static final int COL = 5;
    
    Scanner sc = new Scanner(System.in);
    Random random = new Random();
    int userMenu;
    String[][] seat = new String[ROW][COL]; //좌석번호 배열
    String[][] reservation_number = new String[ROW][COL]; // 예매번호(랜덤) 배열

    void Menu() {
        showMenu();
        while (true) { // 메뉴 다시 짜기
            switch (userMenu) {
            case 1: Reservation();
            case 2: Check();
            case 3: Cancel();
            case 4: break;
            }

        }

    }

    private void showMenu() {
        System.out.println("********************");
        System.out.println("*****영화예매시스템*****");
        System.out.println("********************");
        System.out.println("1. 예매하기");
        System.out.println("2. 예매조회");
        System.out.println("3. 예매취소");
        System.out.println("4. 프로그램 종료");
        userMenu = sc.nextInt();

    }
    
    public void seatReset() {
        for(int i = 0; i < seat.length; i++) {
            for(int j = 0; j < seat[i].length; j++) {
                seat[i][j] = (i+1)+"-"+(j+1);
            }
        }
    }
    
    public void seatPrint() {
        System.out.println("**********좌석현황**********");
        for(int i = 0; i < seat.length; i++) {
            for(int j = 0; j < seat[i].length ; j++) {
                System.out.printf("[%s]",seat[i][j]);
            }
            System.out.println();
        }
        System.out.println("**************************");
    }
    
    public void Reservation() {
        seatPrint();
        System.out.println("좌석을 선택해주세요. 예) 1-1");
        System.out.println("이미 예매된 좌석은 \"예매\"라고 표시됩니다.");
        String userseat = sc.nextLine(); // 유저 선택 좌석
        int userchoice = -1;
        
        int userrow=-1;
        int usercol=-1;
        
        String randomnum = "";
        for(int i = 0; i < 8; i++){ // 0~9의 정수를 총 8자리 뽑으려고!
            randomnum += Integer.toString(random.nextInt(9));
        }
        
        for (int i = 0; i < seat.length; i++) {
            for (int j = 0; j < seat[i].length; j++) {
                if (userseat.equals("예매")) {
                    System.out.println("이미 예매된 좌석입니다.");
                    break;
                } else if (userseat.equals(seat[i][j])) {
                    System.out.println("예매 가능합니다. 예매 하시겠습니까?");
                    System.out.println("(1)네, (2)아니오 중 하나를 입력해주세요.");
                    userchoice = sc.nextInt();

                    userrow = i;
                    usercol = j;
                }
            }
        }
        
        if(userchoice == 1) {
            System.out.println("예매가 완료되었습니다.");
            System.out.printf("예매한 좌석번호:[%s] / 예매번호: [%s] \n",userseat,randomnum);
            reservation_number[userrow][usercol] = randomnum;
            seat[userrow][usercol] = "예매";
            return;
        } else {
            System.out.println("예매를 취소하셨습니다.");
            System.out.println("메뉴선택 화면으로 돌아갑니다.");
            return;
        }
    }
    
    private void Check() {
        
    }
    
    private void Cancel() {
        
    }
    

    
}
