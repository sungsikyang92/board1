package com.mvc.board.service;

import java.util.List;

import com.mvc.board.dto.BoardDto;

public interface BoardService {
	List<BoardDto> getAllBoardList();
	List<BoardDto> getBoardDetailById(int id);
	
}
