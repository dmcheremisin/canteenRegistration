package com.syngenta.canteen.registration.dto;

import lombok.*;

import java.util.List;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ExceptionDto {

    private String description;
    private List<String> stackTrace;

}
