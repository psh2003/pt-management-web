package com.pbl.pt.service.pass;

import com.pbl.pt.repository.pass.BulkPassStatus;
import com.pbl.pt.repository.userGroup.UserGroupEntity;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class BulkPass {
    private Integer bulkPassSeq;
    private Long bulkPassUserGroupId;
    private Integer count;
    private UserGroupEntity userGroupEntity;
    private BulkPassStatus status;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;

}
