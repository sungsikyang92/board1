package com.mvc.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mvc.board.dto.BoardDto;
import com.mvc.board.service.BoardService;

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
	public String getBoardDetail(@PathVariable(name = "id") int id, Model model) {
		for (BoardDto bdetail : boardService.getBoardDetailById(id)) {
			model.addAttribute("detail_author", bdetail.getAuthor());
			model.addAttribute("detail_title", bdetail.getTitle());
			model.addAttribute("detail_content", bdetail.getContent());
			model.addAttribute("detail_id", bdetail.getId());
		}
		return "boardDetail";
	}

	@RequestMapping("/writeButton")
	public String writeButton() {
		return "boardWrite";
	}

	@PostMapping("/boardwrite")
	public String insertWrite(BoardDto dto) {
		int result = boardService.insertToBoard(dto);

		if (result > 0) {
			return "redirect:/";
		} else {
			return "redirect:writeButton";
		}
	}

	@RequestMapping("/updateButton/{id}")
	public String updateButton(@PathVariable(name = "id") int id, Model model) {
		for (BoardDto bdetail : boardService.getBoardDetailById(id)) {
			model.addAttribute("update_author", bdetail.getAuthor());
			model.addAttribute("update_title", bdetail.getTitle());
			model.addAttribute("update_content", bdetail.getContent());
			model.addAttribute("update_id", bdetail.getId());
		}
		return "updateWrite";
	}

	@PostMapping("/updatewrite")
	public String updateWrite(BoardDto dto) {
		int result = boardService.updateBaord(dto);
		if (result > 0) {
			return "redirect:detail/" + dto.getId();
		} else {
			return "redirect:/updateButton/" + dto.getId();
		}
	}
	
	@RequestMapping("/deleteButton/{id}")
	public String deleteButton(@PathVariable(name="id")int id) {
		int result = boardService.deleteBoard(id);
		if (result >0) {
			return "redirect:/";
		}else {
			return "/detail/"+id;
		}
	}
}
