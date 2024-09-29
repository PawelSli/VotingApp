package com.github.pawelsli.votingappapi.service;

import com.github.pawelsli.votingappapi.dto.VoteDto;
import com.github.pawelsli.votingappapi.entity.Voter;
import com.github.pawelsli.votingappapi.repository.VoterRepository;
import jakarta.persistence.EntityNotFoundException;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class VoteServiceImplTest {

    @InjectMocks
    VoteServiceImpl voteService;

    @Mock
    VoterRepository voterRepository;

    @Test
    void givenVoteWithNotExistingVoterId_whenCastVote_thenThrowException() {

        //given
        final Long voterId = 33L;
        final Long candidateId = 44L;

        VoteDto voteDto = VoteDto.builder()
                .voterId(voterId)
                .candidateId(candidateId)
                .build();

        when(voterRepository.findById(voterId)).thenReturn(Optional.empty());

        //when then
        assertThrows(EntityNotFoundException.class, () -> voteService.castVote(voteDto));
        verify(voterRepository).findById(voterId);
    }

    @Test
    void givenAlreadyDoneVote_whenCastVote_thenReturnInformation() {

        //given
        final Long voterId = 55L;
        final Long candidateId = 66L;

        VoteDto voteDto = VoteDto.builder()
                .voterId(voterId)
                .candidateId(candidateId)
                .build();

        Voter voter = new Voter();
        voter.setVoterId(voterId);
        voter.setCandidateId(candidateId);

        when(voterRepository.findById(voterId)).thenReturn(Optional.of(voter));

        //when
        String result = voteService.castVote(voteDto);

        //then
        verify(voterRepository).findById(voterId);
        verify(voterRepository, times(0)).save(any());
        assertEquals("Vote already cast for this candidate", result);
    }

    @Test
    void givenVoteDto_whenCastVote_thenReturnInformation() {

        //given
        final Long voterId = 77L;
        final Long oldCandidateId = 88L;
        final Long newCandidateId = 99L;

        VoteDto voteDto = VoteDto.builder()
                .voterId(voterId)
                .candidateId(newCandidateId)
                .build();

        Voter voter = new Voter();
        voter.setVoterId(voterId);
        voter.setCandidateId(oldCandidateId);

        when(voterRepository.findById(voterId)).thenReturn(Optional.of(voter));

        //when
        String result = voteService.castVote(voteDto);

        //then
        verify(voterRepository).findById(voterId);
        verify(voterRepository).save(voter);
        assertEquals("Vote cast successfully", result);
    }
}