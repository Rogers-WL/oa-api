
drop table if exists sale_group;
create table sale_group
(
    id              varchar(50) primary key,
    name            varchar(50) not null unique,
    remark          varchar(500),
    manager_account varchar(50),
    manager_name    varchar(100),
    create_by         varchar(50),
    create_by_name    varchar(100),
    create_time     datetime,
    update_by         varchar(50),
    update_by_name    varchar(100),
    update_time     datetime
);

drop table if exists sale_wechat;
create table sale_wechat
(
    id           varchar(50) primary key,
    account      varchar(50) not null unique,
    password     varchar(100),
    owner        varchar(50),
    owner_name   varchar(100),
    status       smallint(2) not null comment '0正常1禁用',
    create_by      varchar(50),
    create_by_name varchar(100),
    create_time  datetime,
    update_by      varchar(50),
    update_by_name varchar(100),
    update_time  datetime
);

drop table if exists sale_work_log;
create table sale_work_log
(
    id             varchar(50) primary key,
    finished_work  text not null,
    need_help_work text,
    remark         varchar(500),
    status         smallint(2) comment '0已审阅1组长审阅2主管审阅3boss审阅',
    leader_comment varchar(500),
    create_by        varchar(50),
    create_by_name   varchar(100),
    create_time    datetime,
    update_by        varchar(50),
    update_by_name   varchar(100),
    update_time    datetime
);

drop table if exists sale_new_customer;
create table sale_new_customer
(
    id           varchar(50) primary key,
    date         date not null,
    wechat       varchar(50),
    amount       int(11),
    remark       varchar(500),
    create_by      varchar(50),
    create_by_name varchar(100),
    create_time  datetime,
    update_by      varchar(50),
    update_by_name varchar(100),
    update_time  datetime
);

drop table if exists sale_work_leave;
create table sale_work_leave
(
    id           varchar(50) primary key ,
    start_time   datetime not null,
    end_time     datetime not null,
    reason       varchar(500),
    status       smallint(2) comment '0已通过1未通过2申请取消3组长审批4主管审批5boss审批6人事审批',
    create_by      varchar(50),
    create_by_name varchar(100),
    create_time  datetime,
    update_by      varchar(50),
    update_by_name varchar(100),
    update_time  datetime
);

drop table if exists sale_salary;
create table sale_salary
(
    id           varchar(50) primary key,
    year         smallint(4),
    month        smallint(2),
    user         varchar(50),
    user_name    varchar(100),
    base_salary  decimal(10, 2),
    order_bonus  decimal(10, 2),
    bonus        decimal(10, 2),
    deduct       decimal(10, 2),
    remark       varchar(500),
    create_by      varchar(50),
    create_by_name varchar(100),
    create_time  datetime,
    update_by      varchar(50),
    update_by_name varchar(100),
    update_time  datetime
);

drop table if exists sale_order;
create table sale_order
(
    id             varchar(50) primary key,
    order_no        varchar(50),
    product         text,
    receive_address varchar(300),
    customer_name   varchar(100),
    customer_phone  varchar(30),
    order_price     decimal(10, 2),
    pay_type        smallint(2) comment '0全款1定金',
    pay_money       decimal(10, 2),
    rest_money      decimal(10, 2),
    valid_money     decimal(10, 2),
    remark          varchar(500),
    status          smallint(2) comment '0已签收1已拒收2订单取消3主管确认4boos确认5待发货6待收货',
    create_by         varchar(50),
    create_by_name    varchar(100),
    create_time     datetime,
    update_by         varchar(50),
    update_by_name    varchar(100),
    update_time     datetime
);

drop table if exists sale_approve;
create table sale_approve
(
    id              varchar(50) primary key,
    master_id       varchar(50),
    type         int comment '0请假1工作日志',
    is_approve   bit,
    remark varchar(500),
    handler varchar(30),
    handler_name   varchar(100),
    handle_time datetime
);

