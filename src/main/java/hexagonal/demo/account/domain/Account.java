package hexagonal.demo.account.domain;

import java.time.LocalDateTime;

public class Account {

    private AccountId id;

    private Money baselineBalance;

    private ActivityWindow activityWindow;

    Money calculateBalance() {
        return Money.add(baselineBalance, activityWindow.calculateBalance(id));
    }

    boolean withDraw(Money money, AccountId targetAccountId) {
        if (!mayWithdraw(money)) {
            return false;
        }

        Activity withdrawal = new Activity(
                id,
                id,
                targetAccountId,
                LocalDateTime.now(),
                money
        );

        activityWindow.addActivity(withdrawal);

        return true;
    }

    private boolean mayWithdraw(Money money) {
        return Money.add(
                calculateBalance(),
                money.negate()
        ).isPositive();
    }

    boolean deposit(Money money, AccountId sourceAccountId) {
        Activity deposit = new Activity(
                id,
                sourceAccountId,
                id,
                LocalDateTime.now(),
                money
        );

        activityWindow.addActivity(deposit);

        return true;
    }

    public class AccountId {

    }
}
