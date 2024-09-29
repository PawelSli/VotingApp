package com.github.pawelsli.votingappapi.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "candidates")
public class Candidate {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "candidate_id")
    private Long candidateId;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "votes")
    private Integer votes;

    // candidates.candidate_id -> voters.candidate_id
    @OneToMany(mappedBy = "candidate", fetch = FetchType.LAZY)
    private List<Voter> voterList;

    public Candidate() {
    }

    public Long getCandidateId() {
        return candidateId;
    }

    public void setCandidateId(Long candidateId) {
        this.candidateId = candidateId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getVotes() {
        return votes;
    }

    public void setVotes(Integer votes) {
        this.votes = votes;
    }

    public List<Voter> getVoterList() {
        return voterList;
    }
}
