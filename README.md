# CampusHelp 校园互助平台

CampusHelp 是一个基于 **Spring MVC + MyBatis + JSP** 的校园互助任务平台示例项目。系统提供用户注册、登录、任务发布和任务分页浏览等基础能力，适合作为 Java Web 课程设计或 SSM 入门练习项目。

## 项目特性

- 用户注册与登录（学号/账号 + 密码）。
- 任务发布（标题、奖励、任务描述）。
- 任务中心列表展示（含发布者、发布时间、任务状态、奖励）。
- 任务列表分页浏览。
- 基于 MyBatis 的持久层映射。

## 技术栈

- Java 17
- Maven（WAR 打包）
- Spring Framework 6（含 Spring MVC）
- MyBatis 3 + MyBatis-Spring
- MySQL 8
- Druid 连接池
- JSP / JSTL
- Logback
- Lombok

## 目录结构

```text
src/main/java/njust
├── config          # Spring、MyBatis、数据源与 Web 配置
├── controller      # Web 控制器（用户、任务）
├── mapper          # Mapper 接口与 XML 映射
├── pojo            # 领域对象（User、Task）
├── service         # 业务层
└── utils           # 工具类（分页等）

src/main/resources
├── jdbc.properties # 数据库连接配置
└── logback.xml     # 日志配置

src/main/webapp
├── login.jsp       # 登录页
├── register.jsp    # 注册页
├── allTask.jsp     # 任务中心页
├── newTask.jsp     # 发布任务页
└── WEB-INF/web.xml # Web 应用基础配置
```

## 环境要求

1. JDK 17+
2. Maven 3.8+
3. MySQL 8.x
4. 可部署 WAR 的 Servlet 容器（如 Tomcat 10+）

## 快速开始

### 1）克隆并进入项目

```bash
git clone <your-repo-url>
cd CampusHelp
```

### 2）创建数据库并初始化表

项目默认连接数据库名为 `campushelp`。可先执行：

```sql
CREATE DATABASE IF NOT EXISTS campushelp DEFAULT CHARSET utf8mb4;
USE campushelp;

CREATE TABLE IF NOT EXISTS user (
  stu_id INT PRIMARY KEY AUTO_INCREMENT,
  stu_number VARCHAR(64) NOT NULL UNIQUE,
  password VARCHAR(128) NOT NULL,
  name VARCHAR(64) NOT NULL,
  money DOUBLE DEFAULT 0,
  state INT DEFAULT 0
);

CREATE TABLE IF NOT EXISTS task (
  task_id INT PRIMARY KEY AUTO_INCREMENT,
  taskname VARCHAR(128) NOT NULL,
  taskcontext TEXT,
  reward DOUBLE DEFAULT 0,
  publish_id VARCHAR(64),
  publish_name VARCHAR(64),
  accept_id INT,
  addtime DATETIME,
  endtime DATETIME,
  state INT DEFAULT 0
);
```

> 说明：以上建表 SQL 根据当前代码中的字段映射整理，便于本地快速跑通。

### 3）配置数据库连接

编辑 `src/main/resources/jdbc.properties`：

```properties
jdbc.user=root
jdbc.password=root
jdbc.url=jdbc:mysql://localhost:3306/campushelp
jdbc.driver=com.mysql.jdbc.Driver
```

若你使用 MySQL 8+，推荐将驱动类改为：

```properties
jdbc.driver=com.mysql.cj.jdbc.Driver
```

### 4）打包

```bash
mvn clean package
```

构建成功后会在 `target/` 目录生成 `campushelp-1.0-SNAPSHOT.war`。

### 5）部署并访问

将 WAR 部署到 Tomcat 后访问：

- 登录页：`/login.jsp`
- 注册页：`/register.jsp`
- 登录成功后会跳转到任务中心：`/allTask/5/1`

## 核心业务流程

1. 用户在 `register.jsp` 提交注册信息到 `/register`。
2. 用户在 `login.jsp` 提交登录信息到 `/login`。
3. 登录成功后跳转到 `/allTask/{pageSize}/{currentPage}`，控制器查询分页任务并放入 Session。
4. 用户在 `newTask.jsp` 提交任务到 `/newTask`，发布后重定向回任务中心首页。

## 已知注意事项

- 当前密码为明文存储，仅适用于学习示例，不建议用于生产环境。
- 项目中的 JDBC 驱动类默认是旧写法，建议改为 `com.mysql.cj.jdbc.Driver`。
- 页面层使用 JSP Scriptlet（`<% %>`）方式渲染，维护成本较高，可逐步迁移到 JSTL/EL 或前后端分离方案。

## 后续可优化方向

- 增加参数校验与统一异常处理。
- 增加登录拦截器与权限控制。
- 引入密码哈希（BCrypt）和安全认证方案。
- 补充任务接单、任务完成、评价等完整业务闭环。
- 增加单元测试与集成测试。

## 许可

当前仓库未声明开源许可证；如需开源，请补充 `LICENSE` 文件并明确许可类型。
