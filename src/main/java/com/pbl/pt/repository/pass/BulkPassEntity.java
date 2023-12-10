package com.pbl.pt.repository.pass;

import com.pbl.pt.repository.userGroup.UserGroupEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "bulk_pass")
public class BulkPassEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // 기본 키 생성을 DB에 위임합니다. (AUTO_INCREMENT)
    private Integer bulkPassSeq;
    private Integer packageSeq;
    private Long bulkPassUserGroupId;

    @Enumerated(EnumType.STRING)
    private BulkPassStatus status;
    private Integer count;

    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bulkPassUserGroupId", insertable = false, updatable = false)
    private UserGroupEntity userGroupEntity;

    public void setEndedAt(Integer period) {
        if (period == null) {
            return;

        }
        this.endedAt = this.startedAt.plusDays(period);

    }

    public void setEndedAt(LocalDateTime endedAt) {
        this.endedAt = endedAt;

    }

}
