package hexagonal.demo.account.application;

import hexagonal.demo.account.application.port.in.SendMoneyUseCase;
import hexagonal.demo.account.application.port.out.LoadAccountPort;
import hexagonal.demo.account.application.port.out.UpdateAccountStatePort;

class SendMoneyService implements SendMoneyUseCase {

    private LoadAccountPort loadAccountPort;

    private UpdateAccountStatePort updateAccountStatePort;
}
