package com.github.pawelsli.votingappapi.repository;

import com.github.pawelsli.votingappapi.entity.Voter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VoterRepository extends JpaRepository<Voter, Long> {
}
