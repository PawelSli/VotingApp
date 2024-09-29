package com.github.pawelsli.votingappapi.controller;

import com.github.pawelsli.votingappapi.dto.CandidateDto;
import com.github.pawelsli.votingappapi.service.CandidateService;
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
@RequestMapping("/candidates")
@Slf4j
@Validated
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @PostMapping
    public ResponseEntity<CandidateDto> addCandidate(final @Valid @RequestBody CandidateDto candidateDto) {
        log.info("Adding candidate with name: {}", candidateDto.name());
        final CandidateDto result = candidateService.addCandidate(candidateDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
