package com.maplr.testhockeygame.shared.logger;

import com.maplr.testhockeygame.shared.enumeration.LogTypeEnum;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MaplrLogger {

    private Logger logger;
    private static final int MAX_RANK = 3;
    private static final String TITLE_SPACE = "====";
    private static final String SPACE = "\t";

    public MaplrLogger(Class<?> classType) {
        this.logger = LoggerFactory.getLogger(classType);
    }


    /*  ===============================================
     *          Information log
     *  ===============================================
     */

    /**
     * Log information in title format
     * @param rank of title
     * @param message to log
     */
    public void logTitleInfo(int rank, String message) {
        this.log(LogTypeEnum.INFO, rank, true, message, null);
    }

    /**
     * Log information in title format
     * @param rank of title
     * @param message to log
     * @param throwable exception
     */
    public void logTitleInfo(int rank, String message ,Throwable throwable) {
        this.log(LogTypeEnum.INFO, rank, true, message, throwable);
    }

    /**
     * Log information
     * @param message to log
     */
    public void logInfo(String message) {
        this.log(LogTypeEnum.INFO, MAX_RANK, true, message, null);
    }

    /**
     * Log information
     * @param message to log
     * @param throwable exception
     */
    public void logInfo(String message ,Throwable throwable) {
        this.log(LogTypeEnum.INFO, MAX_RANK, true, message, throwable);
    }


    /*  ===============================================
     *          Warning log
     *  ===============================================
     */

    /**
     * Log warning in title format
     * @param rank of title
     * @param message to log
     */
    public void logTitleWarning(int rank, String message) {
        this.log(LogTypeEnum.WARNING, rank, true, message, null);
    }

    /**
     * Log warning in title format
     * @param rank of title
     * @param message to log
     * @param throwable exception
     */
    public void logTitleWarning(int rank, String message ,Throwable throwable) {
        this.log(LogTypeEnum.WARNING, rank, true, message, throwable);
    }

    /**
     * Log warning
     * @param message to log
     */
    public void logWarning(String message) {
        this.log(LogTypeEnum.WARNING, MAX_RANK, true, message, null);
    }

    /**
     * Log warning
     * @param message to log
     */
    public void logWarning(String message ,Throwable throwable) {
        this.log(LogTypeEnum.WARNING, MAX_RANK, true, message, throwable);
    }



    /*  ===============================================
     *          Error log
     *  ===============================================
     */

    /**
     * Log error in title format
     * @param rank of title
     * @param message to log
     */
    public void logTitleError(int rank, String message) {
        this.log(LogTypeEnum.ERROR, rank, true, message, null);
    }

    /**
     * Log error in title format
     * @param rank of title
     * @param message to log
     * @param throwable exception
     */
    public void logTitleError(int rank, String message ,Throwable throwable) {
        this.log(LogTypeEnum.ERROR, rank, true, message, throwable);
    }

    /**
     * Log error in title format
     * @param message to log
     */
    public void logError(String message) {
        this.log(LogTypeEnum.ERROR, MAX_RANK, true, message, null);
    }

    /**
     * Log error in title format
     * @param message to log
     */
    public void logError(String message ,Throwable throwable) {
        this.log(LogTypeEnum.ERROR, MAX_RANK, true, message, throwable);
    }


    /*  ===============================================
     *          General log
     *  ===============================================
     */

    /**
     * Log a message in given log type, in title format if isTitle
     * @param logType type of the log
     * @param rank of title
     * @param isTitle is a title
     * @param message to log
     * @param throwable exception
     */
    public void log(LogTypeEnum logType, int rank, boolean isTitle, String message, Throwable throwable) {

        rank = getCorrectRank(rank);

        StringBuilder messageToLog = new StringBuilder();

        addBeginSpaces(messageToLog, rank);
        addBeginSpacesOrTitleSeparation(messageToLog, rank, isTitle);
        messageToLog.append(" ").append(message).append(" ");

        if (isTitle) {
            addEndTitleSeparation(messageToLog, rank);
        }

        this.logMessage(logType, messageToLog.toString(), throwable);
    }

    /**
     * get the correct rank.
     * @param rank to verify
     * @return the given rank if it's lesser then MAX_RANK, MAX_RANK otherwise
     */
    private static int getCorrectRank(int rank) {
        if (rank > MAX_RANK) {
            return MAX_RANK;
        } else {
            return rank;
        }
    }

    /**
     * Add begin spaces in the message
     * @param message to log
     * @param rank of message
     */
    private static void addBeginSpaces(StringBuilder message, int rank) {

        // On ajoute des espaces pour les rangs supérieur à 1
        for (int i=0; i<rank-1; i++) {
            message.append(TITLE_SPACE);
        }
    }

    /**
     * Add begin spaces or separation title
     * @param message to log
     * @param rank of message
     * @param isTitle is is a title
     */
    private static void addBeginSpacesOrTitleSeparation(StringBuilder message, int rank, boolean isTitle) {
        for (int i=MAX_RANK; i>rank-1; i--) {
            message.append((isTitle) ? TITLE_SPACE : SPACE);
        }
    }

    /**
     * Add end separation for title
     * @param message to log
     * @param rank of message
     */
    private static void addEndTitleSeparation(StringBuilder message, int rank) {
        for (int i=MAX_RANK; i>rank-1; i--) {
            message.append(TITLE_SPACE);
        }
    }

    /**
     * Log the given message in the given log type with the given throwable
     * @param logType the type of log
     * @param message to log
     * @param throwable exception
     */
    private void logMessage(LogTypeEnum logType, String message, Throwable throwable) {

        switch (logType) {
            case INFO:
                if (throwable == null) {
                    this.logger.info(message);
                } else {
                    this.logger.info(message, throwable);
                }
                break;
            case WARNING:
                if (throwable == null) {
                    this.logger.warn(message);
                } else {
                    this.logger.warn(message, throwable);
                }
                break;
            case ERROR:
                if (throwable == null) {
                    this.logger.error(message);
                } else {
                    this.logger.error(message, throwable);
                }
                break;
        }
    }


}