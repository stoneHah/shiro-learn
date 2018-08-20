package com.stone.learn.shirolearn;

import com.stone.learn.shirolearn.entity.SysPermission;
import com.stone.learn.shirolearn.entity.SysRole;
import com.stone.learn.shirolearn.entity.SysUser;
import com.stone.learn.shirolearn.service.PermissionService;
import com.stone.learn.shirolearn.service.RoleService;
import com.stone.learn.shirolearn.service.UserService;
import com.stone.learn.shirolearn.service.impl.PermissionServiceImpl;
import com.stone.learn.shirolearn.service.impl.RoleServiceImpl;
import com.stone.learn.shirolearn.service.impl.UserServiceImpl;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.apache.shiro.util.ThreadContext;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * <p>User: Zhang Kaitao
 * <p>Date: 14-1-28
 * <p>Version: 1.0
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public abstract class BaseTest {

    protected PermissionService permissionService = new PermissionServiceImpl();
    protected RoleService roleService = new RoleServiceImpl();
    protected UserService userService = new UserServiceImpl();

    protected String password = "123";

    protected SysPermission p1;
    protected SysPermission p2;
    protected SysPermission p3;
    protected SysRole r1;
    protected SysRole r2;
    protected SysUser u1;
    protected SysUser u2;
    protected SysUser u3;
    protected SysUser u4;

    @Before
    public void setUp() {
        /*JdbcTemplateUtils.jdbcTemplate().update("delete from sys_users");
        JdbcTemplateUtils.jdbcTemplate().update("delete from sys_roles");
        JdbcTemplateUtils.jdbcTemplate().update("delete from sys_permissions");
        JdbcTemplateUtils.jdbcTemplate().update("delete from sys_users_roles");
        JdbcTemplateUtils.jdbcTemplate().update("delete from sys_roles_permissions");*/


        //1、新增权限
        p1 = new SysPermission("user:create", "用户模块新增", Boolean.TRUE);
        p2 = new SysPermission("user:update", "用户模块修改", Boolean.TRUE);
        p3 = new SysPermission("menu:create", "菜单模块新增", Boolean.TRUE);
        permissionService.createPermission(p1);
        permissionService.createPermission(p2);
        permissionService.createPermission(p3);
        //2、新增角色
        r1 = new SysRole("admin", "管理员", Boolean.TRUE);
        r2 = new SysRole("user", "用户管理员", Boolean.TRUE);
        roleService.createRole(r1);
        roleService.createRole(r2);
        //3、关联角色-权限
        roleService.correlationPermissions(r1.getId(), p1.getId());
        roleService.correlationPermissions(r1.getId(), p2.getId());
        roleService.correlationPermissions(r1.getId(), p3.getId());

        roleService.correlationPermissions(r2.getId(), p1.getId());
        roleService.correlationPermissions(r2.getId(), p2.getId());

        //4、新增用户
        u1 = new SysUser("zhang", password);
        u2 = new SysUser("li", password);
        u3 = new SysUser("wu", password);
        u4 = new SysUser("wang", password);
        u4.setLocked(Boolean.TRUE);
        userService.createUser(u1);
        userService.createUser(u2);
        userService.createUser(u3);
        userService.createUser(u4);
        //5、关联用户-角色
        userService.correlationRoles(u1.getId(), r1.getId());

    }




    @After
    public void tearDown() throws Exception {
        ThreadContext.unbindSubject();//退出时请解除绑定Subject到线程 否则对下次测试造成影响
    }

    protected void login(String configFile, String username, String password) {
        //1、获取SecurityManager工厂，此处使用Ini配置文件初始化SecurityManager
        Factory<SecurityManager> factory =
                new IniSecurityManagerFactory(configFile);

        //2、得到SecurityManager实例 并绑定给SecurityUtils
        org.apache.shiro.mgt.SecurityManager securityManager = factory.getInstance();
        SecurityUtils.setSecurityManager(securityManager);

        //3、得到Subject及创建用户名/密码身份验证Token（即用户身份/凭证）
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        subject.login(token);
    }

    public Subject subject() {
        return SecurityUtils.getSubject();
    }

}
