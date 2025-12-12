package com.main.maincontroller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@Setter
@Getter
@NoArgsConstructor
public class NewUserAndLoginDetails {
    @NotBlank
    @Size(min = 1, max = 20)
    private User user;

    @NotBlank
    @Size(min = 1, max = 20)
    private LoginDetails details;
}
