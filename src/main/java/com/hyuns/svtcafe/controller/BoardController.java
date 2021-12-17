package com.hyuns.svtcafe.controller;

import com.hyuns.svtcafe.dto.BoardFormDto;
import com.hyuns.svtcafe.entity.Board;
import com.hyuns.svtcafe.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RequiredArgsConstructor
@Controller
@RequestMapping("/board")
public class BoardController {
    private final BoardService boardService;

    @GetMapping({"/list"})
    public String getBoardList(@PageableDefault(size = 10, sort = "id", direction = Sort.Direction.DESC) Pageable pageable, Model model) {

        //페이지 번호가 없으면 0
        Page<Board> boardList = boardService.getBoardList(pageable);

        model.addAttribute("board", boardList);
        model.addAttribute("maxPage", 5);


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
    public String updatePost(@ModelAttribute BoardFormDto boardFormDto, @PathVariable Long bno) {
        boardService.updatePost(boardFormDto, bno);

        return "redirect:/board/" + bno;
    }

    @PostMapping("/remove/{bno}")
    public String deletePost(@PathVariable Long bno) {
        boardService.deletePost(bno);

        return "redirect:/board/list";
    }



//    @ResponseBody
//    @PostMapping(value = "/modify/test")
//    public void test(@RequestParam("pass1") String pass1, @RequestParam("bno") String bno){
//
//        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
//        System.out.println(pass1);
//        System.out.println(bno);
//    }

    @ResponseBody
    @PostMapping(value = "/modify/test")
    public void test(@RequestBody Map<String,Object> map){

        System.out.println("ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ");
        System.out.println(map.get("bno").toString());
        System.out.println(map.get("pass1").toString());
    }


}
