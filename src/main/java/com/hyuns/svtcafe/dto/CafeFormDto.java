package com.hyuns.svtcafe.dto;

import com.hyuns.svtcafe.constant.Member;
import com.hyuns.svtcafe.entity.Cafe;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class CafeFormDto {
    @NotBlank(message = "카페 이름을 입력해주세요.")
    private String name;

    @NotBlank(message = "주소를 선택해주세요.")
    private String address;

    @NotNull(message = "맴버를 선택해주세요.")
    private Member member;

    @NotNull(message = "시작 날짜를 선택해주세요.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventStart;

    @NotNull(message = "마감 날짜를 선택해주세요.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventEnd;

    private String cafeLink;

    @Builder
    public CafeFormDto(String name, String address, Member member, LocalDate eventStart, LocalDate eventEnd, String cafeLink) {
        this.name = name;
        this.address = address;
        this.member=member;
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
        this.cafeLink = cafeLink;
    }

    public Cafe toEntity(){
        return Cafe.builder()
                .name(name)
                .address(address)
                .member(member)
                .eventStart(eventStart)
                .eventEnd(eventEnd)
                .cafeLink(cafeLink)
                .build();
    }
}
