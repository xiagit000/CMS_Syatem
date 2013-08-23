/**
**@version 1.1
**@date 2010/06/28
**@author junxue.rao
*/

/**
 *@func alter table Entry add column hits int.
 */
alter table Entry add hits int DEFAULT 0;
commit;

alter table FRIENDLYLINK add TYPE_ID int DEFAULT null;
commit;

alter table Entry add published NUMBER(1,0) DEFAULT 0 not null;
alter table Entry add publishedDate date DEFAULT null;
alter table Entry add summary clob DEFAULT null;
alter table Entry add simple NUMBER(1,0) DEFAULT 0 not null;
alter table Entry add expiredDay int DEFAULT 0 not null;
alter table Entry drop column author;
alter table Entry add author_id NUMBER(10,0) DEFAULT null;
alter table Entry add userPublishedDate date DEFAULT null;
commit;