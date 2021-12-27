package com.hyuns.svtcafe.entity;

import com.hyuns.svtcafe.constant.Member;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDate;

@Entity
@Getter
@NoArgsConstructor
public class Cafe {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cafe_id")
    private Long id;

    @Enumerated(EnumType.STRING)
    private Member member;

    private String name;

    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventStart;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventEnd;

    private String cafeLink;

    @Builder
    public Cafe(Member member, String name, String address, LocalDate eventStart, LocalDate eventEnd, String cafeLink) {
        this.member=member;
        this.name = name;
        this.address = address;
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
        this.cafeLink = cafeLink;
    }
}
