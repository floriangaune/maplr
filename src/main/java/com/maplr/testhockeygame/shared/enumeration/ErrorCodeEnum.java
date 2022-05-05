package com.maplr.testhockeygame.shared.enumeration;

import org.springframework.util.ObjectUtils;

public enum ErrorCodeEnum {

    /* ======================================
     *          Service
     * ===================================
     */

    SERV_E_1(null, "No data found for given ID %s"),
    ENUM_PP_1(null, "No entry in the enum found for label %s")
    ;


    private String userMessage;
    private String technicalMessage;

    ErrorCodeEnum(String userMessage, String technicalMessage) {
        this.userMessage = userMessage;
        this.technicalMessage = technicalMessage;
    }

    public String getUserMessage() {
        if (ObjectUtils.isEmpty(this.userMessage)) {
            return this.name() + " - Une erreur est survenue";
        } else {
            return this.userMessage;
        }
    }

    public String getTechnicalMessage() {
        return technicalMessage;
    }
}