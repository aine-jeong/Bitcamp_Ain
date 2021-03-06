package Bank;

public class Transaction {
    private String transactionDate; // 거래일
    private String transactionTime; // 거래시간
    
    private String kind; //입금 또는 출금
    private long amount; //거래금액
    private long balance; // 잔고
    
    public Transaction() {
        
    }
    
    public Transaction(String transactionDate, String transactionTime, String kind, long amount, long balance) {
        this.transactionDate = transactionDate;
        this.transactionTime = transactionTime;
        this.kind = kind;
        this.amount = amount;
        this.balance = balance;
    }
    
//    public String getTransactionDate() {
//        return transactionDate;
//    }
//    public void setTransactionDate(String transactionDate) {
//        this.transactionDate = transactionDate;
//    }
//    public String getTransactionTime() {
//        return transactionTime;
//    }
//    public void setTransactionTime(String transactionTime) {
//        this.transactionTime = transactionTime;
//    }
//    public String getKind() {
//        return kind;
//    }
//    public void setKind(String kind) {
//        this.kind = kind;
//    }
//    public long getAmount() {
//        return amount;
//    }
//    public void setAmount(long amount) {
//        this.amount = amount;
//    }
//    public long getBalance() {
//        return balance;
//    }
//    public void setBalance(long balance) {
//        this.balance = balance;
//    }
//    
    @Override
    public String toString() {
        return "[거래날짜: " + transactionDate + "/ 거래시간: " + transactionTime + "/ 거래종류: "
                + kind + "/ 거래금액: " + amount + "/ 잔고:" + balance + "]";
    }
    
    
    
}
