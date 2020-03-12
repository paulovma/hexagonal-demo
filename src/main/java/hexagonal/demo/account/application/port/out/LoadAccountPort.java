package hexagonal.demo.account.application.port.out;

import hexagonal.demo.account.domain.Account;

import java.time.LocalDateTime;

public interface LoadAccountPort {

    Account loadAccount(Account.AccountId accountId, LocalDateTime time);
}
