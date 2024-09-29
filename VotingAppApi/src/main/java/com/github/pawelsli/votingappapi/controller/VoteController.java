package com.github.pawelsli.votingappapi.controller;

import com.github.pawelsli.votingappapi.dto.VoteDto;
import com.github.pawelsli.votingappapi.service.VoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/votes")
@Slf4j
@Validated
@RequiredArgsConstructor
public class VoteController {

    private final VoteService voteService;

    @PostMapping
    public ResponseEntity<String> castVote(final @Valid @RequestBody VoteDto voteDto) {
        log.info("Casting vote with voter id: {} and candidate id: {}", voteDto.voterId(), voteDto.candidateId());
        final String result = voteService.castVote(voteDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
