package com.ohgiraffers.jpql.section06.join;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.util.List;

@Entity(name = "Section06Category")
@Table(name = "tbl_category")
public class Category {
    @Id
    private int categoryCode;
    private String categoryName;
    private Integer refCategoryCode;
    @OneToMany(mappedBy = "category") // 주인(fk를 관리하는 테이블)이 Menu이므로
    private List<Menu> menuList;
}
