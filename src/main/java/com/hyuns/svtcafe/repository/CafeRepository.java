package com.hyuns.svtcafe.repository;

import com.hyuns.svtcafe.entity.Cafe;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CafeRepository extends JpaRepository<Cafe,Long> {
}
