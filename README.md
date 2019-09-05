# blue-eyes
## 一、依赖包版本及项目模块说明
### 1、依赖包及对应版本
|序号|服务依赖|版本|备注|
| --- | --- | --- | --- |
|1|Spring Boot|2.1.7.RELEASE| |
|2|Spring Cloud|Greenwich.SR2| |
|3|Eureka Server|2.0.2.RELEASE| |
|4|Eureka Client|2.0.1.RELEASE| |
|5|spring-boot-admin|2.1.6| |
|6|spring-boot-starter-actuator|2.1.7.RELEASE|
### 2、服务、模块
|序号|服务/模块名称|端口|说明|备注|
| --- | --- | --- | --- | --- |
|1|service-registry|6801|服务注册中心| |
|2|service-geteway|6802|服务网关| |
|3|service-health|6803|健康监控| |
|4|service-auth|6804|统一认证| |
|5|service-common|  |公共模块|数据库映射及公共组件、工具类|
|6|service-mail|6821|邮件服务| |
|7|technical-demo|6831|技术使用示例| |
## 二、项目搭建过程
### 1、搭建父级项目 blue-eyes
### 2、搭建注册中心 service-registry
### 3、搭建健康检查服务 service-health
### 4、搭建公共模块 service-common
### 5、搭建邮件服务客户端 service-mail
