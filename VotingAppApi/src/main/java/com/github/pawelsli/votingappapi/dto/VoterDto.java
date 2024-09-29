package com.github.pawelsli.votingappapi.dto;

public record VoterDto(Long voterId, String name, Long candidateId) {
}
