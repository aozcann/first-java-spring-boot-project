package com.example.firstspringbootproject.model.request;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Getter
@Setter
public class CreateCustomerRequest {
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
}
