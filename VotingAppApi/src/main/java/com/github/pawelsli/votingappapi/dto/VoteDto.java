package com.github.pawelsli.votingappapi.dto;

import lombok.Builder;

@Builder
public record VoteDto(Long voterId, Long candidateId) {
}
