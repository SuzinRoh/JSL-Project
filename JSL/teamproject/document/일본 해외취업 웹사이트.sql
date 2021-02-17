CREATE TABLE "tb_user" (
	"user_num"	number		NOT NULL,
	"user_name"	varchar2(20)		NULL,
	"user_email"	varchar2(50)		NULL,
	"user_pass"	varchar2(50)		NULL,
	"user_id"	varchar2(30)		NULL,
	"user_regidate"	date		NULL,
	"user_lastlogin"	date		NULL
);

CREATE TABLE "tb_user_resume" (
	"resume_num"	number		NOT NULL,
	"user_num"	number		NOT NULL,
	"resume_gender"	varchar2		NULL,
	"resume_ education"	varchar2		NULL,
	"resume_tel"	varcher2		NULL,
	"resume_picture_filename"	varchar2(100)		NULL,
	"resume_language"	varchar2		NULL,
	"resume_foreign_language"	varchar2		NULL,
	"resume_career"	varchar2		NULL,
	"resume_file"	varchar2		NULL,
	"resume_private"	number		NULL,
	"resume_readcnt"	number		NULL,
	"resume_regidate"	date		NULL,
	"resume_modifydate"	date		NULL,
	"resume_address"	varchar2(100)		NULL,
	"resume_certi"	varchar2(100)		NULL,
	"Field"	VARCHAR(255)		NULL
);

CREATE TABLE "tb_job_opening" (
	"Key"	NOT NULL		NOT NULL,
	"com_num2"	number		NOT NULL,
	"Field"	varchar2(40)		NULL,
	"Field2"	varchar2		NULL,
	"Field3"	varchar2		NULL,
	"Field4"	varchar2		NULL,
	"location"	varchar2(100)		NULL,
	"contents"	varchar2		NULL,
	"salary"	number		NULL,
	"opening_regidate"	date		NULL,
	"opening_startdate"	date		NULL,
	"opening_enddate"	date		NULL,
	"Field6"	varchar2		NULL
);

CREATE TABLE "tb_company" (
	"com_num"	number		NOT NULL,
	"com_name"	varchar2(30)		NULL,
	"com_empnum"	number		NULL,
	"com_tel"	varchar2(20)		NULL,
	"com_info"	varchar2		NULL,
	"com_webpage"	varchar2(40)		NULL,
	"com_confirmed"	boolean		NULL,
	"Field"	varchar2		NULL,
	"Field2"	date		NULL,
	"Field3"	varchar2		NULL,
	"Field4"	number		NULL,
	"Field5"	varchar2		NULL,
	"Field6"	VARCHAR(255)		NULL,
	"Field7"	VARCHAR(255)		NULL
);

CREATE TABLE "tb_portfolio" (
	"port_num"	number		NOT NULL,
	"user_num"	number		NOT NULL,
	"port_private"	boolean		NULL,
	"port_readcnt"	number		NULL,
	"port_regidate"	date		NULL,
	"port_modifydate"	date		NULL
);

CREATE TABLE "tb_admin" (
	"admin_num"	number		NOT NULL,
	"admin_id"	varchar2		NULL,
	"admin_pass"	varchar2		NULL
);

CREATE TABLE "tb_ilchon" (
	"user_num"	number		NOT NULL,
	"ilchon_num"	varchar2		NULL
);

CREATE TABLE "tb_cover_letter" (
	"cover_num"	number		NOT NULL,
	"cover_subject"	varchar2		NULL,
	"cover_contents"	varchar2		NULL,
	"user_num"	number		NOT NULL,
	"cover_regidate"	date		NULL,
	"cover_modifydate"	date		NULL
);

CREATE TABLE "tb_job_application" (
	"ja_num"	number		NOT NULL,
	"Key"	NOT NULL		NOT NULL,
	"user_num"	number		NOT NULL,
	"ja_regidate"	date		NULL
);

ALTER TABLE "tb_user" ADD CONSTRAINT "PK_TB_USER" PRIMARY KEY (
	"user_num"
);

ALTER TABLE "tb_user_resume" ADD CONSTRAINT "PK_TB_USER_RESUME" PRIMARY KEY (
	"resume_num"
);

ALTER TABLE "tb_job_opening" ADD CONSTRAINT "PK_TB_JOB_OPENING" PRIMARY KEY (
	"Key"
);

ALTER TABLE "tb_company" ADD CONSTRAINT "PK_TB_COMPANY" PRIMARY KEY (
	"com_num"
);

ALTER TABLE "tb_portfolio" ADD CONSTRAINT "PK_TB_PORTFOLIO" PRIMARY KEY (
	"port_num"
);

ALTER TABLE "tb_admin" ADD CONSTRAINT "PK_TB_ADMIN" PRIMARY KEY (
	"admin_num"
);

ALTER TABLE "tb_cover_letter" ADD CONSTRAINT "PK_TB_COVER_LETTER" PRIMARY KEY (
	"cover_num"
);

ALTER TABLE "tb_job_application" ADD CONSTRAINT "PK_TB_JOB_APPLICATION" PRIMARY KEY (
	"ja_num"
);

