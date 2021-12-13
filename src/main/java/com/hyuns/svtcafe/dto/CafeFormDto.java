package com.hyuns.svtcafe.dto;

import com.hyuns.svtcafe.constant.Member;
import com.hyuns.svtcafe.entity.Cafe;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
public class CafeFormDto {
    private String name;
    private String address;
    private Member member;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventStart;

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
