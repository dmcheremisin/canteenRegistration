package com.syngenta.canteen.registration.exception;

import static org.apache.commons.lang3.ArrayUtils.isEmpty;

public class ApplicationRuntimeException extends RuntimeException {

    public ApplicationRuntimeException(String message, Object... args) {
        this(message, null, args);
    }

    public ApplicationRuntimeException(String message, Throwable cause,  Object... args) {
        super(getErrorMessage(message, args), cause);
    }

    private static String getErrorMessage(String message, Object... args) {
        return isEmpty(args) ? message : String.format(message, args);
    }
}
