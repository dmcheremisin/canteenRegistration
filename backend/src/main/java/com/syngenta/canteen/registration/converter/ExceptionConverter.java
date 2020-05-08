package com.syngenta.canteen.registration.converter;

import com.syngenta.canteen.registration.dto.ExceptionDto;
import com.syngenta.canteen.registration.exception.ApplicationRuntimeException;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class ExceptionConverter {

    public ExceptionDto applicationExceptionToExceptionDto(ApplicationRuntimeException e) {
        return ExceptionDto.builder()
                .description(e.getMessage())
                .stackTrace(getStackTrace(e.getStackTrace()))
                .build();
    }

    private List<String> getStackTrace(StackTraceElement... stackTraceElements) {
        return Arrays.stream(stackTraceElements)
                .map(s -> String.format("%s.%s(%s:%s)",
                        s.getClassName(), s.getMethodName(), s.getFileName(), s.getLineNumber()))
                .collect(Collectors.toList());
    }
}
