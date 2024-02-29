# 图书借阅管理系统

> 这是后端项目，对应的前端地址为:[TankingCao/vue3-vite](https://github.com/TankingCao/vue3-vite)

## 相关技术和环境

> 使用`SpringBoot+Mybatis/Mybatis-Plus`框架制作的一个简单的图书借阅管理系统

|   相关技术   |  版本   |
| :----------: | :-----: |
|  SpringBoot  |  3.0.9  |
|    Maven     |  3.9.5  |
| Mybatis-Plus | 3.5.3.1 |
|    MySQL     |  8.2.0  |
|    Redis     | 7.0.12  |

注意事项：

- 使用前先使用maven下载相关依赖，建议使用IDEA编译器，捆绑了maven，可以直接使用
- `mysql`是必要的
- 最近更新中因为使用`redis`二次校验token实现token主动过期，`redis`变成**必需项**!!!
- 在发行版的资源中有此项目对应的数据库结构的`sql`文件
- 注意前后端一般是同时修改的，必须匹配，没有特别需求（不想使用redis）直接使用最新的

## 快速使用

### 1.修改配置文件

路径：`src/main/resources/application.yml`

```yml
# 项目启动端口，默认8080，修改后前端中的请求地址也要对应修改
server:
  port: 8080

# mybatis-plus配置
mybatis-plus:
  configuration:
    map-underscore-to-camel-case: true # 下划线命名转驼峰
  type-aliases-package: com.clb.domain # 别名扫描包
  mapper-locations: classpath:mapper/*.xml # mapper文件扫描

spring:
  # mysql
  datasource:
    driver-class-name: com.mysql.cj.jdbc.Driver
    url: jdbc:mysql://localhost:3306/java_design?serverTimezone=Asia/Shanghai
    # 注意修改用户名和密码为你自己的
    username: root
    password: 123456
    type: com.alibaba.druid.pool.DruidDataSource

  # redis
  data:
    redis:
      # 修改host和密码为你的，如果没有密码则删除password项
      host: localhost
      password: 123456
      port: 6379
      database: 0
      timeout: 5000ms
  cache:
    type: redis  # 不使用redis将此项改为none
    redis:
      time-to-live: 3600000 # 缓存过期时间,单位ms(此处一小时)

  # 热重载排除advice文件
  devtools:
    restart:
      additional-exclude: com/clb/util/Advice.class
  # 支持控制台ansi颜色输出,乱码则禁止这项
  output:
    ansi:
      enabled: always
      
# 日志
logging:
  level:
    com.clb: debug
  pattern:
    dateformat: MM-dd HH:mm:ss.SSS

```

### 2.启动项目

使用编译器一键启动项目

## 项目目录结构

- `src/main/java/com/clb/`
  - `config`：配置文件
  - `constant`：枚举字段
  - `controller`：表现层
  - `domain`：实体类等
  - `exception`：异常类
  - `handle`：处理器类
  - `interceptor`：拦截器类
  - `mapper`：持久层
  - `service`：业务层
  - `util`：工具类
- `src/main/resources`
  - `mapper`：映射文件mapper
  - `application.yml`：配置文件
  - `banner.txt`：spring项目启动logo
- `src/test/`：测试类
- `pom.xml`：依赖管理

## 打包使用

> 将项目使用maven打成jar包后可以通过命令行执行jar包

```cmd
java -jar .\book-1.0.0.RELEASE.jar
```

> 可以修改端口号

```cmd
java -jar .\book-1.0.0.RELEASE.jar --server.port=8081
```

> 也可以关闭redis

```cmd
java -jar .\book-1.0.0.RELEASE.jar --server.port=8081 --spring.cache.type=none
```

