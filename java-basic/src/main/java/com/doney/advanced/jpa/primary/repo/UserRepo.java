package com.doney.advanced.jpa.primary.repo;

import com.doney.advanced.jpa.primary.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository("UserRepo1")
public interface UserRepo extends JpaRepository<User,Long>, JpaSpecificationExecutor<User> {
}
