springmvc基础配置完整demo
===
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
       xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
       xmlns:context="http://www.springframework.org/schema/context"
       xmlns:mvc="http://www.springframework.org/schema/mvc"
       xsi:scheaLocation="http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd http://www.springframework.org/schema/mvc http://www.springframework.org/schema/mvc/spring-mvc.xsd">

## ·对于注解的handler可以单个配置，实际开发中建议组件扫描
    <context:component-scan base-package="com.**.controller"/>

## ·mvc注解驱动，代替注解映射器和适配器
    <mvc:annotation-driven/>

## ·视图解析器 -解析jsp视图，默认使用jstl标签
    <bean class="org.springframework.web.servlet.view.InternalResourceViewResolver">
        <!-- 配置jsp路径的前缀 -->
        <!--<property name="prefix" value="/"/>-->
        <property name="prefix" value="/WEB-INF/jsp/"/>
        <!-- 配置jsp路径的后缀 -->
        <property name="suffix" value=".jsp"/>
    </bean>

##  ·SpringMVC上传文件时，需要配置MultipartResolver处理器
    <bean id="multipartResolver" class="org.springframework.web.multipart.commons.CommonsMultipartResolver">
        <property name="defaultEncoding" value="UTF-8" />
        <!-- 指定所上传文件的总大小不能超过200KB。注意maxUploadSize属性的限制不是针对单个文件，而是所有文件的容量之和 -->
        <property name="maxUploadSize" value="200000"/>
        <!-- 指定上传文件的临时路径 -->
        <!-- <property name="uploadTempDir" value="uploadTempDirectory" /> -->
    </bean>
</beans>
