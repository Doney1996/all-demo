package com.doney.advanced.controller;

import com.doney.advanced.jpa.primary.User;
import com.doney.advanced.jpa.primary.repo.UserRepo;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Controller;

import java.util.ArrayList;
import java.util.List;

@Controller
public class UserController implements InitializingBean {
    @Autowired
    UserRepo userRepo;


    @Override
    public void afterPropertiesSet() throws Exception {
        List<User> userList = userRepo.findAll();
//        userList.forEach(System.out::println);

        List<String> list = new ArrayList<>();
        list.add("刘备");
        list.add("诸葛亮");


        Specification<User> userSpecification = (root, query, builder) -> {
            query.where(
//                builder.equal(root.get("nickName"), "刘备")
//                builder.equal(root.get("nickName"), "SUCCESS"),
//                builder.between(root.get("nickName"), "aaa", "bbb"),
                builder.and(root.get("nickName").in(list))
            ).getRestriction();

            return query.getRestriction();
        };

        Page<User> all = userRepo.findAll(userSpecification, PageRequest.of(0, 20));
        all.forEach(System.out::println);

        System.out.println(all);


    }
}
