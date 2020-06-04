import java.util.HashMap;
import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

public class Bank
{
    private HashMap<String, Account> accounts;
    private final Random random = new Random();
    public AtomicInteger count = new AtomicInteger(0);

    public Bank() {
        accounts = new HashMap<>();
    }

    public synchronized boolean isFraud(String fromAccountNum, String toAccountNum, long amount)
        throws InterruptedException
    {
        Thread.sleep(1000);
        return random.nextBoolean();
    }

    /**
     * TODO: реализовать метод. Метод переводит деньги между счетами.
     * Если сумма транзакции > 50000, то после совершения транзакции,
     * она отправляется на проверку Службе Безопасности – вызывается
     * метод isFraud. Если возвращается true, то делается блокировка
     * счетов (как – на ваше усмотрение)
     */
    public void transfer(String fromAccountNum, String toAccountNum, long amount) {
        count.incrementAndGet();
        Account src = accounts.get(fromAccountNum);
        Account dst = accounts.get(toAccountNum);

        if (fromAccountNum.equals(toAccountNum)) {
            synchronized (src.compareTo(dst) > 0 ? src : dst) {
                synchronized (src.compareTo(dst) > 0 ? dst : src) {
                    if (src.getMoney() >= amount && !src.isBlocked() && !dst.isBlocked()) {

                        if (amount > 50000) {
                            try {
                                if (isFraud(src.getAccNumber(), dst.getAccNumber(), amount)) {
                                    blockedAcc(src);
                                    blockedAcc(dst);
                                } else {
                                    src.debit(amount);
                                    dst.credit(amount);
                                }
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        } else {
                            src.debit(amount);
                            dst.credit(amount);
                        }
                    }
                }
            }
        }
    }

    /**
     * TODO: реализовать метод. Возвращает остаток на счёте.
     */
    public long getBalance(String accountNum) throws IllegalArgumentException {
        if (accounts.containsKey(accountNum)) {
            return accounts.get(accountNum).getMoney();
        }
        throw new IllegalArgumentException("Not found account!!!");
    }

    private void blockedAcc(Account account) {
        account.setBlocked(true);
    }

    private void unblockedAcc(Account account) {
        account.setBlocked(false);
    }

    public HashMap<String, Account> getAccounts() {
        return accounts;
    }

    public void addAccount(String accNumber, Account account) {
        accounts.put(accNumber, account);
    }
}
