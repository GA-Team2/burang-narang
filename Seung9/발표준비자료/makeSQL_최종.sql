--1. 테이블 생성
--------------------------------------------------------
--  파일이 생성됨 - 수요일-9월-28-2022   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Table LIKEINFO
--------------------------------------------------------

  CREATE TABLE "BUNA"."LIKEINFO" 
   (	"M_NICKNAME" VARCHAR2(18 BYTE), 
	"P_ROWNUM" NUMBER, 
	"M_AGERANGE" NUMBER(3,0), 
	"M_GENDER" NUMBER(1,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PLANINFO
--------------------------------------------------------

  CREATE TABLE "BUNA"."PLANINFO" 
   (	"P_ROWNUM" NUMBER, 
	"M_NICKNAME" VARCHAR2(18 BYTE), 
	"P_TITLE" VARCHAR2(255 BYTE), 
	"P_FIRSTDATE" DATE, 
	"P_LASTDATE" DATE, 
	"T_NAMELIST" VARCHAR2(255 BYTE), 
	"P_REGDATE" DATE, 
	"P_LIKE" NUMBER, 
	"P_PUBLIC" NUMBER(1,0)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table EVENT
--------------------------------------------------------

  CREATE TABLE "BUNA"."EVENT" 
   (	"S_SERIALNUM" VARCHAR2(18 BYTE), 
	"E_NAME" VARCHAR2(255 BYTE), 
	"E_VENUE" VARCHAR2(255 BYTE), 
	"E_PNUMBER" VARCHAR2(255 BYTE), 
	"E_LOCATION" VARCHAR2(255 BYTE), 
	"E_STARTDATE" DATE, 
	"E_ENDDATE" DATE, 
	"E_PHOTO" VARCHAR2(255 BYTE), 
	"E_URL" VARCHAR2(2000 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table ACCOMMODATION
--------------------------------------------------------

  CREATE TABLE "BUNA"."ACCOMMODATION" 
   (	"S_SERIALNUM" VARCHAR2(18 BYTE), 
	"A_TYPE" VARCHAR2(20 BYTE), 
	"A_NAME" VARCHAR2(255 BYTE), 
	"A_PNUMBER" VARCHAR2(255 BYTE), 
	"A_LOCATION" VARCHAR2(255 BYTE), 
	"A_CHECKIN" VARCHAR2(10 BYTE), 
	"A_CHECKOUT" VARCHAR2(10 BYTE), 
	"A_PHOTO" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table MEMBERINFO
--------------------------------------------------------

  CREATE TABLE "BUNA"."MEMBERINFO" 
   (	"M_NICKNAME" VARCHAR2(18 BYTE), 
	"M_PASSWORD" VARCHAR2(50 BYTE), 
	"M_BIRTHYEAR" NUMBER(4,0), 
	"M_GENDER" NUMBER(1,0), 
	"M_JOINDATE" DATE
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table PLANDETAIL
--------------------------------------------------------

  CREATE TABLE "BUNA"."PLANDETAIL" 
   (	"P_ROWNUM" NUMBER, 
	"P_TRIPDAY" NUMBER, 
	"P_TRIPDATE" DATE, 
	"P_SEQUENCE" NUMBER, 
	"S_SERIALNUM" VARCHAR2(18 BYTE), 
	"P_SPOTNAME" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table RESTAURANT
--------------------------------------------------------

  CREATE TABLE "BUNA"."RESTAURANT" 
   (	"S_SERIALNUM" VARCHAR2(18 BYTE), 
	"R_TYPE" VARCHAR2(20 BYTE), 
	"R_NAME" VARCHAR2(255 BYTE), 
	"R_PNUMBER" VARCHAR2(255 BYTE), 
	"R_LOCATION" VARCHAR2(255 BYTE), 
	"R_OPENTIME" VARCHAR2(10 BYTE), 
	"R_CLOSETIME" VARCHAR2(10 BYTE), 
	"R_PHOTO" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table SPOTDETAIL
--------------------------------------------------------

  CREATE TABLE "BUNA"."SPOTDETAIL" 
   (	"S_SERIALNUM" VARCHAR2(50 BYTE), 
	"S_NAME" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TAGLIST
--------------------------------------------------------

  CREATE TABLE "BUNA"."TAGLIST" 
   (	"T_NAME" VARCHAR2(30 BYTE), 
	"T_HIT" NUMBER
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table TRAFFIC
--------------------------------------------------------

  CREATE TABLE "BUNA"."TRAFFIC" 
   (	"S_SERIALNUM" VARCHAR2(18 BYTE), 
	"TF_TYPE" VARCHAR2(20 BYTE), 
	"TF_NAME" VARCHAR2(255 BYTE), 
	"TF_PNUMBER" VARCHAR2(255 BYTE), 
	"TF_LOCATION" VARCHAR2(255 BYTE), 
	"TF_PHOTO" VARCHAR2(255 BYTE)
   ) SEGMENT CREATION IMMEDIATE 
  PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for View ALLTOPVIEW
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "BUNA"."ALLTOPVIEW" ("P_ROWNUM", "P_TITLE", "T_NAMELIST", "P_LIKE") AS 
  select p.p_rownum
     , p.p_title
     , p.t_namelist
     , p.p_like
     from(select * from memberinfo) M, planinfo P
     where P.m_nickname = m.m_nickname
     and p_public = 1
     order by p.p_like desc
;
--------------------------------------------------------
--  DDL for View BOARDVIEW
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "BUNA"."BOARDVIEW" ("P_ROWNUM", "P_TITLE", "T_NAMELIST", "P_REGDATE", "P_LIKE") AS 
  select p_rownum,
       p_title,
       t_namelist,
       p_regdate,
       p_like
from planinfo
where p_public = 1
;
--------------------------------------------------------
--  DDL for View MTOPVIEW
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "BUNA"."MTOPVIEW" ("P_ROWNUM", "P_TITLE", "T_NAMELIST", "P_LIKE") AS 
  select p.p_rownum
     , p.p_title
     , p.t_namelist
     , p.p_like
     from(select * from memberinfo where m_gender=0) M, planinfo P
     where P.m_nickname = m.m_nickname
     and p_public = 1
     order by p.p_like desc
;
--------------------------------------------------------
--  DDL for View TOPVIEW20
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "BUNA"."TOPVIEW20" ("P_ROWNUM", "P_TITLE", "T_NAMELIST", "P_LIKE") AS 
  select 
    P.p_rownum,
    P.p_title,
    P.t_namelist,
    P.p_like
from memberinfo M, planinfo P
where P.m_nickname = m.m_nickname
and (2022 - M.m_birthyear) between 1 and 29
and p_public = 1
order by P.p_like desc
;
--------------------------------------------------------
--  DDL for View TOPVIEW30
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "BUNA"."TOPVIEW30" ("P_ROWNUM", "P_TITLE", "T_NAMELIST", "P_LIKE") AS 
  select 
    P.p_rownum,
    P.p_title,
    P.t_namelist,
    P.p_like
from memberinfo M, planinfo P
where P.m_nickname = m.m_nickname
and (2022 - M.m_birthyear) between 30 and 39
and p_public = 1
order by P.p_like desc
;
--------------------------------------------------------
--  DDL for View TOPVIEW40
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "BUNA"."TOPVIEW40" ("P_ROWNUM", "P_TITLE", "T_NAMELIST", "P_LIKE") AS 
  select 
    P.p_rownum,
    P.p_title,
    P.t_namelist,
    P.p_like
from memberinfo M, planinfo P
where P.m_nickname = m.m_nickname
and (2022 - M.m_birthyear) between 40 and 49
and p_public = 1
order by P.p_like desc
;
--------------------------------------------------------
--  DDL for View TOPVIEW50
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "BUNA"."TOPVIEW50" ("P_ROWNUM", "P_TITLE", "T_NAMELIST", "P_LIKE") AS 
  select 
    P.p_rownum,
    P.p_title,
    P.t_namelist,
    P.p_like
from memberinfo M, planinfo P
where P.m_nickname = m.m_nickname
and (2022 - M.m_birthyear) between 50 and 200
and p_public = 1
order by P.p_like desc
;
--------------------------------------------------------
--  DDL for View WTOPVIEW
--------------------------------------------------------

  CREATE OR REPLACE FORCE VIEW "BUNA"."WTOPVIEW" ("P_ROWNUM", "P_TITLE", "T_NAMELIST", "P_LIKE") AS 
  select p.p_rownum
     , p.p_title
     , p.t_namelist
     , p.p_like
     from(select * from memberinfo where m_gender=1) M, planinfo P
     where P.m_nickname = m.m_nickname
     and p_public = 1
     order by p.p_like desc
;


--2. 기본키/외래키/종속삭제 설정
--------------------------------------------------------
--  DDL for Index PK_PLANINFO
--------------------------------------------------------

  CREATE UNIQUE INDEX "BUNA"."PK_PLANINFO" ON "BUNA"."PLANINFO" ("P_ROWNUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK_ACCOMMODATION
--------------------------------------------------------

  CREATE UNIQUE INDEX "BUNA"."PK_ACCOMMODATION" ON "BUNA"."ACCOMMODATION" ("S_SERIALNUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK_MEMBERINFO
--------------------------------------------------------

  CREATE UNIQUE INDEX "BUNA"."PK_MEMBERINFO" ON "BUNA"."MEMBERINFO" ("M_NICKNAME") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK_RESTAURANT
--------------------------------------------------------

  CREATE UNIQUE INDEX "BUNA"."PK_RESTAURANT" ON "BUNA"."RESTAURANT" ("S_SERIALNUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK_SPOTDETAIL
--------------------------------------------------------

  CREATE UNIQUE INDEX "BUNA"."PK_SPOTDETAIL" ON "BUNA"."SPOTDETAIL" ("S_SERIALNUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index PK_TRAFFIC
--------------------------------------------------------

  CREATE UNIQUE INDEX "BUNA"."PK_TRAFFIC" ON "BUNA"."TRAFFIC" ("S_SERIALNUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table LIKEINFO
--------------------------------------------------------

  ALTER TABLE "BUNA"."LIKEINFO" MODIFY ("M_NICKNAME" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."LIKEINFO" MODIFY ("P_ROWNUM" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."LIKEINFO" MODIFY ("M_AGERANGE" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."LIKEINFO" MODIFY ("M_GENDER" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table PLANINFO
--------------------------------------------------------

  ALTER TABLE "BUNA"."PLANINFO" MODIFY ("P_ROWNUM" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."PLANINFO" MODIFY ("M_NICKNAME" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."PLANINFO" MODIFY ("P_TITLE" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."PLANINFO" MODIFY ("P_FIRSTDATE" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."PLANINFO" MODIFY ("P_LASTDATE" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."PLANINFO" MODIFY ("P_REGDATE" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."PLANINFO" MODIFY ("P_LIKE" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."PLANINFO" MODIFY ("P_PUBLIC" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."PLANINFO" ADD CONSTRAINT "PK_PLANINFO" PRIMARY KEY ("P_ROWNUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table EVENT
--------------------------------------------------------

  ALTER TABLE "BUNA"."EVENT" MODIFY ("S_SERIALNUM" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."EVENT" MODIFY ("E_NAME" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."EVENT" MODIFY ("E_VENUE" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."EVENT" MODIFY ("E_PNUMBER" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."EVENT" MODIFY ("E_LOCATION" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."EVENT" MODIFY ("E_PHOTO" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."EVENT" ADD CONSTRAINT "PK_EVENT" PRIMARY KEY ("S_SERIALNUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;

--------------------------------------------------------
--  Constraints for Table ACCOMMODATION
--------------------------------------------------------

  ALTER TABLE "BUNA"."ACCOMMODATION" MODIFY ("S_SERIALNUM" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."ACCOMMODATION" MODIFY ("A_NAME" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."ACCOMMODATION" MODIFY ("A_PNUMBER" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."ACCOMMODATION" MODIFY ("A_LOCATION" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."ACCOMMODATION" MODIFY ("A_CHECKIN" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."ACCOMMODATION" MODIFY ("A_CHECKOUT" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."ACCOMMODATION" ADD CONSTRAINT "PK_ACCOMMODATION" PRIMARY KEY ("S_SERIALNUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table MEMBERINFO
--------------------------------------------------------

  ALTER TABLE "BUNA"."MEMBERINFO" MODIFY ("M_NICKNAME" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."MEMBERINFO" MODIFY ("M_PASSWORD" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."MEMBERINFO" MODIFY ("M_BIRTHYEAR" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."MEMBERINFO" MODIFY ("M_GENDER" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."MEMBERINFO" MODIFY ("M_JOINDATE" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."MEMBERINFO" ADD CONSTRAINT "PK_MEMBERINFO" PRIMARY KEY ("M_NICKNAME")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table PLANDETAIL
--------------------------------------------------------

  ALTER TABLE "BUNA"."PLANDETAIL" MODIFY ("P_ROWNUM" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."PLANDETAIL" MODIFY ("P_TRIPDAY" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."PLANDETAIL" MODIFY ("P_TRIPDATE" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."PLANDETAIL" MODIFY ("P_SEQUENCE" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."PLANDETAIL" MODIFY ("S_SERIALNUM" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."PLANDETAIL" MODIFY ("P_SPOTNAME" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table RESTAURANT
--------------------------------------------------------

  ALTER TABLE "BUNA"."RESTAURANT" MODIFY ("S_SERIALNUM" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."RESTAURANT" MODIFY ("R_NAME" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."RESTAURANT" MODIFY ("R_LOCATION" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."RESTAURANT" MODIFY ("R_OPENTIME" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."RESTAURANT" MODIFY ("R_CLOSETIME" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."RESTAURANT" MODIFY ("R_PHOTO" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."RESTAURANT" ADD CONSTRAINT "PK_RESTAURANT" PRIMARY KEY ("S_SERIALNUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "BUNA"."RESTAURANT" MODIFY ("R_PNUMBER" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table SPOTDETAIL
--------------------------------------------------------

  ALTER TABLE "BUNA"."SPOTDETAIL" MODIFY ("S_SERIALNUM" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."SPOTDETAIL" MODIFY ("S_NAME" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."SPOTDETAIL" ADD CONSTRAINT "PK_SPOTDETAIL" PRIMARY KEY ("S_SERIALNUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Constraints for Table TAGLIST
--------------------------------------------------------

  ALTER TABLE "BUNA"."TAGLIST" MODIFY ("T_NAME" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."TAGLIST" MODIFY ("T_HIT" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table TRAFFIC
--------------------------------------------------------

  ALTER TABLE "BUNA"."TRAFFIC" MODIFY ("S_SERIALNUM" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."TRAFFIC" MODIFY ("TF_TYPE" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."TRAFFIC" MODIFY ("TF_NAME" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."TRAFFIC" MODIFY ("TF_PNUMBER" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."TRAFFIC" MODIFY ("TF_LOCATION" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."TRAFFIC" MODIFY ("TF_PHOTO" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."TRAFFIC" ADD CONSTRAINT "PK_TRAFFIC" PRIMARY KEY ("S_SERIALNUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table LIKEINFO
--------------------------------------------------------

  ALTER TABLE "BUNA"."LIKEINFO" ADD CONSTRAINT "FK_MEMBERINFO_TO_LIKEINFO_1" FOREIGN KEY ("M_NICKNAME")
	  REFERENCES "BUNA"."MEMBERINFO" ("M_NICKNAME") ON DELETE CASCADE ENABLE;
  ALTER TABLE "BUNA"."LIKEINFO" ADD CONSTRAINT "FK_PLANINFO_TO_LIKEINFO_1" FOREIGN KEY ("P_ROWNUM")
	  REFERENCES "BUNA"."PLANINFO" ("P_ROWNUM") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PLANINFO
--------------------------------------------------------

  ALTER TABLE "BUNA"."PLANINFO" ADD CONSTRAINT "FK_MEMBERINFO_TO_PLANINFO_1" FOREIGN KEY ("M_NICKNAME")
	  REFERENCES "BUNA"."MEMBERINFO" ("M_NICKNAME") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table ACCOMMODATION
--------------------------------------------------------

  ALTER TABLE "BUNA"."ACCOMMODATION" ADD CONSTRAINT "FK_SPOTDETAIL_TO_ACCOM_1" FOREIGN KEY ("S_SERIALNUM")
	  REFERENCES "BUNA"."SPOTDETAIL" ("S_SERIALNUM") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table PLANDETAIL
--------------------------------------------------------

  ALTER TABLE "BUNA"."PLANDETAIL" ADD CONSTRAINT "FK_PLANDETAIL_TO_SPOTDETAIL_1" FOREIGN KEY ("S_SERIALNUM")
	  REFERENCES "BUNA"."SPOTDETAIL" ("S_SERIALNUM") ENABLE;
  ALTER TABLE "BUNA"."PLANDETAIL" ADD CONSTRAINT "FK_PLANINFO_TO_PLANDETAIL_1" FOREIGN KEY ("P_ROWNUM")
	  REFERENCES "BUNA"."PLANINFO" ("P_ROWNUM") ON DELETE CASCADE ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table RESTAURANT
--------------------------------------------------------

  ALTER TABLE "BUNA"."RESTAURANT" ADD CONSTRAINT "FK_SPOTDETAIL_TO_RESTAURANT_1" FOREIGN KEY ("S_SERIALNUM")
	  REFERENCES "BUNA"."SPOTDETAIL" ("S_SERIALNUM") ENABLE;
--------------------------------------------------------
--  Ref Constraints for Table TRAFFIC
--------------------------------------------------------

  ALTER TABLE "BUNA"."TRAFFIC" ADD CONSTRAINT "FK_SPOTDETAIL_TO_TRAFFIC_1" FOREIGN KEY ("S_SERIALNUM")
	  REFERENCES "BUNA"."SPOTDETAIL" ("S_SERIALNUM") ENABLE;

  ALTER TABLE "BUNA"."EVENT" ADD CONSTRAINT "FK_SPOTDETAIL_TO_EVENT_1" FOREIGN KEY ("S_SERIALNUM")
	  REFERENCES "BUNA"."SPOTDETAIL" ("S_SERIALNUM") ENABLE;



--데이터 추가 순서 : member, spotdetail, A,R,E,T, planinfo, plandetail, likeinpo
REM INSERTING into BUNA.MEMBERINFO
SET DEFINE OFF;
Insert into BUNA.MEMBERINFO (M_NICKNAME,M_PASSWORD,M_BIRTHYEAR,M_GENDER,M_JOINDATE) values ('염소','rkskek123!',2002,1,to_date('22/09/27','RR/MM/DD'));
Insert into BUNA.MEMBERINFO (M_NICKNAME,M_PASSWORD,M_BIRTHYEAR,M_GENDER,M_JOINDATE) values ('고양이','rkskek123!',1990,0,to_date('22/09/25','RR/MM/DD'));
Insert into BUNA.MEMBERINFO (M_NICKNAME,M_PASSWORD,M_BIRTHYEAR,M_GENDER,M_JOINDATE) values ('강아지','rkskek123!',2001,0,to_date('22/09/27','RR/MM/DD'));
Insert into BUNA.MEMBERINFO (M_NICKNAME,M_PASSWORD,M_BIRTHYEAR,M_GENDER,M_JOINDATE) values ('송아지','rkskek123!',1990,1,to_date('22/09/27','RR/MM/DD'));
Insert into BUNA.MEMBERINFO (M_NICKNAME,M_PASSWORD,M_BIRTHYEAR,M_GENDER,M_JOINDATE) values ('기린','rkskek123!',1980,0,to_date('22/09/27','RR/MM/DD'));
Insert into BUNA.MEMBERINFO (M_NICKNAME,M_PASSWORD,M_BIRTHYEAR,M_GENDER,M_JOINDATE) values ('원숭이','rkskek123!',1970,1,to_date('22/09/27','RR/MM/DD'));
Insert into BUNA.MEMBERINFO (M_NICKNAME,M_PASSWORD,M_BIRTHYEAR,M_GENDER,M_JOINDATE) values ('치타','rkskek123!',1962,1,to_date('22/09/27','RR/MM/DD'));
Insert into BUNA.MEMBERINFO (M_NICKNAME,M_PASSWORD,M_BIRTHYEAR,M_GENDER,M_JOINDATE) values ('고슴도치','rkskek123!',1985,0,to_date('22/09/27','RR/MM/DD'));
Insert into BUNA.MEMBERINFO (M_NICKNAME,M_PASSWORD,M_BIRTHYEAR,M_GENDER,M_JOINDATE) values ('사슴','rkskek123!',1992,1,to_date('22/09/27','RR/MM/DD'));
Insert into BUNA.MEMBERINFO (M_NICKNAME,M_PASSWORD,M_BIRTHYEAR,M_GENDER,M_JOINDATE) values ('호랑이','rkskek123!',1996,0,to_date('22/09/27','RR/MM/DD'));
Insert into BUNA.MEMBERINFO (M_NICKNAME,M_PASSWORD,M_BIRTHYEAR,M_GENDER,M_JOINDATE) values ('망아지','rkskek123!',1972,1,to_date('22/09/28','RR/MM/DD'));
Insert into BUNA.MEMBERINFO (M_NICKNAME,M_PASSWORD,M_BIRTHYEAR,M_GENDER,M_JOINDATE) values ('미어캣','rkskek123!',1998,1,to_date('22/09/28','RR/MM/DD'));
Insert into BUNA.MEMBERINFO (M_NICKNAME,M_PASSWORD,M_BIRTHYEAR,M_GENDER,M_JOINDATE) values ('얼룩말','rkskek123!',1974,0,to_date('22/09/28','RR/MM/DD'));
Insert into BUNA.MEMBERINFO (M_NICKNAME,M_PASSWORD,M_BIRTHYEAR,M_GENDER,M_JOINDATE) values ('팬더','rkskek123!',1982,0,to_date('22/09/28','RR/MM/DD'));
Insert into BUNA.MEMBERINFO (M_NICKNAME,M_PASSWORD,M_BIRTHYEAR,M_GENDER,M_JOINDATE) values ('돼지','rkskek123!',1965,0,to_date('22/09/28','RR/MM/DD'));
Insert into BUNA.MEMBERINFO (M_NICKNAME,M_PASSWORD,M_BIRTHYEAR,M_GENDER,M_JOINDATE) values ('햄스터','rkskek123!',1981,0,to_date('22/09/28','RR/MM/DD'));

REM INSERTING into BUNA.SPOTDETAIL
SET DEFINE OFF;
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E28','명품 토마토를 사수하라!, 대저토마토축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E29','기장멸치의 변신은 무죄, 기장멸치축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E30','기장 봄바다의 맛, 기장미역다시마축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E01','세계 최고의 케이팝 콘서트, 부산원아시아페스티벌');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E02','영화속 음식을 다양하게 즐길 수 있는, 부산푸드필름페스타');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E03','영화로 물드는 부산의 10월, 부산국제영화제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E04','아름다운 부산 밤하늘의 하모니, 부산불꽃축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E05','음악에 적셔진 한 여름 밤의 열정, 부산국제록페스티벌');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E06','부산하면 여름 여름하면, 부산바다축제!');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E07','해양에 대한 모든 것, 부산항축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E08','동래 언덕 위에 피어나는 역사 속 그 날, 동래읍성 역사축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E09','어방이 궁금해? 궁금하면, 광안리어방축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E10','보고 듣고 맛보는 즐거움이 가득한, 부산자갈치축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E11','다대포 바다를 물들이는 예술의 향기, 부산바다미술제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E12','해운대 밤바다를 낭만으로 물들이는, 해운대빛축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E13','크리스마스트리의 향연, 부산크리스마스트리문화축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E14','구포나루의 추억과 낭만, 낙동강구포나루축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E15','샛노란 봄날의 유혹, 부산낙동강유채꽃축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E16','모래의 변신은 예술, 해운대모래축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E17','부산에서 만나는 중국의 흥!, 부산차이나타운특구 문화축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E18','한?일 양국에 피어나는 봄꽃, 조선통신사축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E19','미로 골목길 투어, 감천문화마을 골목축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E20','골목 분위기 제대로 즐기는, 부산원도심골목길축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E21','열정가득!  벚꽃가득!, 사상강변축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E22','오색찬란 연등터널, 삼광사 연등축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E23','태종대에서 만난 오색찬란, 수국 축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E24','몽환의 순간을 담다, 삼락벚꽃축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E25','보름달이 뜨는 밤엔, 해운대달맞이온천축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E26','한겨울의 짜릿함, 해운대북극곰축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('E27','문화로 노닐다, 금정산성축제');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A01','토요코인호텔 부산역1호점');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A02','아스티호텔 부산');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A03','라마다앙코르 부산역호텔');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A04','아몬드호텔');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A05','코모도호텔 부산');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A06','오름레지던스호텔');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A07','크라운하버호텔 부산');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A08','하운드호텔 부산역');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A09','노떼라미아호텔');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A10','더비에스호텔');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A11','부산뷰호텔');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A12','탑모텔');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('T02','부산역');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('T01','김해국제공항');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A13','파밀리에게스트하우스');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A14','토요코인 부산중앙역점');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A15','부산비즈니스호텔');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A16','이비스앰배서더호텔 부산시티센터점');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A17','롯데호텔 부산');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A18','아르반호텔');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A19','토요코인호텔 부산서면');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A20','솔라리아니시테츠호텔 부산점');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A21','티티호텔');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A22','경성여관');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A23','엔젤호텔');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A24','라이온호텔');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A25','TRT호텔');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A26','한화리조트 해운대');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A27','신라스테이 해운대');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A28','베니키아호텔 해운대');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A29','베니키아해운대호텔마리안느');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A30','파크하얏트 부산');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A31','베스트웨스턴 해운대호텔');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A32','파라다이스호텔 부산');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A34','해운대센텀호텔');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A35','라마다앙코르해운대호텔');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A36','센텀프리미어호텔');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A37','코오롱씨클라우드호텔');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A38','팔레드시즈');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A39','웨스틴조선 부산');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A40','이비스앰배서더 부산해운대');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('A41','해운대 그린나래호텔');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R01','본전돼지국밥');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R02','신발원');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R03','원조부산밀면');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R04','브라운핸즈 부산점');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R05','평산옥');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R06','신창국밥 부산역점');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R07','마가만두');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R08','홍성방 본점');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R09','스완양분식 본점');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R11','은하갈비');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R12','육전밀면 부산역본점');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R13','장성향');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R14','해운대암소갈비집');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R15','해운대가야밀면');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R18','그랜드애플');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R19','옵스 해운대점');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R21','상국이네');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R22','해성막창집 본점');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R23','어밤부');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R24','나가하마만게츠');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R27','타이가텐푸라');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R28','버거샵 해운대점');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R29','빨간떡볶이');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R30','의령식당');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R32','고반식당 부산해운대점');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R33','코지하우스');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R34','사카나식당');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R35','서면밀면');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R39','1984나폴리');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R41','서초갈비');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R42','FM커피하우스 1호점');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R43','프랭클린 커피로스터스');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R44','베르크로스터스');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R45','이너프');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R46','스노잉클라우드');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R47','비비비당');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R48','블랙업커피 해운대점');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R49','벨라비');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R50','브론즈웨인커피');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('R51','카페루프탑');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('T04','서면역');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('T05','동래역');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('T07','하단역');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('T11','센텀시티역');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('T03','구포역');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('T18','덕천역');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('T21','대연역');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('T23','교대역');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('T25','양정역');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('T26','부산역');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('T28','명륜역');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('T31','미남역');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('T32','전포역');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('T33','신평역');

REM INSERTING into BUNA.RESTAURANT
SET DEFINE OFF;
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R32','육류,고기','고반식당 부산해운대점','051-731-3353','부산 해운대구 구남로12번길 16','16:00','2:00','images/restaurantImg/gogi.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R33','양식','코지하우스','051-731-6683','부산 해운대구 우동1로 37','11:30','22:30','images/restaurantImg/pizza.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R34','초밥,롤','사카나식당','051-747-1342','부산 해운대구 우동1로 34','11:30','21:00','images/restaurantImg/susi.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R35','국수','서면밀면','051-817-2812','부산 부산진구 서전로 25','10:00','21:30','images/restaurantImg/milmyeon.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R39','이탈리안','1984나폴리','051-816-1984','부산 부산진구 전포대로209번길 17-6','12:00','22:00','images/restaurantImg/pizza.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R41','갈비','서초갈비','051-817-3391','부산 부산진구 동성로 151','16:00','23:00','images/restaurantImg/galbi.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R42','커피전문점','FM커피하우스 1호점','051-803-0926','부산 부산진구 전포대로199번길 26','11:00','22:00','images/restaurantImg/cafe.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R43','커피전문점','프랭클린 커피로스터스','051-756-0002','부산 부산진구 동성로 29','10:00','18:00','images/restaurantImg/cafe.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R44','커피전문점','베르크로스터스','051-817-2111','부산 부산진구 서전로58번길 115','10:00','18:30','images/restaurantImg/cafe.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R45','카페','이너프','051-803-8748','부산 부산진구 서전로37번길 26','12:00','21:00','images/restaurantImg/cafe.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R46','커피전문점','스노잉클라우드','051-747-8253','부산 해운대구 달맞이길117번가길 120-30','11:00','22:00','images/restaurantImg/cafe.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R47','전통찻집','비비비당','051-746-0705','부산 해운대구 달맞이길 239-16','10:30','22:00','images/restaurantImg/cafe.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R48','커피전문점','블랙업커피 해운대점','051-809-4952','부산 해운대구 중동2로 16','8:00','20:00','images/restaurantImg/cafe.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R49','카페','벨라비','051-704-9588','부산 해운대구 송정광어골로 25','10:30','23:00','images/restaurantImg/cafe.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R50','카페','브론즈웨인커피','051-747-9180','부산 해운대구 해운대해변로 332','11:00','21:00','images/restaurantImg/cafe.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R51','카페','카페루프탑','051-702-3007','부산 해운대구 청사포로 139-4','11:00','22:00','images/restaurantImg/cafe.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R01','국밥','본전돼지국밥','051-441-2946','부산 동구 중앙대로214번길 3-8','9:00','20:30','images/restaurantImg/gukbap.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R02','중식','신발원','051-467-0177','부산 동구 대영로243번길 62','11:00','20:00','images/restaurantImg/mandu.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R03','국수','원조부산밀면','051-466-6999','부산 동구 중앙대로231번길 7','10:30','19:00','images/restaurantImg/milmyeon.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R04','커피전문점','브라운핸즈 부산점','051-464-0332','부산 동구 중앙대로209번길 16','10:00','22:00','images/restaurantImg/cafe.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R05','육류,고기','평산옥','051-468-6255','부산 동구 초량중로 26','10:00','20:00','images/restaurantImg/suyuk.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R06','국밥','신창국밥 부산역점','051-465-7180','부산 동구 중앙대로214번길 3-4','7:00','23:00','images/restaurantImg/gukbap.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R07','중국요리','마가만두','051-468-4059','부산 동구 대영로243번길 56','11:00','21:00','images/restaurantImg/mandu.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R08','중국요리','홍성방 본점','051-468-9495','부산 동구 중앙대로179번길 16','11:00','21:30','images/restaurantImg/jajangmyeon.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R09','돈까스,우동','스완양분식 본점','051-634-2846','부산 동구 중앙대로236번길 7-5','11:30','20:00','images/restaurantImg/tonkatsu.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R11','갈비','은하갈비','051-467-4303','부산 동구 초량중로 86','11:00','23:00','images/restaurantImg/galbi.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R12','국수','육전밀면 부산역본점','051-441-1122','부산 동구 중앙대로221번가길 5','9:00','20:30','images/restaurantImg/milmyeon.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R13','중국요리','장성향','051-467-4496','부산 동구 대영로243번길 29','11:30','21:30','images/restaurantImg/jajangmyeon.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R14','한식','해운대암소갈비집','051-746-0033','부산 해운대구 중동2로10번길 32-10','11:30','22:00','images/restaurantImg/galbi.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R15','냉면','해운대가야밀면','051-747-9404','부산 해운대구 좌동순환로 27','10:00','20:50','images/restaurantImg/milmyeon.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R18','뷔페','그랜드애플','051-743-3331','부산 해운대구 센텀1로 25','12:00','21:00','images/restaurantImg/buffet.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R19','제과,베이커리','옵스 해운대점','051-747-6886','부산 해운대구 중동1로 31','8:00','22:00','images/restaurantImg/cafe.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R21','분식','상국이네','051-742-9001','부산 해운대구 구남로41번길 40-1','10:00','2:00','images/restaurantImg/bunsik.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R22','곱창,막창','해성막창집 본점','051-731-3113','부산 해운대구 중동1로19번길 29','16:30','3:00','images/restaurantImg/gogi.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R23','태국음식','어밤부','051-702-8183','부산 해운대구 송정광어골로 87','11:00','21:00','images/restaurantImg/ssalguksu.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R24','일본식라면','나가하마만게츠','051-731-0886','부산 해운대구 우동1로 57','11:00','20:00','images/restaurantImg/ramen.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R27','일본식','타이가텐푸라','051-731-1914','부산 해운대구 우동1로38번가길 15','11:00','20:00','images/restaurantImg/tendong.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R28','햄버거','버거샵 해운대점','051-747-4961','부산 해운대구 우동1로20번길 19','11:00','20:30','images/restaurantImg/hambuger.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R29','떡볶이','빨간떡볶이','051-743-2814','부산 해운대구 우동1로20번가길 4','8:30','18:30','images/restaurantImg/bunsik.jpg');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('R30','한식','의령식당','051-746-9661','부산 해운대구 우동1로50번길 15','8:30','21:00','images/restaurantImg/hanjeongsik.jpg');

REM INSERTING into BUNA.TRAFFIC
SET DEFINE OFF;
Insert into BUNA.TRAFFIC (S_SERIALNUM,TF_TYPE,TF_NAME,TF_PNUMBER,TF_LOCATION,TF_PHOTO) values ('T02','기차','부산역','051-464-9898','부산광역시 동구 중앙대로 206','images/trafficImg/busan.jpg');
Insert into BUNA.TRAFFIC (S_SERIALNUM,TF_TYPE,TF_NAME,TF_PNUMBER,TF_LOCATION,TF_PHOTO) values ('T01','공항','김해국제공항','051-974-3114','부산 강서구 공항진입로 108','images/trafficImg/GimhaeInternationalAirport.jpg');
Insert into BUNA.TRAFFIC (S_SERIALNUM,TF_TYPE,TF_NAME,TF_PNUMBER,TF_LOCATION,TF_PHOTO) values ('T03','기차','구포역','051-440-2496','부산 북구 구포만세길 82','images/trafficImg/gupo.jpg');
Insert into BUNA.TRAFFIC (S_SERIALNUM,TF_TYPE,TF_NAME,TF_PNUMBER,TF_LOCATION,TF_PHOTO) values ('T04','부산1호선','서면역','051-802-1410','부산 부산진구 중앙대로 지하 730','images/trafficImg/subway.png');
Insert into BUNA.TRAFFIC (S_SERIALNUM,TF_TYPE,TF_NAME,TF_PNUMBER,TF_LOCATION,TF_PHOTO) values ('T05','부산1호선','동래역','051-556-6042','부산 동래구 중앙대로 1324','images/trafficImg/subway.png');
Insert into BUNA.TRAFFIC (S_SERIALNUM,TF_TYPE,TF_NAME,TF_PNUMBER,TF_LOCATION,TF_PHOTO) values ('T07','부산1호선','하단역','051-208-8165','부산 사하구 낙동남로 지하 1415','images/trafficImg/subway.png');
Insert into BUNA.TRAFFIC (S_SERIALNUM,TF_TYPE,TF_NAME,TF_PNUMBER,TF_LOCATION,TF_PHOTO) values ('T11','부산2호선','센텀시티역','051-731-5505','부산 해운대구 센텀남대로 지하 76','images/trafficImg/subway.png');
Insert into BUNA.TRAFFIC (S_SERIALNUM,TF_TYPE,TF_NAME,TF_PNUMBER,TF_LOCATION,TF_PHOTO) values ('T18','부산2호선','덕천역','051-333-2322','부산 북구 금곡대로 지하 14','images/trafficImg/subway.png');
Insert into BUNA.TRAFFIC (S_SERIALNUM,TF_TYPE,TF_NAME,TF_PNUMBER,TF_LOCATION,TF_PHOTO) values ('T21','부산2호선','대연역','051-626-6417','부산 남구 수영로 지하 242','images/trafficImg/subway.png');
Insert into BUNA.TRAFFIC (S_SERIALNUM,TF_TYPE,TF_NAME,TF_PNUMBER,TF_LOCATION,TF_PHOTO) values ('T23','부산1호선','교대역','051-506-1661','부산 연제구 중앙대로 1217','images/trafficImg/subway.png');
Insert into BUNA.TRAFFIC (S_SERIALNUM,TF_TYPE,TF_NAME,TF_PNUMBER,TF_LOCATION,TF_PHOTO) values ('T25','부산1호선','양정역','051-983-1001','부산 부산진구 중앙대로 920','images/trafficImg/subway.png');
Insert into BUNA.TRAFFIC (S_SERIALNUM,TF_TYPE,TF_NAME,TF_PNUMBER,TF_LOCATION,TF_PHOTO) values ('T26','부산1호선','부산역','051-467-1009','부산 동구 중앙대로 197','images/trafficImg/subway.png');
Insert into BUNA.TRAFFIC (S_SERIALNUM,TF_TYPE,TF_NAME,TF_PNUMBER,TF_LOCATION,TF_PHOTO) values ('T28','부산1호선','명륜역','051-554-8701','부산 동래구 중앙대로 1414','images/trafficImg/subway.png');
Insert into BUNA.TRAFFIC (S_SERIALNUM,TF_TYPE,TF_NAME,TF_PNUMBER,TF_LOCATION,TF_PHOTO) values ('T31','부산4호선','미남역','051-503-3092','부산 동래구 아시아드대로246번길 3','images/trafficImg/subway.png');
Insert into BUNA.TRAFFIC (S_SERIALNUM,TF_TYPE,TF_NAME,TF_PNUMBER,TF_LOCATION,TF_PHOTO) values ('T32','부산2호선','전포역','051-802-4742','부산 부산진구 전포대로 지하 181','images/trafficImg/subway.png');
Insert into BUNA.TRAFFIC (S_SERIALNUM,TF_TYPE,TF_NAME,TF_PNUMBER,TF_LOCATION,TF_PHOTO) values ('T33','부산1호선','신평역','051-206-7522','부산 사하구 하신번영로 140','images/trafficImg/subway.png');

REM INSERTING into BUNA.EVENT
SET DEFINE OFF;
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E29','기장멸치의 변신은 무죄, 기장멸치축제','기장멸치축제','051-721-4063','부산 기장군 기장읍 대변리 444-20',to_date('22/05/20','RR/MM/DD'),to_date('22/05/22','RR/MM/DD'),'images/29.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=443&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc255394911058317');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E30','기장 봄바다의 맛, 기장미역다시마축제','삼기물산','051-721-0400','부산 기장군 일광읍 이동길 41',to_date('22/04/06','RR/MM/DD'),to_date('22/04/08','RR/MM/DD'),'images/30.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=441&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc255394911058317');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E25','보름달이 뜨는 밤엔, 해운대달맞이온천축제','해운대종합관광봉사센터 안내소','051-749-5700','부산 해운대구 해운대해변로 264',to_date('22/02/15','RR/MM/DD'),to_date('22/02/15','RR/MM/DD'),'images/25.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=502&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc255394911058317');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E26','한겨울의 짜릿함, 해운대북극곰축제','해운대종합관광봉사센터 안내소','051-749-5700','부산 해운대구 해운대해변로 264',to_date('22/06/11','RR/MM/DD'),to_date('22/06/20','RR/MM/DD'),'images/26.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=503&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc255394911058317');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E27','문화로 노닐다, 금정산성축제','네이처리퍼블릭 장전역점','051-581-1973','부산광역시 금정구 장전온천천로 144',to_date('22/05/26','RR/MM/DD'),to_date('22/05/29','RR/MM/DD'),'images/27.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=330&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc255394911058317');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E28','명품 토마토를 사수하라!, 대저토마토축제','부산대저토마토축제','051-971-4834','부산광역시 강서구 체육공원로 43',to_date('22/04/03','RR/MM/DD'),to_date('22/04/06','RR/MM/DD'),'images/28.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=497&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc255394911058317');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E21','열정가득!  벚꽃가득!, 사상강변축제','삼락생태공원','051-310-4088','부산 사상구 삼락동 29-46',to_date('22/03/01','RR/MM/DD'),to_date('22/03/30','RR/MM/DD'),'images/21.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=500&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc255394911058317');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E22','오색찬란 연등터널, 삼광사 연등축제','삼광사 연등축제 ','051-808-7111','부산광역시 부산진구 초읍천로43번길 77',to_date('22/04/22','RR/MM/DD'),to_date('22/05/08','RR/MM/DD'),'images/22.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=403&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc255394911058317');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E23','태종대에서 만난 오색찬란, 수국 축제','태종사','051-405-2626','부산광역시 영도구 전망로 119',to_date('22/01/01','RR/MM/DD'),to_date('22/12/31','RR/MM/DD'),'images/23.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=253&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc255394911058317');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E24','몽환의 순간을 담다, 삼락벚꽃축제','부산삼락벚꽃축제','051-310-3002','부산 사상구 삼락동 29-52',to_date('22/03/01','RR/MM/DD'),to_date('22/03/31','RR/MM/DD'),'images/24.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=499&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc255394911058317');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E03','영화로 물드는 부산의 10월, 부산국제영화제','영화의전당 야외극장','051-780-6000','부산광역시 해운대구 수영강변대로 120',to_date('22/10/05','RR/MM/DD'),to_date('22/10/14','RR/MM/DD'),'images/3.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=524&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc9e73ea0fd749ff1');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E04','아름다운 부산 밤하늘의 하모니, 부산불꽃축제','광안리해수욕장','051-610-4744','부산 수영구 광안해변로 219',to_date('22/11/05','RR/MM/DD'),to_date('22/11/05','RR/MM/DD'),'images/4.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=395&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc9e73ea0fd749ff1');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E01','세계 최고의 케이팝 콘서트, 부산원아시아페스티벌','부산사직종합운동장 부산아시아드주경기장','051-500-2134','부산 연제구 월드컵대로 344',to_date('22/10/27','RR/MM/DD'),to_date('22/10/30','RR/MM/DD'),'images/1.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=1062&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc9e73ea0fd749ff1');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E02','영화속 음식을 다양하게 즐길 수 있는, 부산푸드필름페스타','영화의전당 야외극장','051-780-6000','부산광역시 해운대구 수영강변대로 120',to_date('22/07/01','RR/MM/DD'),to_date('22/07/03','RR/MM/DD'),'images/2.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=807&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc9e73ea0fd749ff1');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E05','음악에 적셔진 한 여름 밤의 열정, 부산국제록페스티벌','삼락생태공원','051-310-4088','부산 사상구 삼락동 29-46',to_date('22/10/01','RR/MM/DD'),to_date('22/10/02','RR/MM/DD'),'images/5.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=470&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc9e73ea0fd749ff1');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E06','부산하면 여름 여름하면, 부산바다축제!','해운대종합관광봉사센터 안내소','051-749-5700','부산 해운대구 해운대해변로 264',to_date('22/07/30','RR/MM/DD'),to_date('22/08/07','RR/MM/DD'),'images/6.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=71&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc9e73ea0fd749ff1');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E07','해양에 대한 모든 것, 부산항축제','부산항국제전시컨벤션센터','051-400-1280','부산 동구 충장대로 206',to_date('22/07/02','RR/MM/DD'),to_date('22/07/03','RR/MM/DD'),'images/7.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=406&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc9e73ea0fd749ff1');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E08','동래 언덕 위에 피어나는 역사 속 그 날, 동래읍성 역사축제','동래문화회관 대극장','051-550-6611','부산광역시 동래구 문화로 80',to_date('22/10/14','RR/MM/DD'),to_date('22/10/16','RR/MM/DD'),'images/8.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=407&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc9e73ea0fd749ff1');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E09','어방이 궁금해? 궁금하면, 광안리어방축제','광안리해수욕장','051-610-4744','부산광역시 수영구 광안해변로 219',to_date('22/10/14','RR/MM/DD'),to_date('22/10/16','RR/MM/DD'),'images/9.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=442&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc9e73ea0fd749ff1');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E10','보고 듣고 맛보는 즐거움이 가득한, 부산자갈치축제','부산어패류처리조합 ','051-245-2594','부산광역시 중구 자갈치해안로 52',to_date('22/10/13','RR/MM/DD'),to_date('22/10/16','RR/MM/DD'),'images/10.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=411&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc9e73ea0fd749ff1');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E11','다대포 바다를 물들이는 예술의 향기, 부산바다미술제','다대포꿈의낙조분수 ','051-220-5891','부산광역시 사하구 몰운대1길 14',to_date('22/10/16','RR/MM/DD'),to_date('22/11/14','RR/MM/DD'),'images/11.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=427&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc9e73ea0fd749ff1');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E12','해운대 밤바다를 낭만으로 물들이는, 해운대빛축제','해운대종합관광봉사센터 안내소','051-749-5700','부산 해운대구 해운대해변로 264',to_date('21/11/27','RR/MM/DD'),to_date('22/02/02','RR/MM/DD'),'images/12.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=440&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc9e73ea0fd749ff1');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E13','크리스마스트리의 향연, 부산크리스마스트리문화축제','ABC마트 GS부산광복점','051-246-9900','부산 중구 광복중앙로 2',to_date('21/12/04','RR/MM/DD'),to_date('22/01/09','RR/MM/DD'),'images/13.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=449&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc9e73ea0fd749ff1');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E14','구포나루의 추억과 낭만, 낙동강구포나루축제','낙동강구포나루축제','051-309-4065','부산 북구 낙동대로1739번길 257',to_date('22/10/22','RR/MM/DD'),to_date('22/11/05','RR/MM/DD'),'images/14.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=331&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc9e73ea0fd749ff1');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E15','샛노란 봄날의 유혹, 부산낙동강유채꽃축제','부산 낙동강유채꽃축제','051-501-6051','부산 강서구 대저1동 2647',to_date('22/04/01','RR/MM/DD'),to_date('22/04/30','RR/MM/DD'),'images/15.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=496&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc9e73ea0fd749ff1');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E16','모래의 변신은 예술, 해운대모래축제를','해운대종합관광봉사센터 안내소','051-749-5700','부산 해운대구 해운대해변로 264',to_date('22/05/20','RR/MM/DD'),to_date('22/05/23','RR/MM/DD'),'images/16.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=405&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc9e73ea0fd749ff1');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E17','부산에서 만나는 중국의 흥!, 부산차이나타운특구 문화축제','초량차이나타운 ','051-440-4061','부산 동구 초량동 1109',to_date('22/10/13','RR/MM/DD'),to_date('22/10/16','RR/MM/DD'),'images/17.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=414&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc255394911058317');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E18','한?일 양국에 피어나는 봄꽃, 조선통신사축제','용두산공원 관리사무소','051-860-7820','부산광역시 중구 용두산길 37-55',to_date('22/05/05','RR/MM/DD'),to_date('22/05/08','RR/MM/DD'),'images/18.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=523&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc255394911058317');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E19','미로 골목길 투어, 감천문화마을 골목축제','감천문화마을 안내센터','051-204-1444','부산광역시 사하구 감내2로 203',to_date('22/10/28','RR/MM/DD'),to_date('22/10/29','RR/MM/DD'),'images/19.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=531&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc255394911058317');
Insert into BUNA.EVENT (S_SERIALNUM,E_NAME,E_VENUE,E_PNUMBER,E_LOCATION,E_STARTDATE,E_ENDDATE,E_PHOTO,E_URL) values ('E20','골목 분위기 제대로 즐기는, 부산원도심골목길축제','부산원도심 골목길축제','051-501-6051','부산 동구 초량동 994-50',to_date('22/06/11','RR/MM/DD'),to_date('22/06/12','RR/MM/DD'),'images/20.jpg','https://www.visitbusan.net/index.do?menuCd=DOM_000000201005001000&uc_seq=404&lang_cd=ko&pagingParms=4ca15f3a76a21f554a6e515f5344f50c4f734814d27260977c0eb574b1e0019a33f5a8e2dd587a9efb82cc91cf112987488312a3bc08c3054da8c190c930f6592e7894a7ed3cf424c17bc506baa57feb0aa608ee54ad79feb8b43e0becf2aedf306446a26175f37928b2e64d297ab48f8acfae3743ce2794ef15d99eb793341329c53a76d24a81ef72a11ca917970aac34400ec0365d93e364d7a859d58178e212648c28901350cb20330ec09b4e8c7ee5e2b8287a2a6536a889e832bf7d31f847bff6a467836ed9d75537b39410af399cbcba9ee6702cb3dbdfc37118061bdc6242d2505ff463a634757c4ad1fb5316c17e3c6c881b1202936a9591f574a9b458fe7ada378c8e24a939d38009efceb2f1d2f3d9fb0a84335999d70d74a175a02229fcd269f25ecae09cba47d7fa5b4ca79471889a1020e6226a199377b97ead69d777bcce27c101be7225c1ffeb0036367494277c22e6ec9cff0114e7cadf3a2d867367262d1b5f6a717ace24b4cae0734d3410c3de7cbbe8e8e2de4a08c9f7f2d71419b760deedc85bfd092d20cf83296e62049d974032c50fee7f8aa0e20719104acb04653baa264be502ef0f1cca19faf72dfd77b0bf1930b929eb2ee93dbea2f5bff2d9ad4661906d2630252c7a77755caae6cc44ce63bad15ddb06615ce3b6b3e2ad2ade8ddc56b9a8835779c8968497af73b9cee2d26904ec9ddb2852944561dc3a786f3e5c68c8e0e32ae35abb0978563b823f553103c0757fd7e769114895883f6c30f8d9107f51b43406263d9ba68fff184ad872b9b0efeefd8d3a2a809eb15b6818f12446d25d8cd7efecc255394911058317');
REM INSERTING into BUNA.ACCOMMODATION
SET DEFINE OFF;
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A11','호텔','부산뷰호텔','051-442-1248','부산 동구 중앙대로196번길 16-10','15:00','12:00','images/accommodationImg/hotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A12','여관,모텔','탑모텔','051-462-3755','부산 동구 중앙대로196번길 12-15','15:00','12:00','images/accommodationImg/motel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A13','게스트하우스','파밀리에게스트하우스','051-461-0080','부산 동구 중앙대로214번길 3-4 4,5층','15:00','12:00','images/accommodationImg/guesthouse.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A14','호텔','토요코인 부산중앙역점','051-442-1045','부산 중구 중앙대로 125','15:00','12:00','images/accommodationImg/hotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A15','호텔','부산비즈니스호텔','051-808-2000','부산 부산진구 부전로 67','14:00','12:00','images/accommodationImg/hotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A16','특급호텔','이비스앰배서더호텔 부산시티센터점','051-930-1100','부산 부산진구 중앙대로 777','14:00','12:00','images/accommodationImg/fivestarhotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A17','특급호텔','롯데호텔 부산','051-810-1000','부산 부산진구 가야대로 772','14:00','11:00','images/accommodationImg/fivestarhotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A18','호텔','아르반호텔','051-805-9901','부산 부산진구 중앙대로691번길 32','14:00','11:00','images/accommodationImg/hotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A19','호텔','토요코인호텔 부산서면','051-638-1045','부산 부산진구 서전로 39','15:00','11:00','images/accommodationImg/hotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A20','호텔','솔라리아니시테츠호텔 부산점','051-802-8585','부산 부산진구 서면로 20','15:00','11:00','images/accommodationImg/hotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A21','호텔','티티호텔','051-808-5514','부산 부산진구 새싹로 35','15:00','11:00','images/accommodationImg/hotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A22','호텔','경성여관','051-802-0090','부산 부산진구 서면문화로 26','15:00','11:00','images/accommodationImg/hotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A23','여관,모텔','엔젤호텔','051-802-8223','부산 부산진구 중앙대로692번길 46-7','15:00','11:00','images/accommodationImg/motel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A24','호텔','라이온호텔','051-808-3593','부산 부산진구 중앙대로691번가길 14-7','14:00','11:00','images/accommodationImg/hotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A25','호텔','TRT호텔','051-819-8231','부산 부산진구 부전로 33-1','14:00','11:00','images/accommodationImg/hotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A26','콘도,리조트','한화리조트 해운대','051-749-5500','부산 해운대구 마린시티3로 52','14:00','11:00','images/accommodationImg/condo.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A27','호텔','신라스테이 해운대','051-912-9000','부산 해운대구 해운대로570번길 46','14:00','11:00','images/accommodationImg/hotel2.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A28','호텔','베니키아호텔 해운대','051-760-7000','부산 해운대구 해운대해변로 317','14:00','11:00','images/accommodationImg/hotel2.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A29','호텔','베니키아해운대호텔마리안느','051-606-0600','부산 해운대구 해운대해변로 310','14:00','11:00','images/accommodationImg/hotel2.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A30','특급호텔','파크하얏트 부산','051-990-1234','부산 해운대구 마린시티1로 51','14:00','12:00','images/accommodationImg/fivestarhotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A31','특급호텔','베스트웨스턴 해운대호텔','051-664-1234','부산 해운대구 구남로 42','15:00','12:00','images/accommodationImg/fivestarhotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A32','특급호텔','파라다이스호텔 부산','051-742-2121','부산 해운대구 해운대해변로 296','15:00','12:00','images/accommodationImg/fivestarhotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A34','호텔','해운대센텀호텔','051-720-9000','부산 해운대구 센텀3로 20','15:00','12:00','images/accommodationImg/hotel2.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A35','호텔','라마다앙코르해운대호텔','051-610-3000','부산 해운대구 구남로 9','15:00','12:00','images/accommodationImg/hotel2.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A36','호텔','센텀프리미어호텔','051-755-9000','부산 해운대구 센텀1로 17','15:00','11:00','images/accommodationImg/hotel2.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A37','호텔','코오롱씨클라우드호텔','051-933-1000','부산 해운대구 해운대해변로 287','15:00','11:00','images/accommodationImg/hotel2.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A38','콘도,리조트','팔레드시즈','051-746-0985','부산 해운대구 해운대해변로298번길 24','15:00','11:00','images/accommodationImg/condo.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A39','특급호텔','웨스틴조선 부산','051-749-7000','부산 해운대구 동백로 67','14:00','11:00','images/accommodationImg/fivestarhotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A40','호텔','이비스앰배서더 부산해운대','051-630-1100','부산 해운대구 해운대해변로237번길 12','14:00','11:00','images/accommodationImg/hotel2.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A41','호텔','해운대 그린나래호텔','051-744-8160','부산 해운대구 해운대해변로 233','14:00','11:00','images/accommodationImg/hotel2.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A01','호텔','토요코인호텔 부산역1호점','051-466-1045','부산 동구 중앙대로196번길 12','15:00','11:00','images/accommodationImg/hotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A02','특급호텔','아스티호텔 부산','051-409-8888','부산 동구 중앙대로214번길 7-8','15:00','11:00','images/accommodationImg/fivestarhotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A03','호텔','라마다앙코르 부산역호텔','051-922-0000','부산 동구 중앙대로196번길 10','14:00','11:00','images/accommodationImg/hotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A04','호텔','아몬드호텔','051-469-1918','부산 동구 중앙대로196번길 12-5','15:00','11:00','images/accommodationImg/hotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A05','특급호텔','코모도호텔 부산','051-466-9101','부산 중구 중구로 151','15:00','11:00','images/accommodationImg/fivestarhotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A06','호텔','오름레지던스호텔','051-936-1123','부산 동구 중앙대로180번길 16-8','15:00','11:00','images/accommodationImg/hotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A07','호텔','크라운하버호텔 부산','051-678-1000','부산 중구 중앙대로 114','15:00','11:00','images/accommodationImg/hotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A08','호텔','하운드호텔 부산역','051-464-2000','부산 동구 중앙대로236번길 9','15:00','11:00','images/accommodationImg/hotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A09','호텔','노떼라미아호텔','051-462-7700','부산 동구 대영로 265 지하1층,1층,3~15층','15:00','11:00','images/accommodationImg/hotel.jpg');
Insert into BUNA.ACCOMMODATION (S_SERIALNUM,A_TYPE,A_NAME,A_PNUMBER,A_LOCATION,A_CHECKIN,A_CHECKOUT,A_PHOTO) values ('A10','여관,모텔','더비에스호텔','051-466-8400','부산 동구 중앙대로236번길 7-11','15:00','12:00','images/accommodationImg/motel.jpg');

REM INSERTING into BUNA.PLANINFO
SET DEFINE OFF;
Insert into BUNA.PLANINFO (P_ROWNUM,M_NICKNAME,P_TITLE,P_FIRSTDATE,P_LASTDATE,T_NAMELIST,P_REGDATE,P_LIKE,P_PUBLIC) values (2,'강아지','강아지플랜2',to_date('22/10/06','RR/MM/DD'),to_date('22/10/07','RR/MM/DD'),'#강 #풍경 #커플 #인스타 #산 #동물 #사진 #태그 #냠냠 ',to_date('22/09/27','RR/MM/DD'),8,1);
Insert into BUNA.PLANINFO (P_ROWNUM,M_NICKNAME,P_TITLE,P_FIRSTDATE,P_LASTDATE,T_NAMELIST,P_REGDATE,P_LIKE,P_PUBLIC) values (1,'강아지','강아지플랜1',to_date('22/10/05','RR/MM/DD'),to_date('22/10/07','RR/MM/DD'),'#사진 #바다 #인스타 #산 #커플 #풍경 ',to_date('22/09/27','RR/MM/DD'),2,1);
Insert into BUNA.PLANINFO (P_ROWNUM,M_NICKNAME,P_TITLE,P_FIRSTDATE,P_LASTDATE,T_NAMELIST,P_REGDATE,P_LIKE,P_PUBLIC) values (3,'염소','미어캣플랜2',to_date('22/10/06','RR/MM/DD'),to_date('22/10/07','RR/MM/DD'),'#강 #풍경 #커플 #인스타 #산 #동물 #사진 #태그 #냠냠 ',to_date('22/09/27','RR/MM/DD'),4,2);
Insert into BUNA.PLANINFO (P_ROWNUM,M_NICKNAME,P_TITLE,P_FIRSTDATE,P_LASTDATE,T_NAMELIST,P_REGDATE,P_LIKE,P_PUBLIC) values (4,'염소','염소플랜2',to_date('22/10/05','RR/MM/DD'),to_date('22/10/06','RR/MM/DD'),'#동물 #사진 #맛집 #산 #커플 #풍경 #강 #인스타 ',to_date('22/09/27','RR/MM/DD'),5,1);
Insert into BUNA.PLANINFO (P_ROWNUM,M_NICKNAME,P_TITLE,P_FIRSTDATE,P_LASTDATE,T_NAMELIST,P_REGDATE,P_LIKE,P_PUBLIC) values (5,'송아지','송아지플랜1',to_date('22/10/11','RR/MM/DD'),to_date('22/10/13','RR/MM/DD'),'#바다 #사진 #맛집 #송아지가떠나는여행 #커플 ',to_date('22/09/27','RR/MM/DD'),3,1);
Insert into BUNA.PLANINFO (P_ROWNUM,M_NICKNAME,P_TITLE,P_FIRSTDATE,P_LASTDATE,T_NAMELIST,P_REGDATE,P_LIKE,P_PUBLIC) values (6,'기린','기린플랜1',to_date('22/10/18','RR/MM/DD'),to_date('22/10/22','RR/MM/DD'),'#인스타 #동물 #사진 #산 #물 #목길이 ',to_date('22/09/27','RR/MM/DD'),3,1);
Insert into BUNA.PLANINFO (P_ROWNUM,M_NICKNAME,P_TITLE,P_FIRSTDATE,P_LASTDATE,T_NAMELIST,P_REGDATE,P_LIKE,P_PUBLIC) values (7,'원숭이','원숭이플랜1',to_date('22/10/30','RR/MM/DD'),to_date('22/11/01','RR/MM/DD'),'#사진 #바다 #인스타 ',to_date('22/09/27','RR/MM/DD'),6,1);
Insert into BUNA.PLANINFO (P_ROWNUM,M_NICKNAME,P_TITLE,P_FIRSTDATE,P_LASTDATE,T_NAMELIST,P_REGDATE,P_LIKE,P_PUBLIC) values (8,'치타','치타플랜1',to_date('22/10/03','RR/MM/DD'),to_date('22/10/05','RR/MM/DD'),'#맛집 #인스타 #산 #커플 #강 #풍경 #바다 #치타는빨라빠르면비행 ',to_date('22/09/27','RR/MM/DD'),3,1);
Insert into BUNA.PLANINFO (P_ROWNUM,M_NICKNAME,P_TITLE,P_FIRSTDATE,P_LASTDATE,T_NAMELIST,P_REGDATE,P_LIKE,P_PUBLIC) values (9,'고슴도치','고슴도치플랜1',to_date('22/10/26','RR/MM/DD'),to_date('22/10/27','RR/MM/DD'),'#동물 #사진 #산 #인스타 #커플 #풍경 #고슴도치는따가워 ',to_date('22/09/27','RR/MM/DD'),2,1);
Insert into BUNA.PLANINFO (P_ROWNUM,M_NICKNAME,P_TITLE,P_FIRSTDATE,P_LASTDATE,T_NAMELIST,P_REGDATE,P_LIKE,P_PUBLIC) values (10,'사슴','사슴플랜1',to_date('22/10/17','RR/MM/DD'),to_date('22/10/19','RR/MM/DD'),'#맛집 #사진 #산 #인스타 #커플 #풍경 #강 #동물 ',to_date('22/09/27','RR/MM/DD'),3,1);
Insert into BUNA.PLANINFO (P_ROWNUM,M_NICKNAME,P_TITLE,P_FIRSTDATE,P_LASTDATE,T_NAMELIST,P_REGDATE,P_LIKE,P_PUBLIC) values (11,'호랑이','호랑이플랜1',to_date('22/10/10','RR/MM/DD'),to_date('22/10/12','RR/MM/DD'),'#사진 #바다 #인스타 #풍경 #강 #동물 #커플 #맛집 #드라이브 ',to_date('22/09/27','RR/MM/DD'),3,1);
Insert into BUNA.PLANINFO (P_ROWNUM,M_NICKNAME,P_TITLE,P_FIRSTDATE,P_LASTDATE,T_NAMELIST,P_REGDATE,P_LIKE,P_PUBLIC) values (14,'미어캣','미어캣플랜2',to_date('22/10/06','RR/MM/DD'),to_date('22/10/07','RR/MM/DD'),'#강 #풍경 #커플 #인스타 #산 #동물 #사진 #태그 #냠냠 ',to_date('22/09/28','RR/MM/DD'),2,1);
Insert into BUNA.PLANINFO (P_ROWNUM,M_NICKNAME,P_TITLE,P_FIRSTDATE,P_LASTDATE,T_NAMELIST,P_REGDATE,P_LIKE,P_PUBLIC) values (12,'망아지','망아지플랜1',to_date('22/10/12','RR/MM/DD'),to_date('22/10/14','RR/MM/DD'),'#맛집 #바다 #드라이브 #커플 #인스타 ',to_date('22/09/28','RR/MM/DD'),2,1);
Insert into BUNA.PLANINFO (P_ROWNUM,M_NICKNAME,P_TITLE,P_FIRSTDATE,P_LASTDATE,T_NAMELIST,P_REGDATE,P_LIKE,P_PUBLIC) values (13,'미어캣','미어캣플랜1',to_date('22/10/22','RR/MM/DD'),to_date('22/10/23','RR/MM/DD'),'#동물 #드라이브 #커플 #주말 ',to_date('22/09/28','RR/MM/DD'),1,1);
Insert into BUNA.PLANINFO (P_ROWNUM,M_NICKNAME,P_TITLE,P_FIRSTDATE,P_LASTDATE,T_NAMELIST,P_REGDATE,P_LIKE,P_PUBLIC) values (15,'돼지','돼지플랜1',to_date('22/10/05','RR/MM/DD'),to_date('22/10/06','RR/MM/DD'),'#동물 #사진 #맛집 #산 #커플 #풍경 #강 #인스타 ',to_date('22/09/28','RR/MM/DD'),2,1);
Insert into BUNA.PLANINFO (P_ROWNUM,M_NICKNAME,P_TITLE,P_FIRSTDATE,P_LASTDATE,T_NAMELIST,P_REGDATE,P_LIKE,P_PUBLIC) values (16,'팬더','팬더플랜1',to_date('22/10/30','RR/MM/DD'),to_date('22/11/01','RR/MM/DD'),'#사진 #바다 #인스타 #강 #드라이브 ',to_date('22/09/28','RR/MM/DD'),1,1);
Insert into BUNA.PLANINFO (P_ROWNUM,M_NICKNAME,P_TITLE,P_FIRSTDATE,P_LASTDATE,T_NAMELIST,P_REGDATE,P_LIKE,P_PUBLIC) values (17,'햄스터','햄스터플랜1',to_date('22/10/26','RR/MM/DD'),to_date('22/10/28','RR/MM/DD'),'#맛집 #사진 #드라이브 #바다 #산 ',to_date('22/09/28','RR/MM/DD'),1,1);
Insert into BUNA.PLANINFO (P_ROWNUM,M_NICKNAME,P_TITLE,P_FIRSTDATE,P_LASTDATE,T_NAMELIST,P_REGDATE,P_LIKE,P_PUBLIC) values (18,'강아지','ㅍㄴㅇㅁㄹㄴㅇㅁㄹ',to_date('22/09/19','RR/MM/DD'),to_date('22/09/20','RR/MM/DD'),'#바다 #맛집 ',to_date('22/09/28','RR/MM/DD'),1,1);
Insert into BUNA.PLANINFO (P_ROWNUM,M_NICKNAME,P_TITLE,P_FIRSTDATE,P_LASTDATE,T_NAMELIST,P_REGDATE,P_LIKE,P_PUBLIC) values (19,'강아지','강아지플랜2',to_date('22/10/06','RR/MM/DD'),to_date('22/10/07','RR/MM/DD'),'#강 #풍경 #커플 #인스타 #산 #동물 #사진 #태그 #냠냠 ',to_date('22/09/28','RR/MM/DD'),0,1);

REM INSERTING into BUNA.PLANDETAIL
SET DEFINE OFF;
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (1,1,to_date('22/10/05','RR/MM/DD'),3,'E28','부산대저토마토축제');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (1,1,to_date('22/10/05','RR/MM/DD'),1,'R32','고반식당 부산해운대점');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (1,1,to_date('22/10/05','RR/MM/DD'),2,'R35','서면밀면');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (1,2,to_date('22/10/06','RR/MM/DD'),1,'R42','FM커피하우스 1호점');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (1,2,to_date('22/10/06','RR/MM/DD'),2,'E04','광안리해수욕장');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (1,2,to_date('22/10/06','RR/MM/DD'),3,'R05','평산옥');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (1,3,to_date('22/10/07','RR/MM/DD'),1,'E20','부산원도심 골목길축제');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (1,3,to_date('22/10/07','RR/MM/DD'),2,'R29','빨간떡볶이');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (1,3,to_date('22/10/07','RR/MM/DD'),3,'R23','어밤부');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (2,1,to_date('22/10/06','RR/MM/DD'),3,'T01','김해국제공항');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (2,1,to_date('22/10/06','RR/MM/DD'),4,'E30','삼기물산');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (2,1,to_date('22/10/06','RR/MM/DD'),5,'E26','해운대종합관광봉사센터 안내소');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (2,1,to_date('22/10/06','RR/MM/DD'),6,'T02','부산역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (2,1,to_date('22/10/06','RR/MM/DD'),7,'T01','김해국제공항');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (2,1,to_date('22/10/06','RR/MM/DD'),8,'T04','서면역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (3,1,to_date('22/10/07','RR/MM/DD'),1,'E29','기장멸치축제');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (3,1,to_date('22/10/07','RR/MM/DD'),2,'R44','베르크로스터스');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (3,2,to_date('22/10/08','RR/MM/DD'),1,'A27','신라스테이 해운대');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (3,2,to_date('22/10/08','RR/MM/DD'),2,'A07','크라운하버호텔 부산');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (4,1,to_date('22/10/05','RR/MM/DD'),1,'R32','고반식당 부산해운대점');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (4,1,to_date('22/10/05','RR/MM/DD'),2,'R24','나가하마만게츠');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (4,1,to_date('22/10/05','RR/MM/DD'),3,'E05','삼락생태공원');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (4,2,to_date('22/10/06','RR/MM/DD'),1,'E29','기장멸치축제');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (4,2,to_date('22/10/06','RR/MM/DD'),2,'R01','본전돼지국밥');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (4,2,to_date('22/10/06','RR/MM/DD'),3,'R28','버거샵 해운대점');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (5,1,to_date('22/10/11','RR/MM/DD'),1,'R46','스노잉클라우드');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (5,1,to_date('22/10/11','RR/MM/DD'),2,'E11','다대포꿈의낙조분수');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (5,1,to_date('22/10/11','RR/MM/DD'),3,'E16','해운대종합관광봉사센터 안내소');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (5,1,to_date('22/10/11','RR/MM/DD'),4,'R12','육전밀면 부산역본점');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (5,2,to_date('22/10/12','RR/MM/DD'),1,'T02','부산역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (5,2,to_date('22/10/12','RR/MM/DD'),2,'E04','광안리해수욕장');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (5,2,to_date('22/10/12','RR/MM/DD'),3,'R39','1984나폴리');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (5,3,to_date('22/10/13','RR/MM/DD'),1,'R35','서면밀면');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (5,3,to_date('22/10/13','RR/MM/DD'),2,'R47','비비비당');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (5,3,to_date('22/10/13','RR/MM/DD'),3,'R14','해운대암소갈비집');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (6,1,to_date('22/10/18','RR/MM/DD'),1,'T01','김해국제공항');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (6,1,to_date('22/10/18','RR/MM/DD'),2,'A11','부산뷰호텔');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (6,1,to_date('22/10/18','RR/MM/DD'),3,'R46','스노잉클라우드');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (6,1,to_date('22/10/18','RR/MM/DD'),4,'R51','카페루프탑');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (6,1,to_date('22/10/18','RR/MM/DD'),5,'E18','용두산공원 관리사무소');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (6,2,to_date('22/10/19','RR/MM/DD'),1,'E17','초량차이나타운');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (6,2,to_date('22/10/19','RR/MM/DD'),2,'R11','은하갈비');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (6,2,to_date('22/10/19','RR/MM/DD'),3,'R02','신발원');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (6,3,to_date('22/10/20','RR/MM/DD'),1,'R50','브론즈웨인커피');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (6,3,to_date('22/10/20','RR/MM/DD'),2,'R41','서초갈비');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (6,3,to_date('22/10/20','RR/MM/DD'),3,'R44','베르크로스터스');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (6,4,to_date('22/10/21','RR/MM/DD'),1,'R34','사카나식당');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (6,4,to_date('22/10/21','RR/MM/DD'),2,'R45','이너프');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (6,5,to_date('22/10/22','RR/MM/DD'),1,'R48','블랙업커피 해운대점');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (6,5,to_date('22/10/22','RR/MM/DD'),2,'R05','평산옥');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (6,5,to_date('22/10/22','RR/MM/DD'),3,'T01','김해국제공항');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (7,1,to_date('22/10/30','RR/MM/DD'),1,'A38','팔레드시즈');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (7,1,to_date('22/10/30','RR/MM/DD'),2,'R11','은하갈비');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (7,1,to_date('22/10/30','RR/MM/DD'),3,'R07','마가만두');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (7,2,to_date('22/10/31','RR/MM/DD'),1,'A34','해운대센텀호텔');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (7,2,to_date('22/10/31','RR/MM/DD'),2,'R02','신발원');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (7,2,to_date('22/10/31','RR/MM/DD'),3,'R12','육전밀면 부산역본점');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (7,3,to_date('22/11/01','RR/MM/DD'),1,'A39','웨스틴조선 부산');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (7,3,to_date('22/11/01','RR/MM/DD'),2,'R21','상국이네');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (7,3,to_date('22/11/01','RR/MM/DD'),3,'R13','장성향');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (8,1,to_date('22/10/03','RR/MM/DD'),1,'T04','서면역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (8,1,to_date('22/10/03','RR/MM/DD'),2,'T05','동래역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (8,1,to_date('22/10/03','RR/MM/DD'),3,'T07','하단역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (8,1,to_date('22/10/03','RR/MM/DD'),4,'T11','센텀시티역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (8,1,to_date('22/10/03','RR/MM/DD'),5,'T18','덕천역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (8,2,to_date('22/10/04','RR/MM/DD'),1,'T21','대연역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (8,2,to_date('22/10/04','RR/MM/DD'),2,'T23','교대역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (8,2,to_date('22/10/04','RR/MM/DD'),3,'T25','양정역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (8,2,to_date('22/10/04','RR/MM/DD'),4,'T26','부산역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (8,3,to_date('22/10/05','RR/MM/DD'),1,'T28','명륜역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (8,3,to_date('22/10/05','RR/MM/DD'),2,'T31','미남역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (8,3,to_date('22/10/05','RR/MM/DD'),3,'T32','전포역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (8,3,to_date('22/10/05','RR/MM/DD'),4,'T33','신평역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (9,1,to_date('22/10/26','RR/MM/DD'),1,'A11','부산뷰호텔');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (9,1,to_date('22/10/26','RR/MM/DD'),2,'A24','라이온호텔');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (9,1,to_date('22/10/26','RR/MM/DD'),3,'A25','TRT호텔');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (9,2,to_date('22/10/27','RR/MM/DD'),1,'A29','베니키아해운대호텔마리안느');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (9,2,to_date('22/10/27','RR/MM/DD'),2,'A31','베스트웨스턴 해운대호텔');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (9,2,to_date('22/10/27','RR/MM/DD'),3,'A35','라마다앙코르해운대호텔');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (10,1,to_date('22/10/17','RR/MM/DD'),1,'A11','부산뷰호텔');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (10,1,to_date('22/10/17','RR/MM/DD'),2,'R33','코지하우스');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (10,2,to_date('22/10/18','RR/MM/DD'),1,'A17','롯데호텔 부산');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (10,2,to_date('22/10/18','RR/MM/DD'),2,'A24','라이온호텔');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (10,3,to_date('22/10/19','RR/MM/DD'),1,'E01','부산사직종합운동장 부산아시아드주경기장');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (10,3,to_date('22/10/19','RR/MM/DD'),2,'E09','광안리해수욕장');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (11,1,to_date('22/10/10','RR/MM/DD'),1,'R42','FM커피하우스 1호점');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (11,1,to_date('22/10/10','RR/MM/DD'),2,'T32','전포역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (11,1,to_date('22/10/10','RR/MM/DD'),3,'E03','영화의전당 야외극장');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (11,2,to_date('22/10/11','RR/MM/DD'),1,'R48','블랙업커피 해운대점');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (11,2,to_date('22/10/11','RR/MM/DD'),2,'A26','한화리조트 해운대');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (11,2,to_date('22/10/11','RR/MM/DD'),3,'R43','프랭클린 커피로스터스');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (11,3,to_date('22/10/12','RR/MM/DD'),1,'R44','베르크로스터스');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (11,3,to_date('22/10/12','RR/MM/DD'),2,'R33','코지하우스');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (11,3,to_date('22/10/12','RR/MM/DD'),3,'T05','동래역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (12,1,to_date('22/10/12','RR/MM/DD'),3,'R34','사카나식당');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (12,1,to_date('22/10/12','RR/MM/DD'),4,'E24','부산삼락벚꽃축제');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (12,1,to_date('22/10/12','RR/MM/DD'),5,'R05','평산옥');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (12,1,to_date('22/10/12','RR/MM/DD'),6,'A11','부산뷰호텔');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (12,2,to_date('22/10/13','RR/MM/DD'),1,'R34','사카나식당');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (12,2,to_date('22/10/13','RR/MM/DD'),2,'R02','신발원');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (12,2,to_date('22/10/13','RR/MM/DD'),3,'E09','광안리해수욕장');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (12,1,to_date('22/10/12','RR/MM/DD'),1,'T02','부산역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (12,1,to_date('22/10/12','RR/MM/DD'),2,'A11','부산뷰호텔');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (12,2,to_date('22/10/13','RR/MM/DD'),4,'R02','신발원');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (12,2,to_date('22/10/13','RR/MM/DD'),5,'A11','부산뷰호텔');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (12,3,to_date('22/10/14','RR/MM/DD'),1,'R43','프랭클린 커피로스터스');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (12,3,to_date('22/10/14','RR/MM/DD'),2,'T02','부산역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (13,1,to_date('22/10/22','RR/MM/DD'),3,'E25','해운대종합관광봉사센터 안내소');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (13,2,to_date('22/10/23','RR/MM/DD'),1,'R32','고반식당 부산해운대점');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (13,2,to_date('22/10/23','RR/MM/DD'),2,'R51','카페루프탑');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (13,2,to_date('22/10/23','RR/MM/DD'),3,'T01','김해국제공항');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (2,2,to_date('22/10/07','RR/MM/DD'),1,'A27','신라스테이 해운대');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (2,2,to_date('22/10/07','RR/MM/DD'),2,'R01','본전돼지국밥');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (13,1,to_date('22/10/22','RR/MM/DD'),1,'T03','구포역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (13,1,to_date('22/10/22','RR/MM/DD'),2,'R32','고반식당 부산해운대점');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (2,2,to_date('22/10/07','RR/MM/DD'),3,'E13','ABC마트 GS부산광복점');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (2,1,to_date('22/10/06','RR/MM/DD'),1,'E26','해운대종합관광봉사센터 안내소');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (14,1,to_date('22/10/06','RR/MM/DD'),1,'E26','해운대종합관광봉사센터 안내소');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (2,1,to_date('22/10/06','RR/MM/DD'),2,'R39','1984나폴리');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (14,1,to_date('22/10/06','RR/MM/DD'),2,'R39','1984나폴리');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (14,1,to_date('22/10/06','RR/MM/DD'),3,'T01','김해국제공항');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (14,1,to_date('22/10/06','RR/MM/DD'),4,'E30','삼기물산');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (14,1,to_date('22/10/06','RR/MM/DD'),5,'E26','해운대종합관광봉사센터 안내소');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (14,1,to_date('22/10/06','RR/MM/DD'),6,'T02','부산역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (14,1,to_date('22/10/06','RR/MM/DD'),7,'T01','김해국제공항');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (14,1,to_date('22/10/06','RR/MM/DD'),8,'T04','서면역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (14,1,to_date('22/10/06','RR/MM/DD'),9,'E30','삼기물산');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (14,2,to_date('22/10/07','RR/MM/DD'),1,'A27','신라스테이 해운대');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (14,2,to_date('22/10/07','RR/MM/DD'),2,'R01','본전돼지국밥');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (14,2,to_date('22/10/07','RR/MM/DD'),3,'E13','ABC마트 GS부산광복점');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (15,1,to_date('22/10/05','RR/MM/DD'),1,'R32','고반식당 부산해운대점');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (15,1,to_date('22/10/05','RR/MM/DD'),2,'R24','나가하마만게츠');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (15,1,to_date('22/10/05','RR/MM/DD'),3,'E05','삼락생태공원');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (15,1,to_date('22/10/05','RR/MM/DD'),4,'A13','파밀리에게스트하우스');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (15,2,to_date('22/10/06','RR/MM/DD'),1,'E29','기장멸치축제');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (15,2,to_date('22/10/06','RR/MM/DD'),2,'R01','본전돼지국밥');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (15,2,to_date('22/10/06','RR/MM/DD'),3,'R28','버거샵 해운대점');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (15,2,to_date('22/10/06','RR/MM/DD'),4,'E27','네이처리퍼블릭 장전역점');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (16,1,to_date('22/10/30','RR/MM/DD'),1,'A38','팔레드시즈');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (16,1,to_date('22/10/30','RR/MM/DD'),2,'R11','은하갈비');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (16,1,to_date('22/10/30','RR/MM/DD'),3,'R07','마가만두');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (16,1,to_date('22/10/30','RR/MM/DD'),4,'A15','부산비즈니스호텔');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (16,2,to_date('22/10/31','RR/MM/DD'),1,'A34','해운대센텀호텔');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (16,2,to_date('22/10/31','RR/MM/DD'),2,'R02','신발원');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (16,2,to_date('22/10/31','RR/MM/DD'),3,'R12','육전밀면 부산역본점');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (16,2,to_date('22/10/31','RR/MM/DD'),4,'A18','아르반호텔');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (16,3,to_date('22/11/01','RR/MM/DD'),1,'A39','웨스틴조선 부산');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (16,3,to_date('22/11/01','RR/MM/DD'),2,'R21','상국이네');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (16,3,to_date('22/11/01','RR/MM/DD'),3,'R13','장성향');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (16,3,to_date('22/11/01','RR/MM/DD'),4,'A19','토요코인호텔 부산서면');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (17,1,to_date('22/10/26','RR/MM/DD'),3,'R39','1984나폴리');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (17,1,to_date('22/10/26','RR/MM/DD'),4,'E01','부산사직종합운동장 부산아시아드주경기장');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (17,1,to_date('22/10/26','RR/MM/DD'),5,'A21','티티호텔');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (17,2,to_date('22/10/27','RR/MM/DD'),1,'R33','코지하우스');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (17,2,to_date('22/10/27','RR/MM/DD'),2,'E27','네이처리퍼블릭 장전역점');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (17,2,to_date('22/10/27','RR/MM/DD'),3,'R42','FM커피하우스 1호점');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (17,1,to_date('22/10/26','RR/MM/DD'),1,'T01','김해국제공항');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (17,1,to_date('22/10/26','RR/MM/DD'),2,'R32','고반식당 부산해운대점');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (17,2,to_date('22/10/27','RR/MM/DD'),4,'A15','부산비즈니스호텔');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (17,3,to_date('22/10/28','RR/MM/DD'),1,'R41','서초갈비');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (17,3,to_date('22/10/28','RR/MM/DD'),2,'E27','네이처리퍼블릭 장전역점');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (17,3,to_date('22/10/28','RR/MM/DD'),3,'T03','구포역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (18,1,to_date('22/09/19','RR/MM/DD'),1,'T01','김해국제공항');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (18,1,to_date('22/09/19','RR/MM/DD'),2,'E26','해운대종합관광봉사센터 안내소');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (18,1,to_date('22/09/19','RR/MM/DD'),3,'R43','프랭클린 커피로스터스');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (18,2,to_date('22/09/20','RR/MM/DD'),1,'A18','아르반호텔');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (18,2,to_date('22/09/20','RR/MM/DD'),2,'E22','삼광사 연등축제');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (19,1,to_date('22/10/06','RR/MM/DD'),1,'E26','해운대종합관광봉사센터 안내소');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (19,1,to_date('22/10/06','RR/MM/DD'),2,'R39','1984나폴리');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (19,1,to_date('22/10/06','RR/MM/DD'),3,'T01','김해국제공항');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (19,1,to_date('22/10/06','RR/MM/DD'),4,'E30','삼기물산');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (19,1,to_date('22/10/06','RR/MM/DD'),5,'E26','해운대종합관광봉사센터 안내소');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (19,1,to_date('22/10/06','RR/MM/DD'),6,'T02','부산역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (19,1,to_date('22/10/06','RR/MM/DD'),7,'T01','김해국제공항');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (19,1,to_date('22/10/06','RR/MM/DD'),8,'T04','서면역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (19,1,to_date('22/10/06','RR/MM/DD'),9,'T02','부산역');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (19,2,to_date('22/10/07','RR/MM/DD'),1,'A27','신라스테이 해운대');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (19,2,to_date('22/10/07','RR/MM/DD'),2,'R01','본전돼지국밥');
Insert into BUNA.PLANDETAIL (P_ROWNUM,P_TRIPDAY,P_TRIPDATE,P_SEQUENCE,S_SERIALNUM,P_SPOTNAME) values (19,2,to_date('22/10/07','RR/MM/DD'),3,'E13','ABC마트 GS부산광복점');

REM INSERTING into BUNA.TAGLIST
SET DEFINE OFF;
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#강',23);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#바다',64);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#산',33);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#드라이브',136);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#커플',33);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#맛집',63);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#인스타',97);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#동물',66);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#사진',103);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#풍경',81);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('null',1);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#태그',4);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#냠냠',4);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#송아지가떠나는여행',1);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#물',1);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#목길이',1);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#고슴도치는따가워',1);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#주말',1);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#카페',1);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#황령산야경맛집',1);

REM INSERTING into BUNA.LIKEINFO
SET DEFINE OFF;
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('염소',3,2,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('강아지',1,0,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('강아지',2,0,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('염소',4,2,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('송아지',5,3,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('송아지',4,3,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('송아지',3,3,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('송아지',2,3,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('송아지',1,3,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('기린',6,4,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('기린',5,4,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('기린',2,4,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('원숭이',7,5,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('원숭이',2,5,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('원숭이',6,5,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('치타',8,6,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('치타',2,6,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('치타',4,6,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('치타',7,6,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('고슴도치',9,3,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('고슴도치',5,3,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('고슴도치',2,3,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('고슴도치',3,3,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('사슴',10,3,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('사슴',4,3,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('사슴',8,3,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('호랑이',11,2,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('호랑이',6,2,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('호랑이',10,2,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('호랑이',3,2,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('호랑이',7,2,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('강아지',7,2,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('망아지',12,5,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('망아지',2,5,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('망아지',7,5,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('망아지',10,5,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('망아지',11,5,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('미어캣',14,2,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('미어캣',13,2,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('미어캣',2,2,1);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('돼지',15,5,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('돼지',7,5,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('돼지',12,5,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('돼지',8,5,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('돼지',14,5,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('돼지',9,5,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('팬더',16,4,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('팬더',15,4,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('팬더',11,4,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('햄스터',17,4,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('햄스터',4,4,0);
Insert into BUNA.LIKEINFO (M_NICKNAME,P_ROWNUM,M_AGERANGE,M_GENDER) values ('강아지',18,2,0);