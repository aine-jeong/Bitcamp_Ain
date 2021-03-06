package Bank;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class Account {

    private String accountNo; //계좌번호
    private String name; // 이름
    private long balance;
//    private Transaction[] transactions = new Transaction[30]; // 크기를 어떻게 지정해야되지 ......
    private ArrayList<Transaction> transactions = new ArrayList<Transaction>();

    //방식을 통일시켜라
    // Bank에서는 생성자를 만들었는데 여기서는 그냥 바로 초기화시켰다
    // 여기도 생성자 만들어서 해주면 좋았을 것.
    
    // 거래내역의 개수 
    private int num = -1;
    
    Calendar cal = Calendar.getInstance();
    SimpleDateFormat dateformat = new SimpleDateFormat("yyyy.MM.dd");
    String transactionDate = dateformat.format(cal.getTime());

    SimpleDateFormat timeformat = new SimpleDateFormat("HH:mm:ss");
    String transactionTime = timeformat.format(cal.getTime());
    
    public int getNum() {
        return num;
    }

    public Account(String accountNo, String name) {
        this.accountNo = accountNo;
        this.name = name;
    }

    // ------------------------------------------
    public Account(String accountNo, String name, long balance, ArrayList<Transaction> transaction) {
        super();
        this.accountNo = accountNo;
        this.name = name;
        this.balance = balance;
        this.transactions = transaction;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBalance(long balance) {
        this.balance = balance;
    }

    @Override
    public String toString() {
        return "[계좌번호: " + accountNo + ", 소유자 명: " + name + ", 잔액: " + balance + "]";
    }

    // ------------------------------------------

    public void deposit(long amount) { //입금
        this.balance += amount;
        this.num++;

        Transaction transaction = new Transaction(transactionDate, transactionTime, "입금", amount, this.balance);
        this.transactions.add(transaction);
        
        System.out.println(amount+"원 입금하셨습니다. 잔액은 "+ this.balance +"입니다.");
    }

    public void withdraw(long amount) { //출금
        if (this.balance < amount) {
            System.out.println("잔액이 부족합니다.");
            System.out.println("현재 잔고: " + this.balance);
        } else {
            this.balance -= amount;
            this.num++;

            Transaction transaction = new Transaction(transactionDate, transactionTime, "출금", amount, this.balance);
            this.transactions.add(transaction);
            
            System.out.println(amount+"원 출금하셨습니다. 잔액은 "+ this.balance +"입니다.");
        }
    }

    public long getBalance() { //잔고확인하기
        return balance;
    }

    public ArrayList<Transaction> getTransaction() { //거래내역보기
        return transactions;
    }

}
