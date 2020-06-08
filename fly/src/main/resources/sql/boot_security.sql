-- auto-generated definition
create table sys_user
(
    id           bigint auto_increment comment '主键'
        primary key,
    user_no      bigint                                                  not null comment '用户编号',
    username     varchar(50)                                             not null comment '用户名',
    password     varchar(60)                                             not null comment '密码',
    nickname     varchar(255)                          default ''        null comment '昵称',
    head_img_url varchar(255)                          default ''        null comment '头像链接',
    phone        varchar(11)                           default ''        null comment '手机号码',
    email        varchar(50)                           default ''        null comment '邮箱',
    birthday     date                                                    null comment '生日',
    sex          varchar(1)                                              null comment '性别：男，女',
    status       enum ('ENABLED', 'DISABLE', 'LOCKED') default 'ENABLED' null comment '状态：ENABLED, DISABLE, LOCKED',
    create_time  datetime                                                not null comment '创建时间',
    update_time  datetime                                                not null comment '修改时间',
    constraint u_name
        unique (username)
)
    comment '用户信息表' charset = utf8mb4;

create index idx_name
    on sys_user (username);

create index idx_no
    on sys_user (user_no);


-- auto-generated definition
create table sys_role
(
    id          bigint auto_increment comment '主键'
        primary key,
    role_name   varchar(50)             not null comment '角色名称',
    description varchar(100) default '' null comment '角色描述',
    create_time datetime                not null comment '创建时间',
    update_time datetime                not null comment '修改时间',
    constraint u_name
        unique (role_name)
)
    comment '用户角色表' charset = utf8mb4;

create index idx_name
    on sys_role (role_name);


-- auto-generated definition
create table sys_user_role
(
    id          bigint auto_increment comment '主键'
        primary key,
    user_no     bigint   not null comment '用户编号',
    role_id     bigint   not null comment '角色id',
    create_time datetime not null comment '创建时间',
    update_time datetime not null comment '修改时间'
)
    comment '用户角色表' charset = utf8mb4;

create index idx_user_role
    on sys_user_role (user_no, role_id);


-- auto-generated definition
create table sys_permission
(
    id              bigint auto_increment comment '主键'
        primary key,
    parent_id       bigint                 not null comment '父级id',
    menu_name       varchar(50)            not null comment '菜单名称',
    type            tinyint                not null comment '权限类别',
    permission_name varchar(50) default '' null comment '权限名称',
    sort            int                    not null comment '排序',
    create_time     datetime               not null comment '创建时间',
    update_time     datetime               not null comment '修改时间'
)
    comment '菜单权限表' charset = utf8mb4;


-- auto-generated definition
create table sys_role_permission
(
    id            bigint auto_increment comment '主键'
        primary key,
    role_id       bigint   not null comment '角色id',
    permission_id bigint   not null comment '权限id',
    create_time   datetime not null comment '创建时间',
    update_time   datetime not null comment '修改时间'
)
    comment '角色权限表' charset = utf8mb4;

create index idx_role_permission
    on sys_role_permission (role_id, permission_id);


-- auto-generated definition
create table sys_logs
(
    id          bigint auto_increment comment '主键'
        primary key,
    user_no     bigint                                       not null comment '用户编号',
    module      varchar(50)                default ''        null comment '模块名',
    result      enum ('SUCCESS', 'FAILED') default 'SUCCESS' null comment '操作结果：SUCCESS, FAILED',
    remark      varchar(255)               default ''        null comment '备注',
    create_time datetime                                     not null comment '创建时间'
)
    comment '用户操作日志表' charset = utf8mb4;

create index idx_create_time
    on sys_logs (create_time);

create index idx_user
    on sys_logs (user_no);

