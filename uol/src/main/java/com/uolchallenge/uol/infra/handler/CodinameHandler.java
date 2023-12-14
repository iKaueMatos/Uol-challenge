package com.uolchallenge.uol.infra.handler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.uolchallenge.uol.Domain.Enum.GroupType;
import com.uolchallenge.uol.Domain.service.CodinameService;

import lombok.Getter;

@Getter
@Component
public class CodinameHandler {

    private CodinameService service;
    
    @Autowired
    public CodinameHandler(CodinameService service) {
        this.service = service;
    }

    public String findCodiname(GroupType groupType) {
        if (groupType == GroupType.AVANGERS) {
            String firstMatch = service.getAvangersCodinameList().stream().findFirst().orElseThrow();
            this.service.getAvangersCodinameList().remove(firstMatch);
            return firstMatch;
        }
        String firstMatch = service.getJusticeLeagueList().stream().findFirst().orElseThrow();
        this.service.getJusticeLeagueList().remove(firstMatch);
        return firstMatch;
    }
}
