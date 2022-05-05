package com.maplr.testhockeygame.web.view;

import lombok.Getter;
import lombok.Setter;

/**
 * Player represents a hokey player with its own data.
 */
@Getter
@Setter
public class PlayerView extends MaplrView{

    private long number;
    private String name;
    private String lastname;
    private String position;
    private boolean isCaptain;
}
