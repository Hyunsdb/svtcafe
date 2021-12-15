package com.hyuns.svtcafe.entity;

import com.hyuns.svtcafe.dto.BoardFormDto;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

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

    public void updatePost(BoardFormDto boardFormDto){
        this.writer = boardFormDto.getWriter();
        this.password = boardFormDto.getPassword();
        this.title = boardFormDto.getTitle();
        this.content = boardFormDto.getContent();
    }
}