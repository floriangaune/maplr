package com.maplr.testhockeygame.domain;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.Instant;

/**
 * Is the base class for all entities used in the Maplr application.
 * Represents the core data for auditing events
 */
@Getter
@Setter
public class MaplrEntity {

    @CreatedBy
    protected String createdBy;

    @CreatedDate
    protected Instant createdDate;

    @LastModifiedBy
    protected String lastModifiedBy;

    @LastModifiedDate
    protected Instant lastModifiedDate;
}
