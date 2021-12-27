package com.hyuns.svtcafe.entity;

import com.hyuns.svtcafe.dto.BoardFormDto;
import groovyjarjarantlr4.v4.runtime.misc.NotNull;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Getter
@NoArgsConstructor
public class Board extends BaseEntity {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "board_id")
    private Long id;

    private String writer;

    private String password;

    private String title;

    private String content;


    @Builder
    public Board(String title, String password, String content, String writer) {
        this.title = title;
        this.password = password;
        this.content = content;
        this.writer = writer;
    }

    public void updatePost(BoardFormDto boardFormDto, PasswordEncoder passwordEncoder){
        this.writer = boardFormDto.getWriter();
        this.password = passwordEncoder.encode(boardFormDto.getPassword());
        this.title = boardFormDto.getTitle();
        this.content = boardFormDto.getContent();
    }
}
