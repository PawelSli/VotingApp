package com.github.pawelsli.votingappapi.service;

import com.github.pawelsli.votingappapi.dto.VoteDto;
import com.github.pawelsli.votingappapi.dto.VoterDto;

public interface VoterService {

    VoterDto addVoter(VoterDto voterDto);

    String castVote(VoteDto voteDto);
}
