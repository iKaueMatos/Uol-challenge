package com.uolchallenge.uol.Domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uolchallenge.uol.Application.Dtos.PlayerDto;
import com.uolchallenge.uol.infra.entity.PlayerEntity;
import com.uolchallenge.uol.infra.repository.PlayerRepository;

@Service
public class PlayerService {
    
    private PlayerRepository playerRepository;

    @Autowired
    public PlayerService(PlayerRepository playerRepository) {
        this.playerRepository = playerRepository;
    }

    public PlayerEntity createPlayer(PlayerDto playerDto) {

    }
}
