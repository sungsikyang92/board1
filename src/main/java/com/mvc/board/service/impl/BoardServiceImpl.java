package com.mvc.board.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.mvc.board.dao.BoardDao;
import com.mvc.board.dto.BoardDto;
import com.mvc.board.service.BoardService;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class BoardServiceImpl implements BoardService{
	private final BoardDao boardDao;
	@Override
	public List<BoardDto> getAllBoardList() {
		List<BoardDto> list = boardDao.getAllBoardList();
		return list;
	}
	@Override
	public List<BoardDto> getBoardDetailById(int id) {
		List<BoardDto> list = boardDao.getBoardDetailById(id);
		return list;
	}
	@Override
	public int insertToBoard(BoardDto boardDto) {
		int result = boardDao.insertToBoard(boardDto);
		return result;
	}
	@Override
	public int updateBaord(BoardDto boardDto) {
		int result = boardDao.updateBaord(boardDto);
		return result;
	}
	@Override
	public int deleteBoard(int id) {
		int result = boardDao.deleteBoard(id);
		return result;
	}

}
