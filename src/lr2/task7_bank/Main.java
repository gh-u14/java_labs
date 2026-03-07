package lr2.task7_bank;

public class Main {

    public static void main(String[] args) {
        BankAccountInterface account = new BankAccount(1000);
        System.out.println("Начальный баланс: " + account.getBalance());

        account.deposit(500);
        System.out.println("После депозита 500: " + account.getBalance());

        account.withdraw(200);
        System.out.println("После снятия 200: " + account.getBalance());
    }
}
