package com.ohgiraffers.mapping.section01.entity;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.time.LocalDateTime;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class MemberRegistServiceTest {

    @Autowired
    private MemberRegistService memberRegistService;

    private static Stream<Arguments> getMember() {
        private static Stream<Arguments> getMember() {
            return Stream.of(
                    Arguments.of(
                            "user01",
                            "pass01",
                            "홍길동",
                            "010-1234-5678",
                            "서울시 동작구",
                            LocalDateTime.now(),
                            "ROLE_ADMIN",
                            "Y"
                    ),
                    Arguments.of(
                            "user02",
                            "pass02",
                            "유관순",
                            "010-1234-4444",
                            "서울시 동작구",
                            LocalDateTime.now(),
                            "ROLE_USER",
                            "Y"
                    )
            );
        }

        @DisplayName("테이블 생성 테스트")
        @ParameterizedTest
        @MethodSource("getMember")
        void
    }

}