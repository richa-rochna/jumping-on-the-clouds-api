package com.jotc.api.utils;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class JOTCUtilsTest {

    @Test
    void test_jumpingOnTheClouds() {
        List<Integer> c = Arrays.asList(0, 0, 1, 0, 0, 1, 0);
        int j = JOTCUtils.jumpingOnTheClouds(c);
        assertEquals(4, j);
    }
}
