package com.github.pawelsli.votingappapi.controller;

import com.github.pawelsli.votingappapi.dto.CandidateDto;
import com.github.pawelsli.votingappapi.service.CandidateService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/candidates")
@Slf4j
@Validated
@RequiredArgsConstructor
public class CandidateController {

    private final CandidateService candidateService;

    @GetMapping
    public ResponseEntity<List<CandidateDto>> getAllCandidates(){
        log.info("Retrieving list of all candidates");
        final List<CandidateDto> result = candidateService.getAllCandidates();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }

    @PostMapping
    public ResponseEntity<CandidateDto> addCandidate(final @Valid @RequestBody CandidateDto candidateDto) {
        log.info("Adding candidate with name: {}", candidateDto.name());
        final CandidateDto result = candidateService.addCandidate(candidateDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
