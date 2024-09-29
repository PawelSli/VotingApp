package com.github.pawelsli.votingappapi.service;

import com.github.pawelsli.votingappapi.dto.CandidateDto;
import com.github.pawelsli.votingappapi.mapper.CandidateMapper;
import com.github.pawelsli.votingappapi.repository.CandidateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CandidateServiceImpl implements CandidateService {

    private final CandidateMapper candidateMapper;
    private final CandidateRepository candidateRepository;

    @Override
    public CandidateDto addCandidate(CandidateDto candidateDTO) {
        return candidateMapper.candidateToCandidateDto(candidateRepository.save(candidateMapper.candidateDtoToCandidate(candidateDTO)));
    }
}
