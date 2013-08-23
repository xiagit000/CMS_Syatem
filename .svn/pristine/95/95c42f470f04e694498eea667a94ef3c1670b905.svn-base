/**
**@version 1.5
**@date 2010/08/11
**@author junxue.rao
*/


  CREATE TABLE "STATE"."LDAPSETTING" 
   (	"ID" NUMBER(10,0) NOT NULL ENABLE, 
	"ATTR" VARCHAR2(255 BYTE), 
	"BASE" VARCHAR2(255 BYTE), 
	"NAME" VARCHAR2(255 BYTE), 
	"PORT" NUMBER(10,0) NOT NULL ENABLE, 
	"URL" VARCHAR2(255 BYTE), 
	"ADMIN" VARCHAR2(255 CHAR), 
	"BASEDN" VARCHAR2(255 CHAR), 
	"HOST" VARCHAR2(255 CHAR), 
	"LOGINNAME" VARCHAR2(255 CHAR), 
	"PASSWORD" VARCHAR2(255 CHAR), 
	"SECURE" NUMBER(1,0) NOT NULL ENABLE, 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;

alter table applog add tempDate timestamp;
update applog set tempDate=CAST(createtime AS TIMESTAMP);
alter table applog drop column createtime;
alter table applog rename column tempDate to createtime;
commit;

alter table entry_comment add tempDate timestamp;
update entry_comment set tempDate=CAST(addtime as timestamp);
alter table entry_comment drop column addtime;
alter table entry_comment rename column tempDate to addtime;
commit;

alter table entry add tempDate timestamp;
update entry set tempDate=CAST(publishedDate as timestamp);
alter table entry drop column publishedDate;
alter table entry rename column tempDate to publishedDate;
commit;

alter table entry add tempDate timestamp;
update entry set tempDate=CAST(timeline as timestamp);
alter table entry drop column timeline;
alter table entry rename column tempDate to timeline;
commit;

alter table entry add tempDate timestamp;
update entry set tempDate=CAST(userPublishedDate as timestamp);
alter table entry drop column userPublishedDate;
alter table entry rename column tempDate to userPublishedDate;
commit;

alter table image add tempDate timestamp;
update image set tempDate=CAST(addTime as timestamp);
alter table image drop column addTime;
alter table image rename column tempDate to addTime;
commit;

alter table T_USER add ldapValidate number(1,0) default 0 not null;

alter table "STATE"."SYSTEMINFO" add "SYSTEMINFO_ALLOWLDAP" NUMBER(1,0) default 0 not null;
commit;
