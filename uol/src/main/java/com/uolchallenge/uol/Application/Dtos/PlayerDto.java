package com.uolchallenge.uol.Application.Dtos;

import com.uolchallenge.uol.Domain.Enum.GroupType;

public record PlayerDto(
    String name,
    String email,
    String phoneNumber,
    GroupType groupType
) { }
