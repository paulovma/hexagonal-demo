package hexagonal.demo.account.domain;

public class Money {
    public static Money add(Money baselineBalance, Object calculateBalance) {
        return baselineBalance;
    }

    public Object negate() {
        return null;
    }

    public boolean isPositive() {
        return false;
    }
}
