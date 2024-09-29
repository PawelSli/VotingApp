package com.github.pawelsli.votingappapi.service;

import com.github.pawelsli.votingappapi.dto.VoterDto;
import com.github.pawelsli.votingappapi.entity.Voter;
import com.github.pawelsli.votingappapi.mapper.VoterMapper;
import com.github.pawelsli.votingappapi.repository.VoterRepository;
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
class VoterServiceUnitTest {

    @InjectMocks
    VoterServiceImpl voterService;

    @Spy
    VoterMapper voterMapper = Mappers.getMapper(VoterMapper.class);

    @Mock
    VoterRepository voterRepository;

    @Test
    void givenVoterDto_whenAddVoter_thenCreateObject() {

        //given
        final String name = "Name";
        final Long voterId = 22L;
        VoterDto voterDto = VoterDto.builder()
                .name(name)
                .build();

        when(voterRepository.save(any()))
                .thenAnswer((Answer<Voter>) invocation -> {
                    Voter args = (Voter) invocation.getArguments()[0];
                    args.setVoterId(voterId);
                    return args;
                });

        //when
        VoterDto result = voterService.addVoter(voterDto);

        //then
        verify(voterRepository).save(argThat(t -> t.getName().equals(name)));
        assertEquals(name, result.name());
        assertEquals(voterId, result.voterId());
    }
}