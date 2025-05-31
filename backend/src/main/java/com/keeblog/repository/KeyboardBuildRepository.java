package com.keeblog.repository;

import com.keeblog.model.KeyboardBuild;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface KeyboardBuildRepository extends JpaRepository<KeyboardBuild, Long> {

    List<KeyboardBuild> findAllByAuthorId(Long authorId);
}
