package com.uyghurjavaj.wtsb3.dtos;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class UserDTO {

    private Long id;

    private String name;

    private String email;

    private String phoneNumber;

}
