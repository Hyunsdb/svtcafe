package com.hyuns.svtcafe.service;

import com.hyuns.svtcafe.dto.CafeFormDto;
import com.hyuns.svtcafe.dto.CafeSearchDto;
import com.hyuns.svtcafe.entity.Cafe;
import com.hyuns.svtcafe.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


@Service
@RequiredArgsConstructor
public class CafeService {
    private final CafeRepository cafeRepository;


    public Long save(CafeFormDto cafeFormDto){
        return cafeRepository.save(cafeFormDto.toEntity()).getId();
    }

    @Transactional(readOnly = true)
    public Page<Cafe> getMainPage(CafeSearchDto cafeSearchDto, Pageable pageable) {
        return cafeRepository.getMainPage(cafeSearchDto,pageable);
    }

}
