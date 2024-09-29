package com.github.pawelsli.votingappapi.service;

import com.github.pawelsli.votingappapi.dto.VoterDto;
import com.github.pawelsli.votingappapi.mapper.VoterMapper;
import com.github.pawelsli.votingappapi.repository.VoterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class VoterServiceImpl implements VoterService {

    private final VoterMapper voterMapper;
    private final VoterRepository voterRepository;

    @Override
    public VoterDto addVoter(VoterDto voterDto) {
        return voterMapper.voterToVoterDto(voterRepository.save(voterMapper.voterDtoToVoter(voterDto)));
    }
}
