package com.stone.learn.shirolearn.repository;

import com.stone.learn.shirolearn.entity.SysRolesPermission;
import com.stone.learn.shirolearn.entity.SysUsersRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RolePermissionRepository extends JpaRepository<SysRolesPermission,Long>{
}
