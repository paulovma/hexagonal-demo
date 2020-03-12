package hexagonal.demo.account.application.port.in;

import hexagonal.demo.account.domain.Account;
import hexagonal.demo.account.domain.Money;

public interface GetAccountBalanceQuery {

    public Money getAccountBalance(Account.AccountId accountId);
}
