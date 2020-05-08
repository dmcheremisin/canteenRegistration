package com.syngenta.canteen.registration.exception;

import com.syngenta.canteen.registration.converter.ExceptionConverter;
import com.syngenta.canteen.registration.dto.ExceptionDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RequiredArgsConstructor
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

    private final ExceptionConverter exceptionConverter;

    @ExceptionHandler(SlotIsFullyBookedException.class)
    public ResponseEntity<ExceptionDto> handleAuthenticationException(SlotIsFullyBookedException e) {
        ExceptionDto exceptionDto = exceptionConverter.applicationExceptionToExceptionDto(e);
        return new ResponseEntity<>(exceptionDto, HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    public ResponseEntity<ExceptionDto> handleNotFoundException(EntityNotFoundException e) {
        ExceptionDto exceptionDto = exceptionConverter.applicationExceptionToExceptionDto(e);
        return new ResponseEntity<>(exceptionDto, HttpStatus.NOT_FOUND);
    }

}
