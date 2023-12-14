package com.uolchallenge.uol.Domain.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uolchallenge.uol.Application.Dtos.PlayerDto;
import com.uolchallenge.uol.Domain.Enum.GroupType;
import com.uolchallenge.uol.infra.entity.PlayerEntity;
import com.uolchallenge.uol.infra.handler.CodinameHandler;
import com.uolchallenge.uol.infra.repository.PlayerRepository;

@Service
public class PlayerService {
    
    private PlayerRepository playerRepository;
    private CodinameHandler handler;

    @Autowired
    public PlayerService(PlayerRepository playerRepository, CodinameHandler handler) {
        this.playerRepository = playerRepository;
        this.handler = handler;
    }

    public PlayerEntity createPlayer(PlayerDto playerDto) {
        PlayerEntity newPlayer = new PlayerEntity(playerDto);
        String codiname = getCodiname(playerDto.groupType());
        newPlayer.setCodiane(codiname);
        return newPlayer;
    }

    private String getCodiname(GroupType groupType){
        return handler.findCodiname(groupType);
    }

    public List<PlayerEntity> getAllPlayers() {
        return playerRepository.findAll();
    }
}
