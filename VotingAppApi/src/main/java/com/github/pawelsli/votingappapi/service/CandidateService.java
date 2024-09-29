package com.github.pawelsli.votingappapi.service;

import com.github.pawelsli.votingappapi.dto.CandidateDto;

public interface CandidateService {

    CandidateDto addCandidate(CandidateDto candidateDTO);
}
