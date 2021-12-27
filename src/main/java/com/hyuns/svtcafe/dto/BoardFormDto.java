package com.hyuns.svtcafe.dto;

import com.hyuns.svtcafe.entity.Board;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class BoardFormDto {
    @NotBlank(message = "닉네임을 입력해주세요.")
    private String writer;

    @NotBlank(message = "비밀번호를 입력해주세요.")
    @Size(min = 4, message = "비밀번호는 4자 이상이어야 합니다.")
    private String password;

    @NotBlank(message = "제목을 입력해주세요.")
    private String title;

    @NotBlank(message = "내용을 입력해주세요.")
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
