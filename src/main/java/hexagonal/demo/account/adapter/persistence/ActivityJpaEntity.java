package hexagonal.demo.account.adapter.persistence;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.LocalDateTime;

@NoArgsConstructor
@AllArgsConstructor
@Data
@Entity
@Table(name = "activity")
public class ActivityJpaEntity {

    @Id
    @GeneratedValue
    private Long id;

    private LocalDateTime time;

    private Long ownerAccountId;

    private Long sourceAccountId;

    private Long amount;
}
