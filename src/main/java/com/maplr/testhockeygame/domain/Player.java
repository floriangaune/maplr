package com.maplr.testhockeygame.domain;

import com.maplr.testhockeygame.domain.enumeration.PlayerPositionEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;

@Getter
@Setter
public class Player extends MaplrEntity {

    private long number;
    private String name;
    private String lastName;
    private Team team;

    @Enumerated(EnumType.STRING)
    private PlayerPositionEnum position;
    private boolean isCaptain;
}
