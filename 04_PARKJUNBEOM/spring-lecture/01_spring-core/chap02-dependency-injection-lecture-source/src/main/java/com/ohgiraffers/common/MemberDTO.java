package com.ohgiraffers.common;

import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor

public class MemberDTO {

    private int sequence;
    private String name;
    private String phone;
    private String email;
    private Account personalAccount;
}
