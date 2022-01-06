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

    @Test
    public void testE(){
        InnerClass innerClass = new InnerClass();
        innerClass.setName("SS");
        innerClass.setStatus(Status.ACTIVE);
        Status status = innerClass.getStatus();
        innerClass.setStatus(Status.SUSPENDED);
        System.out.println(status == innerClass.getStatus());
    }

    @Test
    public void test2(){
        Object o = new Object();
        setNull(o);
        System.out.println(o);
    }
    private void setNull(Object o){
        System.out.println(o);
        o = null;
        System.out.println(o);
    }

    public enum Status {
        NEW, // initial state of account
        INACTIVE, // intermediate state. Depends if activation is required. If no
        // need activation, from NEW go to ACTIVE
        ACTIVE, // state that funds form the account can be used
        BLOCKED, // when black listed
        CLOSED, // BY: change from DEACTIVATED because TnG wants to be consistent with Vector.
        // activity on the account
        SUSPENDED
    }
    private class InnerClass{
        private String name;
        private Status status;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Status getStatus() {
            return status;
        }

        public void setStatus(Status status) {
            this.status = status;
        }
    }
}

