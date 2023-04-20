package com.jotc.api.utils;

import java.util.List;

public class JOTCUtils {

    public static int jumpingOnTheClouds(List<Integer> c) {
        int jumps = -1;
        int size = c.size();
        for (int i = 0; i < size; jumps++) {
            if (i + 2 < size && c.get(i + 2) == 0) {
                i += 2;
            } else {
                i++;
            }
        }
        return jumps;
    }
}
