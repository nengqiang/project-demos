-- auto-generated definition
CREATE TABLE s_user
(
  id               INT AUTO_INCREMENT
  COMMENT '主键，用户id'
    PRIMARY KEY,
  user_name        VARCHAR(50)                         NOT NULL
  COMMENT '用户名',
  password         VARCHAR(128)                        NOT NULL
  COMMENT '密码md5',
  create_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
  COMMENT '创建时间',
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP
  COMMENT '最后更新时间',
  CONSTRAINT uk_uname
  UNIQUE (user_name)
)
  COMMENT 'springboot 集成 shiro 用user表';

# ----------------------------------------------------------------------------------------------------------------------

-- auto-generated definition
CREATE TABLE s_role
(
  id               INT AUTO_INCREMENT
  COMMENT '主键,角色id'
    PRIMARY KEY,
  role_name        VARCHAR(50)                         NOT NULL
  COMMENT '角色名',
  user_id          INT                                 NOT NULL
  COMMENT '用户id',
  create_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
  COMMENT '创建时间',
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP
  COMMENT '最后更新时间',
  CONSTRAINT fk_role_user
  FOREIGN KEY (user_id) REFERENCES s_user (id)
)
  COMMENT 'springboot 集成 shiro 用role表';
CREATE INDEX fk_role_user
  ON s_role (user_id);

# ----------------------------------------------------------------------------------------------------------------------

-- auto-generated definition
CREATE TABLE s_permission
(
  id               INT AUTO_INCREMENT
  COMMENT '主键，权限id'
    PRIMARY KEY,
  permission       VARCHAR(128)                        NOT NULL
  COMMENT '操作权限',
  role_id          INT                                 NOT NULL
  COMMENT '角色id',
  create_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
  COMMENT '创建时间',
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP
  COMMENT '最后更新时间',
  CONSTRAINT fk_permission_role
  FOREIGN KEY (role_id) REFERENCES s_role (id)
)
  COMMENT 'springboot 集成 shiro 用permission表';
CREATE INDEX fk_permission_role
  ON s_permission (role_id);

# ----------------------------------------------------------------------------------------------------------------------

-- auto-generated definition
CREATE TABLE third_tool_link
(
  id               INT AUTO_INCREMENT
  COMMENT '主键，三方工具链接id'
    PRIMARY KEY,
  tool_name        VARCHAR(128)                        NOT NULL
  COMMENT '工具名称',
  type             TINYINT DEFAULT '1'                 NULL
  COMMENT '工具类型，1-生活常用，2-教育学习，3-办公辅助，4-图片视频，5-网络工具，6-程序开发',
  link             VARCHAR(255)                        NOT NULL
  COMMENT '三方工具链接地址',
  spare            VARCHAR(50)                         NULL
  COMMENT '备用字段',
  create_date      TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL
  COMMENT '创建时间',
  last_update_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP NOT NULL ON UPDATE CURRENT_TIMESTAMP
  COMMENT '最后更新时间'
)
  COMMENT '三方工具及其链接地址表';
CREATE INDEX idx_tName
  ON third_tool_link (tool_name);
