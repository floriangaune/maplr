package com.maplr.testhockeygame.web.view;

import com.maplr.testhockeygame.domain.Team;
import com.maplr.testhockeygame.domain.enumeration.PlayerPositionEnum;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

@Getter
@Setter
public class PlayerView extends MaplrView{

    private long number;
    private String name;
    private String lastname;
    private String position;
    private boolean isCaptain;
}
