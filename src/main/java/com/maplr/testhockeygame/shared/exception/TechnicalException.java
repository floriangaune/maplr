package com.maplr.testhockeygame.shared.exception;

import com.maplr.testhockeygame.shared.enumeration.ErrorCodeEnum;
import com.maplr.testhockeygame.shared.logger.MaplrLogger;

public class TechnicalException extends Exception {

    private ErrorCodeEnum error;
    private Object[] data;


    public TechnicalException(ErrorCodeEnum error, Object... data) {
        super(String.format(error.getUserMessage(), data));
        // Store data in case of logging
        this.error = error;
        this.data = data;
    }

    public TechnicalException(ErrorCodeEnum error, Throwable cause, Object... data) {
        super(String.format(error.getUserMessage(), data), cause);
        // Store data in case of logging
        this.error = error;
        this.data = data;
    }

    public void logIt(MaplrLogger logger) {
        logger.logError(String.format(this.error.getTechnicalMessage(), this.data));
    }

}