package com.maplr.testhockeygame.service;

import com.maplr.testhockeygame.domain.Player;
import com.maplr.testhockeygame.domain.Team;
import com.maplr.testhockeygame.repository.ITeamRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TeamService {

    private ITeamRepository teamRepository;
    private PlayerService playerService;

    @Autowired
    public TeamService(ITeamRepository teamRepository, PlayerService playerService) {
        this.teamRepository = teamRepository;
        this.playerService = playerService;
    }

    public Team findByYear(long year) {
        return this.teamRepository.findByYear(year);
    }

    public Player createAndAddPlayerToTeamOfYEar(long year, Player player) {
        Team team = this.createTeamIfNecessary(year);
        player = this.playerService.createPlayer(player);
        player.setTeam(team);
        return this.playerService.createPlayer(player);
    }

    private Team createTeamIfNecessary(long year) {
        Team searchedTeam = this.findByYear(year);

        if (searchedTeam == null) {
            Team newTeam = new Team();
            newTeam.setYear(year);
            return this.teamRepository.save(newTeam);
        }

        return searchedTeam;
    }
}
