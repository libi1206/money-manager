/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/2/13 17:24:26                           */
/*==============================================================*/


drop table if exists assets;

drop table if exists family;

drop table if exists family_mapping;

drop table if exists transaction_record;

drop table if exists user;

/*==============================================================*/
/* Table: assets                                                */
/*==============================================================*/
create table assets
(
   id                   bigint not null auto_increment,
   owner                bigint not null,
   assets_name          varchar(50) not null,
   money                decimal not null,
   note                 varchar(256),
   create_time          bigint not null,
   primary key (id)
);

/*==============================================================*/
/* Table: family                                                */
/*==============================================================*/
create table family
(
   id                   bigint not null auto_increment,
   family_name          varchar(50),
   create_time          bigint not null,
   primary key (id)
);

/*==============================================================*/
/* Table: family_mapping                                        */
/*==============================================================*/
create table family_mapping
(
   user_id               bigint not null,
   family_id            bigint not null,
   primary key (user_id, family_id)
);

/*==============================================================*/
/* Table: transaction_record                                    */
/*==============================================================*/
create table transaction_record
(
   id                   bigint not null auto_increment,
   spend                bigint,
   save                 bigint,
   operation_user       bigint,
   accept_user          bigint,
   amount               decimal not null,
   record_type          varchar(20),
   note                 varchar(20) not null,
   create_time          bigint not null,
   primary key (id)
);

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table user
(
   id                   bigint not null auto_increment,
   user_name            varchar(50) not null,
   password             varchar(50) not null,
   sex                  tinyint(1),
   authority            varchar(50),
   neck_name            varchar(50),
   head_img             varchar(100),
   phone                varchar(20),
   create_time          bigint not null,
   primary key (id)
);

alter table assets add constraint FK_have foreign key (owner)
      references user (id) on delete restrict on update restrict;

alter table family_mapping add constraint FK_mack foreign key (use_id)
      references user (id) on delete restrict on update restrict;

alter table family_mapping add constraint FK_mack2 foreign key (family_id)
      references family (id) on delete restrict on update restrict;

alter table transaction_record add constraint FK_ac_user foreign key (accept_user)
      references user (id) on delete restrict on update restrict;

alter table transaction_record add constraint FK_op_user foreign key (operation_user)
      references user (id) on delete restrict on update restrict;

alter table transaction_record add constraint FK_save foreign key (save)
      references assets (id) on delete restrict on update restrict;

alter table transaction_record add constraint FK_spend foreign key (spend)
      references assets (id) on delete restrict on update restrict;

