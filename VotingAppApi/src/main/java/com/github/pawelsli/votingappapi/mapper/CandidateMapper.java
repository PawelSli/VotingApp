package com.github.pawelsli.votingappapi.mapper;

import com.github.pawelsli.votingappapi.dto.CandidateDto;
import com.github.pawelsli.votingappapi.entity.Candidate;
import com.github.pawelsli.votingappapi.entity.Voter;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.util.ObjectUtils;

import java.util.List;

@Mapper(componentModel = "spring")
public interface CandidateMapper {

    Candidate candidateDtoToCandidate(CandidateDto candidateDto);

    @Mapping(source = "voterList", target = "votes", qualifiedByName = "populateVotesNumbers")
    CandidateDto candidateToCandidateDto(Candidate candidate);

    @Named("populateVotesNumbers")
    default Integer populateVotesNumbers(final List<Voter> voterList) {
        return ObjectUtils.isEmpty(voterList) ? 0 : voterList.size();
    }
}
