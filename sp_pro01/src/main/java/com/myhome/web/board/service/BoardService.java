package com.myhome.web.board.service;

import java.sql.SQLDataException;
import java.util.*;

import javax.servlet.http.HttpSession;

import org.apache.ibatis.cursor.Cursor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.myhome.web.board.controller.BoardController;
import com.myhome.web.board.model.BoardDAO;
import com.myhome.web.board.model.BoardDTO;
import com.myhome.web.board.model.BoardStatisDTO;
import com.myhome.web.board.vo.BoardVO;
import com.myhome.web.common.util.Paging;
import com.myhome.web.emp.model.EmpDTO;

@Service
public class BoardService {
	
	private static final Logger logger = LoggerFactory.getLogger(BoardService.class);

	@Autowired
	private BoardDAO dao;
	
	public List<BoardDTO> getAll() {
		logger.info("getAll()");
		List<BoardDTO> datas = dao.selectAll();
		return datas;
	}
	
	@Transactional
	public Paging getPage(int page, int limit) {
		logger.info("getPage(page={}, limit={})", page, limit);
		int totalRows = dao.getTotalRows();
		
		Paging paging = new Paging(page, limit, totalRows);
		dao.selectPage(paging);
		return paging;
	}
	
	public BoardDTO getData(int id) {
		logger.info("getData(id={})", id);
		BoardDTO data = dao.selectData(id);
		return data;
	}
	
	public int add(EmpDTO empDto, BoardVO data) {
		logger.info("add(empDto={}, data={})", empDto, data);
		BoardDTO boardDto = new BoardDTO();
		boardDto.setTitle(data.getTitle());
		boardDto.setContent(data.getContent());
		boardDto.setEmpId(empDto.getEmpId());
		
		boolean result = dao.insertData(boardDto);
		
		if(result) {
			return boardDto.getId();
		}
		return 0;
	}
	
	public boolean modify(BoardDTO data) {
		logger.info("modify(data={})", data);
		boolean result = dao.updateData(data);
		return result;
	}
	
	@Transactional
	public boolean remove(BoardDTO data) {
		logger.info("remove(data={})", data);
		
		dao.deleteStatisData(data);
		boolean result = dao.deleteData(data);
		return result;
	}
	
	@Transactional
	public void incViewCnt(EmpDTO empDto, BoardDTO data) {
		logger.info("incViewCnt(empDto={}, data={})", empDto, data);
		
		boolean result = false;
		BoardStatisDTO statisData = new BoardStatisDTO();
		statisData.setbId(data.getId());
		statisData.setEmpId(empDto.getEmpId());
		
		statisData = dao.selectStatis(statisData);
		
		if(statisData == null) {
			result = dao.updateViewCnt(data);
			if(!result) {
				throw new RuntimeException("BoardService.incViewCnt - 조회 수 업데이트 작업중 오류 발생");
			}
			statisData = new BoardStatisDTO();
			statisData.setbId(data.getId());
			statisData.setEmpId(empDto.getEmpId());
			
			result = dao.insertStatis(statisData);
			if(!result) {
				throw new RuntimeException("BoardService.incViewCnt - 통계 정보 추가 작업중 오류 발생");
			}
		} else {
			java.util.Date now = new java.util.Date();
			long timeDiff = now.getTime() - statisData.getLatestView().getTime();
			if(timeDiff / (1000 * 60 * 60 * 24) >= 7) {
				result = dao.updateViewCnt(data);
				if(!result) {
					throw new RuntimeException("BoardService.incViewCnt - 조회 수 업데이트 작업중 오류 발생");
				}
				dao.updateStatis(statisData);
				if(!result) {
					throw new RuntimeException("BoardService.incViewCnt - 통계 정보 업데이트 작업중 오류 발생");
				}
			}
		}
		
		if(result) {
			data.setViewCnt(data.getViewCnt() + 1);
		}
	}
	
	@Transactional(rollbackFor = SQLDataException.class)
	public void incLike(EmpDTO empDto, BoardDTO data) throws SQLDataException {
		logger.info("incLike(empDto={}, data={})", empDto, data);
		
		// 1. EMP_BOARDS_STATISTICS 테이블에서 추천 했던 기록을 찾는다.
		// 2. 찾은 기록에서 ISLIKE 컬럼의 값에 따라 다음의 작업을 진행한다.
		//     2-1. 찾은 기록에서 ISLIKE 컬럼의 값이 N 이면 Y로 변경 후
		//          EMP_BOARDS 에서 추천수 + 1 을 한다.
		//     2-2. 찾은 기록에서 ISLIKE 컬럼의 값이 Y 이면 N으로 변경 후
		//          EMP_BOARDS 에서 추천수 - 1 을 한다.
		
		boolean result = false;
		BoardStatisDTO statisData = new BoardStatisDTO();
		statisData.setbId(data.getId());
		statisData.setEmpId(empDto.getEmpId());
		
		statisData = dao.selectStatis(statisData);
		
		if(statisData.isLike()) {
			// 추천을 했음 -> 추천수 - 1 / 추천안함(false)
			statisData.setLike(false);
			data.setLike(data.getLike() - 1);
		} else {
			// 추천을 안 했음 -> 추천수 + 1 / 추천함(true)
			statisData.setLike(true);
			data.setLike(data.getLike() + 1);
		}
		
		result = dao.updateStatis(statisData, "like");
		if(!result) {
			throw new SQLDataException("BoardService.incLike - 추천 통계 업데이트 중 문제가 발생하였습니다.");
		}
		
		result = dao.updateLike(data);
		if(!result) {
			throw new SQLDataException("BoardService.incLike - 추천 수 업데이트 중 문제가 발생하였습니다.");
		}
	}
	
	/*
	public Paging getPage(String page, String limit, String search) {
		int totalRows = dao.getTotalRows(search);
		
		Paging paging = new Paging(Integer.parseInt(page), Integer.parseInt(limit), totalRows);
		dao.selectPage(paging, search);
		
		return paging;
	}
	*/
}