package com.hyuns.svtcafe.repository;

import com.hyuns.svtcafe.dto.CafeSearchDto;
import com.hyuns.svtcafe.entity.Cafe;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CafeRepositoryCustom {
    Page<Cafe> getMainPage(CafeSearchDto cafeSearchDto, Pageable pageable);
}
