package com.github.pawelsli.votingappapi.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;

@Builder
public record CandidateDto(
        Long candidateId,
        @NotBlank(message = "Name is required") String name,
        Integer votes) {
}

