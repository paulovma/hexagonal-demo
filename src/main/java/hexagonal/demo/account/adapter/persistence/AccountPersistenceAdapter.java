package hexagonal.demo.account.adapter.persistence;

import hexagonal.demo.account.application.port.out.LoadAccountPort;
import hexagonal.demo.account.domain.Account;

import java.time.LocalDateTime;

class AccountPersistenceAdapter implements LoadAccountPort {

    @Override
    public Account loadAccount(Account.AccountId accountId, LocalDateTime time) {
        return null;
    }
}
