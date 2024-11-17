import java.util.ArrayList;
import java.util.Date;
import java.util.List;
public class Account {
    private double balance;
    private List<Transaction> transactions;

    public Account(double initialBalance) {
        this.balance = initialBalance;
        this.transactions = new ArrayList<>();
    }
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            transactions.add(new Transaction("Пополнение", amount));
        }
    }
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Снятие", amount));
        } else {
            System.out.println("Недостаточно средств или некорректная сумма.");
        }
    }
    public void makePayment(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            transactions.add(new Transaction("Платеж", amount));
        } else {
            System.out.println("Недостаточно средств или некорректная сумма.");
        }
    }
    public double getBalance() {
        return balance;
    }

    public List<Transaction> getTransactions() {
        return transactions;
    }
    public class Transaction {
        private String type;
        private double amount;
        private Date date;

        public Transaction(String type, double amount) {
            this.type = type;
            this.amount = amount;
            this.date = new Date();
        }
        public String getType() {
            return type;
        }
        public double getAmount() {
            return amount;
        }
        public Date getDate() {
            return date;
        }
        @Override
        public String toString() {
            return "Транзакция{" +
                    "Тип='" + type + '\'' +
                    ", Сумма=" + amount +
                    ", Дата=" + date +
                    '}';
        }
    }
    public void printAllTransactions() {
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
    public static void main(String[] args) {
        Account myAccount = new Account(500.0);
        myAccount.deposit(200);
        myAccount.withdraw(100);
        myAccount.makePayment(50);
        System.out.println("Текущий баланс: " + myAccount.getBalance());
        System.out.println("Все транзакции:");
        myAccount.printAllTransactions();
    }
}
