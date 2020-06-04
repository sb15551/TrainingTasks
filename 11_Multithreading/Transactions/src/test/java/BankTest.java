import junit.framework.TestCase;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;

public class BankTest extends TestCase {
    Bank bank;
    Account src, dst;
    Random random;
    AtomicInteger count;

    int numOfAccount = 20;
    final int threadCount = 10;
    final int transfersPerThread = 1000;
    ArrayList<Account> accounts = new ArrayList<>();
    ArrayList<Thread> threads = new ArrayList<>();

    @Override
    protected void setUp() throws Exception {
        bank = new Bank();
        random = new Random();
        count = new AtomicInteger();
        for (int i = 0; i < numOfAccount; i++) {
            String accNumber = String.valueOf(i + 31);
            Account account = new Account(accNumber);
            account.setMoney(1000000);
            accounts.add(account);
            bank.addAccount(accNumber, account);
        }
    }

    private void getRandomAccounts() {
        String srcNum = String.valueOf(random.nextInt(10) + 31);
        String dstNum = String.valueOf(random.nextInt(10) + 31);

        while (srcNum.equals(dstNum)) {
            dstNum = String.valueOf(random.nextInt(10) + 31);
        }

        src = bank.getAccounts().get(srcNum);
        dst = bank.getAccounts().get(dstNum);
    }

    @Test
    public void testBank() throws InterruptedException {
        long sumOfMoney = bank.getAccounts().values().stream().mapToLong(Account::getMoney).sum();
        for (int i = 0; i < threadCount; i++) {
            threads.add(new Thread(() -> {
                for (int j = 0; j < transfersPerThread; j++) {
                    getRandomAccounts();
//                    Account from = accounts.get((int) (Math.random() * accounts.size()));
//                    Account to = accounts.get((int) (Math.random() * accounts.size()));
                    int sum = random.nextInt(50500);
//                    System.out.println(Thread.currentThread().getName());
                    bank.transfer(src.getAccNumber(), dst.getAccNumber(), sum);
                }
            }));
        }
        threads.forEach(Thread::start);
        for (Thread thread : threads) {
            thread.join();
        }

        long result = bank.getAccounts().values().stream().mapToLong(Account::getMoney).sum();
        System.out.println(sumOfMoney + "\n" + result);
        System.out.println(bank.count.get());
        System.out.println(accounts.stream().map(account -> account.getAccNumber() + "-" + account.isBlocked()).collect(Collectors.toList()));
        assertEquals(sumOfMoney, result);
    }

    public void testGetBalance() {
        long actual = bank.getBalance("31");
        long expected = 100000;
        assertEquals(expected, actual);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

}
