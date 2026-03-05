package com.alice.syncly.service;

import com.alice.syncly.domain.Member;
import com.alice.syncly.domain.Project;
import com.alice.syncly.domain.ProjectMember;
import com.alice.syncly.repository.MemberRepository;
import com.alice.syncly.repository.ProjectMemberRepository;
import com.alice.syncly.repository.ProjectRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class ProjectMemberService {

    private final ProjectMemberRepository projectMemberRepository;
    private final ProjectRepository projectRepository;
    private final MemberRepository memberRepository;

    public ProjectMemberService(ProjectMemberRepository projectMemberRepository,
                                ProjectRepository projectRepository,
                                MemberRepository memberRepository) {
        this.projectMemberRepository = projectMemberRepository;
        this.projectRepository = projectRepository;
        this.memberRepository = memberRepository;
    }

    @Transactional
    public ProjectMember addMemberToProject(Long projectId, Long memberId, String projectRole) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found: " + projectId));
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found: " + memberId));

        ProjectMember projectMember = new ProjectMember(project, member, projectRole);
        return projectMemberRepository.save(projectMember);
    }

    public List<ProjectMember> findByProject(Long projectId) {
        Project project = projectRepository.findById(projectId)
                .orElseThrow(() -> new IllegalArgumentException("Project not found: " + projectId));
        return projectMemberRepository.findByProject(project);
    }

    public List<ProjectMember> findByMember(Long memberId) {
        Member member = memberRepository.findById(memberId)
                .orElseThrow(() -> new IllegalArgumentException("Member not found: " + memberId));
        return projectMemberRepository.findByMember(member);
    }
}

