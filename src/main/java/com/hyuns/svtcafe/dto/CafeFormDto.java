package com.hyuns.svtcafe.dto;

import com.hyuns.svtcafe.entity.Cafe;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter @Setter
@NoArgsConstructor
public class CafeFormDto {
    private String name;
    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventStart;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventEnd;

    private String cafeLink;

    @Builder
    public CafeFormDto(String name, String address, LocalDate eventStart, LocalDate eventEnd, String cafeLink) {
        this.name = name;
        this.address = address;
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
        this.cafeLink = cafeLink;
    }

    public Cafe toEntity(){
        return Cafe.builder()
                .name(name)
                .address(address)
                .eventStart(eventStart)
                .eventEnd(eventEnd)
                .cafeLink(cafeLink)
                .build();
    }
}