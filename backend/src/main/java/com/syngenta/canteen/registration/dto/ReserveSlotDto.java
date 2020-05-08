package com.syngenta.canteen.registration.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ReserveSlotDto {

    private Integer id;
    private String username;
    private Integer menuId;
    private Integer slotId;
}
