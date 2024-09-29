package com.github.pawelsli.votingappapi.repository;

import com.github.pawelsli.votingappapi.entity.Candidate;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepository extends JpaRepository<Candidate, Long> {
}
