package com.syngenta.canteen.registration.exception;

public class SlotIsFullyBookedException extends ApplicationRuntimeException {

	public SlotIsFullyBookedException(String message, Object... args) {
		super(message, args);
	}

}