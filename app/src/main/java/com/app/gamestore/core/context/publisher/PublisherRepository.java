package com.app.gamestore.core.context.publisher;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

import com.app.gamestore.core.domain.entity.Publisher;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;


public interface PublisherRepository extends JpaRepository<Publisher, Long>, JpaSpecificationExecutor<Publisher> {
    Optional<Publisher> findByUid(long uid);
    Page<Publisher> findAll(Specification<Publisher> spec, Pageable pageable);
}
