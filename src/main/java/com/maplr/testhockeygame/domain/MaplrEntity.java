package com.maplr.testhockeygame.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.*;

import java.time.Instant;

@Getter
@Setter
public class MaplrEntity {

    @Id
    protected long id;

    @CreatedBy
    protected String createdBy;

    @CreatedDate
    protected Instant createdDate;

    @LastModifiedBy
    protected String lastModifiedBy;

    @LastModifiedDate
    protected Instant lastModifiedDate;
}
