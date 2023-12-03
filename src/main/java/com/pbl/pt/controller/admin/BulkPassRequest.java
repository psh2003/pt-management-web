package com.pbl.pt.controller.admin;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.pbl.pt.util.LocalDateTimeUtils;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public class BulkPassRequest {
    private Integer packageSeq;
    private Long bulkPassUserGroupId;
    @NotNull(message = "시작일은 필수입니다.")
    private LocalDateTime startedAt;

    public void setStartedAt(String startedAtString) {
        this.startedAt = LocalDateTimeUtils.parse(startedAtString);

    }

}
