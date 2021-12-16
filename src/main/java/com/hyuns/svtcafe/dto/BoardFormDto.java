package com.hyuns.svtcafe.dto;

import com.hyuns.svtcafe.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class BoardFormDto {
    private String writer;
    private String password;
    private String title;
    private String content;
    private LocalDateTime regTime;
    private LocalDateTime modDate;

    @Builder
    public BoardFormDto(String writer, String password, String title, String content, LocalDateTime regTime, LocalDateTime modDate) {
        this.writer = writer;
        this.password = password;
        this.title = title;
        this.content = content;
        this.regTime = regTime;
        this.modDate = modDate;
    }

    public Board toEntity(PasswordEncoder passwordEncoder){
        return Board.builder()
                .writer(writer)
                .password(passwordEncoder.encode(password))
                .title(title)
                .content(content)
                .build();
    }
}
