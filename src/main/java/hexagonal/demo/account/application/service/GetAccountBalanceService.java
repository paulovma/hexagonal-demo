package hexagonal.demo.account.application.service;

import hexagonal.demo.account.application.port.in.GetAccountBalanceQuery;
import hexagonal.demo.account.application.port.out.LoadAccountPort;
import hexagonal.demo.account.domain.Account;
import hexagonal.demo.account.domain.Money;
import org.springframework.beans.factory.annotation.Autowired;

import java.time.LocalDateTime;

public class GetAccountBalanceService implements GetAccountBalanceQuery {

    @Autowired
    private LoadAccountPort loadAccountPort;

    @Override
    public Money getAccountBalance(Account.AccountId accountId) {
        return loadAccountPort.loadAccount(accountId, LocalDateTime.now()).calculateBalance();
    }
}
