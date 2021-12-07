package com.hyuns.svtcafe.controller;

import com.hyuns.svtcafe.entity.Cafe;
import com.hyuns.svtcafe.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final CafeRepository cafeRepository;

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("cafes", cafeRepository.findAll());

        return "main";
    }
}
