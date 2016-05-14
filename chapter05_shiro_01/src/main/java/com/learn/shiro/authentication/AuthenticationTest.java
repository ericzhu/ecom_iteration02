package com.learn.shiro.authentication;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.config.IniSecurityManagerFactory;
import org.apache.shiro.mgt.SecurityManager;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.util.Factory;
import org.junit.Test;

public class AuthenticationTest {

   @Test
   public void testLogin() {
      Factory<SecurityManager> factory = new IniSecurityManagerFactory("classpath:shiro.ini");
      SecurityManager securityManager = factory.getInstance();
      SecurityUtils.setSecurityManager(securityManager);

      Subject subject = SecurityUtils.getSubject();
      UsernamePasswordToken token = new UsernamePasswordToken("eric", "123456");

      subject.login(token);
      System.out.println(subject.isAuthenticated());

      subject.logout();
      System.out.println(subject.isAuthenticated());
   }
}