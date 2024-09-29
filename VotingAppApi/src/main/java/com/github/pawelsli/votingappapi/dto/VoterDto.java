package com.github.pawelsli.votingappapi.dto;

import lombok.Builder;

@Builder
public record VoterDto(Long voterId, String name, Long candidateId) {
}
