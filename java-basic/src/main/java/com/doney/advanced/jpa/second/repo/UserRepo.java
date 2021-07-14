package com.doney.advanced.jpa.second.repo;

import com.doney.advanced.jpa.second.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository("UserRepo2")
public interface UserRepo extends JpaRepository<User,Long> {
}
