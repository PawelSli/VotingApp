package com.github.pawelsli.votingappapi.mapper;

import com.github.pawelsli.votingappapi.dto.CandidateDto;
import com.github.pawelsli.votingappapi.entity.Candidate;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CandidateMapper {

    Candidate candidateDtoToCandidate(CandidateDto candidateDto);

    CandidateDto candidateToCandidateDto(Candidate candidate);
}
