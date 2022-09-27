--------------------------------------------------------
--  ������ ������ - ȭ����-9��-27-2022   
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
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#��',12);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#�ٴ�',52);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#��',18);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#����̺�',128);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#�ν�Ÿ',79);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#����',54);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#����',83);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#Ŀ��',25);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#����',59);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#ǳ��',76);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#�±�',1);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#�ȳ�',1);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#�۾����������¿���',1);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#��',1);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#�����',1);
Insert into BUNA.TAGLIST (T_NAME,T_HIT) values ('#����ġ�µ�����',1);
--------------------------------------------------------
--  Constraints for Table TAGLIST
--------------------------------------------------------

  ALTER TABLE "BUNA"."TAGLIST" MODIFY ("T_NAME" NOT NULL ENABLE);
  ALTER TABLE "BUNA"."TAGLIST" MODIFY ("T_HIT" NOT NULL ENABLE);
