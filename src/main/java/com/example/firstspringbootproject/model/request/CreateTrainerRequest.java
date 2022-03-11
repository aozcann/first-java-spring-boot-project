package com.example.firstspringbootproject.model.request;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@Getter
@Setter
@NoArgsConstructor
public class CreateTrainerRequest {
    private String name;
    private String surname;
    private String email;
    private String phoneNumber;
    private String branch;
}
