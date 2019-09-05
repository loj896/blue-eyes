### 一、项目启动报错
#### 1.Failed to start component / A child container failed during start
在父级项目pom文件中添加配置

`
<dependencyManagement>
     <dependencies>
         <dependency>
             <groupId>org.springframework.cloud</groupId>
             <artifactId>spring-cloud-dependencies</artifactId>
             <version>${spring.cloud.version}</version>
             <type>pom</type>
             <scope>import</scope>
         </dependency>
     </dependencies>
</dependencyManagement>`
#### 2、邮件服务客户端启动报错扫描不到映射文件
`org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'blogServiceImpl': Unsatisfied dependency expressed through field 'baseMapper'; nested exception is org.springframework.beans.factory.UnsatisfiedDependencyException: Error creating bean with name 'webBlogMapper' defined in file [D:\workSpace\myProjects\blue-eyes\service-common\target\classes\com\blue\eyes\mapper\blog\WebBlogMapper.class]: Unsatisfied dependency expressed through bean property 'sqlSessionFactory'; nested exception is org.springframework.beans.factory.BeanCreationException: Error creating bean with name 'sqlSessionFactory' defined in class path resource [com/baomidou/mybatisplus/autoconfigure/MybatisPlusAutoConfiguration.class]: Bean instantiation via factory method failed; nested exception is org.springframework.beans.BeanInstantiationException: Failed to instantiate [org.apache.ibatis.session.SqlSessionFactory]: Factory method 'sqlSessionFactory' threw exception; nested exception is java.lang.NoClassDefFoundError: org/mybatis/logging/LoggerFactory`

删除mybatis依赖配置，只保留mybatis-plus配置

#### 3、Root name 'timestamp' does not match expected


### 二