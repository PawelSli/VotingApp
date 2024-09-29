package com.github.pawelsli.votingappapi.service;

import com.github.pawelsli.votingappapi.dto.VoterDto;

import java.util.List;

public interface VoterService {

    VoterDto addVoter(VoterDto voterDto);

    List<VoterDto> getAllVoters();
}
