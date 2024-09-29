package com.github.pawelsli.votingappapi.service;

import com.github.pawelsli.votingappapi.dto.CandidateDto;
import com.github.pawelsli.votingappapi.entity.Candidate;
import com.github.pawelsli.votingappapi.mapper.CandidateMapper;
import com.github.pawelsli.votingappapi.repository.CandidateRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mapstruct.factory.Mappers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;
import org.mockito.stubbing.Answer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.argThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class CandidateServiceUnitTest {

    @InjectMocks
    CandidateServiceImpl candidateService;

    @Spy
    CandidateMapper candidateMapper = Mappers.getMapper(CandidateMapper.class);

    @Mock
    CandidateRepository candidateRepository;

    @Test
    void givenCandidateDto_whenAddCandidate_thenCreateObject() {

        //given
        final String name = "Name";
        final Long candidateId = 11L;
        CandidateDto candidateDto = CandidateDto.builder()
                .name(name)
                .build();

        when(candidateRepository.save(any()))
                .thenAnswer((Answer<Candidate>) invocation -> {
                    Candidate args = (Candidate) invocation.getArguments()[0];
                    args.setCandidateId(candidateId);
                    return args;
                });

        //when
        CandidateDto result = candidateService.addCandidate(candidateDto);

        //then
        verify(candidateRepository).save(argThat(t -> t.getName().equals(name)));
        assertEquals(name, result.name());
        assertEquals(candidateId, result.candidateId());
    }
}