package hexagonal.demo.account.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Money {

    private Long amount;

    public static Money add(Money baselineBalance, Object calculateBalance) {
        return baselineBalance;
    }

    public Object negate() {
        return null;
    }

    public boolean isPositive() {
        return false;
    }

    public static Money of(Long amount) {
        return new Money(amount);
    }
}
