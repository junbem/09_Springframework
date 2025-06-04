package com.ohgiraffers.jpql.section01.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class SimpleJPQLRespositoryTest {

    @Autowired
    private SimpleJPQLRespository simpleJPQLRespository;

    @DisplayName("TypedQuery를 이용한 단일메뉴(단일행,단일컬럼) 조회 테스트")
    @Test
    public void testSelectSingleMenuByTypedQuery() {
        //given
        //when
        String menuName = simpleJPQLRespository.selectSingleMenuByTypedQuery();

        //then
        Assertions.assertEquals("한우딸기국밥", menuName);
    }

    @DisplayName("Query를 이용한 단일메뉴(단일행,단일컬럼) 조회 테스트")
    @Test
    public void testSelectSingleMenuByQuery() {
        //given
        //when
        Object menuName = simpleJPQLRespository.selectSingleMenuByQuery();

        //then
        Assertions.assertEquals("한우딸기국밥", menuName);
        Assertions.assertTrue(menuName instanceof String);
    }

    @DisplayName("TypedQuery를 이용한 단일행 조회 테스트")
    @Test
    public void testSelectSingleRowByTypedQuery() {
        //given
        //when
        Menu menu = simpleJPQLRespository.selectSingleRowByTypedQuery();

        //then
        Assertions.assertEquals(8, menu.getMenuCode());
    }

    @DisplayName("TypedQuery를 이용한 다중행 조회 테스트")
    @Test
    public void testSelectMultipleRowByTypedQuery() {
        //given
        //when
        List<Menu> menuList = simpleJPQLRespository.selectMultipleRowByTypedQuery();

        //then
        Assertions.assertNotNull(menuList);
        menuList.forEach(System.out::println);
    }

    @DisplayName("DISTINCT를 활용한 중복 제거 다중행 조회 테스트")
    @Test
    public void testSelectUsingDistinct() {
        //given
        //when
        List<Integer> categoryCodeList = simpleJPQLRespository.selectUsingDistinct();

        //then
        Assertions.assertNotNull(categoryCodeList);
        categoryCodeList.forEach(System.out::println);
    }

    @DisplayName("IN 연산자를 활용한 조회 테스트")
    @Test
    public void testSelectUsingIn() {
        //given
        //when
        List<Menu> menuList = simpleJPQLRespository.selectUsingIn();

        //then
        Assertions.assertNotNull(menuList);
        menuList.forEach(System.out::println);
    }

    @DisplayName("LIKE 연산자를 활용한 조회 테스트")
    @Test
    public void testSelectUsingLike() {
        //given
        //when
        List<Menu> menuList = simpleJPQLRespository.selectUsingLike();

        //then
        Assertions.assertNotNull(menuList);
        menuList.forEach(System.out::println);
    }
}