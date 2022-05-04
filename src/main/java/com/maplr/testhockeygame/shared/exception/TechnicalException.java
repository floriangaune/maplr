package com.maplr.testhockeygame.shared.exception;

import com.maplr.testhockeygame.shared.enumeration.ErrorCodeEnum;
import com.maplr.testhockeygame.shared.logger.MaplrLogger;

public class TechnicalException extends Exception {

    private ErrorCodeEnum error;
    private MaplrLogger logger = new MaplrLogger(TechnicalException.class);

    public TechnicalException(ErrorCodeEnum error, Object... data) {
        super(String.format(error.getUserMessage(), data));
        this.error = error;
        this.logger.logError(String.format(error.getTechnicalMessage(), data));
    }

    public TechnicalException(ErrorCodeEnum error, Throwable cause, Object... data) {
        super(String.format(error.getUserMessage(), data), cause);
        this.error = error;
        this.logger.logError(String.format(error.getTechnicalMessage(), data));
    }

}