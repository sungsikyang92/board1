package com.mvc.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.board.service.impl.BoardServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class BoardController {
	private final BoardServiceImpl boardServiceImpl;
	
	@GetMapping("/")
	public String getAllBoardList(Model model) {
		model.addAttribute("list", boardServiceImpl.getAllBoardList());
		return "boardList";
	}
}
