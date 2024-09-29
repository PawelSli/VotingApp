package com.github.pawelsli.votingappapi.dto;

import lombok.Builder;

@Builder
public record CandidateDto(Long candidateId, String name, Integer votes) {
}

