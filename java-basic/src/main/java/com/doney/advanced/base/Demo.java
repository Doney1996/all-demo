package com.doney.advanced.base;

import java.lang.reflect.Field;

/**
 * Java 基础测试
 */
public class Demo {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        changPrivateField();
    }

    /**
     * 改变对象private私有字段的值
     */
    private static void changPrivateField() throws NoSuchFieldException, IllegalAccessException {
        DemoDTO demoDTO = new DemoDTO("123");
        Field id = demoDTO.getClass().getDeclaredField("id");
        id.setAccessible(true);
        id.set(demoDTO,"asd");
        System.out.println(demoDTO.getId());
    }
}
