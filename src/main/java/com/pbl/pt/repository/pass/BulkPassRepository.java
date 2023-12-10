package com.pbl.pt.repository.pass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BulkPassRepository extends JpaRepository<BulkPassEntity, Integer> {

    @Query(value = "select b, a from BulkPassEntity b " +
            "left join UserGroupEntity a on a.userGroupId = b.bulkPassUserGroupId " +
            "order by b.startedAt desc")
    List<BulkPassEntity> findAllOrderByStartedAtDesc();
}
