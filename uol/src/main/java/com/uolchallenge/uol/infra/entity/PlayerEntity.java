package com.uolchallenge.uol.infra.entity;

import com.uolchallenge.uol.Application.Dtos.PlayerDto;
import com.uolchallenge.uol.Domain.Enum.GroupType;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@Entity
@Table(name = "players")
@EqualsAndHashCode(of = "id")
public class PlayerEntity  {
    
    public PlayerEntity(PlayerDto playerDto) {
        this.name = playerDto.name();
        this.email = playerDto.email();
        this.phoneNumber = playerDto.phoneNumber();
        this.groupType = playerDto.groupType();
    }

    @Id
    @Column(name = "id_player")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    @Column(name = "nome")
    private String name;

    @NotBlank
    @Column(name = "email", unique = true)
    private String email;


    @Column(name = "telefone")
    private String phoneNumber;

    @Column(name = "")
    private String codiane;

    @Column(name = "tipo")
    private GroupType groupType;
}
