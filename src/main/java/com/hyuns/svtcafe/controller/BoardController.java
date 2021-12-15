package com.hyuns.svtcafe.controller;

import com.hyuns.svtcafe.dto.BoardFormDto;
import com.hyuns.svtcafe.entity.Board;
import com.hyuns.svtcafe.entity.Cafe;
import com.hyuns.svtcafe.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

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
        model.addAttribute("post", post);
        return "board/read";

    }

    @GetMapping("/modify/{bno}")
    public String modifyPost(@PathVariable("bno") Long boardId, Model model) {
        Board post = boardService.getPost(boardId);
        model.addAttribute("post", post);
        return "board/modify";
    }

    @PostMapping("/modify/{bno}")
    public String updatePost(@ModelAttribute BoardFormDto boardFormDto, @PathVariable Long bno){
        Long update = boardService.update(boardFormDto, bno);
        System.out.println(update);


        return "redirect:/board/"+bno;
    }
}
