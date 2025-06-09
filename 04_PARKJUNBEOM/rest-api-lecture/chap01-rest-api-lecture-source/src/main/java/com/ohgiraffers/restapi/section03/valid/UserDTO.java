package com.ohgiraffers.restapi.section03.valid;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class UserDTO {

    private int no;

    @NotNull(message = "아이디는 반드시 입력되어야 합니다.")
    @NotBlank(message = "아이디는 공백 안됨!")
    private String id;
    @Length(max=10, message = "비밀번호 길이는 최대 10")
    private String pwd;
    @Size(min=2, message = "이름은 두 글자 이상")
    private String name;
}
