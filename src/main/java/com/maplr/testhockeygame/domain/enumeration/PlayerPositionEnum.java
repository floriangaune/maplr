package com.maplr.testhockeygame.domain.enumeration;

import lombok.Getter;
import lombok.Setter;

@Getter
public enum PlayerPositionEnum {
    DEFENSEMAN("defenseman");

    private String label;

    private PlayerPositionEnum(String label) {
       this.label = label;
    }
}
