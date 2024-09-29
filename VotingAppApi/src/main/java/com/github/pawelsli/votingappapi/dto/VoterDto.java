package com.github.pawelsli.votingappapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record VoterDto(
        Long voterId,
        @NotBlank(message = "Name is required") String name,
        Long candidateId) {
}
