package com.ohgiraffers.nativequery.section01.simple;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class NativeQueryRepositoryTest {

    @Autowired
    private NativeQueryRepository nativeQueryRepository;

    @DisplayName("결과 타입을 정의한 Native Query 테스트")
    @Test
    void testNativeQueryByResultType() {

        int menuCode = 15;
        Menu foundMenu = nativeQueryRepository.nativeQueryByResultType(menuCode);
        assertNotNull(foundMenu);
        System.out.println("foundMenu = " + foundMenu);
    }

    @DisplayName("결과 타입을 정의하지 않은 Native Query 테스트")
    @Test
    public void testNativeQueryByNoResultType() {
        //given
        //when
        List<Object[]> menuList
                = nativeQueryRepository.nativeQueryByNoResultType();
        //then
        assertNotNull(menuList);
        menuList.forEach(
                row -> {
                    for(Object col : row) {
                        System.out.print(col + " ");
                    }
                    System.out.println();
                }
        );
    }

    @DisplayName("자동 결과 매핑을 사용한 Native Query 조회 테스트")
    @Test
    public void testNativeQueryByAutoMapping() {
        //given
        //when
        List<Object[]> categoryList
                = nativeQueryRepository.nativeQueryByAutoMapping();

        //then
        Assertions.assertNotNull(categoryList);
        categoryList.forEach(
                row -> {
                    for(Object col : row) {
                        System.out.print(col + "/");
                    }
                    System.out.println();
                }
        );
    }

    @DisplayName("수동 결과 매핑을 사용한 Native Query 조회 테스트")
    @Test
    public void testNativeQueryByManualMapping() {
        //given
        //when
        List<Object[]> categoryList
                = nativeQueryRepository.nativeQueryByManualMapping();

        //then
        Assertions.assertNotNull(categoryList);
        categoryList.forEach(
                row -> {
                    for(Object col : row) {
                        System.out.print(col + "/");
                    }
                    System.out.println();
                }
        );
    }
}