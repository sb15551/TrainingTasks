import java.util.Objects;

public class Account implements Comparable<Account>
{
    private long money;
    private String accNumber;
    private boolean blocked;

    public Account() {
        blocked = false;
    }

    public Account(String accNumber) {
        this.accNumber = accNumber;
        money = 0;
        blocked = false;
    }

    public void debit(long amount) {
        if (!blocked) {
            money -= amount;
        } else {
            throw new IllegalArgumentException("Payment account is blocked");
        }
    }

    public void credit(long amount) {
        if (!blocked) {
            money += amount;
        } else {
            throw new IllegalArgumentException("Payment account is blocked");
        }
    }

    public long getMoney() {
        return money;
    }

    public void setMoney(long money) throws IllegalArgumentException {
        this.money = money;
    }

    public String getAccNumber() {
        return accNumber;
    }

    public boolean isBlocked() {
        return blocked;
    }

    public void setBlocked(boolean blocked) {
        this.blocked = blocked;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Account account = (Account) o;
        return Objects.equals(accNumber, account.accNumber);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accNumber);
    }

    @Override
    public int compareTo(Account o) {
        return this.getAccNumber().compareTo(o.getAccNumber());
    }
}
