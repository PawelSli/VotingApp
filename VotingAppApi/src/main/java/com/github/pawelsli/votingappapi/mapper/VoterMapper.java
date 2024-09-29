package com.github.pawelsli.votingappapi.mapper;

import com.github.pawelsli.votingappapi.dto.VoterDto;
import com.github.pawelsli.votingappapi.entity.Voter;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface VoterMapper {

    Voter voterDtoToVoter(VoterDto voterDto);

    VoterDto voterToVoterDto(Voter voter);

    List<VoterDto> voterListToVoterDtoList(List<Voter> voterList);
}
