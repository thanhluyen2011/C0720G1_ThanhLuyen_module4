package com.codegym.model;

import lombok.*;

import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserModel {
    @Size(max = 45,min = 5,message = "firstName không đúng định dạng!")
    private String firstName;
    @Size(max = 45,min = 5,message = "lastName không đúng định dạng!")
    private String lastName;
    @Pattern(regexp = "(090|098)\\d{7}",message = "Phone không đúng định dạng!")
    private String phoneNumber;
    @Min(value = 18,message = "tuổi phải lớn hơn 18!")
    @Max(value = 50,message = "tuổi phải nhỏ hơn 50!")
    private String age;
    @Email(message = "email không đúng dịnh dạng")
    @NotEmpty(message = "email không đúng dịnh dạng")
    private String email;
}
