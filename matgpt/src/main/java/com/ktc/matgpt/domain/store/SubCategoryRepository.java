package com.ktc.matgpt.domain.store;

import com.ktc.matgpt.domain.store.entity.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SubCategoryRepository extends JpaRepository<SubCategory, Long> {
}
