package com.hyuns.svtcafe.service;

import com.hyuns.svtcafe.dto.BoardFormDto;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Test
    void addPost(){
        BoardFormDto boardFormDto = BoardFormDto.builder()
                .writer("작성자")
                .password("1234")
                .title("제목")
                .content("내용")
                .regTime(LocalDateTime.now())
                .modDate(LocalDateTime.now())
                .build();

        Long savedId = boardService.save(boardFormDto);

        assertThat(savedId).isEqualTo(1L);
    }
}