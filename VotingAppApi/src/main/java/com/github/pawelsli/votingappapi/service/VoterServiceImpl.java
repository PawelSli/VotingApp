package com.github.pawelsli.votingappapi.service;

import com.github.pawelsli.votingappapi.dto.VoteDto;
import com.github.pawelsli.votingappapi.dto.VoterDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoterServiceImpl implements VoterService{

    @Override
    public VoterDto addVoter(VoterDto voterDto) {
        return null;
    }

    @Override
    public String castVote(VoteDto voteDto) {
        return null;
    }
}
