package com.stone.learn.shirolearn.repository;

import com.stone.learn.shirolearn.entity.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserRepository extends JpaRepository<SysUser,Long>,JpaSpecificationExecutor<SysUser> {

    SysUser findByUsername(String username);
}
