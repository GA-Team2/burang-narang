--------------------------------------------------------
--  파일이 생성됨 - 금요일-9월-23-2022   
--------------------------------------------------------
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
REM INSERTING into BUNA.SPOTDETAIL
SET DEFINE OFF;
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('s01','해운대해수욕장');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('s02','광안리해수욕장');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('a01','다대포해수욕장');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('c50','서면역');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('a02','김해국제공항');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('re01','기장손칼국수');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('re02','부산식당');
Insert into BUNA.SPOTDETAIL (S_SERIALNUM,S_NAME) values ('re03','월남선생 부산덕천점');
REM INSERTING into BUNA.RESTAURANT
SET DEFINE OFF;
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('re01','한식','기장손칼국수','051-806-6832','부산 부산진구 서면로 56','01:00','01:00','ㄷㄷ');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('re02','한식','부산식당','051-512-0247','부산 금정구 중앙대로1720번길 16','01:00','01:00','ㄷㄷ');
Insert into BUNA.RESTAURANT (S_SERIALNUM,R_TYPE,R_NAME,R_PNUMBER,R_LOCATION,R_OPENTIME,R_CLOSETIME,R_PHOTO) values ('re03','한식','월남선생 부산덕천점','051-342-0116','부산 북구 금곡대로8번길 33','01:00','01:00','ㄷㄷ');
--------------------------------------------------------
--  DDL for Index PK_SPOTDETAIL
--------------------------------------------------------

  CREATE UNIQUE INDEX "BUNA"."PK_SPOTDETAIL" ON "BUNA"."SPOTDETAIL" ("S_SERIALNUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Index RESTAURANT_PK
--------------------------------------------------------

  CREATE UNIQUE INDEX "BUNA"."RESTAURANT_PK" ON "BUNA"."RESTAURANT" ("S_SERIALNUM") 
  PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  Constraints for Table SPOTDETAIL
--------------------------------------------------------

  ALTER TABLE "BUNA"."SPOTDETAIL" ADD CONSTRAINT "PK_SPOTDETAIL" PRIMARY KEY ("S_SERIALNUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 COMPUTE STATISTICS 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "BUNA"."SPOTDETAIL" MODIFY ("S_NAME" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."SPOTDETAIL" MODIFY ("S_SERIALNUM" NOT NULL ENABLE);
--------------------------------------------------------
--  Constraints for Table RESTAURANT
--------------------------------------------------------

  ALTER TABLE "BUNA"."RESTAURANT" ADD CONSTRAINT "RESTAURANT_PK" PRIMARY KEY ("S_SERIALNUM")
  USING INDEX PCTFREE 10 INITRANS 2 MAXTRANS 255 
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM"  ENABLE;
  ALTER TABLE "BUNA"."RESTAURANT" MODIFY ("R_PHOTO" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."RESTAURANT" MODIFY ("R_CLOSETIME" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."RESTAURANT" MODIFY ("R_OPENTIME" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."RESTAURANT" MODIFY ("R_LOCATION" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."RESTAURANT" MODIFY ("R_PNUMBER" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."RESTAURANT" MODIFY ("R_NAME" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."RESTAURANT" MODIFY ("R_TYPE" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."RESTAURANT" MODIFY ("S_SERIALNUM" NOT NULL ENABLE);
--------------------------------------------------------
--  Ref Constraints for Table RESTAURANT
--------------------------------------------------------

  ALTER TABLE "BUNA"."RESTAURANT" ADD CONSTRAINT "RESTAURANT_FK1" FOREIGN KEY ("S_SERIALNUM")
	  REFERENCES "BUNA"."SPOTDETAIL" ("S_SERIALNUM") ENABLE;
