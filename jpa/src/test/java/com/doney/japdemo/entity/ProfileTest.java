package com.doney.japdemo.entity;

import org.junit.Test;

import java.util.HashMap;

public class ProfileTest {

    @Test
    public void testProfile(){
        Profile profile = new Profile();
        profile.setMap(new HashMap());
        profile.setId(1L);
        System.out.println(profile);
    }

}