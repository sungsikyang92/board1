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

}
