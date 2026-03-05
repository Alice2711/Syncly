package com.alice.syncly.domain;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class ProjectMember {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id", nullable = false)
    private Project project;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id", nullable = false)
    private Member member;

    @Column(nullable = false)
    private String projectRole;

    @Column(nullable = false, updatable = false)
    private LocalDateTime joinedAt;

    protected ProjectMember() {
    }

    public ProjectMember(Project project, Member member, String projectRole) {
        this.project = project;
        this.member = member;
        this.projectRole = projectRole;
    }

    @PrePersist
    protected void onCreate() {
        this.joinedAt = LocalDateTime.now();
    }

    public Long getId() {
        return id;
    }

    public Project getProject() {
        return project;
    }

    public Member getMember() {
        return member;
    }

    public String getProjectRole() {
        return projectRole;
    }

    public LocalDateTime getJoinedAt() {
        return joinedAt;
    }
}

