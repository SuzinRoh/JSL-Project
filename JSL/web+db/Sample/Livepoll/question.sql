-- 설문조사 테이블
-- 테이블 구조 `tbl_question'

create table tbl_question (
	idx number not null ,			-- 고유번호/자동증가
	question varchar2(255) not null,	-- 질문 내용을 저장
	reply1 varchar2(100) ,			-- 답변1(사용자가 답변할 선택사항 1의 내용)
	reply2 varchar2(100) ,			-- 답변2(사용자가 답변할 선택사항 2의 내용)
	reply3 varchar2(100) ,			-- 답변3(사용자가 답변할 선택사항 3의 내용)
	reply4 varchar2(100) ,			-- 답변4(사용자가 답변할 선택사항 4의 내용)
	replynum1 number ,			-- 답변1(답변1의 응답자 수)
	replynum2 number ,			-- 답변2(답변2의 응답자 수)
	replynum3 number ,			-- 답변3(답변3의 응답자 수)
	replynum4 number ,			-- 답변4(답변4의 응답자 수)
	replytot  number ,			-- 전체 응답자 수
	regdate date not null,			-- 질문 등록일자
	primary key(num)			-- 기본키
);
create sequence tbl_question_seq_idx;
