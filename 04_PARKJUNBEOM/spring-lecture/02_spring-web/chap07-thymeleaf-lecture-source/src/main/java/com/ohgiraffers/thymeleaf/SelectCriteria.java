package com.ohgiraffers.thymeleaf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class SelectCriteria {

    private int startPage;
    private int endPage;
    private int pageNo;
}
