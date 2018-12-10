package com.iu.s4;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.iu.board.BoardDTO;

@Controller
@RequestMapping("/qna/**")
public class QnaController {

	//list
	@RequestMapping(value="qnaList")
	public String list(Model model) {
		model.addAttribute("board","qna");
		return "board/boardList";
	}
	
	//select
	@RequestMapping(value="qnaSelect")
	public String select(Model model, int num) {
		model.addAttribute("board","qna");
		return "board/boardSelect";
	}
	
	//write Form
	@RequestMapping(value="qnaWrite",method=RequestMethod.GET)
	public String write(Model model) {
		model.addAttribute("board","qna");
		return "board/boardWrite";
	}

	//write process
	@RequestMapping(value="qnaWrite",method=RequestMethod.POST)
	public void write(BoardDTO boardDTO) {
		System.out.println("write:" + boardDTO.getTitle());
	}
	
	//update Form
	
	@RequestMapping(value="qnaUpdate",method=RequestMethod.GET)
	public String update(Model model) {
		model.addAttribute("board","qna");
		return "board/boardUpdate";
	}
	
	//update process
	@RequestMapping(value="qnaUpdate",method=RequestMethod.POST)
	public void update(BoardDTO boardDTO) {
		System.out.println("update :" +boardDTO.getTitle());
	}
	
	//delete process
	@RequestMapping(value="qnaDelete", method=RequestMethod.POST)
	public void delete(int num) {
		System.out.println("delete :"+num);
	}
	
	//reply Form
	@RequestMapping(value="qnaReply",method=RequestMethod.GET)
	public String reply(Model model) {
		model.addAttribute("board", "qna");
		return "board/boardReply";
	}
	//reply process
	@RequestMapping(value="qnaReply",method=RequestMethod.POST)
	public void reply(BoardDTO boardDTO	) {
		System.out.println("reply:" + boardDTO.getTitle());
	}

}
