package com.alice.syncly.repository;

import com.alice.syncly.domain.Project;
import com.alice.syncly.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectRepository extends JpaRepository<Project, Long> {

    List<Project> findByOwner(Member owner);
}

