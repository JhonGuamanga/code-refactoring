package com.appgate.dtp.code.refactoring.adapters.out.shared.repositories;

import com.appgate.dtp.code.refactoring.adapters.out.shared.entities.TweetEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JpaTweetRepository extends JpaRepository<TweetEntity, Long> {
}
