package com.uolchallenge.uol.Application.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uolchallenge.uol.Application.Dtos.PlayerDto;
import com.uolchallenge.uol.Domain.service.PlayerService;
import com.uolchallenge.uol.infra.entity.PlayerEntity;

import jakarta.validation.Valid;

@RestController
@RequestMapping("v1/player")
public class PlayerController {
    
    private PlayerService playerService;

    @Autowired
    public PlayerController(PlayerService playerService) {
        this.playerService = playerService;
    }

    public ResponseEntity<PlayerEntity> createPlayer(@RequestBody @Valid PlayerDto playerDate) {
        PlayerEntity newPlayer = playerService.createPlayer(playerDate);
        return ResponseEntity.status(HttpStatus.CREATED).body(newPlayer);
    }

    @GetMapping
    public ResponseEntity<List<PlayerEntity>> getAllPlayers(){
        return new ResponseEntity<>(playerService.getAllPlayers(), HttpStatus.OK);
    }
}
