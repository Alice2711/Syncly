package com.alice.syncly.repository;

import com.alice.syncly.domain.ProjectMember;
import com.alice.syncly.domain.Member;
import com.alice.syncly.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProjectMemberRepository extends JpaRepository<ProjectMember, Long> {

    List<ProjectMember> findByProject(Project project);

    List<ProjectMember> findByMember(Member member);
}

