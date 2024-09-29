package com.github.pawelsli.votingappapi.service;

import com.github.pawelsli.votingappapi.dto.VoteDto;
import com.github.pawelsli.votingappapi.entity.Voter;
import com.github.pawelsli.votingappapi.repository.VoterRepository;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Objects;

@Service
@RequiredArgsConstructor
public class VoteServiceImpl implements VoteService {

    private final VoterRepository voterRepository;

    @Override
    public String castVote(VoteDto voteDto) {
        Voter voter = voterRepository.findById(voteDto.voterId())
                .orElseThrow(() -> new EntityNotFoundException(String.format("Voter entity with id %s not found",
                        voteDto.voterId())));

        Long oldCandidateId = voter.getCandidateId();
        Long newCandidateId = voteDto.candidateId();

        if (Objects.equals(oldCandidateId, newCandidateId)) {
            return "Vote already cast for this candidate";
        }

        voter.setCandidateId(newCandidateId);
        voterRepository.save(voter);

        return "Vote cast successfully";
    }
}
