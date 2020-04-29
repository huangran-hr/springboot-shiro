package com.hr.springboot.config;

import com.hr.springboot.shiro.MyRealm;
import com.hr.springboot.shiro.filter.URLPathMatchingFilter;
import org.apache.shiro.authc.credential.HashedCredentialsMatcher;
import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.apache.shiro.spring.security.interceptor.AuthorizationAttributeSourceAdvisor;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.CookieRememberMeManager;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.apache.shiro.web.servlet.SimpleCookie;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.apache.shiro.mgt.SecurityManager;

import javax.servlet.Filter;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfiguration {
    @Bean
    public static LifecycleBeanPostProcessor getLifecycleBeanProcessor() {
        return new LifecycleBeanPostProcessor();
    }

    @Bean
    public ShiroFilterFactoryBean shiroFilter(SecurityManager securityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        shiroFilterFactoryBean.setSecurityManager(securityManager);

        Map<String, String > filterChainDefinitionMap = new LinkedHashMap<String, String>();
        Map<String, Filter> customizedFilter = new HashMap<>();

        // 设置自定义过滤器名称为 url
        customizedFilter.put("url", getURLPathMatchingFilter());

        // 对管理接口的访问启用自定义拦截（url 规则），即执行 URLPathMatchingFilter 中定义的过滤方法
        filterChainDefinitionMap.put("/api/admin/**", "url");
        // 启用自定义过滤器
        shiroFilterFactoryBean.setFilters(customizedFilter);
        //authc 即 autentication，是 shiro 自带的过滤器。除了它以外，常用的还有 anon（可匿名访问）、roles（需要角色）、perms（需要权限）等。
        filterChainDefinitionMap.put("/api/authentication", "authc"); //防前端鸡贼登录规则
        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterChainDefinitionMap);
        return shiroFilterFactoryBean;
    }

    public URLPathMatchingFilter getURLPathMatchingFilter() {
        return new URLPathMatchingFilter();
    }

    @Bean
    public SecurityManager securityManager() {
        DefaultWebSecurityManager securityManager = new DefaultWebSecurityManager();
        securityManager.setRealm(getMyRealm());
        return securityManager;
    }

    @Bean
    public MyRealm getMyRealm() {
        MyRealm myRealm = new MyRealm();
        myRealm.setCredentialsMatcher(hashedCredentialsMatcher());
        return myRealm;
    }

    @Bean
    public HashedCredentialsMatcher hashedCredentialsMatcher() {
        HashedCredentialsMatcher hashedCredentialsMatcher = new HashedCredentialsMatcher();
        hashedCredentialsMatcher.setHashAlgorithmName("md5");
        hashedCredentialsMatcher.setHashIterations(2); //这块和注册那块 设置 hash 算法迭代次数一致
        return hashedCredentialsMatcher;
    }

    @Bean
    public AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor(SecurityManager securityManager) {
        AuthorizationAttributeSourceAdvisor authorizationAttributeSourceAdvisor = new AuthorizationAttributeSourceAdvisor();
        authorizationAttributeSourceAdvisor.setSecurityManager(securityManager);
        return authorizationAttributeSourceAdvisor;
    }

    //为了启用 cookie rememberMe
    public CookieRememberMeManager rememberMeManager() {
        CookieRememberMeManager cookieRememberMeManager = new CookieRememberMeManager();
        cookieRememberMeManager.setCookie(rememberMeCookie());
        cookieRememberMeManager.setCipherKey("EVANNIGHTLY_WAOU".getBytes());
        return cookieRememberMeManager;
    }

    @Bean
    public SimpleCookie rememberMeCookie() {
        SimpleCookie simpleCookie = new SimpleCookie("rememberMe");
        simpleCookie.setMaxAge(259200); //存活时间
        return simpleCookie;
    }
}
