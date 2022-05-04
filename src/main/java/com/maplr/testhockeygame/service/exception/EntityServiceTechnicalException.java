package com.maplr.testhockeygame.service.exception;

import com.maplr.testhockeygame.shared.enumeration.ErrorCodeEnum;
import com.maplr.testhockeygame.shared.exception.TechnicalException;

public class EntityServiceTechnicalException extends TechnicalException {
    public EntityServiceTechnicalException(ErrorCodeEnum error) {
        super(error);
    }

    public EntityServiceTechnicalException(ErrorCodeEnum error, Throwable cause) {
        super(error, cause);
    }
}
