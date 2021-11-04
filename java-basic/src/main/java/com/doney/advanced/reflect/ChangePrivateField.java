package com.doney.advanced.reflect;

import java.lang.reflect.Field;

/**
 * 通过反射改变对象的私有字段
 */
public class ChangePrivateField {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        changPrivateField();
    }

    /**
     * 改变对象private私有字段的值
     */
    private static void changPrivateField() throws NoSuchFieldException, IllegalAccessException {
        Dto pp = new Dto("123");
        Field id = pp.getClass().getDeclaredField("id");
        id.setAccessible(true);
        id.set(pp,"asd");
        System.out.println(pp.getId());
    }
}

class Dto {
    private String id;

    public Dto(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
