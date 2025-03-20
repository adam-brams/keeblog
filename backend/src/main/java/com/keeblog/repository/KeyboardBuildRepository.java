package com.keeblog.repository;

import com.keeblog.model.KeyboardBuild;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KeyboardBuildRepository extends JpaRepository<KeyboardBuild, Long> {
}
