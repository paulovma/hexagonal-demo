package hexagonal.demo.account.adapter.in.web;

import hexagonal.demo.account.application.port.in.SendMoneyCommand;
import hexagonal.demo.account.application.port.in.SendMoneyUseCase;
import hexagonal.demo.account.domain.Account;
import hexagonal.demo.account.domain.Money;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class SendMoneyController {

    private final SendMoneyUseCase sendMoneyUseCase;

    @PostMapping(path = "/accounts/sendMoney/{sourceAccountId}/{targetAccountId}/{amount}")
    void sendMoney(
            @PathVariable("sourceAccountId") Long sourceAccountId,
            @PathVariable("targetAccountId") Long targetAccountId,
            @PathVariable("amount") Long amount
    ) {
        SendMoneyCommand sendMoneyCommand = SendMoneyCommand.builder()
                .sourceAccountId(new Account.AccountId(sourceAccountId))
                .targetAccountId(new Account.AccountId(targetAccountId))
                .money(Money.of(amount))
                .build();

        sendMoneyUseCase.sendMoney(sendMoneyCommand);
    }

}
