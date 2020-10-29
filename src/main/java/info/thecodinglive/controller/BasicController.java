package info.thecodinglive.controller;


import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import info.thecodinglive.model.Board;
import info.thecodinglive.repository.BoardRepository;
import info.thecodinglive.service.BoardService;

@RestController
@RequestMapping(value = "")	
public class BasicController {
	//http://localhost:8080/board/insert
	@Autowired
	BoardService boardService; 
	
	@RequestMapping("/board/form")
	public ModelAndView insertForm(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/form");
		
		if (session != null) {
			System.out.println("check username " + session.getAttribute("userName"));
			mv.addObject("userNameSe", session.getAttribute("userName"));
		}
		
		return mv;
	}
	@RequestMapping(value = "/home")
	public ModelAndView Homepage(HttpServletRequest req, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/index");
		
		if (session != null) {
			if(session.getAttribute("userName") != null) {
				System.out.println("check username " + session.getAttribute("userName"));
				mv.addObject("userNameSe", session.getAttribute("userName"));
			}
		}
		
		return mv;
	}
	
	@RequestMapping(value = "/summary")
	public ModelAndView Homepage2(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/summary");
		
		if (session != null) {
			System.out.println("check username " + session.getAttribute("userName"));
			mv.addObject("userNameSe", session.getAttribute("userName"));
		}
		
		return mv;
	}
	@RequestMapping(value = "/company")
	public ModelAndView Homepage3(HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/Company");
		
		if (session != null) {
			System.out.println("check username " + session.getAttribute("userName"));
			mv.addObject("userNameSe", session.getAttribute("userName"));
		}
		
		return mv;
	}
	
	@RequestMapping("/login")
	public ModelAndView loginForm() {
		ModelAndView mv = new ModelAndView();
		mv.setViewName("board/login");
	
		return mv;
	}
	
	
	
	@RequestMapping("/list")//
	public ModelAndView list(@PageableDefault(size=10,sort = "id",direction = Sort.Direction.DESC) Pageable pageable, HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardList",boardService.findBoardList(pageable));
//		mv.setViewName("board/test1");
		
		if (session != null) {
			System.out.println("check username " + session.getAttribute("userName"));
			mv.addObject("userNameSe", session.getAttribute("userName"));
		}
		
		mv.setViewName("board/list");
		return mv;
	}
	
	@GetMapping("/board")
	public ModelAndView board(@RequestParam(value = "id",defaultValue = "0") Integer id , HttpSession session) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("board",boardService.findBoardById(id));
		mv.setViewName("board/form");
		
		if (session != null) {
			System.out.println("check username " + session.getAttribute("userName"));
			mv.addObject("userNameSe", session.getAttribute("userName"));
		}

		return mv;
	}
	@GetMapping("/boardview")
	public ModelAndView board2(@RequestParam(value = "id",defaultValue = "0") Integer id , HttpSession session) {
		ModelAndView mv = new ModelAndView();
		Board board = boardService.findBoardById(id);
		board.setViewcount(board.getViewcount()+1);
		boardService.save(board);
		mv.addObject("board",board);
		mv.setViewName("board/boardview");
		
		if (session != null) {
			System.out.println("check username " + session.getAttribute("userName"));
			mv.addObject("userNameSe", session.getAttribute("userName"));
		}

		return mv;
	}
	
	
	@PostMapping("/insert")
	public ResponseEntity<Board> insert(@RequestBody Board board){
		boardService.save(board);
		
		return new ResponseEntity(board,HttpStatus.CREATED);
	}
	
	@Transactional
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateBoard(@PathVariable int id,@RequestBody Board reqBoard) {
		Board board = boardService.findBoardById(id);
		board.setTitle(reqBoard.getTitle());
		board.setContent(reqBoard.getContent());
		//boardService.save(board);
		return new ResponseEntity<>("{}",HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<?> deleteBoard(@PathVariable int id){
		try {
			boardService.deleteById(id);

		} catch (Exception e) {
			System.out.println("====>"+e);
		}
		return new ResponseEntity<>("{}",HttpStatus.OK);
	}
}
