drop database if exists gemini_upms_dev;

create database gemini_upms_dev default character set utf8mb4 collate utf8mb4_general_ci;

set names utf8mb4;
set foreign_key_checks = 0;

use gemini_upms_dev;

-- ----------------------------
-- 租户表
-- ----------------------------
drop table if exists base_tenant;

create table base_tenant
(
    id            bigint auto_increment comment '主键'
        primary key,
    tenant_name   varchar(255) null comment '租户名称',
    tenant_code   varchar(255) null comment '租户编码',
    tenant_status int          null comment '租户状态',
    tenant_type   int          null comment '租户类型',
    tenant_desc   varchar(255) null comment '租户描述',
    create_time   datetime     null comment '创建时间',
    create_user   bigint       null comment '创建人',
    update_time   datetime     null comment '更新时间',
    update_user   bigint       null comment '更新人',
    is_deleted    int          null comment '是否删除',
    version       int          null comment '版本号'
)
    comment '租户表';