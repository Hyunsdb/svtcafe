package com.hyuns.svtcafe.repository;

import com.hyuns.svtcafe.constant.Member;
import com.hyuns.svtcafe.entity.QCafe;
import com.querydsl.core.QueryResults;
import com.hyuns.svtcafe.dto.CafeSearchDto;
import com.hyuns.svtcafe.entity.Cafe;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import java.util.List;

public class CafeRepositoryCustomImpl implements CafeRepositoryCustom {

    private JPAQueryFactory jpaQueryFactory;
    public CafeRepositoryCustomImpl(EntityManager em){
        this.jpaQueryFactory = new JPAQueryFactory(em);
    }


    @Override
    public Page<Cafe> getMainPage(CafeSearchDto cafeSearchDto, Pageable pageable) {
        QueryResults<Cafe> results = jpaQueryFactory
                .selectFrom(QCafe.cafe)
                .where(searchMemberEq(cafeSearchDto.getSearchMemberType()))
                .orderBy(QCafe.cafe.id.desc())
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetchResults();

        List<Cafe> result = results.getResults();
        long total = results.getTotal();
        return new PageImpl<>(result,pageable,total);
    }

    private BooleanExpression searchMemberEq(Member memberType){
        return memberType == null ? null : QCafe.cafe.member.eq(memberType);
    }
}
