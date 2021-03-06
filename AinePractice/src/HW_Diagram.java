interface Loanable{ 
}

class AinLoan implements Loanable{ 
    int loanable_money = 3000;  // 대출업체의 대출가능 자산이 3000만원이다.
    int Interest(int money) { // 이율은 20%이다.
        return (int)(money/20.0);
    }

}

abstract class Bank{ // 
    int property = 2000; // 모든 은행들의 대출가능 자산은 2000만원이다.
    int money;
    
    Bank(int money) {
        this.money = money;
    }
    
    abstract void Info();
    
    void BCAuth() {
        System.out.println(); // 구현하기
    }
}

class KHBank extends Bank{
    
    KHBank(int money) {
        super(money);
    }

    @Override
    void Info() {
        System.out.println("KH은행의 잔액: "+this.money);
    }
    
    @Override
    public String toString() {
        return "KH은행";
    }
    
    @Override
    void BCAuth() {
        System.out.println("KH은행의 보안인증이 실행중입니다.");
    }
    
}

class YHBank extends Bank implements Loanable{

    YHBank(int money) {
        super(money);
    }
    
    @Override
    void Info() {
        System.out.println("YH은행의 잔액: "+this.money); // ##다르게 만들어보기
    }
    
    @Override
    public String toString() {
        return "YH은행";
    }
    
    @Override
    void BCAuth() {
        System.out.println("YH은행의 보안인증이 실행중입니다.");
    }

}

class JHBank extends Bank implements Loanable{

    JHBank(int money) {
        super(money);
    }
    
    @Override
    void Info() {
        System.out.println("JH은행의 잔액: "+this.money);
    }
    
    @Override
    public String toString() {
        return "JH은행";
    }

}

class User{
    int money;
    
    User(int money) {
        this.money = money;
    }
    
    void bankWithDraw(Bank bank, int money) {
        bank.money -= money;
        this.money += money;
        System.out.println(bank.toString()+"에"+money+"만원 출금하셨습니다.");
        System.out.println(bank.toString()+"의 고객님 잔액: "+bank.money+"\n");
    }
    
    void bankDeposit(Bank bank, int money) {
        bank.money += money;
        this.money -= money;
        System.out.println(bank.toString()+"에"+money+"만원 입금하셨습니다.");
        System.out.println(bank.toString()+"의 고객님 잔액: "+bank.money+"\n");
    }
    
    void loan(Loanable loan, int money) {
        this.money += money;
        
        if (loan instanceof Bank) {
            Bank bank = (Bank)loan;
            bank.property -= money;
            System.out.println(bank.toString()+"에서"+money+"만원 대출하셨습니다.");
            System.out.println("고객님, "+bank.toString()+"에서"+bank.property+"만원 더 대출 가능합니다!"+"\n");
        } else {
            AinLoan ainloan = (AinLoan)loan;
            ainloan.loanable_money -= money;
            int interest = ainloan.Interest(money);
            System.out.println("Ainloan 고객님 환영합니다 ^^");
            System.out.println(money+"만원 대출신청 승인되셨습니다.");
            System.out.println("이율은 20%로, 고객님의 이자는 "+interest+"만원 입니다. \n");
        }
    }
    
    void Info() {
        System.out.println("***********");
        System.out.println("현재 가지고있는 현금: "+this.money+"만원");
        System.out.println("***********");
    }
}

public class HW_Diagram {
    public static void main(String[] args) {
        User user = new User(1000);
        KHBank khbank = new KHBank(1000);
        YHBank yhbank = new YHBank(500);
        JHBank jhbank = new JHBank(300);
        
        AinLoan ainloan = new AinLoan();
        
        khbank.BCAuth();
        user.bankDeposit(khbank, 300); // kh은행에 300만원 입금하기
        yhbank.BCAuth();
        user.bankWithDraw(yhbank, 200); // yh은행에서 200만원 출금하기
        
        user.bankWithDraw(jhbank, 50); // jh은행에서 50만원 출금하기
        
        user.loan(jhbank, 300); // jh은행에서 500만원 대출받기
//        user.toString();
        user.loan(ainloan, 700); // ainloan에서 700만원 대출받기
        
        System.out.println("자산관리좀 해볼까?");
        khbank.Info(); // kh은행 잔고 확인하기
        yhbank.Info(); // yh은행 잔고 확인하기
        jhbank.Info(); // jh은행 잔고 확인하기
        user.Info(); //현재 현금 확인하기
        
    }

}
