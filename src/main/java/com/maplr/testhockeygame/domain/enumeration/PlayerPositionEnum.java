package com.maplr.testhockeygame.domain.enumeration;

import com.maplr.testhockeygame.shared.enumeration.ErrorCodeEnum;
import com.maplr.testhockeygame.shared.exception.TechnicalException;
import lombok.Getter;

/**
 * Enumeration representing the player position.
 * Contains a label to user reading
 */
@Getter
public enum PlayerPositionEnum {
    DEFENSEMAN("defenseman"),
    FOREWARD("forward");

    private String label;

    PlayerPositionEnum(String label) {
       this.label = label;
    }

    /**
     * Find the player position related to the given label.
     * If the given label has no match, then throws an exception
     * @param label : The label to search
     * @return the Player position related to the searched label
     * @throws TechnicalException in case of no match found
     */
    public static PlayerPositionEnum findByLabel(String label) throws TechnicalException {

        // Iterate throw all tghe enumeration to find the matched one
        for (PlayerPositionEnum position : PlayerPositionEnum.values()) {
            if (position.getLabel().equals(label)) {
                return position;
            }
        }

        throw new TechnicalException(ErrorCodeEnum.ENUM_PP_1, label);
    }
}
