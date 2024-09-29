package com.github.pawelsli.votingappapi.controller;

import com.github.pawelsli.votingappapi.dto.VoterDto;
import com.github.pawelsli.votingappapi.service.VoterService;
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
@RequestMapping("/voters")
@Slf4j
@Validated
@RequiredArgsConstructor
public class VoterController {

    private final VoterService voterService;

    @PostMapping
    public ResponseEntity<VoterDto> addVoter(final @Valid @RequestBody VoterDto voterDto) {
        log.info("Adding voting person with name: {}", voterDto.name());
        final VoterDto result = voterService.addVoter(voterDto);
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
