package com.hyuns.svtcafe.repository;

import com.hyuns.svtcafe.entity.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;

public interface CafeRepository extends JpaRepository<Cafe,Long>, QuerydslPredicateExecutor<Cafe>, CafeRepositoryCustom {
}
