--------------------------------------------------------
--  ������ ������ - �����-9��-04-2025   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Sequence BOARD_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."BOARD_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 157 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Sequence MEMBER_SEQ
--------------------------------------------------------

   CREATE SEQUENCE  "SYSTEM"."MEMBER_SEQ"  MINVALUE 1 MAXVALUE 9999999999999999999999999999 INCREMENT BY 1 START WITH 8 NOCACHE  NOORDER  NOCYCLE ;
--------------------------------------------------------
--  DDL for Table BOARDTBL
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."BOARDTBL" 
   (	"BNUM" NUMBER, 
	"BTITLE" VARCHAR2(50 BYTE), 
	"BCONTENT" VARCHAR2(200 BYTE), 
	"BWRITER" VARCHAR2(20 BYTE), 
	"BHIT" NUMBER, 
	"BDATE" DATE DEFAULT sysdate
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table MEMBERTBL
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."MEMBERTBL" 
   (	"MEMBERNUM" NUMBER, 
	"MEMBERID" VARCHAR2(20 BYTE), 
	"MEMBERPW" VARCHAR2(20 BYTE), 
	"MEMBERNAME" VARCHAR2(20 BYTE), 
	"MEMBERDATE" DATE DEFAULT sysdate
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
--------------------------------------------------------
--  DDL for Table SEAT
--------------------------------------------------------

  CREATE TABLE "SYSTEM"."SEAT" 
   (	"SEATNAME" VARCHAR2(10 BYTE), 
	"RESERVED" NUMBER(1,0) DEFAULT 0, 
	"RESERVEID" VARCHAR2(50 BYTE), 
	"RESERVE_DATE" DATE DEFAULT sysdate
   ) PCTFREE 10 PCTUSED 40 INITRANS 1 MAXTRANS 255 NOCOMPRESS LOGGING
  STORAGE(INITIAL 65536 NEXT 1048576 MINEXTENTS 1 MAXEXTENTS 2147483645
  PCTINCREASE 0 FREELISTS 1 FREELIST GROUPS 1 BUFFER_POOL DEFAULT FLASH_CACHE DEFAULT CELL_FLASH_CACHE DEFAULT)
  TABLESPACE "SYSTEM" ;
REM INSERTING into SYSTEM.BOARDTBL
SET DEFINE OFF;
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (1,'�׽�Ʈ','1234','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (2,'���� ���� �����Դϴ�.1','���� ���� �����Դϴ�.1�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (3,'���� ���� �����Դϴ�.2','���� ���� �����Դϴ�.2�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (4,'���� ���� �����Դϴ�.3','���� ���� �����Դϴ�.3�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (5,'���� ���� �����Դϴ�.4','���� ���� �����Դϴ�.4�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (6,'���� ���� �����Դϴ�.5','���� ���� �����Դϴ�.5�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (7,'���� ���� �����Դϴ�.6','���� ���� �����Դϴ�.6�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (8,'���� ���� �����Դϴ�.7','���� ���� �����Դϴ�.7�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (9,'���� ���� �����Դϴ�.8','���� ���� �����Դϴ�.8�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (10,'���� ���� �����Դϴ�.9','���� ���� �����Դϴ�.9�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (11,'���� ���� �����Դϴ�.10','���� ���� �����Դϴ�.10�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (12,'���� ���� �����Դϴ�.11','���� ���� �����Դϴ�.11�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (13,'���� ���� �����Դϴ�.12','���� ���� �����Դϴ�.12�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (14,'���� ���� �����Դϴ�.13','���� ���� �����Դϴ�.13�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (15,'���� ���� �����Դϴ�.14','���� ���� �����Դϴ�.14�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (16,'���� ���� �����Դϴ�.15','���� ���� �����Դϴ�.15�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (17,'���� ���� �����Դϴ�.16','���� ���� �����Դϴ�.16�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (18,'���� ���� �����Դϴ�.17','���� ���� �����Դϴ�.17�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (19,'���� ���� �����Դϴ�.18','���� ���� �����Դϴ�.18�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (20,'���� ���� �����Դϴ�.19','���� ���� �����Դϴ�.19�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (21,'���� ���� �����Դϴ�.20','���� ���� �����Դϴ�.20�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (22,'���� ���� �����Դϴ�.21','���� ���� �����Դϴ�.21�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (23,'���� ���� �����Դϴ�.22','���� ���� �����Դϴ�.22�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (24,'���� ���� �����Դϴ�.23','���� ���� �����Դϴ�.23�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (25,'���� ���� �����Դϴ�.24','���� ���� �����Դϴ�.24�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (26,'���� ���� �����Դϴ�.25','���� ���� �����Դϴ�.25�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (27,'���� ���� �����Դϴ�.26','���� ���� �����Դϴ�.26�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (28,'���� ���� �����Դϴ�.27','���� ���� �����Դϴ�.27�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (29,'���� ���� �����Դϴ�.28','���� ���� �����Դϴ�.28�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (30,'���� ���� �����Դϴ�.29','���� ���� �����Դϴ�.29�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (31,'���� ���� �����Դϴ�.30','���� ���� �����Դϴ�.30�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (32,'���� ���� �����Դϴ�.31','���� ���� �����Դϴ�.31�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (33,'���� ���� �����Դϴ�.32','���� ���� �����Դϴ�.32�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (34,'���� ���� �����Դϴ�.33','���� ���� �����Դϴ�.33�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (35,'���� ���� �����Դϴ�.34','���� ���� �����Դϴ�.34�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (36,'���� ���� �����Դϴ�.35','���� ���� �����Դϴ�.35�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (37,'���� ���� �����Դϴ�.36','���� ���� �����Դϴ�.36�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (38,'���� ���� �����Դϴ�.37','���� ���� �����Դϴ�.37�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (39,'���� ���� �����Դϴ�.38','���� ���� �����Դϴ�.38�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (40,'���� ���� �����Դϴ�.39','���� ���� �����Դϴ�.39�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (41,'���� ���� �����Դϴ�.40','���� ���� �����Դϴ�.40�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (42,'���� ���� �����Դϴ�.41','���� ���� �����Դϴ�.41�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (43,'���� ���� �����Դϴ�.42','���� ���� �����Դϴ�.42�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (44,'���� ���� �����Դϴ�.43','���� ���� �����Դϴ�.43�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (45,'���� ���� �����Դϴ�.44','���� ���� �����Դϴ�.44�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (46,'���� ���� �����Դϴ�.45','���� ���� �����Դϴ�.45�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (47,'���� ���� �����Դϴ�.46','���� ���� �����Դϴ�.46�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (48,'���� ���� �����Դϴ�.47','���� ���� �����Դϴ�.47�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (49,'���� ���� �����Դϴ�.48','���� ���� �����Դϴ�.48�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (50,'���� ���� �����Դϴ�.49','���� ���� �����Դϴ�.49�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (51,'���� ���� �����Դϴ�.50','���� ���� �����Դϴ�.50�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (52,'���� ���� �����Դϴ�.51','���� ���� �����Դϴ�.51�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (53,'���� ���� �����Դϴ�.52','���� ���� �����Դϴ�.52�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (54,'���� ���� �����Դϴ�.53','���� ���� �����Դϴ�.53�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (55,'���� ���� �����Դϴ�.54','���� ���� �����Դϴ�.54�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (56,'���� ���� �����Դϴ�.55','���� ���� �����Դϴ�.55�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (57,'���� ���� �����Դϴ�.56','���� ���� �����Դϴ�.56�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (58,'���� ���� �����Դϴ�.57','���� ���� �����Դϴ�.57�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (59,'���� ���� �����Դϴ�.58','���� ���� �����Դϴ�.58�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (60,'���� ���� �����Դϴ�.59','���� ���� �����Դϴ�.59�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (61,'���� ���� �����Դϴ�.60','���� ���� �����Դϴ�.60�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (62,'���� ���� �����Դϴ�.61','���� ���� �����Դϴ�.61�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (63,'���� ���� �����Դϴ�.62','���� ���� �����Դϴ�.62�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (64,'���� ���� �����Դϴ�.63','���� ���� �����Դϴ�.63�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (65,'���� ���� �����Դϴ�.64','���� ���� �����Դϴ�.64�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (66,'���� ���� �����Դϴ�.65','���� ���� �����Դϴ�.65�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (67,'���� ���� �����Դϴ�.66','���� ���� �����Դϴ�.66�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (68,'���� ���� �����Դϴ�.67','���� ���� �����Դϴ�.67�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (69,'���� ���� �����Դϴ�.68','���� ���� �����Դϴ�.68�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (70,'���� ���� �����Դϴ�.69','���� ���� �����Դϴ�.69�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (71,'���� ���� �����Դϴ�.70','���� ���� �����Դϴ�.70�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (72,'���� ���� �����Դϴ�.71','���� ���� �����Դϴ�.71�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (73,'���� ���� �����Դϴ�.72','���� ���� �����Դϴ�.72�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (74,'���� ���� �����Դϴ�.73','���� ���� �����Դϴ�.73�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (75,'���� ���� �����Դϴ�.74','���� ���� �����Դϴ�.74�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (76,'���� ���� �����Դϴ�.75','���� ���� �����Դϴ�.75�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (77,'���� ���� �����Դϴ�.76','���� ���� �����Դϴ�.76�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (78,'���� ���� �����Դϴ�.77','���� ���� �����Դϴ�.77�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (79,'���� ���� �����Դϴ�.78','���� ���� �����Դϴ�.78�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (80,'���� ���� �����Դϴ�.79','���� ���� �����Դϴ�.79�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (81,'���� ���� �����Դϴ�.80','���� ���� �����Դϴ�.80�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (82,'���� ���� �����Դϴ�.81','���� ���� �����Դϴ�.81�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (83,'���� ���� �����Դϴ�.82','���� ���� �����Դϴ�.82�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (84,'���� ���� �����Դϴ�.83','���� ���� �����Դϴ�.83�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (85,'���� ���� �����Դϴ�.84','���� ���� �����Դϴ�.84�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (86,'���� ���� �����Դϴ�.85','���� ���� �����Դϴ�.85�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (87,'���� ���� �����Դϴ�.86','���� ���� �����Դϴ�.86�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (88,'���� ���� �����Դϴ�.87','���� ���� �����Դϴ�.87�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (89,'���� ���� �����Դϴ�.88','���� ���� �����Դϴ�.88�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (90,'���� ���� �����Դϴ�.89','���� ���� �����Դϴ�.89�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (91,'���� ���� �����Դϴ�.90','���� ���� �����Դϴ�.90�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (92,'���� ���� �����Դϴ�.91','���� ���� �����Դϴ�.91�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (93,'���� ���� �����Դϴ�.92','���� ���� �����Դϴ�.92�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (94,'���� ���� �����Դϴ�.93','���� ���� �����Դϴ�.93�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (95,'���� ���� �����Դϴ�.94','���� ���� �����Դϴ�.94�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (96,'���� ���� �����Դϴ�.95','���� ���� �����Դϴ�.95�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (97,'���� ���� �����Դϴ�.96','���� ���� �����Դϴ�.96�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (98,'���� ���� �����Դϴ�.97','���� ���� �����Դϴ�.97�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (99,'���� ���� �����Դϴ�.98','���� ���� �����Դϴ�.98�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (100,'���� ���� �����Դϴ�.99','���� ���� �����Դϴ�.99�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (101,'���� ���� �����Դϴ�.100','���� ���� �����Դϴ�.100�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (102,'���� ���� �����Դϴ�.101','���� ���� �����Դϴ�.101�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (103,'���� ���� �����Դϴ�.102','���� ���� �����Դϴ�.102�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (104,'���� ���� �����Դϴ�.103','���� ���� �����Դϴ�.103�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (105,'���� ���� �����Դϴ�.104','���� ���� �����Դϴ�.104�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (106,'���� ���� �����Դϴ�.105','���� ���� �����Դϴ�.105�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (107,'���� ���� �����Դϴ�.106','���� ���� �����Դϴ�.106�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (108,'���� ���� �����Դϴ�.107','���� ���� �����Դϴ�.107�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (109,'���� ���� �����Դϴ�.108','���� ���� �����Դϴ�.108�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (110,'���� ���� �����Դϴ�.109','���� ���� �����Դϴ�.109�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (111,'���� ���� �����Դϴ�.110','���� ���� �����Դϴ�.110�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (112,'���� ���� �����Դϴ�.111','���� ���� �����Դϴ�.111�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (113,'���� ���� �����Դϴ�.112','���� ���� �����Դϴ�.112�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (114,'���� ���� �����Դϴ�.113','���� ���� �����Դϴ�.113�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (115,'���� ���� �����Դϴ�.114','���� ���� �����Դϴ�.114�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (116,'���� ���� �����Դϴ�.115','���� ���� �����Դϴ�.115�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (117,'���� ���� �����Դϴ�.116','���� ���� �����Դϴ�.116�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (118,'���� ���� �����Դϴ�.117','���� ���� �����Դϴ�.117�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (119,'���� ���� �����Դϴ�.118','���� ���� �����Դϴ�.118�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (120,'���� ���� �����Դϴ�.119','���� ���� �����Դϴ�.119�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (121,'���� ���� �����Դϴ�.120','���� ���� �����Դϴ�.120�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (122,'���� ���� �����Դϴ�.121','���� ���� �����Դϴ�.121�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (123,'���� ���� �����Դϴ�.122','���� ���� �����Դϴ�.122�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (124,'���� ���� �����Դϴ�.123','���� ���� �����Դϴ�.123�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (125,'���� ���� �����Դϴ�.124','���� ���� �����Դϴ�.124�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (126,'���� ���� �����Դϴ�.125','���� ���� �����Դϴ�.125�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (127,'���� ���� �����Դϴ�.126','���� ���� �����Դϴ�.126�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (128,'���� ���� �����Դϴ�.127','���� ���� �����Դϴ�.127�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (129,'���� ���� �����Դϴ�.128','���� ���� �����Դϴ�.128�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (130,'���� ���� �����Դϴ�.129','���� ���� �����Դϴ�.129�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (131,'���� ���� �����Դϴ�.130','���� ���� �����Դϴ�.130�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (132,'���� ���� �����Դϴ�.131','���� ���� �����Դϴ�.131�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (133,'���� ���� �����Դϴ�.132','���� ���� �����Դϴ�.132�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (134,'���� ���� �����Դϴ�.133','���� ���� �����Դϴ�.133�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (135,'���� ���� �����Դϴ�.134','���� ���� �����Դϴ�.134�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (136,'���� ���� �����Դϴ�.135','���� ���� �����Դϴ�.135�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (137,'���� ���� �����Դϴ�.136','���� ���� �����Դϴ�.136�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (138,'���� ���� �����Դϴ�.137','���� ���� �����Դϴ�.137�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (139,'���� ���� �����Դϴ�.138','���� ���� �����Դϴ�.138�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (140,'���� ���� �����Դϴ�.139','���� ���� �����Դϴ�.139�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (141,'���� ���� �����Դϴ�.140','���� ���� �����Դϴ�.140�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (142,'���� ���� �����Դϴ�.141','���� ���� �����Դϴ�.141�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (143,'���� ���� �����Դϴ�.142','���� ���� �����Դϴ�.142�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (144,'���� ���� �����Դϴ�.143','���� ���� �����Դϴ�.143�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (145,'���� ���� �����Դϴ�.144','���� ���� �����Դϴ�.144�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (146,'���� ���� �����Դϴ�.145','���� ���� �����Դϴ�.145�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (147,'���� ���� �����Դϴ�.146','���� ���� �����Դϴ�.146�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (148,'���� ���� �����Դϴ�.147','���� ���� �����Դϴ�.147�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (149,'���� ���� �����Դϴ�.148','���� ���� �����Դϴ�.148�� �� �����Դϴ�','tiger',0,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (150,'���� ���� �����Դϴ�.149','���� ���� �����Դϴ�.149�� �� �����Դϴ�','tiger',1,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (151,'���� ���� �����Դϴ�.150','���� ���� �����Դϴ�.150�� �� �����Դϴ�','tiger',4,to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (152,'�� ���� �׽�Ʈ','�׽�Ʈ�Դϴ�','cat11',2,to_date('25/09/03','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (153,'�۾��� �׽�Ʈ2','12111','cat11',2,to_date('25/09/03','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (154,'�۾��� �׽�Ʈ3 ����1','33333','cat11',57,to_date('25/09/03','RR/MM/DD'));
Insert into SYSTEM.BOARDTBL (BNUM,BTITLE,BCONTENT,BWRITER,BHIT,BDATE) values (156,'�ȳ��ϼ��� tiger88�Դϴ�','���� Ÿ�̰� 88 �Դϴ�','tiger88',1,to_date('25/09/03','RR/MM/DD'));
REM INSERTING into SYSTEM.MEMBERTBL
SET DEFINE OFF;
Insert into SYSTEM.MEMBERTBL (MEMBERNUM,MEMBERID,MEMBERPW,MEMBERNAME,MEMBERDATE) values (1,'tiger','12345','ȫ�浿',to_date('25/09/02','RR/MM/DD'));
Insert into SYSTEM.MEMBERTBL (MEMBERNUM,MEMBERID,MEMBERPW,MEMBERNAME,MEMBERDATE) values (2,'cat1','1234','ȫ�浿',to_date('25/09/03','RR/MM/DD'));
Insert into SYSTEM.MEMBERTBL (MEMBERNUM,MEMBERID,MEMBERPW,MEMBERNAME,MEMBERDATE) values (3,'lion','1234','������',to_date('25/09/03','RR/MM/DD'));
Insert into SYSTEM.MEMBERTBL (MEMBERNUM,MEMBERID,MEMBERPW,MEMBERNAME,MEMBERDATE) values (4,'cat11','123123','ĹĹ',to_date('25/09/03','RR/MM/DD'));
Insert into SYSTEM.MEMBERTBL (MEMBERNUM,MEMBERID,MEMBERPW,MEMBERNAME,MEMBERDATE) values (5,'tiger1','1234','��浿',to_date('25/09/03','RR/MM/DD'));
Insert into SYSTEM.MEMBERTBL (MEMBERNUM,MEMBERID,MEMBERPW,MEMBERNAME,MEMBERDATE) values (6,'tiger8899','121345','ȫŸ�̰�',to_date('25/09/03','RR/MM/DD'));
Insert into SYSTEM.MEMBERTBL (MEMBERNUM,MEMBERID,MEMBERPW,MEMBERNAME,MEMBERDATE) values (7,'tiger88','12345','ȫ�浿',to_date('25/09/03','RR/MM/DD'));
REM INSERTING into SYSTEM.SEAT
SET DEFINE OFF;
Insert into SYSTEM.SEAT (SEATNAME,RESERVED,RESERVEID,RESERVE_DATE) values ('A1',1,'cat11',to_date('25/09/03','RR/MM/DD'));
Insert into SYSTEM.SEAT (SEATNAME,RESERVED,RESERVEID,RESERVE_DATE) values ('A2',1,'tiger88',to_date('25/09/03','RR/MM/DD'));
Insert into SYSTEM.SEAT (SEATNAME,RESERVED,RESERVEID,RESERVE_DATE) values ('A3',0,null,to_date('25/09/03','RR/MM/DD'));
Insert into SYSTEM.SEAT (SEATNAME,RESERVED,RESERVEID,RESERVE_DATE) values ('A4',0,null,to_date('25/09/03','RR/MM/DD'));
Insert into SYSTEM.SEAT (SEATNAME,RESERVED,RESERVEID,RESERVE_DATE) values ('A5',0,null,to_date('25/09/03','RR/MM/DD'));
Insert into SYSTEM.SEAT (SEATNAME,RESERVED,RESERVEID,RESERVE_DATE) values ('A6',0,null,to_date('25/09/03','RR/MM/DD'));
Insert into SYSTEM.SEAT (SEATNAME,RESERVED,RESERVEID,RESERVE_DATE) values ('A7',0,null,to_date('25/09/03','RR/MM/DD'));
Insert into SYSTEM.SEAT (SEATNAME,RESERVED,RESERVEID,RESERVE_DATE) values ('A8',0,null,to_date('25/09/03','RR/MM/DD'));
Insert into SYSTEM.SEAT (SEATNAME,RESERVED,RESERVEID,RESERVE_DATE) values ('A9',0,null,to_date('25/09/03','RR/MM/DD'));
Insert into SYSTEM.SEAT (SEATNAME,RESERVED,RESERVEID,RESERVE_DATE) values ('A10',1,'cat11',to_date('25/09/03','RR/MM/DD'));
