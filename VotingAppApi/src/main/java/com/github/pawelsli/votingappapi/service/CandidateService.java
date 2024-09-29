package com.github.pawelsli.votingappapi.service;

import com.github.pawelsli.votingappapi.dto.CandidateDto;

import java.util.List;

public interface CandidateService {

    CandidateDto addCandidate(CandidateDto candidateDTO);

    List<CandidateDto> getAllCandidates();
}
