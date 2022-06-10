package com.mvc.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.board.dto.BoardDto;
import com.mvc.board.service.BoardService;
import com.mvc.board.service.impl.BoardServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	private final BoardService boardService;
	
	@GetMapping("/")
	public String getAllBoardList(Model model) {
		model.addAttribute("list", boardService.getAllBoardList());
		return "boardList";
	}
	
	@RequestMapping("/detail/{id}")
	public String getBoardDetail(@PathVariable(name="id") int id, 
			Model model) {
		for(BoardDto bdetail:boardService.getBoardDetailById(id)) {
			model.addAttribute("detail_author", bdetail.getAuthor());
			model.addAttribute("detail_title", bdetail.getTitle());
			model.addAttribute("detail_content", bdetail.getContent());
		}
		return "boardDetail";
	}
}
