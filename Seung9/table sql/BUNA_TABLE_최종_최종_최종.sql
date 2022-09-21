CREATE TABLE "PLANINFO" (
	"P_ROWNUM"	NUMBER		NOT NULL,
	"M_NICKNAME"	VARCHAR2(18)		NOT NULL,
	"P_TITLE"	VARCHAR2(255)		NOT NULL,
	"P_FIRSTDATE"	DATE		NOT NULL,
	"P_LASTDATE"	DATE		NOT NULL,
	"T_NAMELIST"	VARCHAR2(255)		NULL,
	"P_REGDATE"	DATE		NOT NULL,
	"P_LIKE"	NUMBER		NOT NULL,
	"P_PUBLIC"	NUMBER(1)		NOT NULL
);

CREATE TABLE "MEMBERINFO" (
	"M_NICKNAME"	VARCHAR2(18)		NOT NULL,
	"M_PASSWORD"	VARCHAR2(50)		NOT NULL,
	"M_BIRTHYEAR"	NUMBER(4)		NOT NULL,
	"M_GENDER"	NUMBER(1)		NOT NULL,
	"M_JOINDATE"	DATE		NOT NULL
);

CREATE TABLE "TAGLIST" (
	"T_NAME"	VARCHAR2(30)		NOT NULL,
	"T_HIT"	NUMBER		NOT NULL
);

CREATE TABLE "PLANDETAIL" (
	"P_ROWNUM"	NUMBER		NOT NULL,
	"P_TRIPDAY"	NUMBER		NOT NULL,
	"P_TRIPDATE"	DATE		NOT NULL,
	"P_SEQUENCE"	NUMBER		NOT NULL,
	"S_SERIALNUM"	VARCHAR2(18)		NOT NULL,
	"P_SPOTNAME"	VARCHAR2(255)		NOT NULL
);

CREATE TABLE "SPOTDETAIL" (
	"S_SERIALNUM"	VARCHAR2(50)		NOT NULL,
	"S_NAME"	VARCHAR2(255)		NOT NULL
);

CREATE TABLE "ACCOMMODATION" (
	"S_SERIALNUM"	VARCHAR2(18)		NOT NULL,
	"A_TYPE"	VARCHAR2(20)		NULL,
	"A_NAME"	VARCHAR2(255)		NOT NULL,
	"A_LOCATION"	VARCHAR2(255)		NOT NULL,
	"A_CHECKIN"	DATE		NOT NULL,
	"A_CHECKOUT"	DATE		NOT NULL,
	"A_PHOTO"	VARCHAR2(255)		NULL
);

CREATE TABLE "RESTAURANT" (
	"S_SERIALNUM"	VARCHAR2(18)		NOT NULL,
	"R_TYPE"	VARCHAR2(20)		NULL,
	"R_NAME"	VARCHAR2(255)		NOT NULL,
	"R_LOCATION"	VARCHAR2(255)		NOT NULL,
	"R_OPENTIME"	DATE		NOT NULL,
	"R_CLOSETIME"	DATE		NOT NULL,
	"R_PHOTO"	VARCHAR2(255)		NOT NULL
);

CREATE TABLE "EVENT" (
	"S_SERIALNUM"	VARCHAR2(18)		NOT NULL,
	"E_NAME"	VARCHAR2(255)		NOT NULL,
	"E_LOCATION"	VARCHAR2(255)		NOT NULL,
	"E_STARTDATE"	DATE		NOT NULL,
	"E_ENDDATE"	DATE		NOT NULL,
	"E_PHOTO"	VARCHAR2(255)		NOT NULL,
	"E_URL"	VARCHAR2(2000)		NULL
);

CREATE TABLE "LIKEINFO" (
	"M_NICKNAME"	VARCHAR2(18)		NOT NULL,
	"P_ROWNUM"	NUMBER		NOT NULL,
	"M_AGERANGE"	NUMBER(3)		NULL,
	"M_GENDER"	NUMBER(1)		NOT NULL
);

