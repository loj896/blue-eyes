# blue-eyes
### 一、依赖包及对应版本
|序号|服务依赖|版本|备注|
| --- | --- | --- | --- |
|1|Spring Boot|2.1.7.RELEASE| |
|2|Spring Cloud|Greenwich.SR2| |
|3|Eureka Server|2.0.2.RELEASE| |
|4|Eureka Client|2.0.1.RELEASE| |
### 二、服务、模块
|序号|服务/模块名称|端口|说明|备注|
| --- | --- | --- | --- | --- |
|1|service-registry|6801|服务注册中心| |
|2|service-geteway|6802|服务网关| |
|3|service-health|6803|健康监控| |
|4|service-auth|6804|统一认证| |
|5|service-common|  |公共模块|数据库映射及公共组件、工具类|
|6|service-mail|6821|邮件服务| |
