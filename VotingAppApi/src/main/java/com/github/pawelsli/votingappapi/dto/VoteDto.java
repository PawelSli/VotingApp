package com.github.pawelsli.votingappapi.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;

@Builder
public record VoteDto(
        @NotNull(message = "Voter id is required") Long voterId,
        @NotNull(message = "Candidate id is required") Long candidateId) {
}
