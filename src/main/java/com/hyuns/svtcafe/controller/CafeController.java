package com.hyuns.svtcafe.controller;

import com.hyuns.svtcafe.dto.CafeFormDto;
import com.hyuns.svtcafe.entity.Cafe;
import com.hyuns.svtcafe.repository.CafeRepository;
import com.hyuns.svtcafe.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("cafe")
@RequiredArgsConstructor
public class CafeController {
    private final CafeService cafeService;

    @GetMapping("/add")
    public String addCafeForm(Model model) {
        model.addAttribute("cafeFormDto", new CafeFormDto());
        return "/cafe/add";
    }

    @PostMapping("/add")
    public String addCafe(@Validated @ModelAttribute CafeFormDto cafeFormDto, BindingResult bindingResult){
        if (bindingResult.hasErrors()) {
            return "/cafe/add";
        }

        cafeService.save(cafeFormDto);
        return "redirect:/";
    }

    @GetMapping("/{cno}")
    public String detailCafe(@PathVariable("cno") Long cno, Model model) {
        Cafe findCafe = cafeService.getDetail(cno);
        model.addAttribute("cafe", findCafe);
        return "/cafe/read";
    }
}
