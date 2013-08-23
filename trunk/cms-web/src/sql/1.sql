/**
**@version 1.0
**@date 2010/06/28
**@author junxue.rao
**/
 
/**
**@func create tables;
**/
 CREATE TABLE "STATE"."ABSTRACTNEWS" 
   (	"DIS" VARCHAR2(31 BYTE) NOT NULL ENABLE, 
	"ID" NUMBER(10,0) NOT NULL ENABLE, 
	"CONTENT" CLOB, 
	"DATELINE" DATE, 
	"NEWSTYPE" VARCHAR2(255 BYTE), 
	"PLAINTEXT" CLOB, 
	"PUBLISHED" NUMBER(1,0) NOT NULL ENABLE, 
	"TITLE" VARCHAR2(255 BYTE), 
	"SUMMARY" CLOB, 
	"AUTHOR_ID" NUMBER(10,0), 
	"DEFINEDTYPE_ID" NUMBER(10,0), 
	"IMAGE_ID" NUMBER(10,0), 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "FKDCA16235E5C8CA30" FOREIGN KEY ("IMAGE_ID")
	  REFERENCES "STATE"."IMAGE" ("ID") ENABLE, 
	 CONSTRAINT "FKDCA1623598E7817C" FOREIGN KEY ("DEFINEDTYPE_ID")
	  REFERENCES "STATE"."DATATYPE" ("ID") ENABLE, 
	 CONSTRAINT "FKDCA16235EEE793F3" FOREIGN KEY ("AUTHOR_ID")
	  REFERENCES "STATE"."T_USER" ("ID") ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" 
 LOB ("CONTENT") STORE AS (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192 PCTVERSION 10
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)) 
 LOB ("PLAINTEXT") STORE AS (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192 PCTVERSION 10
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)) 
 LOB ("SUMMARY") STORE AS (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192 PCTVERSION 10
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)) ;
 

  CREATE TABLE "STATE"."ABSTRACTUSER" 
   (	"ID" NUMBER(10,0) NOT NULL ENABLE, 
	"PASSWORD" VARCHAR2(255 BYTE), 
	"USERRIGHT" NUMBER(10,0), 
	"USERNAME" VARCHAR2(255 BYTE), 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

  CREATE TABLE "STATE"."APPLICATIONSETTING" 
   (	"ID" NUMBER(10,0) NOT NULL ENABLE, 
	"KEY" VARCHAR2(255 BYTE), 
	"VALUE" VARCHAR2(255 BYTE), 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

  CREATE TABLE "STATE"."ATTACHMENT" 
   (	"ID" NUMBER(10,0) NOT NULL ENABLE, 
	"ADDTIME" DATE, 
	"DETAIL" CLOB, 
	"FILENAME" VARCHAR2(255 BYTE), 
	"NAME" VARCHAR2(255 BYTE), 
	"ORGINALNAME" VARCHAR2(255 BYTE), 
	"TYPE_ID" NUMBER(10,0), 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "FK1C9354335D50679" FOREIGN KEY ("TYPE_ID")
	  REFERENCES "STATE"."DATATYPE" ("ID") ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" 
 LOB ("DETAIL") STORE AS (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192 PCTVERSION 10
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)) ;
 

  CREATE TABLE "STATE"."ATTENTION" 
   (	"ID" NUMBER(10,0) NOT NULL ENABLE, 
	"CREATEDATE" DATE, 
	"DESCRIBE" VARCHAR2(255 BYTE), 
	"LINK" VARCHAR2(255 BYTE), 
	"TYPE" VARCHAR2(255 BYTE), 
	"ADDTIME" DATE, 
	"USER_ID" NUMBER(10,0), 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "FK625940FE8E2EA1B3" FOREIGN KEY ("USER_ID")
	  REFERENCES "STATE"."T_USER" ("ID") ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

  CREATE TABLE "STATE"."BLOCK" 
   (	"ID" NUMBER(19,0) NOT NULL ENABLE, 
	"BLOCK_INDEX" NUMBER(10,0), 
	"BLOCK_SIZE" NUMBER(10,0), 
	"NODE_ID" NUMBER(10,0), 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 UNIQUE ("BLOCK_INDEX")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "FK3D4D46D1C7F6A7C" FOREIGN KEY ("NODE_ID")
	  REFERENCES "STATE"."NODE" ("ID") ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

  CREATE UNIQUE INDEX "STATE"."SYS_C005156" ON "STATE"."BLOCK" ("ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 
  CREATE UNIQUE INDEX "STATE"."SYS_C005157" ON "STATE"."BLOCK" ("BLOCK_INDEX") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

  CREATE TABLE "STATE"."CITY" 
   (	"ID" NUMBER(10,0) NOT NULL ENABLE, 
	"AREA" VARCHAR2(255 BYTE), 
	"CITYCODE" VARCHAR2(255 BYTE), 
	"NAME" VARCHAR2(255 BYTE), 
	"PINYIN" VARCHAR2(255 BYTE), 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

  CREATE TABLE "STATE"."DATATYPE" 
   (	"DATATYPE" VARCHAR2(31 BYTE) NOT NULL ENABLE, 
	"ID" NUMBER(10,0) NOT NULL ENABLE, 
	"NAME" VARCHAR2(255 BYTE), 
	"POSITION" NUMBER(10,0) NOT NULL ENABLE, 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

  CREATE TABLE "STATE"."EMAILTEMPLATE" 
   (	"ID" NUMBER(10,0) NOT NULL ENABLE, 
	"CONTENT" VARCHAR2(255 BYTE), 
	"SUBJECT" VARCHAR2(255 BYTE), 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

  CREATE TABLE "STATE"."ENTRY" 
   (	"ID" NUMBER(10,0) NOT NULL ENABLE, 
	"AUTHOR" RAW(255), 
	"CONTENT" CLOB, 
	"LINK" NUMBER(1,0) NOT NULL ENABLE, 
	"PLAINTEXT" CLOB, 
	"TIMELINE" DATE, 
	"TITLE" VARCHAR2(255 BYTE), 
	"BELONGED_ID" NUMBER(10,0), 
	"IMAGE_ID" NUMBER(10,0), 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "FK4001852E5C8CA30" FOREIGN KEY ("IMAGE_ID")
	  REFERENCES "STATE"."IMAGE" ("ID") ENABLE, 
	 CONSTRAINT "FK40018526EDA0E0" FOREIGN KEY ("BELONGED_ID")
	  REFERENCES "STATE"."NODE" ("ID") ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" 
 LOB ("CONTENT") STORE AS (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192 PCTVERSION 10
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)) 
 LOB ("PLAINTEXT") STORE AS (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192 PCTVERSION 10
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)) ;
 

  CREATE TABLE "STATE"."EXPERIENCE" 
   (	"ID" NUMBER(19,0) NOT NULL ENABLE, 
	"EX_CAREER" VARCHAR2(255 BYTE), 
	"EX_PERIOD" VARCHAR2(255 BYTE), 
	"EX_UNIT" VARCHAR2(255 BYTE), 
	"RESUME_ID" NUMBER(19,0), 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "FK71B8358ACB83C591" FOREIGN KEY ("RESUME_ID")
	  REFERENCES "STATE"."REGISTER" ("ID") ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

  CREATE TABLE "STATE"."FAMILYMEMBER" 
   (	"ID" NUMBER(19,0) NOT NULL ENABLE, 
	"APPELLATION" VARCHAR2(255 BYTE), 
	"NAME" VARCHAR2(255 BYTE), 
	"POSITION" VARCHAR2(255 BYTE), 
	"WORKUNIT" VARCHAR2(255 BYTE), 
	"FAMILY_ID" NUMBER(19,0), 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "FKB58A0B3EE6E552FA" FOREIGN KEY ("FAMILY_ID")
	  REFERENCES "STATE"."REGISTER" ("ID") ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

  CREATE TABLE "STATE"."FRIENDLYLINK" 
   (	"ID" NUMBER(10,0) NOT NULL ENABLE, 
	"LINK" VARCHAR2(255 BYTE), 
	"NAME" VARCHAR2(255 BYTE), 
	"POSITION" NUMBER(10,0) NOT NULL ENABLE, 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

  CREATE TABLE "STATE"."IMAGE" 
   (	"ID" NUMBER(10,0) NOT NULL ENABLE, 
	"ADDTIME" DATE, 
	"ALBUM" VARCHAR2(255 BYTE), 
	"DESCRIPTION" VARCHAR2(255 BYTE), 
	"EXT" VARCHAR2(255 BYTE), 
	"FILESIZE" NUMBER(19,0) NOT NULL ENABLE, 
	"ICONIMG" VARCHAR2(255 BYTE), 
	"PATH" VARCHAR2(255 BYTE), 
	"TYPE" NUMBER(10,0) NOT NULL ENABLE, 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

  CREATE TABLE "STATE"."IUR_COMMENT" 
   (	"ID" NUMBER(10,0) NOT NULL ENABLE, 
	"ADDTIME" DATE, 
	"CONTENT" CLOB, 
	"IP" VARCHAR2(255 BYTE), 
	"VOTE" NUMBER(10,0) NOT NULL ENABLE, 
	"NEWS_ID" NUMBER(10,0), 
	"USER_ID" NUMBER(10,0), 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "FKFF8637A6E4938CED" FOREIGN KEY ("NEWS_ID")
	  REFERENCES "STATE"."ABSTRACTNEWS" ("ID") ENABLE, 
	 CONSTRAINT "FKFF8637A68E2EA1B3" FOREIGN KEY ("USER_ID")
	  REFERENCES "STATE"."T_USER" ("ID") ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" 
 LOB ("CONTENT") STORE AS (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192 PCTVERSION 10
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)) ;
 

  CREATE TABLE "STATE"."IUR_RESOURCE" 
   (	"ID" NUMBER(10,0) NOT NULL ENABLE, 
	"INFO" CLOB, 
	"NAME" VARCHAR2(255 BYTE), 
	"RESOURCETYPE_ID" NUMBER(10,0), 
	"UNIT_ID" NUMBER(10,0), 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "FKD4A387C3AE4150" FOREIGN KEY ("RESOURCETYPE_ID")
	  REFERENCES "STATE"."DATATYPE" ("ID") ENABLE, 
	 CONSTRAINT "FKD4A387557C58FA" FOREIGN KEY ("UNIT_ID")
	  REFERENCES "STATE"."UNIT" ("ID") ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" 
 LOB ("INFO") STORE AS (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192 PCTVERSION 10
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)) ;
 

  CREATE TABLE "STATE"."MESSAGE" 
   (	"ID" NUMBER(10,0) NOT NULL ENABLE, 
	"ADDTIME" DATE, 
	"ADDRESS" VARCHAR2(255 BYTE), 
	"CONTENT" VARCHAR2(255 BYTE), 
	"EMAIL" VARCHAR2(255 BYTE), 
	"IP" VARCHAR2(255 BYTE), 
	"MESSAGER" VARCHAR2(255 BYTE), 
	"REPLIED" NUMBER(1,0) NOT NULL ENABLE, 
	"REPLIEDCONTENT" VARCHAR2(255 BYTE), 
	"REPLIEDPERSON" VARCHAR2(255 BYTE), 
	"REPLIEDTIME" DATE, 
	"TELPHONE" VARCHAR2(255 BYTE), 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

  CREATE TABLE "STATE"."NODE" 
   (	"ID" NUMBER(10,0) NOT NULL ENABLE, 
	"ADDRESS" VARCHAR2(255 BYTE), 
	"BLANK" NUMBER(1,0) NOT NULL ENABLE, 
	"DISPLAY" NUMBER(1,0) NOT NULL ENABLE, 
	"LINK" NUMBER(1,0) NOT NULL ENABLE, 
	"NAME" VARCHAR2(255 BYTE), 
	"POSITION" NUMBER(10,0) NOT NULL ENABLE, 
	"PARENT_ID" NUMBER(10,0), 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "FK25222219DE2ED4" FOREIGN KEY ("PARENT_ID")
	  REFERENCES "STATE"."NODE" ("ID") ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

  CREATE TABLE "STATE"."PRIVILEGE" 
   (	"ID" NUMBER(10,0) NOT NULL ENABLE, 
	"NAME" VARCHAR2(255 BYTE), 
	"OPERATION" VARCHAR2(255 BYTE), 
	"POSITION" NUMBER(10,0) NOT NULL ENABLE, 
	"NODE_ID" NUMBER(10,0), 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "FK196D16911C7F6A7C" FOREIGN KEY ("NODE_ID")
	  REFERENCES "STATE"."NODE" ("ID") ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

  CREATE TABLE "STATE"."REGISTER" 
   (	"ID" NUMBER(19,0) NOT NULL ENABLE, 
	"BIRTHDATE" VARCHAR2(255 BYTE), 
	"CULTURALLEVEL" VARCHAR2(255 BYTE), 
	"ENROLLMENTTIME" VARCHAR2(255 BYTE), 
	"ETHNIC" VARCHAR2(255 BYTE), 
	"HOMEADDRESS" VARCHAR2(255 BYTE), 
	"IDENTITYNUMBER" VARCHAR2(255 BYTE), 
	"NAME" VARCHAR2(255 BYTE), 
	"NOTES" VARCHAR2(255 BYTE), 
	"PHONE" VARCHAR2(255 BYTE), 
	"POLITICALAFFILIATION" VARCHAR2(255 BYTE), 
	"RADUATIONNUMBER" VARCHAR2(255 BYTE), 
	"SCHOOLNAME" VARCHAR2(255 BYTE), 
	"SCHOOLOFGRADUATION" VARCHAR2(255 BYTE), 
	"SEX" NUMBER(10,0), 
	"SPECIALTY" VARCHAR2(255 BYTE), 
	"TAKECARE" VARCHAR2(255 BYTE), 
	"ZIPCODE" VARCHAR2(255 BYTE), 
	"STUDYLEVEL" NUMBER(10,0), 
	"STUDYTYPE" NUMBER(10,0), 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

  CREATE TABLE "STATE"."ROLE" 
   (	"ID" NUMBER(10,0) NOT NULL ENABLE, 
	"NAME" VARCHAR2(255 BYTE), 
	"POSITION" NUMBER(10,0) NOT NULL ENABLE, 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

  CREATE TABLE "STATE"."ROLE_PRIVILEGE" 
   (	"ROLE_ID" NUMBER(10,0) NOT NULL ENABLE, 
	"PRIVILEGES_ID" NUMBER(10,0) NOT NULL ENABLE, 
	 UNIQUE ("PRIVILEGES_ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "FK81B4C228260E81F6" FOREIGN KEY ("ROLE_ID")
	  REFERENCES "STATE"."ROLE" ("ID") ENABLE, 
	 CONSTRAINT "FK81B4C228A796CD" FOREIGN KEY ("PRIVILEGES_ID")
	  REFERENCES "STATE"."PRIVILEGE" ("ID") ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

  CREATE UNIQUE INDEX "STATE"."SYS_C005204" ON "STATE"."ROLE_PRIVILEGE" ("PRIVILEGES_ID") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

  CREATE TABLE "STATE"."SUGGESTION" 
   (	"ID" NUMBER(10,0) NOT NULL ENABLE, 
	"ADDTIME" DATE, 
	"ADDRESS" VARCHAR2(255 BYTE), 
	"ADVISER" VARCHAR2(255 BYTE), 
	"CAREER" VARCHAR2(255 BYTE), 
	"CONTENT" VARCHAR2(255 BYTE), 
	"EMAIL" VARCHAR2(255 BYTE), 
	"REPLIED" NUMBER(1,0) NOT NULL ENABLE, 
	"TELPHONE" VARCHAR2(255 BYTE), 
	"TITLE" VARCHAR2(255 BYTE), 
	"UNITNAME" VARCHAR2(255 BYTE), 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

  CREATE TABLE "STATE"."T_USER" 
   (	"ACTIVATED" NUMBER(1,0) NOT NULL ENABLE, 
	"ADDRESS" VARCHAR2(255 BYTE), 
	"APPENDIX" VARCHAR2(255 BYTE), 
	"EMAIL" VARCHAR2(255 BYTE), 
	"PHONE" VARCHAR2(255 BYTE), 
	"ID" NUMBER(10,0) NOT NULL ENABLE, 
	"PORTRAIT_ID" NUMBER(10,0), 
	"UNIT_ID" NUMBER(10,0), 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "CMS_USER" FOREIGN KEY ("ID")
	  REFERENCES "STATE"."ABSTRACTUSER" ("ID") ENABLE, 
	 CONSTRAINT "FK94B9B0D67B778FF0" FOREIGN KEY ("PORTRAIT_ID")
	  REFERENCES "STATE"."IMAGE" ("ID") ENABLE, 
	 CONSTRAINT "FK94B9B0D6557C58FA" FOREIGN KEY ("UNIT_ID")
	  REFERENCES "STATE"."UNIT" ("ID") ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

  CREATE TABLE "STATE"."T_USER_ROLE" 
   (	"T_USER_ID" NUMBER(10,0) NOT NULL ENABLE, 
	"ROLES_ID" NUMBER(10,0) NOT NULL ENABLE, 
	 CONSTRAINT "FK3E63125F49C094E8" FOREIGN KEY ("T_USER_ID")
	  REFERENCES "STATE"."T_USER" ("ID") ENABLE, 
	 CONSTRAINT "FK3E63125FC426FA4F" FOREIGN KEY ("ROLES_ID")
	  REFERENCES "STATE"."ROLE" ("ID") ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

  CREATE TABLE "STATE"."UNIT" 
   (	"ID" NUMBER(10,0) NOT NULL ENABLE, 
	"ADDRESS" VARCHAR2(255 BYTE), 
	"DETAIL" CLOB, 
	"EMAIL" VARCHAR2(255 BYTE), 
	"NAME" VARCHAR2(255 BYTE), 
	"PHONE" VARCHAR2(255 BYTE), 
	"UNITNUMBER" VARCHAR2(255 BYTE), 
	"UNITSCOPE" VARCHAR2(255 BYTE), 
	"ZIPCODE" VARCHAR2(255 BYTE), 
	"CITY_ID" NUMBER(10,0), 
	"UNITTYPE_ID" NUMBER(10,0), 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "FK284DA490842ADA" FOREIGN KEY ("UNITTYPE_ID")
	  REFERENCES "STATE"."DATATYPE" ("ID") ENABLE, 
	 CONSTRAINT "FK284DA49558FB9A" FOREIGN KEY ("CITY_ID")
	  REFERENCES "STATE"."CITY" ("ID") ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" 
 LOB ("DETAIL") STORE AS (
  TABLESPACE "USERS" ENABLE STORAGE IN ROW CHUNK 8192 PCTVERSION 10
  NOCACHE LOGGING 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)) ;
 

  CREATE TABLE "STATE"."WEBRECORD" 
   (	"ID" NUMBER(10,0) NOT NULL ENABLE, 
	"HREF" VARCHAR2(255 BYTE), 
	"TITLE" VARCHAR2(255 BYTE), 
	"VIEWTIME" DATE, 
	"USER_ID" NUMBER(10,0), 
	 PRIMARY KEY ("ID")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS"  ENABLE, 
	 CONSTRAINT "FK30E674A58E2EA1B3" FOREIGN KEY ("USER_ID")
	  REFERENCES "STATE"."T_USER" ("ID") ENABLE
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT)
  TABLESPACE "USERS" ;
 

/**
**@func init user admin identified by 123456
**/

REM INSERTING into ABSTRACTUSER
Insert into ABSTRACTUSER (ID,PASSWORD,USERRIGHT,USERNAME) values (752,'e1adc3949ba59abbe56e057f2f883e',2,'admin');
REM INSERTING into T_USER
Insert into T_USER (ACTIVATED,ADDRESS,APPENDIX,EMAIL,PHONE,ID,PORTRAIT_ID,UNIT_ID) values (1,'sadsadsa','sdsadsad','admin@sample.com','1344444444',752,null,null);

/**
**@func init nodes
**/

REM INSERTING into NODE
Insert into NODE (ID,ADDRESS,BLANK,DISPLAY,LINK,NAME,POSITION,PARENT_ID) values (686,'/open',0,1,1,'首页',1,null);
Insert into NODE (ID,ADDRESS,BLANK,DISPLAY,LINK,NAME,POSITION,PARENT_ID) values (687,null,0,1,0,'学院概况',2,null);
Insert into NODE (ID,ADDRESS,BLANK,DISPLAY,LINK,NAME,POSITION,PARENT_ID) values (688,null,0,1,0,'学院新闻',3,null);
Insert into NODE (ID,ADDRESS,BLANK,DISPLAY,LINK,NAME,POSITION,PARENT_ID) values (689,null,0,1,0,'招生政策',4,null);
Insert into NODE (ID,ADDRESS,BLANK,DISPLAY,LINK,NAME,POSITION,PARENT_ID) values (690,null,0,1,0,'教务管理',5,null);
Insert into NODE (ID,ADDRESS,BLANK,DISPLAY,LINK,NAME,POSITION,PARENT_ID) values (691,null,0,1,0,'在线考试',6,null);
Insert into NODE (ID,ADDRESS,BLANK,DISPLAY,LINK,NAME,POSITION,PARENT_ID) values (712,null,0,1,0,'通知公告',1,688);
Insert into NODE (ID,ADDRESS,BLANK,DISPLAY,LINK,NAME,POSITION,PARENT_ID) values (722,null,0,1,0,'招生简章',1,689);
Insert into NODE (ID,ADDRESS,BLANK,DISPLAY,LINK,NAME,POSITION,PARENT_ID) values (815,null,0,0,0,'专业设置',12,null);
Insert into NODE (ID,ADDRESS,BLANK,DISPLAY,LINK,NAME,POSITION,PARENT_ID) values (816,'/open/register',0,1,0,'网上报名',9,null);
Insert into NODE (ID,ADDRESS,BLANK,DISPLAY,LINK,NAME,POSITION,PARENT_ID) values (817,null,0,1,0,'资源下载',10,null);
Insert into NODE (ID,ADDRESS,BLANK,DISPLAY,LINK,NAME,POSITION,PARENT_ID) values (818,null,0,1,0,'联系我们',11,null);
Insert into NODE (ID,ADDRESS,BLANK,DISPLAY,LINK,NAME,POSITION,PARENT_ID) values (1711,null,0,1,0,'学籍管理',7,null);
Insert into NODE (ID,ADDRESS,BLANK,DISPLAY,LINK,NAME,POSITION,PARENT_ID) values (1712,null,0,1,0,'学院简介',1,687);
Insert into NODE (ID,ADDRESS,BLANK,DISPLAY,LINK,NAME,POSITION,PARENT_ID) values (1713,null,0,1,0,'院长介绍',2,687);
Insert into NODE (ID,ADDRESS,BLANK,DISPLAY,LINK,NAME,POSITION,PARENT_ID) values (1714,null,0,1,0,'机构设置',3,687);
Insert into NODE (ID,ADDRESS,BLANK,DISPLAY,LINK,NAME,POSITION,PARENT_ID) values (1715,null,0,1,0,'教师风采',4,687);
Insert into NODE (ID,ADDRESS,BLANK,DISPLAY,LINK,NAME,POSITION,PARENT_ID) values (1758,null,0,1,0,'招生政策',2,689);
Insert into NODE (ID,ADDRESS,BLANK,DISPLAY,LINK,NAME,POSITION,PARENT_ID) values (1780,null,0,1,0,'分院管理',8,null);
Insert into NODE (ID,ADDRESS,BLANK,DISPLAY,LINK,NAME,POSITION,PARENT_ID) values (1781,null,0,1,0,'学院新闻1',2,688);

commit;
