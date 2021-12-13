package com.hyuns.svtcafe.controller;

import com.hyuns.svtcafe.dto.BoardFormDto;
import com.hyuns.svtcafe.entity.Board;
import com.hyuns.svtcafe.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping("/list")
    public String getBoardList(){
        return "board/list";
    }

    @GetMapping("/add")
    public String addPostForm(Model model) {
        model.addAttribute("boardFormDto", new BoardFormDto());
        return "board/add";
    }

    @PostMapping("/add")
    public String addPost(@ModelAttribute BoardFormDto boardFormDto) {
        boardService.save(boardFormDto);
        return "redirect:/board/list";
    }

    @GetMapping("/{bno}")
    public String PostDetail(@PathVariable("bno") Long boardId, Model model) {
        Board post = boardService.getPost(boardId);
        model.addAttribute("post",post);
        return "board/read";

    }

}
