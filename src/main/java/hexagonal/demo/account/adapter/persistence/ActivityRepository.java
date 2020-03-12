package hexagonal.demo.account.adapter.persistence;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;

@Repository
public interface ActivityRepository extends JpaRepository<ActivityJpaEntity, Long> {

    @Query("select a from ActivityJpaEntity where a.ownerAccountId = :ownerAccountId and a.time >= :since")
    List<ActivityJpaEntity> findByOwnderSince(@Param("ownerAccountId") Long ownerAccountId, @Param("since")LocalDateTime since);

    @Query("select sum (a.amount) from ActivityJpaEntity a where a.targetAccountId = :accountId and a.ownerAccount = :accountId and a.time < :until")
    Long getDepositBalanceUntil(@Param("accountId")  Long accountId, @Param("until") LocalDateTime until);

    @Query("select sum(a.amount) from ActivityJpaEntity a where a.sourceAccountId = :accountId and a.ownerAccountId = :accountId and a.time < :until")
    Long getWithdrawalBalanceUntil(@Param("accountId") Long accountId, @Param("until") LocalDateTime until);
}
