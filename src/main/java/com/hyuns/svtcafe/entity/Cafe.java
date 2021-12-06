package com.hyuns.svtcafe.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
public class Cafe {
    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cafe_id")
    private Long id;

    private String name;

    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventStart;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate eventEnd;

    private String cafeLink;

    @Builder
    public Cafe(String name, String address, LocalDate eventStart, LocalDate eventEnd, String cafeLink) {
        this.name = name;
        this.address = address;
        this.eventStart = eventStart;
        this.eventEnd = eventEnd;
        this.cafeLink = cafeLink;
    }
}
