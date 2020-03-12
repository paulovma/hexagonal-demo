package hexagonal.demo.account.domain;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@AllArgsConstructor
@NoArgsConstructor
public class Account {

    private AccountId id;

    private Money baselineBalance;

    private ActivityWindow activityWindow;

    public static Account withoutId(Money baselineBalance, ActivityWindow activityWindow) {
        return new Account(null, baselineBalance, activityWindow);
    }

    public static Account withId(AccountId accountId, Money baselineBalance, ActivityWindow activityWindow) {
        return new Account(accountId, baselineBalance, activityWindow);
    }

    public Money calculateBalance() {
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

    @AllArgsConstructor
    @NoArgsConstructor
    public static class AccountId {

        private Long id;

    }
}
