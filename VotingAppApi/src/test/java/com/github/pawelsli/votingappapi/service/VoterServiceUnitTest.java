package com.github.pawelsli.votingappapi.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class VoterServiceUnitTest {

    @InjectMocks
    VoterServiceImpl voterService;

    @Test
    void givenVoterDto_whenAddVoter_thenAddObject() {
    }

    @Test
    void givenVoteDtoWithNoExistingCandidate_whenCastVote_thenThrowException() {
    }

    @Test
    void givenVoteDtoWithNoExistingVoter_whenCastVote_thenThrowException() {
    }

    @Test
    void givenVoteDto_whenCastVote_thenUpdateVotes() {
    }

}