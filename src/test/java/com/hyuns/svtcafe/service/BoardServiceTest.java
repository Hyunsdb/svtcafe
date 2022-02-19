package com.hyuns.svtcafe.service;

import com.hyuns.svtcafe.dto.BoardFormDto;
import com.hyuns.svtcafe.entity.Board;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.test.context.TestPropertySource;

import java.time.LocalDateTime;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@TestPropertySource(locations = {"classpath:application-test.properties"})
class BoardServiceTest {

    @Autowired
    private BoardService boardService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    void addPost(){
        //given
        BoardFormDto boardFormDto = BoardFormDto.builder()
                .writer("작성자")
                .password("1234")
                .title("제목")
                .content("내용")
                .regTime(LocalDateTime.now())
                .modDate(LocalDateTime.now())
                .build();

        //when
        Long savedId = boardService.save(boardFormDto);
        Board post = boardService.getPost(savedId);

        //then
        assertThat(savedId).isEqualTo(post.getId());
    }

    @Test
    @DisplayName("암호화 테스트")
    void addPostWithEncoderTest(){
        //given
        BoardFormDto boardFormDto1 = BoardFormDto.builder()
                .writer("작성자")
                .password("1234")
                .title("제목")
                .content("내용")
                .regTime(LocalDateTime.now())
                .modDate(LocalDateTime.now())
                .build();

        BoardFormDto boardFormDto2 = BoardFormDto.builder()
                .writer("작성자")
                .password("1234")
                .title("제목")
                .content("내용")
                .regTime(LocalDateTime.now())
                .modDate(LocalDateTime.now())
                .build();

        //when
        Board findPost1 = boardService.getPost(boardService.save(boardFormDto1));
        Board findPost2 = boardService.getPost(boardService.save(boardFormDto2));

        //then
        assertAll(
                () -> assertNotEquals(findPost1.getPassword(), findPost2.getPassword()),
                () -> assertTrue(passwordEncoder.matches("1234", findPost2.getPassword()))
        );
    }
}
