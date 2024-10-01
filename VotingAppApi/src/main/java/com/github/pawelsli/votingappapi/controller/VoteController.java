package com.github.pawelsli.votingappapi.controller;

import com.github.pawelsli.votingappapi.dto.VoteDto;
import com.github.pawelsli.votingappapi.service.VoteService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/votes")
@Slf4j
@Validated
@RequiredArgsConstructor
@CrossOrigin(origins = "http://localhost:4200")
public class VoteController {

    private final VoteService voteService;

    @PostMapping
    public ResponseEntity<String> castVote(final @Valid @RequestBody VoteDto voteDto) {
        log.info("Casting vote with voter id: {} and candidate id: {}", voteDto.voterId(), voteDto.candidateId());
        final String result = voteService.castVote(voteDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
