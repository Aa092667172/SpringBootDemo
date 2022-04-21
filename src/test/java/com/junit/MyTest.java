package com.junit;

import org.junit.jupiter.api.*;

public class MyTest {

    @BeforeEach
    public void beforeEach() {
        System.out.println("執行beforeEach");
    }

    @AfterEach
    public void AfterEach() {
        System.out.println("執行AfterEach");
    }

    /**
     * all較少用到 原因是 需為static
     * 無法與bean做設定
     */
    @BeforeAll
    public static void BeforeAll() {
        System.out.println("執行BeforeAll");
    }

    @AfterAll
    public static void AfterAll() {
        System.out.println("執行AfterAll");
    }

    @Test
    public void test1() {
        System.out.println("執行 test1");
    }

    @Test
    public void test2() {
        System.out.println("執行 test2");
    }
}
