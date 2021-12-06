package com.hyuns.svtcafe.service;

import com.hyuns.svtcafe.dto.CafeFormDto;
import com.hyuns.svtcafe.entity.Cafe;
import com.hyuns.svtcafe.repository.CafeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CafeService {
    private final CafeRepository cafeRepository;

    public Long save(CafeFormDto cafeFormDto){
        return cafeRepository.save(cafeFormDto.toEntity()).getId();
    }
}
