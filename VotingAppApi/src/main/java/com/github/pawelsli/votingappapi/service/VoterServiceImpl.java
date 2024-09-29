package com.github.pawelsli.votingappapi.service;

import com.github.pawelsli.votingappapi.dto.VoterDto;
import com.github.pawelsli.votingappapi.mapper.VoterMapper;
import com.github.pawelsli.votingappapi.repository.VoterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class VoterServiceImpl implements VoterService {

    private final VoterMapper voterMapper;
    private final VoterRepository voterRepository;

    @Override
    public List<VoterDto> getAllVoters() {
        return voterMapper.voterListToVoterDtoList(voterRepository.findAll());
    }

    @Override
    public VoterDto addVoter(VoterDto voterDto) {
        return voterMapper.voterToVoterDto(voterRepository.save(voterMapper.voterDtoToVoter(voterDto)));
    }
}
