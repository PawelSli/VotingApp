package com.github.pawelsli.votingappapi.service;

import com.github.pawelsli.votingappapi.dto.VoteDto;

public interface VoteService {

   String castVote(VoteDto voteDto);
}
