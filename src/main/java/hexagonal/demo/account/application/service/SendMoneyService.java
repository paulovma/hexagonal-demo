package hexagonal.demo.account.application.service;

import hexagonal.demo.account.application.port.in.SendMoneyCommand;
import hexagonal.demo.account.application.port.in.SendMoneyUseCase;
import hexagonal.demo.account.application.port.out.LoadAccountPort;
import hexagonal.demo.account.application.port.out.UpdateAccountStatePort;
import hexagonal.demo.account.domain.Account;
import lombok.RequiredArgsConstructor;
import org.springframework.transaction.annotation.Transactional;

@RequiredArgsConstructor
@Transactional
class SendMoneyService implements SendMoneyUseCase {

    private final LoadAccountPort loadAccountPort;

    private final UpdateAccountStatePort updateAccountStatePort;

    @Override
    public boolean sendMoney(SendMoneyCommand command) {
        requireAccountExists(command.getSourceAccountId());
        requireAccountExists(command.getTargetAccountId());
        return false;
    }

    private void requireAccountExists(Account.AccountId targetAccountId) {
     //throw exception if fails
    }


}
