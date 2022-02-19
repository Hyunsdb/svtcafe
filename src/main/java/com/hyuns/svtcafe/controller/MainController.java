package com.hyuns.svtcafe.controller;

import com.hyuns.svtcafe.dto.CafeSearchDto;
import com.hyuns.svtcafe.entity.Cafe;
import com.hyuns.svtcafe.service.CafeService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


import java.util.Optional;

@Controller
@RequiredArgsConstructor
public class MainController {

    private final CafeService cafeService;

    @GetMapping({"/","/{page}"})
    public String mainPage(Optional<Integer> page, CafeSearchDto cafeSearchDto, Model model) {
        //페이지 번호가 없으면 0
        Pageable pageable = PageRequest.of(page.isPresent() ? page.get() : 0,5);
        Page<Cafe> cafeList = cafeService.getMainPage(cafeSearchDto,pageable);

        model.addAttribute("cafes", cafeList);
        model.addAttribute("cafeSearchDto", cafeSearchDto);
        model.addAttribute("maxPage", 3);


        return "main";
    }

}
