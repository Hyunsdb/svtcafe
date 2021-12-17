package com.hyuns.svtcafe.controller;

import com.hyuns.svtcafe.dto.CafeFormDto;
import com.hyuns.svtcafe.repository.CafeRepository;
import com.hyuns.svtcafe.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

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
    public String addCafe(@ModelAttribute CafeFormDto cafeFormDto){
        cafeService.save(cafeFormDto);
        return "redirect:/";
    }
}
