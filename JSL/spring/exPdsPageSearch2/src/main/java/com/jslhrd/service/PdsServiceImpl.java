package com.jslhrd.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jslhrd.domain.PageVO;
import com.jslhrd.domain.PdsVO;
import com.jslhrd.mapper.PdsMapper;

import lombok.AllArgsConstructor;
import lombok.Setter;
@Service
@AllArgsConstructor
public class PdsServiceImpl implements PdsService {
	private static final Logger log = 
            LoggerFactory.getLogger(PdsServiceImpl.class);
	
	@Setter(onMethod_=@Autowired)
	private PdsMapper mapper;
	
	@Override
	public int pdsCount() {
		return mapper.pdsCount();
	}
	
	@Override
	public int pdsCountSearch(PageVO pg) {
		return mapper.pdsCountSearch(pg);
	}
/*
	@Override
	public List<PdsVO> pdsList() {
		return mapper.pdsList();
	}
*/
	@Override
	public List<PdsVO> pdsList(PageVO pg) {
		return mapper.pdsList(pg);
	}
	
	@Override
	public List<PdsVO> pdsListSearch(PageVO pg) {
		return mapper.pdsListSearch(pg);
	}
	
	@Override
	public int pdsWrite(PdsVO vo) {
		return mapper.pdsWrite(vo);
	}
	
	@Override
	public PdsVO pdsSelect(int idx) {
		return mapper.pdsSelect(idx);
	}
	
	@Override
	public void pdsHits(int idx) {
		mapper.pdsHits(idx);		
	}
	
	@Override
	public int pdsModify(PdsVO vo) {
		return mapper.pdsModify(vo);
	}
	
	@Override
	public int pdsDelete(PdsVO vo) {
		return mapper.pdsDelete(vo);
	}
}
