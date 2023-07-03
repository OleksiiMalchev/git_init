package com.security.security.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UserReqDTO {
    @NotNull
    @NotEmpty
    private String userName;
    @NotNull
    @NotEmpty
    @Size(min = 6, max = 12)
    private String password;
    @NotNull
    @NotEmpty
    @Email(regexp = "^[A-Za-z0-9][A-Za-z0-9\\.\\-_]*[A-Za-z0-9]*@([A-Za-z0-9]+([A-Za-z0-9-]*[A-Za-z0-9]+)*\\.)+[A-Za-z]*$")
    private String email;
}
