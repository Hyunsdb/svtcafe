package com.hyuns.svtcafe.dto;

import com.hyuns.svtcafe.constant.Member;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class CafeSearchDto {
    private Member searchMemberType;

    private String searchCafeName="";
}
