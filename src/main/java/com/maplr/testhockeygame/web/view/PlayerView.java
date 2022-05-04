package com.maplr.testhockeygame.web.view;

import com.maplr.testhockeygame.domain.Team;
import com.maplr.testhockeygame.domain.enumeration.PlayerPositionEnum;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class PlayerView extends MaplrView{

    private long number;
    private String name;
    private String lastName;
    private String position;
    private boolean isCaptain;
}
