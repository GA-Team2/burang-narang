--------------------------------------------------------
--  파일이 생성됨 - 화요일-9월-27-2022   
--------------------------------------------------------
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
REM INSERTING into BUNA.TAGLIST
SET DEFINE OFF;
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#강',12);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#바다',52);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#산',18);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#드라이브',128);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#인스타',79);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#동물',54);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#사진',83);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#커플',25);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#맛집',59);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#풍경',76);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#태그',1);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#냠냠',1);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#송아지가떠나는여행',1);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#물',1);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#목길이',1);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#고슴도치는따가워',1);
--------------------------------------------------------
--  Constraints for Table TAGLIST
--------------------------------------------------------

  ALTER TABLE "BUNA"."TAGLIST" MODIFY ("T_NAME" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."TAGLIST" MODIFY ("T_HIT" NOT NULL ENABLE);
