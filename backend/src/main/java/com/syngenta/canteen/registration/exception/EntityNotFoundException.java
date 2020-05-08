package com.syngenta.canteen.registration.exception;

public class EntityNotFoundException extends ApplicationRuntimeException {

    public EntityNotFoundException(String message, Object... args) {
        super(message, args);
    }
}
