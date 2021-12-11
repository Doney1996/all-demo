package com.doney.japdemo.entity;


import javax.persistence.PostLoad;
import javax.persistence.PostUpdate;
import javax.persistence.PrePersist;
import java.util.Date;

public class CreatedTimePersistentListener{

  private  final static ThreadLocal<String> tl = new ThreadLocal<String>();

  @PrePersist
  protected void onCreate(Object object) {
    try {
      User user = (User) object;
      user.setCreate_time(new Date());
      System.out.println(user);
    }catch (Exception e){
      e.printStackTrace();
    }
  }

  @PostUpdate
  protected void postUpdate(Object newUser) {
    try {
      User user = (User) newUser;
      String name = tl.get();

        System.out.println("odl = " + name);
        System.out.println("new = " + user.getName());

    }catch (Exception e){
      e.printStackTrace();
    }
  }


  @PostLoad
  protected void postLoad(Object oldUser) {
    try {
      User user = (User) oldUser;
      String name = user.getName();
      tl.set(name);
    }catch (Exception e){
      e.printStackTrace();
    }
  }




}