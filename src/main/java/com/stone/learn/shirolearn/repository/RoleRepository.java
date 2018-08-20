package com.stone.learn.shirolearn.repository;

import com.stone.learn.shirolearn.entity.SysRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoleRepository extends JpaRepository<SysRole,Long> {
}
