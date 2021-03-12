package com.jslhrd.mapper;

import java.util.List;

import com.jslhrd.domain.PageVO;
import com.jslhrd.domain.PdsVO;

public interface PdsMapper {
	// 전체 게시물 카운트
	public int pdsCount();

	// 검색조건에 맞는 게시물 카운트
	public int pdsCountSearch(PageVO pg);

/*	
	// 전체목록(검색 및 Page 처리 없음)
	public List<PdsVO> pdsList();
*/
	// 전체목록(Page처리) 추가
	public List<PdsVO> pdsList(PageVO pg);
	
	// 전체목록(Page처리 + 검색) 추가
	public List<PdsVO> pdsListSearch(PageVO pg);
	
	// 특정 게시물 검색(view, modify)
	public PdsVO pdsSelect(int idx);
	
	//조회수 증가
	public void pdsHits(int idx);
	
	// 등록
	public int pdsWrite(PdsVO vo);
	
	// 수정처리
	public int pdsModify(PdsVO vo);
	
	// 삭제
	public int pdsDelete(PdsVO vo);
}
