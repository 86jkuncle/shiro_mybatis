package com.example.demo;

import org.springframework.util.Base64Utils;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * @author Administrator
 * @date 2019/9/16 16:32
 */
public class KeyTest {
    public static void main(String[] args) {
        String key = "shiro_batis32";
        byte[] keyByte = key.getBytes(StandardCharsets.UTF_8);
        System.out.println(Base64Utils.encodeToString(Arrays.copyOf(keyByte, 16)));
    }
}
